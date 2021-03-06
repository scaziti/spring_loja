package com.loja.venda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.venda.model.LojaCategoriaModel;
import com.loja.venda.repository.LojaCategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LojaCategoriaController 
{
	@Autowired
	private LojaCategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<LojaCategoriaModel>> GetAll()
	{
		return ResponseEntity.ok(this.repository.findAll());
	}
	
	@GetMapping("/nome/{nomeCategoria}")
	public ResponseEntity<List<LojaCategoriaModel>> GetByNome(@PathVariable String nomeCategoria)
	{
		return ResponseEntity.ok(this.repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<LojaCategoriaModel> GetById(@PathVariable Long idCategoria)
	{
		return this.repository.findById(idCategoria)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<LojaCategoriaModel> post(@RequestBody LojaCategoriaModel categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<LojaCategoriaModel> put(@RequestBody LojaCategoriaModel categoria)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.repository.save(categoria));
	}
	
	@DeleteMapping("/{idCategoria}")
	public void delete(@PathVariable Long idCategoria)
	{
		this.repository.deleteById(idCategoria);
	}
}
