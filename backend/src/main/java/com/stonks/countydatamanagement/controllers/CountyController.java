package com.stonks.countydatamanagement.controllers;

import java.net.URI;
import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stonks.countydatamanagement.dto.CountyDTO;
import com.stonks.countydatamanagement.entities.views.CountyView;
import com.stonks.countydatamanagement.services.CountyService;

@RestController
@RequestMapping(value = "/counties")
public class CountyController {
	
	@Autowired
	private CountyService service;
	
	@PostMapping
	public ResponseEntity<CountyDTO> insert(@RequestBody CountyDTO dto){
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CountyDTO> update (@PathVariable Long id, @RequestBody CountyDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CountyDTO> findById (@PathVariable Long id){
		CountyDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<List<CountyDTO>> findAll() {
		List<CountyDTO> counties = service.findAll();
		return ResponseEntity.ok(counties);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
