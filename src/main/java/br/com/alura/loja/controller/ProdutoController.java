package br.com.alura.loja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.enums.TipoPreco;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.validators.ProdutoValidator;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;

	@InitBinder
	public void initBinders(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProdutoValidator());
	}

	@RequestMapping("form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Produto produto, BindingResult bindResult,
			RedirectAttributes redirectAttributes) {
		if (bindResult.hasErrors()) {
			return form(produto);
		}

		dao.salvar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		List<Produto> produtos = dao.listar();
		model.addAttribute("produtos", produtos);
		return "produtos/lista";
	}

}
