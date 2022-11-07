package net.zabalburu.ejercicio1.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="operaciones")
public class Operacion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idConcepto")
	private Concepto concepto;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@NumberFormat(style = NumberFormat.Style.NUMBER)
	private Double importe;
	
	private String comentarios;

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

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Operacion [id=" + id + ", cliente=" + cliente + ", concepto=" + concepto + ", fecha=" + fecha
				+ ", importe=" + importe + ", comentarios=" + comentarios + "]";
	}
	
	
	
}
