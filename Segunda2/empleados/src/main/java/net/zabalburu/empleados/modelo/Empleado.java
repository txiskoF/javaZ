package net.zabalburu.empleados.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
		@Id
		@Column (name= "employeeid")
		private Integer id;

		@Column(name="lastname")
	    private String apellidos;
	    
	    @Column(name="firstname")
	    private String nombre;
	    
	    private String extension;

		public Empleado() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Empleado(Integer id, String apellidos, String nombre, String extension) {
			super();
			this.id = id;
			this.apellidos = apellidos;
			this.nombre = nombre;
			this.extension = extension;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
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
			Empleado other = (Empleado) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Empleado [id=" + id + ", apellidos=" + apellidos + ", nombre=" + nombre + ", extension=" + extension
					+ "]";
		}
	    

}
