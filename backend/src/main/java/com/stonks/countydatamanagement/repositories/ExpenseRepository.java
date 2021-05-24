package com.stonks.countydatamanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>  {

}
