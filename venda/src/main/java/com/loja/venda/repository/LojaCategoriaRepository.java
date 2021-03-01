package com.loja.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.venda.model.LojaCategoriaModel;

@Repository
public interface LojaCategoriaRepository extends JpaRepository<LojaCategoriaModel, Long> 
{
	public List<LojaCategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
}
