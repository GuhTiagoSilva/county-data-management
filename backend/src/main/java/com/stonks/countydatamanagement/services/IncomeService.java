package com.stonks.countydatamanagement.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.IncomeDTO;
import com.stonks.countydatamanagement.entities.Income;
import com.stonks.countydatamanagement.entities.enums.IncomeType;
import com.stonks.countydatamanagement.repositories.IncomeRepository;
import com.stonks.countydatamanagement.services.exceptions.DatabaseException;
import com.stonks.countydatamanagement.services.exceptions.ResourceNotFoundException;

@Service
public class IncomeService {

	@Autowired
	private IncomeRepository repository;

	@Transactional
	public IncomeDTO insert(IncomeDTO dto) {
		Income entity = new Income();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new IncomeDTO(entity);
	}

	@Transactional
	public IncomeDTO update(Long id, IncomeDTO dto) {
		try {
			Income entity = repository.getById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new IncomeDTO(entity);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Not Found: " + id);
		}
		
	}

	@Transactional(readOnly = true)
	public IncomeDTO findById(Long id) {
		Optional<Income> result = repository.findById(id);
		Income entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new IncomeDTO(entity);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Database Exception");
		}
	}

	private void copyDtoToEntity(IncomeDTO dto, Income entity) {
		entity.setApplication(dto.getApplication());
		entity.setBudgetedValue(dto.getBudgetedValue());
		entity.setCollectedValue(dto.getCollectedValue());
		entity.setDescription(dto.getDescription());
		entity.setFont(dto.getFont());
		entity.setIncomeDate(dto.getIncomeDate());
		entity.setType(IncomeType.toEnum(dto.getType()));
	}

}
