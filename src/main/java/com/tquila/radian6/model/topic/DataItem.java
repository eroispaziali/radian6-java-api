package com.tquila.radian6.model.topic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataItem {
	
	@XmlElement(name="graphData")
	GraphData graphData;
	
	@XmlElement(name="status")
	String status;

	public GraphData getGraphData() {
		return graphData;
	}

	public void setGraphData(GraphData graphData) {
		this.graphData = graphData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
