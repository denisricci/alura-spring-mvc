package br.com.alura.loja.dao;

import java.util.List;

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

	public void salvar(Produto produto) {
		this.manager.persist(produto);
	}

	public List<Produto> listar() {
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public Produto findById(int id) {
		return manager
				.createQuery("select distinct(p) from Produto p join fetch p.precos where p.id = :id", Produto.class)
				.setParameter("id", id).getSingleResult();
	}
}
