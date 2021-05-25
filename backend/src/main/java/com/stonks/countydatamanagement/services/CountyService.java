package com.stonks.countydatamanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.CountyDTO;
import com.stonks.countydatamanagement.entities.County;
import com.stonks.countydatamanagement.entities.Website;
import com.stonks.countydatamanagement.repositories.CountyRepository;
import com.stonks.countydatamanagement.repositories.WebsiteRepository;

@Service
public class CountyService {

	@Autowired
	private CountyRepository repository;
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Transactional
	public CountyDTO insert (CountyDTO dto) {
		
		County entity = new County();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CountyDTO(entity);
		
	}
	
	@Transactional(readOnly = true)
	public CountyDTO findById(Long id) {
		County county = repository.findById(id).get();
		return new CountyDTO(county);		
	}
	
	@Transactional
	public CountyDTO update (Long id, CountyDTO dto) {
		County entity = repository.getById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CountyDTO(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(CountyDTO dto, County entity) {
		
		Website website = websiteRepository.getById(dto.getWebSiteId());
		
		entity.setCountyName(dto.getCountyName());
		entity.setMayorName(dto.getMayorName());
		entity.setPopulation(dto.getPopulation());
		entity.setWebSite(website);
		
	}
	
}
