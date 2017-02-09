package br.com.alura.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.loja.model.Produto;

@Transactional
@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	
	public void salvar(Produto produto){
		this.manager.persist(produto);
	}
}
