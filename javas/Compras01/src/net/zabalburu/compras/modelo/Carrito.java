package net.zabalburu.compras.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	//Un id de carrito
	private Integer id;
	//El usuario 
	private Usuario usuario;
	//Lista con los productos del carrito
	private List<DetalleCarrito> detalles = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleCarrito> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCarrito> detalles) {
		this.detalles = detalles;
	}

	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	
	//Para añadir productos al carrito y ver los detalles
	public void añadirDetalle(DetalleCarrito dc) {
		detalles.add(dc);
	}
	
	//Quitar productos del carrito
	public void quitarDetalle(DetalleCarrito dc) {
		/*int i;
		for(i=0; i<detalles.size() && 
			!(detalles.get(i).getProducto().getId().equals(
					dc.getProducto().getId()) && 
			detalles.get(i).getCantidad()==dc.getCantidad());i++);
		if (i < detalles.size()) {
			detalles.remove(i);
		}*/
		detalles.remove(dc);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalles == null) ? 0 : detalles.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Carrito other = (Carrito) obj;
		if (detalles == null) {
			if (other.detalles != null)
				return false;
		} else if (!detalles.equals(other.detalles))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", usuario=" + usuario + ", detalles=" + detalles + "]";
	}

}
