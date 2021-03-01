package com.loja.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.loja.venda.model.LojaProdutoModel;

@Repository
public interface LojaProdutoRepository extends JpaRepository<LojaProdutoModel, Long>
{
	public List<LojaProdutoModel> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
}
