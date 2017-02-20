package br.com.alura.loja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.enums.TipoPreco;
import br.com.alura.loja.infra.FileSaver;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.validators.ProdutoValidator;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;
	
	@Autowired
	private FileSaver fileSaver;

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
	//para o multipartfile funcionar eh necessario uma configuracao na AppWebConfiguration(multipartResolver)
	//e uma configuracao na ServletSpringMvc(customizeRegistration)
	//alem disso o formulario no jsp precisa conter enctype="multipart/form-data"
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(MultipartFile sumario, @Valid Produto produto, BindingResult bindResult,
			RedirectAttributes redirectAttributes) {
				
		if (bindResult.hasErrors()) {
			return form(produto);
		}
		
		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
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
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ModelAndView detalhes(@PathVariable("id")int id){
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = dao.findById(id);
		modelAndView.addObject("produto", produto);		
		return modelAndView;
	}

}
