package net.zabalburu.actividad6.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import net.zabalburu.actividad6.modelo.Reparacion;

public class ReparacionDAO {
	private List<Reparacion> reparaciones = new ArrayList<Reparacion>();
	
	public ReparacionDAO() {
		reparaciones.add(new Reparacion(1,"marta","Ordenador",new GregorianCalendar(2020,9,7).getTime(),"El equipo PC123 no funciona"));
		reparaciones.add(new Reparacion(2,"marta","Internet",new GregorianCalendar(2020,9,5).getTime(),"No va internet en DAW2",
				new GregorianCalendar(2020,9,5).getTime(),23.5,"itziar"));
		reparaciones.add(new Reparacion(3,"javi","Ordenador",new GregorianCalendar(2020,9,9).getTime(),"El equipo PC200 no funciona"));
		reparaciones.add(new Reparacion(4,"marta","Monitor",new GregorianCalendar(2020,9,7).getTime(),"Hace falta un monitor en el aula 202",
				new GregorianCalendar(2020,9,5).getTime(),23.5,"itziar"));
	}
	
	public Reparacion getReparacion(Integer rep_no) {
		Reparacion r = new Reparacion();
		r.setRep_no(rep_no);
		int pos = reparaciones.indexOf(r);
		if (pos != -1) {
			r = reparaciones.get(pos);
		} else {
			r = null;
		}
		return r;
	}
	
	public void añadirReparacion(Reparacion r) {
		if (r.getFechaSolicitud() == null) {
			r.setFechaSolicitud(new Date());
		}
		int rep_no = 1;
		if (!reparaciones.isEmpty()) {
			rep_no = reparaciones.get(reparaciones.size()-1).getRep_no()+1;
		}
		r.setRep_no(rep_no);
		reparaciones.add(r);
	}
	
	public void eliminarReparacion(Integer rep_no) {
		Reparacion r = getReparacion(rep_no);
		if (r != null) {
			this.reparaciones.remove(r);
		}
	}
	
	public List<Reparacion> getReparaciones() {
		return reparaciones;
	}
	
	public void actualizarReparacion(Reparacion r) {
		Reparacion modificar = getReparacion(r.getRep_no());
		modificar.setCoste(r.getCoste());
		modificar.setDescripcion(r.getDescripcion());
		modificar.setElemento(r.getElemento());
		modificar.setFechaReparacion(r.getFechaReparacion());
		modificar.setFechaSolicitud(r.getFechaSolicitud());
		modificar.setReparador(r.getReparador());
		modificar.setUsuario(r.getUsuario());
	}
	
	public static void main(String[] args) {
		ReparacionDAO dao = new ReparacionDAO();
		Reparacion r = new Reparacion(0,"marta","Nuevo",new GregorianCalendar(2020,9,7).getTime(),"Nuevo");
		dao.añadirReparacion(r);
		r = dao.getReparacion(2);
		System.out.println(r);
		r.setReparador("argeme");
		dao.eliminarReparacion(1);
		for (Reparacion rep : dao.getReparaciones()) {
			System.out.println(rep);
		}
		
	}
	
}
