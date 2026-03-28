package com.example.LoanManagementAPI.exception;

public class DuplicateLoanApplicationException  extends RuntimeException{
	public DuplicateLoanApplicationException(String m)
	{
		super(m);
	}

}
