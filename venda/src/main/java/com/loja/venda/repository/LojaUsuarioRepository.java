package com.loja.venda.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.venda.model.LojaUsuarioModel;

public interface LojaUsuarioRepository extends JpaRepository<LojaUsuarioModel, Long>
{
	public List<LojaUsuarioModel> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
