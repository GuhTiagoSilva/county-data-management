package com.stonks.countydatamanagement.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.WebSiteDTO;
import com.stonks.countydatamanagement.entities.WebSite;
import com.stonks.countydatamanagement.repositories.WebSiteRepository;

@Service
public class WebSiteService {

	@Autowired
	private WebSiteRepository repository;
	
	@Transactional
	public WebSiteDTO insert(WebSiteDTO dto) {
		WebSite entity = new WebSite();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new WebSiteDTO(entity);
	}
	
	@Transactional
	public WebSiteDTO update(Long id,WebSiteDTO dto) {
		WebSite entity = repository.getById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new WebSiteDTO(entity);
		
	}
	
	@Transactional(readOnly = true)
	public WebSiteDTO findById(Long id) {
		WebSite entity = repository.findById(id).get();
		return new WebSiteDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<WebSiteDTO> findAll(PageRequest request){
		Page<WebSite> results = repository.findAll(request);
		return results.map(result -> new WebSiteDTO(result));
	}
	
	
	public void delete(Long id) {
		WebSite entity = repository.getById(id);
		repository.delete(entity);
	}

	private void copyDtoToEntity(WebSiteDTO dto, WebSite entity) {
		entity.setLink(dto.getLink());
	}	
}
