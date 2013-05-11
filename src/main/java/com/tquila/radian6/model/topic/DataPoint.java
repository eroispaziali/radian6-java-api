package com.tquila.radian6.model.topic;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPoint {
	
	@XmlAttribute(name="timestamp")
	String timestamp;

	@XmlAttribute(name="actual")
	String actual;
	
	@XmlElement(name="plot")
	List<DataPointPlot> points;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public List<DataPointPlot> getPoints() {
		return points;
	}

	public void setPoints(List<DataPointPlot> points) {
		this.points = points;
	}
	
}
