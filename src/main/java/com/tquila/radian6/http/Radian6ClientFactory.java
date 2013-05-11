package com.tquila.radian6.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.log4j.Logger;

import com.google.inject.Singleton;


@Singleton
public class Radian6ClientFactory {

	
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(Radian6ClientFactory.class);


	private final static Integer MaxRedirects = 10;
	private final static Boolean AllowCircularRedirects = Boolean.FALSE;
	private final static Integer httpConnectionTimeout = 60000;
	private final static Integer httpSocketTimeout = 60000;

	private HttpParams createHttpParams() {
		HttpParams params = new BasicHttpParams();
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, "UTF-8");
		HttpProtocolParams.setUseExpectContinue(params, true);
		params.setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, true);
		params.setIntParameter(ClientPNames.MAX_REDIRECTS, MaxRedirects);
		params.setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS,AllowCircularRedirects);
		params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT,httpSocketTimeout);
		params.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,httpConnectionTimeout);
		return params;
	}

	@SuppressWarnings("unused")
	private static SchemeRegistry getSupportedSchemes() {
		SchemeRegistry registry = new SchemeRegistry();
		Scheme http = new Scheme("http", 80, PlainSocketFactory.getSocketFactory());
		registry.register(http);
		SSLSocketFactory sf = SSLSocketFactory.getSocketFactory();
		Scheme https = new Scheme("https", 443, sf);
		registry.register(https);
		return registry;
	}

	public HttpClient createClient() {
		DefaultHttpClient httpclient = new DefaultHttpClient(createHttpParams());
		return httpclient;
	}
	
	@SuppressWarnings("unused")
	private List<NameValuePair> getParameters(Map<String, String> params) {
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		Iterator<Entry<String, String>> it = params.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, String> pairs = (Map.Entry<String, String>)it.next();
    		qparams.add(new BasicNameValuePair(pairs.getKey(), pairs.getValue()));
	        it.remove();
	    }
	    return qparams;
	}

	@SuppressWarnings("unused")
	private static String streamToString(InputStream is) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer);
		return writer.toString();
	}
/*
	@SuppressWarnings("unused")
	private String urlEncode(String resource, List<NameValuePair> params) {
        String resourceUrl;
        if (resource.startsWith("/"))
        	resourceUrl = endpoint + resource.substring(1);
        else
            resourceUrl = resource.contains("://") ? resource : endpoint + resource;
        return (params == null) ?
        		resourceUrl :
                resourceUrl + "?" + URLEncodedUtils.format(params, "UTF-8");
    }
*/
}
