package br.com.alura.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.enums.TipoPreco;
import br.com.alura.loja.model.CarrinhoCompras;
import br.com.alura.loja.model.CarrinhoItem;
import br.com.alura.loja.model.Produto;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {

	@Autowired
	private CarrinhoCompras carrinhoCompras;

	@Autowired
	private ProdutoDAO produtoDao;

	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		carrinhoCompras.addItem(criaItem(produtoId, tipoPreco));
		return modelAndView;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ModelAndView remove(Integer produtoId, TipoPreco tipoPreco){
		carrinhoCompras.removeItem(produtoId, tipoPreco);
		return new ModelAndView("redirect:/carrinho");
	}

	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
		Produto produto = produtoDao.findById(produtoId);
		CarrinhoItem item = new CarrinhoItem(produto, tipoPreco);
		return item;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
		return new ModelAndView("/carrinho/itens");
	}
}
