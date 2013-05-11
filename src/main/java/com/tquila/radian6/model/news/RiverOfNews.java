package com.tquila.radian6.model.news;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="radian6_RiverOfNews_export")
@XmlAccessorType(XmlAccessType.FIELD)
public class RiverOfNews {
	
	@XmlElement(name="report_date")
	String reportDate;
	
	@XmlElement(name="user_name")
	String username;
	
	@XmlElement(name="article_count")
	Long articleCount;
	
	@XmlElement(name="total_article_count")
	Long totalArticleCount;
	
	@XmlElement(name="article")
	List<Article> articles;

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Long articleCount) {
		this.articleCount = articleCount;
	}

	public Long getTotalArticleCount() {
		return totalArticleCount;
	}

	public void setTotalArticleCount(Long totalArticleCount) {
		this.totalArticleCount = totalArticleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
