package net.zabalburu.clientenoticias.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NoticiasControlador {

	
	@Autowired
	private NoticiasServicio servicio;
}
