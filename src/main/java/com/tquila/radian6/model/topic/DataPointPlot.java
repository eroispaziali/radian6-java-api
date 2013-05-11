package com.tquila.radian6.model.topic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="plot")
public class DataPointPlot {
	
	@XmlAttribute(name="word")
	String word;
	
	@XmlValue
	Long value;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
	

}
