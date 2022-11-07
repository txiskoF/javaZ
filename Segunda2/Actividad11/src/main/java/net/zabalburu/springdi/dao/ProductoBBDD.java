package net.zabalburu.springdi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.zabalburu.springdi.conexion.Conexion;
import net.zabalburu.springdi.modelo.Categoria;
import net.zabalburu.springdi.modelo.Producto;

public class ProductoBBDD implements ProductoDAO {
	
	private Conexion conexion;
	
	public ProductoBBDD(Conexion conexion) {
		super();
		this.conexion = conexion;
	}

	public ProductoBBDD() {
		// TODO Auto-generated constructor stub
	}

	public List<Producto> getProductos() {
		List<Producto> productos = new ArrayList();
		try {
			ResultSet rst = conexion.getConexion().createStatement().executeQuery(
					"Select * From Productos11");
			while (rst.next()) {
				productos.add(cogerProducto(rst));
			}
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return productos;
	}

	public Producto getProducto(Integer id) {
		Producto p = null;
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(
					"select * from Productos11 where id=?");
			pst.setString(1, p.getNombre());
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				p = cogerProducto(rst);
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Producto cogerProducto(ResultSet rst) {
		Producto p = new Producto();
		try {
			p.setNombre(rst.getString("nombre"));
			p.setId(rst.getInt("id"));
			//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public List<Categoria> getCategorias() {
		List<Categoria> categorias = new ArrayList();
		try {
			ResultSet rst = conexion.getConexion().createStatement().executeQuery(
					"Select * From Categorias11");
			while (rst.next()) {
				categorias.add(cogerCategoria(rst));
			}
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return categorias;
	}

	public Categoria getCategoria(Integer id) {
		Categoria p = null;
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(
					"select * from Productos11 where id=?");
			pst.setString(1, p.getDescripcion());
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				p = cogerCategoria(rst);
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Categoria cogerCategoria(ResultSet rst) {
		Categoria c = new Categoria();
		try {
			c.setDescripcion(rst.getString("descripcion"));
			c.setId(rst.getInt("id"));
			//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public void nuevoProducto(Producto p) {
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(
					"insert into productos(nombre, idCategoria) values(?,?)");
			pst.setString(1, p. getNombre());
			pst.setInt(2, p.getCategoria().getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void eliminarProducto(Integer id) {
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(
					"delete from Productos11 where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
