package net.zabalburu.discos.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "albumid")
	private Album album;

	@Column(name="fechapedido")
	private Date fechaPedido;
	
	private Integer pagado;

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(Integer id, Cliente cliente, Album album, Date fechaPedido, Integer pagado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.album = album;
		this.fechaPedido = fechaPedido;
		this.pagado = pagado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Integer getPagado() {
		return pagado;
	}

	public void setPagado(Integer pagado) {
		this.pagado = pagado;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", album=" + album + ", fechaPedido=" + fechaPedido
				+ ", pagado=" + pagado + "]";
	}

}
