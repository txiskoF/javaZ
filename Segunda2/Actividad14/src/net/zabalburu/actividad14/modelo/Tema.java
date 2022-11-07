package net.zabalburu.actividad14.modelo;

public class Tema {
	private Integer id;
	private String descripción;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	public Tema(Integer id, String descripción) {
		super();
		this.id = id;
		this.descripción = descripción;
	}
	public Tema() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tema [id=" + id + ", descripción=" + descripción + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}


