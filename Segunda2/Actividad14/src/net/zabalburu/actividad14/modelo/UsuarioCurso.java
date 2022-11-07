package net.zabalburu.actividad14.modelo;

public class UsuarioCurso {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Usuario usuario;
	private Curso curso;
	public UsuarioCurso(Integer id,Usuario usuario, Curso curso) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.curso = curso;
	}
	public UsuarioCurso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "UsuarioCurso [usuario=" + usuario + ", curso=" + curso + "]";
	}
	
	
	
}
