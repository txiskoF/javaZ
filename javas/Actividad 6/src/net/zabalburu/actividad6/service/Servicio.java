package net.zabalburu.actividad6.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.zabalburu.actividad6.dao.ReparacionDAO;
import net.zabalburu.actividad6.dao.UsuarioDAO;
import net.zabalburu.actividad6.modelo.Reparacion;
import net.zabalburu.actividad6.modelo.Usuario;

public class Servicio {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private ReparacionDAO reparacionDAO = new ReparacionDAO();
	
	public void reparar(Integer rep_no, String reparador, Double coste) {
		Reparacion r = reparacionDAO.getReparacion(rep_no);
		r.setReparador(reparador);
		r.setCoste(coste);
		r.setFechaReparacion(new Date());
		reparacionDAO.actualizarReparacion(r);
	}
	
	public List<Reparacion> getReparacionesUsuario(String usuario){
		List<Reparacion> rep = new ArrayList<>();
		for(Reparacion r : reparacionDAO.getReparaciones()) {
			if (r.getUsuario().equalsIgnoreCase(usuario)) {
				rep.add(r);
			}
		}
		return rep;
	}
	
	public List<Reparacion> getReparacionesPendientes(){
		List<Reparacion> rep = new ArrayList<>();
		for(Reparacion r : reparacionDAO.getReparaciones()) {
			if (r.getFechaReparacion() == null) {
				rep.add(r);
			}
		}
		return rep;
	}
	
	public Usuario login(String nombre, String password) {
		Usuario usuario = usuarioDAO.getUsuario(nombre);
		if (usuario != null) {
			if (!usuario.getPassword().equals(password)) {
				usuario = null;
			}
		}
		return usuario;
	}
	
	public void añadirReparacion(Reparacion r) {
		reparacionDAO.añadirReparacion(r);
	}
	
	public void eliminarReparacion(Integer rep_no) {
		reparacionDAO.eliminarReparacion(rep_no);
	}
	
	public List<Reparacion> getReparaciones(){
		return reparacionDAO.getReparaciones();
	}
	
	public Reparacion getReparacion(Integer rep_no) {
		return reparacionDAO.getReparacion(rep_no);
	}
	public static void main(String[] args) {
		Servicio s = new Servicio();
		/*Reparacion r = s.getReparacion(1);
		System.out.println(r);
		s.reparar(1, "marta", 20.0);
		System.out.println(r);
		for(Reparacion r : s.getReparacionesUsuario("marta")) {
			System.out.println(r);
		}
		for(Reparacion r : s.getReparacionesPendientes()) {
			System.out.println(r);
		}*/
		System.out.println(s.login("marta", "1234"));
		System.out.println(s.login("marta", "marta"));
	}
	
}
