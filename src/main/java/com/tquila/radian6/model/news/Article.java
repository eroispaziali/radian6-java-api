package com.tquila.radian6.model.news;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tquila.radian6.adapter.DateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
	
	@XmlElement(name="avatar")
	String avatar;

	@XmlElement(name="source")
	String source;

	@XmlElement(name="host")
	String host;
	
	@XmlElement(name="article_url")
	String url;
	
	@XmlElement(name="media_provider")
	String mediaProvider;
	
	@XmlElement(name="media_type_id")
	Integer mediaType;
	
	@XmlElement(name="language_id")
	Integer languageId;
	
	@XmlElement(name="spam_rating")
	Integer spamRating;
	
	@XmlElement(name="publish_date")
	@XmlJavaTypeAdapter(DateAdapter.class)
	Date publishDate;
	
	@XmlElement(name="harvest_date")
	@XmlJavaTypeAdapter(DateAdapter.class)
	Date harvestDate;

	@XmlElementWrapper(name="PostInsights")
	@XmlElement(name="PostInsight")
	List<PostInsight> postInsights;
	
	@XmlElement(name="description")
	ArticleDescription description;
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaProvider() {
		return mediaProvider;
	}

	public void setMediaProvider(String mediaProvider) {
		this.mediaProvider = mediaProvider;
	}

	public Integer getMediaType() {
		return mediaType;
	}

	public void setMediaType(Integer mediaType) {
		this.mediaType = mediaType;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getSpamRating() {
		return spamRating;
	}

	public void setSpamRating(Integer spamRating) {
		this.spamRating = spamRating;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(Date harvestDate) {
		this.harvestDate = harvestDate;
	}

	public List<PostInsight> getPostInsights() {
		return postInsights;
	}

	public void setPostInsights(List<PostInsight> postInsights) {
		this.postInsights = postInsights;
	}

	public ArticleDescription getDescription() {
		return description;
	}

	public void setDescription(ArticleDescription description) {
		this.description = description;
	}
	
}
