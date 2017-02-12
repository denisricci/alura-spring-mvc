package br.com.alura.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.enums.TipoPreco;
import br.com.alura.loja.model.Produto;

@Controller
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;

	@RequestMapping("form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Produto produto) {
		dao.salvar(produto);
		return "produtos/ok";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {		
		List<Produto> produtos = dao.listar();
		model.addAttribute("produtos", produtos);
		return "produtos/lista";
	}

}
