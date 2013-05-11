package com.tquila.radian6.api;

import org.junit.Before;
import org.junit.Test;

import com.tquila.radian6.exception.Radian6Exception;


public class ApiTest {
	
	@SuppressWarnings("unused")
	private Radian6Api r6;
	private final static String TEST_APP_KEY = "";
	
	@Before
	public void setUp() throws Exception {
		r6 = new Radian6(TEST_APP_KEY);
	}
	
	@Test(expected=Radian6Exception.class)
	public void login() throws Exception {
		throw new Radian6Exception("not yet implemented");
	}
	
}
