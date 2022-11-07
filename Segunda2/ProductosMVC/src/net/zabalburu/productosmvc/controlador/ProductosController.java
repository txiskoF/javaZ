package net.zabalburu.productosmvc.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;                                  


@Controller
public class ProductosController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
