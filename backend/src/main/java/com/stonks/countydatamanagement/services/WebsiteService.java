package com.stonks.countydatamanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.WebsiteDTO;
import com.stonks.countydatamanagement.entities.Website;
import com.stonks.countydatamanagement.repositories.WebsiteRepository;

@Service
public class WebsiteService {

	@Autowired
	private WebsiteRepository repository;
	
	@Transactional
	public WebsiteDTO insert(WebsiteDTO dto) {
		Website entity = new Website();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new WebsiteDTO(entity);
	}
	
	@Transactional
	public WebsiteDTO update(Long id,WebsiteDTO dto) {
		Website entity = repository.getById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new WebsiteDTO(entity);
		
	}
	
	@Transactional(readOnly = true)
	public WebsiteDTO findById(Long id) {
		Website entity = repository.findById(id).get();
		return new WebsiteDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<WebsiteDTO> findAll(PageRequest request){
		Page<Website> results = repository.findAll(request);
		return results.map(result -> new WebsiteDTO(result));
	}
	
	
	public void delete(Long id) {
		Website entity = repository.getById(id);
		repository.delete(entity);
	}

	private void copyDtoToEntity(WebsiteDTO dto, Website entity) {
		entity.setLink(dto.getLink());
	}	
}
