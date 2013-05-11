package com.tquila.radian6.model.topic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="info")
public class SphinxInfoItem {
	
	@XmlAttribute(name="word")
	String word;
	
	@XmlAttribute(name="isSphinxLimit")
	Boolean isSphinxLimit;


}
