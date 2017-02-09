package br.com.alura.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Produto;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;
	
	
	@RequestMapping("produtos/form")
	public String form() {
		return "produtos/form";
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public String salvar(Produto produto) {
		dao.salvar(produto);
		return "produtos/ok";
	}

}
