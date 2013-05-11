package com.tquila.radian6.exception;


public class Radian6Exception extends Exception {

	private static final long serialVersionUID = 816144316799556899L;

	public Radian6Exception(String errorMessage) {
		super(errorMessage);
	}
	
	public Radian6Exception(Exception e) {
		super(e);
	}

}
