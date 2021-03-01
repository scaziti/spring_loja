package com.loja.venda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.venda.model.LojaProdutoModel;
import com.loja.venda.repository.LojaProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LojaProdutoController 
{
	@Autowired
	private LojaProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<LojaProdutoModel>> GetAll()
	{
		return ResponseEntity.ok(this.repository.findAll());
	}
	
	@GetMapping("/nome/{nomeProduto}")
	public ResponseEntity<List<LojaProdutoModel>> GetByNome(@PathVariable String nomeProduto)
	{
		return ResponseEntity.ok(this.repository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
	}
}
