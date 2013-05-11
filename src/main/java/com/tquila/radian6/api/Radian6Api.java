package com.tquila.radian6.api;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import com.tquila.radian6.exception.Radian6Exception;
import com.tquila.radian6.model.auth.Auth;
import com.tquila.radian6.model.news.RiverOfNews;
import com.tquila.radian6.model.topic.TopicTrend;


public interface Radian6Api {

	// Authentication
	public abstract Auth authenticate(String username, String password) throws Radian6Exception, IOException;
	
	// River Of News
	public abstract RiverOfNews fetchRiverOfNews(Auth auth, Long topicProfile, Integer mediaType, Integer hours, Integer pageIndex, Integer pageSize) throws Radian6Exception, IOException;
	public abstract RiverOfNews fetchRiverOfNews(Auth auth, Set<Long> topicProfiles, Set<Integer> mediaTypes, Integer hours, Integer pageIndex, Integer pageSize) throws Radian6Exception, IOException;
	
	// Topic Trend
	public abstract TopicTrend fetchTopicTrend(Auth auth, Set<Long> topicProfiles, Set<Integer> mediaTypes, Integer segmentation, Date from, Date to) throws Radian6Exception, IOException;
	
	
}