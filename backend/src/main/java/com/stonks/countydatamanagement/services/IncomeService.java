package com.stonks.countydatamanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.IncomeDTO;
import com.stonks.countydatamanagement.entities.Income;
import com.stonks.countydatamanagement.entities.enums.IncomeType;
import com.stonks.countydatamanagement.repositories.IncomeRepository;

@Service
public class IncomeService {

	@Autowired
	private IncomeRepository repository;
	
	@Transactional
	public IncomeDTO insert (IncomeDTO dto) {
		Income entity = new Income();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new IncomeDTO(entity);
	}
	
	@Transactional
	public IncomeDTO update (Long id, IncomeDTO dto) {
		Income entity = repository.getById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new IncomeDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public IncomeDTO findById (Long id) {
		Income entity = repository.findById(id).get();
		return new IncomeDTO(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
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
