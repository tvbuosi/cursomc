package com.thiagobuosi.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiagobuosi.cursomc.domain.Cidade;
import com.thiagobuosi.cursomc.domain.Estado;
import com.thiagobuosi.cursomc.dto.CidadeDTO;
import com.thiagobuosi.cursomc.dto.EstadoDTO;
import com.thiagobuosi.cursomc.services.CidadeService;
import com.thiagobuosi.cursomc.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService CidadeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map( obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		
		List<Cidade> list = CidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDto = list.stream().map( obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
}
