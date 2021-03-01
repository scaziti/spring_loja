package com.loja.venda.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.loja.venda.model.LojaUsuarioModel;

@Repository
public interface LojaUsuarioRepository extends JpaRepository<LojaUsuarioModel, Long>
{
	public List<LojaUsuarioModel> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
