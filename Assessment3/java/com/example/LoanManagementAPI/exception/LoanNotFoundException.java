package com.example.LoanManagementAPI.exception;

public class LoanNotFoundException extends RuntimeException{
	
	public LoanNotFoundException(String m)
	{
		super(m);
	}

}
