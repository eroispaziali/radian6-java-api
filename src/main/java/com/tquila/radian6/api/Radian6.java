package com.tquila.radian6.api;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tquila.radian6.exception.Radian6Exception;
import com.tquila.radian6.http.Radian6ClientFactory;
import com.tquila.radian6.model.auth.Auth;
import com.tquila.radian6.model.news.RiverOfNews;
import com.tquila.radian6.model.topic.TopicTrend;


public class Radian6 implements Radian6Api {
	
	public final String API_ENDPOINT_PROD ="https://api.radian6.com/socialcloud/v1";
	public final String API_ENDPOINT_DEV ="https://sandbox-insights.radian6.com/socialcloud/v1";
	private String endpoint = API_ENDPOINT_DEV;

	
	public final String RESOURCE_AUTH = "/auth/authenticate";
	public final String RESOURCE_TOPICS = "/topics";
	
	private String appKey;
	private Radian6ClientFactory client;
	
	private final static Logger logger = Logger.getLogger(Radian6ClientFactory.class);
	
	public Radian6(String appKey) {
		this.appKey = appKey;
		Injector injector = Guice.createInjector();
		client = injector.getInstance(Radian6ClientFactory.class);
	}
	
	public HttpGet signRequest(HttpGet request, Auth auth) {
		request.addHeader("auth_token", auth.getToken());
		return request;
	}
	
	public HttpGet prepareRequest(String resource) {
		String url = String.format("%s%s", endpoint, resource);
		HttpGet request = new HttpGet(url);
		request.addHeader("auth_appkey", appKey);
		return request;
	}

	
	public HttpGet prepareAuthRequest(String username, String password) {
		HttpGet request = prepareRequest(RESOURCE_AUTH);
		request.setHeader("auth_user", username);
		request.setHeader("auth_pass", password);
		return request;
	}

	public Object execute(Auth auth, HttpGet request, Class<?> dataType) throws Radian6Exception, IOException {
		signRequest(request, auth);
		return execute(request, dataType);
	}
	
	public Object execute(HttpGet request, Class<?> dataType) throws Radian6Exception, IOException  {
		HttpClient httpClient = client.createClient();
		HttpResponse response = httpClient.execute(request);
		HttpEntity responseEntity = response.getEntity();
		InputStream is = responseEntity.getContent();

		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, "UTF-8");
		String outString = writer.toString();
		
		
		logger.info("=[ RESPONSE ]=====================================");
		logger.info(outString);
		logger.info("==================================================");
		
       	try {
			JAXBContext context = JAXBContext.newInstance(dataType);
	       	Object obj = context.createUnmarshaller().unmarshal(new ByteArrayInputStream(outString.getBytes("UTF-8")));
	       	return obj;
       	} catch (JAXBException e) {
       		throw new Radian6Exception(e);
       	}
	}
	

	@Override
	public Auth authenticate(String username, String password) throws Radian6Exception, IOException {
		HttpGet request = prepareAuthRequest(username, password);
		return (Auth) execute(request, Auth.class);
	}

	@Override
	public RiverOfNews fetchRiverOfNews(Auth auth, Set<Long> topicProfiles, Set<Integer> mediaTypes, Integer hours, Integer pageIndex, Integer pageSize) throws Radian6Exception, IOException {
		/* Format: /data/topicdata/realtime/{recentXhours}/{topics}/{mediatypes}/{pageIndex}/{pageSize} */
		String topics = convertLongSet(topicProfiles);
		String mtypes = convertIntSet(mediaTypes);
		String resource = String.format("/data/topicdata/realtime/%d/%s/%s/%d/%d", hours, topics, mtypes, pageIndex, pageSize);
		logger.info(resource);

		HttpGet request = prepareRequest(resource);
		signRequest(request, auth);
		return (RiverOfNews) execute(request, RiverOfNews.class);

	}

	@Override
	public TopicTrend fetchTopicTrend(Auth auth, Set<Long> topicProfiles, Set<Integer> mediaTypes, Integer segmentation, Date from, Date to) throws Radian6Exception, IOException {
		/* Format: /data/timeseriesdata/{daterangeStart}/{daterangeEnd}/{topics}/{mediatypes}/{segmentation} */
		
		String dateRangeStart = Long.toString(from.getTime());
		String dateRangeEnd = Long.toString(to.getTime());
		String topics = convertLongSet(topicProfiles);
		String mtypes = convertIntSet(mediaTypes);
		String segm = Integer.toString(segmentation);
		String resource = String.format("/data/timeseriesdata/%s/%s/%s/%s/%s", dateRangeStart, dateRangeEnd, topics, mtypes, segm);
		
		HttpGet request = prepareRequest(resource);
		return (TopicTrend) execute(auth, request, TopicTrend.class);
	}
	
	private String convertLongSet(Set<Long> numbers) {
		Set<String> strings = new HashSet<String>();
		for (Long n : numbers) {
			strings.add(n.toString());
		}
		return StringUtils.join(strings, ",");
	}
	
	private String convertIntSet(Set<Integer> numbers) {
		Set<String> strings = new HashSet<String>();
		for (Integer n : numbers) {
			strings.add(n.toString());
		}
		return StringUtils.join(strings, ",");
	}

}
