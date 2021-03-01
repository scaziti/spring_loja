package com.loja.venda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
