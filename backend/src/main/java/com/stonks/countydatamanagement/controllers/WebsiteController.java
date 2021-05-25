package com.stonks.countydatamanagement.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stonks.countydatamanagement.dto.WebsiteDTO;
import com.stonks.countydatamanagement.services.WebsiteService;

@RestController
@RequestMapping(value = "/websites")
public class WebsiteController {

	@Autowired
	private WebsiteService service;
	
	@PostMapping
	public ResponseEntity<WebsiteDTO> insert(@RequestBody WebsiteDTO dto){
		WebsiteDTO webSiteDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(webSiteDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(webSiteDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<WebsiteDTO> update(@PathVariable Long id, @RequestBody WebsiteDTO dto){
		WebsiteDTO webSiteDTO = service.update(id, dto);
		return ResponseEntity.ok().body(webSiteDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WebsiteDTO> findById (@PathVariable Long id){
		WebsiteDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
