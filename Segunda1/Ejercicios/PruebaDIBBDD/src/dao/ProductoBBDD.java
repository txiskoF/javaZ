package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import util.Conexion;

public class ProductoBBDD implements ProductoDAO {
	
	private Conexion conexion;
	
		public ProductoBBDD(Conexion conexion) {
		super();
		this.conexion = conexion;
	}

	@Override
	public void añadirProducto(Producto p) {
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(
					"insert into productos(nombre) values(?)");
			pst.setString(1, p.getNombre());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void eliminarProducto(Producto p) {
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(
					"delete productos where prod_no=?");
			pst.setInt(1, p.getProdNo());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Producto getProducto(Integer id) {
		Producto p = null;
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(
					"select * from productoswhere prod_no=?");
			pst.setString(1, p.getNombre());
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
		return null;
	}

	private Producto cargarProducto(ResultSet rst) {
		Producto p = new Producto();
		
			try {
				p.setNombre(rst.getString("nombre"));
				p.setProdNo(rst.getInt("prod_no"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p;		
	}

	@Override
	public List<Producto> getProductos() {
		List<Producto> productos = new ArrayList<>();
		try {
			ResultSet rst = conexion.getConexion().createStatement().executeQuery(
					"Select * From Productos");
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
	
}
