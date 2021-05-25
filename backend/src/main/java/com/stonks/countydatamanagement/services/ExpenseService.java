package com.stonks.countydatamanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.countydatamanagement.dto.ExpenseDTO;
import com.stonks.countydatamanagement.entities.Expense;
import com.stonks.countydatamanagement.entities.enums.ExpenseType;
import com.stonks.countydatamanagement.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository repository;
	
	@Transactional
	public ExpenseDTO insert (ExpenseDTO dto) {
		
		Expense entity = new Expense();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ExpenseDTO(entity);
		
	}
	
	@Transactional(readOnly = true)
	public ExpenseDTO findById (Long id) {
		Expense expense = repository.findById(id).get();
		return new ExpenseDTO(expense);
	}
	
	@Transactional
	public ExpenseDTO update(Long id, ExpenseDTO dto) {
		Expense expense = repository.getById(id);
		copyDtoToEntity(dto, expense);
		expense = repository.save(expense);
		return new ExpenseDTO(expense);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(ExpenseDTO dto, Expense entity) {
		entity.setBudgetedValue(dto.getBudgetedValue());
		entity.setCommitted(dto.isCommitted());
		entity.setCreditorName(dto.getCreditorName());
		entity.setExpenseDate(dto.getExpenseDate());
		entity.setFinished(dto.isFinished());
		entity.setHiredValue(dto.getHiredValue());
		entity.setPayed(dto.isPayed());
		entity.setSmash(dto.getSmash());
		entity.setSubSmash(dto.getSubSmash());
		entity.setType(ExpenseType.toEnum(dto.getType()));
	}
	
}
