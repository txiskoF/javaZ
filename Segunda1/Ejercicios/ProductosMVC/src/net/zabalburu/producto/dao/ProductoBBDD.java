package net.zabalburu.producto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.zabalburu.producto.util.*;
import net.zabalburu.producto.modelo.Categoria;
import net.zabalburu.producto.modelo.Producto;

@Repository(value="productoBBDD")
public class ProductoBBDD implements ProductoDAO {
	@Autowired
	private Conexion conexion;
	
	@Override
	public List<Producto> getProductos() {
		List<Producto> productos = new ArrayList<>();
		try {
			ResultSet rst = conexion.getConexion()
					.createStatement()
					.executeQuery("Select * From Productos");
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
			p.setFechaCompra(rst.getDate("fechaCompra"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Producto getProducto(Integer id) {
		Producto p = null;
		try {
			PreparedStatement pst = conexion.getConexion()
					.prepareStatement(
					"Select * From Productos where id=?");
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				p = cargarProducto(rst);
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void nuevoProducto(Producto p) {
		try {
			PreparedStatement pst = conexion.getConexion()
					.prepareStatement(
					"Insert Into Productos(nombre,precio,fechaCompra) values(?,?,?)");
			pst.setString(1,p.getNombre());
			pst.setDouble(2, p.getPrecio());
			pst.setDate(3, new java.sql.Date(p.getFechaCompra().getTime()));
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarProducto(Producto p) {
		eliminarProducto(p.getId());
	}

	@Override
	public void eliminarProducto(Integer id) {
		try {
			PreparedStatement pst = conexion.getConexion()
					.prepareStatement(
					"Delete Productos where id=?");
			pst.setInt(1,id);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Categoria> getCategorias() {
		List<Categoria> categorias = new ArrayList<>();
		try {
			ResultSet rst = conexion.getConexion()
					.createStatement()
					.executeQuery("Select * From Categorias");
			while (rst.next()) {
				categorias.add(cargarCategoria(rst));
			}
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public Categoria getCategoria(Integer id) {
		Categoria c = null;
		try {
			PreparedStatement pst = conexion.getConexion()
					.prepareStatement(
					"Select * From Categorias where id=?");
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				c = cargarCategoria(rst);
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	private Categoria cargarCategoria(ResultSet rst) {
		Categoria c = new Categoria();
		try {
			c.setId(rst.getInt("id"));
			c.setDescripcion(rst.getString("descripcion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
}
