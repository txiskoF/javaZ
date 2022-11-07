package net.zabalburu.actividad9.ejbs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import net.zabalburu.actividad9.modelo.Pregunta;

/**
 * Session Bean implementation class PreguntasDAO
 */
@Singleton
public class PreguntasDAO implements PreguntasDAOLocal {
	@EJB
	private UsuarioDAO dao;

	private List<Pregunta> preguntas = new ArrayList<Pregunta>();

    /**
     * Default constructor. 
     */
    public PreguntasDAO() {
    	preguntas.add(new Pregunta(0, dao.getUsuario(0), new Date(),"¿Cómo funciona?",0));
    	preguntas.add(new Pregunta(1, dao.getUsuario(1), new Date(),"¿Cómo se fabrica?",0));
    	preguntas.add(new Pregunta(2, dao.getUsuario(1), new Date(),"Funciona correctamente",1));
    }

	@Override
	public List<Pregunta> getPreguntas() {
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		for(Pregunta p: preguntas) {
			if (p.getRespuestaA().equals(0)) {
				preguntas.add(p);
			}
		}
		return preguntas;
	}

	@Override
	public List<Pregunta> getRespuestas(Integer Id) {
	List<Pregunta> respuestas = new ArrayList<Pregunta>();
	for(Pregunta p: this.preguntas) {
		if (p.getRespuestaA().equals(Id)) {
			respuestas.add(p);
		}
	}
	return respuestas;
	}

	@Override
	public void nuevaPregunta(Pregunta p) {
		Integer id = 1;
		if (preguntas.size()>0) {
			id = preguntas.size();
		}
		p.setId(id);
		preguntas.add(p);
	}

	@Override
	public void nuevaRespuesta(Integer id, Pregunta respuesta) {
		respuesta.setRespuestaA(id);
		nuevaPregunta(respuesta);
	}

	

}
