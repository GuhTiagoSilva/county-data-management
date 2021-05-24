package com.stonks.countydatamanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.countydatamanagement.entities.WebSite;

@Repository
public interface WebSiteRepository extends JpaRepository<WebSite, Long> {

}
