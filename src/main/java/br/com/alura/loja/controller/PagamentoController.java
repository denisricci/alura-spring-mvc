package br.com.alura.loja.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.loja.model.CarrinhoCompras;
import br.com.alura.loja.model.DadosPagamento;

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinhoCompras;

	@Autowired
	private RestTemplate restTemplate;

	private static final String paymentUrl = "http://book-payment.herokuapp.com/payment";

	@RequestMapping(value = "/finalizar", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizar(RedirectAttributes attributes) {
		return ()->{
			System.out.println(carrinhoCompras.getTotal());		
		try {
			attributes.addFlashAttribute("sucesso", "Pagamento finalizado com sucesso!!");
			String response = restTemplate
					.postForEntity(paymentUrl, new DadosPagamento(carrinhoCompras.getTotal()), String.class).getBody();
			System.out.println(response);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			attributes.addFlashAttribute("falha", "Valor maior que o permitido");
		}
			return new ModelAndView("redirect:/produtos");
		};
	}

}
