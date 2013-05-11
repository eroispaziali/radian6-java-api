package com.tquila.radian6.model.topic;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="widgetOutput")
@XmlAccessorType(XmlAccessType.FIELD)
public class TopicTrend {
	
	@XmlElementWrapper(name="dataitems")
	@XmlElement(name="dataitem")
	List<DataItem> items;

	public List<DataItem> getItems() {
		return items;
	}

	public void setItems(List<DataItem> items) {
		this.items = items;
	}
	
}
