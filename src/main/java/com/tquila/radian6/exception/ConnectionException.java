package com.tquila.radian6.exception;

import java.io.IOException;


public class ConnectionException extends IOException {

	private static final long serialVersionUID = 1367109621775696433L;

	public ConnectionException(String errorMessage) {
		super(errorMessage);
	}

}
