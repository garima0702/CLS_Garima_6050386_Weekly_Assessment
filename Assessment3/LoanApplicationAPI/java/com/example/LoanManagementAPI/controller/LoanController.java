package com.example.LoanManagementAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoanManagementAPI.entity.Loan;
import com.example.LoanManagementAPI.service.ILoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private ILoanService iLoanservice;

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return iLoanservice.createLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return iLoanservice.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return iLoanservice.getLoanById(id);
    }

    @PutMapping("/{id}/status")
    public Loan updateStatus(@PathVariable Long id, @RequestBody Loan loan) {
        return iLoanservice.updateLoanStatus(id, loan.getStatus());
    }
}
