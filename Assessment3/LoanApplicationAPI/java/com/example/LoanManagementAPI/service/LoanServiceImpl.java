package com.example.LoanManagementAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LoanManagementAPI.entity.Loan;
import com.example.LoanManagementAPI.entity.repository.ILoanRepository;
import com.example.LoanManagementAPI.exception.DuplicateLoanApplicationException;
import com.example.LoanManagementAPI.exception.InvalidLoanAmountException;
import com.example.LoanManagementAPI.exception.LoanNotFoundException;

@Service
public class LoanServiceImpl   implements ILoanService {
	 @Autowired
	    private ILoanRepository iLoanRepository;

	    public Loan createLoan(Loan loan) {
	        if (loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 5000000) {
	            throw new InvalidLoanAmountException("Loan amount must be between 1 and 5000000");
	        }

	        iLoanRepository.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING")
	            .ifPresent(l -> { throw new DuplicateLoanApplicationException("Duplicate loan"); });

	        loan.setStatus("PENDING");
	        return iLoanRepository.save(loan);
	    }

	    public List<Loan> getAllLoans() {
	        return iLoanRepository.findAll();
	    }

	    public Loan getLoanById(Long id) {
	        return iLoanRepository.findById(id)
	                .orElseThrow(() -> new LoanNotFoundException("Loan not found"));
	    }

	    public Loan updateLoanStatus(Long id, String status) {
	        Loan loan = getLoanById(id);
	        loan.setStatus(status);
	        return iLoanRepository.save(loan);
	    }

	

}

