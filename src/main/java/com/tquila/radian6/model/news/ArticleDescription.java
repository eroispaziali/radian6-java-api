package com.tquila.radian6.model.news;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArticleDescription {
	
	@XmlAttribute(name="charset")
	String charset;
	
	@XmlElement(name="headline")
	String headline;
	
	@XmlElement(name="author_full_name")
	String authorFullName;
	
	@XmlElement(name="recipient")
	String recipient;
	
	@XmlElement(name="external_id")
	String externalId;
	
	@XmlElement(name="content")
	String content;


	@XmlElement(name="parentExternalId")
	String parentExternalId;


	public String getCharset() {
		return charset;
	}


	public void setCharset(String charset) {
		this.charset = charset;
	}


	public String getHeadline() {
		return headline;
	}


	public void setHeadline(String headline) {
		this.headline = headline;
	}


	public String getAuthorFullName() {
		return authorFullName;
	}


	public void setAuthorFullName(String authorFullName) {
		this.authorFullName = authorFullName;
	}


	public String getRecipient() {
		return recipient;
	}


	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}


	public String getExternalId() {
		return externalId;
	}


	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getParentExternalId() {
		return parentExternalId;
	}


	public void setParentExternalId(String parentExternalId) {
		this.parentExternalId = parentExternalId;
	}


}
