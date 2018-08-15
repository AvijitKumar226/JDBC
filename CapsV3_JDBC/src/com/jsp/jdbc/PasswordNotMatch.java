package com.jsp.jdbc;

public class PasswordNotMatch extends RuntimeException {
	 @Override
	public String getMessage() {
		return "New Passwords are not Matching";
	}
}