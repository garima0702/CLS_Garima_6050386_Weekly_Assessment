package com.example.LoanManagementAPI.service;

import java.util.List;

import com.example.LoanManagementAPI.entity.Loan;

public interface ILoanService{
	  Loan createLoan(Loan loan);
	  List<Loan> getAllLoans();
	  Loan getLoanById(Long id);
	  Loan updateLoanStatus(Long id, String status);

}


