package com.loja.venda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.venda.model.LojaUsuarioModel;
import com.loja.venda.repository.LojaUsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LojaUsuarioController 
{
	@Autowired
	private LojaUsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<LojaUsuarioModel>> GetAll()
	{
		return ResponseEntity.ok(this.repository.findAll());
	}
}
