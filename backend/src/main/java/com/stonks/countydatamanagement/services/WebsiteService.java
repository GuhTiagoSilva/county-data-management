package com.stonks.countydatamanagement.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.WebsiteDTO;
import com.stonks.countydatamanagement.entities.Website;
import com.stonks.countydatamanagement.repositories.WebsiteRepository;
import com.stonks.countydatamanagement.services.exceptions.DatabaseException;
import com.stonks.countydatamanagement.services.exceptions.ResourceNotFoundException;

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
	public WebsiteDTO update(Long id, WebsiteDTO dto) {
		try {
			Website entity = repository.getById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new WebsiteDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional(readOnly = true)
	public WebsiteDTO findById(Long id) {
		Optional<Website> result = repository.findById(id);
		Website entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new WebsiteDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<WebsiteDTO> findAll(PageRequest request) {
		Page<Website> results = repository.findAll(request);
		return results.map(result -> new WebsiteDTO(result));
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("DatabaseException");
		}
	}

	private void copyDtoToEntity(WebsiteDTO dto, Website entity) {
		entity.setLink(dto.getLink());
	}
}
