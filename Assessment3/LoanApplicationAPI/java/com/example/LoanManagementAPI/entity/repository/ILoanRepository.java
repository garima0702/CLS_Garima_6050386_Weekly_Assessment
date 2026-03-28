package com.example.LoanManagementAPI.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LoanManagementAPI.entity.Loan;

@Repository
public interface ILoanRepository extends JpaRepository<Loan, Long> {
	Optional<Loan> findByApplicantNameAndStatus(String applicantName, String status);

}

