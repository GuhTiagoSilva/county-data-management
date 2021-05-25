package com.stonks.countydatamanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.views.IncomeSumView;

@Repository
public interface IncomeViewRepository extends JpaRepository<IncomeSumView, Long> {

	@Query(value = "SELECT * FROM VW_INCOME", nativeQuery = true)
	List<IncomeSumView> findIncomeSumByCounty();
	
}
