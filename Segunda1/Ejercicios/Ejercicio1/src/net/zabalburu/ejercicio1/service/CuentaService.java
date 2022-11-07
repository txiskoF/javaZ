package net.zabalburu.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.ejercicio1.dao.CuentasDAO;
import net.zabalburu.ejercicio1.modelo.Cliente;
import net.zabalburu.ejercicio1.modelo.Concepto;
import net.zabalburu.ejercicio1.modelo.Operacion;

@Service
public class CuentaService {
	@Autowired
	private CuentasDAO dao;
	
	public Cliente getCliente(String nombre) {
		return dao.getCliente(nombre);
	}
	
	public List<Concepto> getConceptos(String tipo){
		return dao.getConceptos(tipo);
	}
	
	public List<Concepto> getConceptos(){
		return dao.getConceptos();
	}
	
	public Concepto getConcepto(Integer id) {
		return dao.getConcepto(id);
	}
	
	public void nuevoConcepto(Concepto c) {
		dao.nuevoConcepto(c);
	}
	
	public Operacion getOperacion(Integer id) {
		return dao.getOperacion(id);
	}
	
	public void nuevaOperacion(Operacion o) {
		dao.nuevaOperacion(o);
	}
	
	public void eliminarOperacion(Operacion o) {
		dao.eliminarOperacion(o);
	}
	
	public void eliminarOperacion(Integer id) {
		dao.eliminarOperacion(id);
	}
	
	public Cliente login(String nombre, String password) {
		Cliente c = this.getCliente(nombre);
		if (c != null) {
			if (!c.getPassword().equals(password)) {
				c = null;
			}
		}
		return c;
	}
}
