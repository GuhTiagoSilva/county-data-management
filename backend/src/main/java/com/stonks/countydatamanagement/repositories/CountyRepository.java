package com.stonks.countydatamanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.County;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {

}
