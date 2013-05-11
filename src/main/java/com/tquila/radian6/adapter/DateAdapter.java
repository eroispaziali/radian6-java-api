package com.tquila.radian6.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;

public class DateAdapter extends XmlAdapter<String, Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }

    //2012-07-10 14:07:17 +1200
    @Override
    public Date unmarshal(String v) throws Exception {
    	String d = StringUtils.substringBeforeLast(v, " +");
        return dateFormat.parse(d);
    }

}