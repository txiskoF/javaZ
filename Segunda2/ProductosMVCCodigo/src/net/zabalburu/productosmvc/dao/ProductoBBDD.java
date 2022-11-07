package net.zabalburu.productosmvc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.productosmvc.modelo.Categoria;
import net.zabalburu.productosmvc.modelo.Producto;
import net.zabalburu.productosmvc.servicio.ProductoServicio;
import net.zabalburu.productosmvc.util.Conexion;

@Repository("productoBBDD")
public class ProductoBBDD implements ProductoDAO {
	@Autowired
	private Conexion conexion;
	
	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public ProductoBBDD() {
		// TODO Auto-generated constructor stub
	}

	public ProductoBBDD(Conexion conexion) {
		super();
		this.conexion = conexion;
	}

	public List<Producto> getProductos() {
		List<Producto> productos = new ArrayList<Producto>();
		try {
			ResultSet rst = conexion.getConexion().createStatement()
					.executeQuery("Select * From Productos Order By nombre");
			while (rst.next()) {
				productos.add(cargarProducto(rst));
			}
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}

	private Producto cargarProducto(ResultSet rst) {
		Producto p = new Producto();
		try {
			p.setId(rst.getInt("id"));
			p.setNombre(rst.getString("nombre"));
			p.setPrecio(rst.getDouble("precio"));
			p.setCategoria(getCategoria(rst.getInt("idCategoria")));
			p.setFechaCompra(rst.getDate("fechaCompra"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public Producto getProducto(Integer id) {
		Producto producto = null;
		try {
			PreparedStatement pst = conexion.getConexion()
				.prepareStatement("Select * From Productos Where id=?");
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				producto = cargarProducto(rst);
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}

	public List<Categoria> getCategorias() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			ResultSet rst = conexion.getConexion().createStatement()
					.executeQuery("Select * From Categorias Order By descripcion");
			while (rst.next()) {
				categorias.add(cargarCategoria(rst));
			}
			rst.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return categorias;
	}

	public Categoria getCategoria(Integer id) {
		Categoria categoria = null;
		try {
			PreparedStatement pst = conexion.getConexion()
				.prepareStatement("Select * From Categorias Where id=?");
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				categoria = cargarCategoria(rst);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoria;
	}

	private Categoria cargarCategoria(ResultSet rst) {
		Categoria categoria = new Categoria();
		try {
			categoria.setId(rst.getInt("id"));
			categoria.setDescripcion(rst.getString("descripcion"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return categoria;
	}

	public void nuevoProducto(Producto p) {
		try {
			PreparedStatement pst = conexion.getConexion()
					.prepareStatement("Insert Into Productos(nombre,precio,idCategoria, fechaCompra) values(?,?,?,?)");
			pst.setString(1, p.getNombre());
			pst.setDouble(2, p.getPrecio());
			pst.setInt(3, p.getCategoria().getId());
			pst.setDate(4, new java.sql.Date(p.getFechaCompra().getTime()));
			pst.executeUpdate();
			pst.close();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
	}

	public void eliminarProducto(Integer id) {
		try {
			PreparedStatement pst = conexion.getConexion()
					.prepareStatement("Delete Productos where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}

	}

}
