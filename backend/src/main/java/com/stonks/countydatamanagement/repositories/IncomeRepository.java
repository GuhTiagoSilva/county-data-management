package com.stonks.countydatamanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

}
