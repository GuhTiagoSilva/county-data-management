package com.stonks.countydatamanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.views.CountyView;

@Repository
public interface CountyViewRepository  extends JpaRepository<CountyView, Long> {

	@Query(value = "SELECT * FROM VW_COUNTY", nativeQuery = true)
	List<CountyView> findAllCountyView();
	
}
