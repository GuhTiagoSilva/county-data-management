package com.stonks.countydatamanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.Website;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {

}
