package com.tquila.radian6.model.news;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostInsight {
	
	@XmlElement(name="Provider")
	String provider;
	
	@XmlElement(name="Type")
	String type;
	
	@XmlElement(name="Value")
	String value;

}
