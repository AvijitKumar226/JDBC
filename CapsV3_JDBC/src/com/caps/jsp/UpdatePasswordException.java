package com.caps.jsp;

public class UpdatePasswordException extends RuntimeException {
	private String msg;
	public UpdatePasswordException(String e) {
		msg=e;
		
	}
	public String getMsg()
	{
		return msg;
	}

}
