package com.tquila.radian6.model.topic;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="graphData")
public class GraphData {
	
	@XmlAttribute(name="bucketSizeInMS")
	Long bucketSizeInMS;
	
	@XmlAttribute(name="postCounts")
	String postCounts;

	@XmlElement(name="sphinxInfo")
	SphinxInfo sphinxInfo;
	
	@XmlElement(name="dataPoint")
	List<DataPoint> dataPoints;

	public Long getBucketSizeInMS() {
		return bucketSizeInMS;
	}

	public void setBucketSizeInMS(Long bucketSizeInMS) {
		this.bucketSizeInMS = bucketSizeInMS;
	}

	public String getPostCounts() {
		return postCounts;
	}

	public void setPostCounts(String postCounts) {
		this.postCounts = postCounts;
	}

	public SphinxInfo getSphinxInfo() {
		return sphinxInfo;
	}

	public void setSphinxInfo(SphinxInfo sphinxInfo) {
		this.sphinxInfo = sphinxInfo;
	}

	public List<DataPoint> getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(List<DataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	
	
}
