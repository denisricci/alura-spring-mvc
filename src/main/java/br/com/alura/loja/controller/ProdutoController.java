package br.com.alura.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.enums.TipoPreco;
import br.com.alura.loja.model.Produto;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;

	@RequestMapping("produtos/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public String salvar(Produto produto) {
		dao.salvar(produto);
		return "produtos/ok";
	}

}
