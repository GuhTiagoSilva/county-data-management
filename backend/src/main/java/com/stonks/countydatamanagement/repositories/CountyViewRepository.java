package com.stonks.countydatamanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.views.CountyView;

@Repository
public interface CountyViewRepository  extends JpaRepository<CountyView, Long> {

	@Query(value = "SELECT * FROM VW_COUNTY", nativeQuery = true)
	Page<CountyView> findAllCountyView(Pageable pageable);
	
}
