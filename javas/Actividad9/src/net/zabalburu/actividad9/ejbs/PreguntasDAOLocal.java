package net.zabalburu.actividad9.ejbs;

import java.util.List;

import javax.ejb.Local;

import net.zabalburu.actividad9.modelo.Pregunta;

@Local
public interface PreguntasDAOLocal {
	List<Pregunta> getPreguntas();
	List<Pregunta> getRespuestas (Integer Id);
	void nuevaPregunta(Pregunta p);
	void nuevaRespuesta(Integer id, Pregunta respuesta);

}
