package com.stonks.countydatamanagement.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.CountyDTO;
import com.stonks.countydatamanagement.dto.ExpenseDTO;
import com.stonks.countydatamanagement.dto.IncomeDTO;
import com.stonks.countydatamanagement.entities.County;
import com.stonks.countydatamanagement.entities.Expense;
import com.stonks.countydatamanagement.entities.Income;
import com.stonks.countydatamanagement.entities.Website;
import com.stonks.countydatamanagement.entities.views.CountyView;
import com.stonks.countydatamanagement.repositories.CountyRepository;
import com.stonks.countydatamanagement.repositories.CountyViewRepository;
import com.stonks.countydatamanagement.repositories.ExpenseRepository;
import com.stonks.countydatamanagement.repositories.IncomeRepository;
import com.stonks.countydatamanagement.repositories.WebsiteRepository;
import com.stonks.countydatamanagement.services.exceptions.DatabaseException;
import com.stonks.countydatamanagement.services.exceptions.ResourceNotFoundException;

@Service
public class CountyService {

	@Autowired
	private CountyRepository repository;
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private CountyViewRepository countyViewRepository;
	
	
	@Transactional
	public CountyDTO insert (CountyDTO dto) {
		
		County entity = new County();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CountyDTO(entity);
		
	}
	
	@Transactional(readOnly = true)
	public CountyDTO findById(Long id) {
		Optional<County> result = repository.findById(id);
		County county = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new CountyDTO(county);		
	}
	
	@Transactional
	public CountyDTO update (Long id, CountyDTO dto) {
		try {
			County entity = repository.getById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new CountyDTO(entity);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
		
	}
	
	@Transactional(readOnly = true)
	public Page<CountyView> findAllJoined(PageRequest pageRequest){
		Page<CountyView> countyView = countyViewRepository.findAllCountyView(pageRequest);
		return countyView;
	}

	@Transactional(readOnly = true)
	public List<CountyDTO> findAll() {
		List<County> counties = repository.findAll();
		return counties.stream().map(county -> new CountyDTO(county)).collect(Collectors.toList());
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);	
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found: " + id);
		}catch( DataIntegrityViolationException e ) {
			throw new DatabaseException("Database Exception");
		}
	}
	
	private void copyDtoToEntity(CountyDTO dto, County entity) {
		entity.setName(dto.getName());
		entity.setMayorName(dto.getMayorName());
		entity.setPopulation(dto.getPopulation());
		entity.setWebSite(null);

	}
	
}
