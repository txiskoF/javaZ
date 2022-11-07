/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio2.servicio;

import java.util.List;
import net.zabalburu.ejercicio2.dao.CategoriaBBDD;
import net.zabalburu.ejercicio2.dao.CategoriaDAO;
import net.zabalburu.ejercicio2.dao.ProductoBBDD;
import net.zabalburu.ejercicio2.dao.ProductoDAO;
import net.zabalburu.ejercicio2.dao.ProveedorBBDD;
import net.zabalburu.ejercicio2.dao.ProveedorDAO;
import net.zabalburu.ejercicio2.modelo.Categoria;
import net.zabalburu.ejercicio2.modelo.Producto;
import net.zabalburu.ejercicio2.modelo.Proveedor;

/**
 *
 * @author ichueca
 */
public class ProductosServicio implements CategoriaDAO,
        ProductoDAO, ProveedorDAO{

    private CategoriaDAO categoriaDAO = new CategoriaBBDD();
    private ProductoDAO productoDAO = new ProductoBBDD();
    private ProveedorDAO proveedorDAO = new ProveedorBBDD();
    
    @Override
    public List<Categoria> getCategorias() {
        return categoriaDAO.getCategorias();
    }

    @Override
    public Producto getProducto(Integer id) {
        return productoDAO.getProducto(id);
    }

    @Override
    public List<Producto> getProductosCategoria(Integer id) {
        return productoDAO.getProductosCategoria(id);
    }

    @Override
    public Proveedor getProveedor(Integer id) {
        return proveedorDAO.getProveedor(id);
    }
    
    public static void main(String[] args) {
        ProductosServicio servicio = new ProductosServicio();
        Categoria c = servicio.getCategorias().get(0);
        System.out.println(c);
        for(Producto p: servicio.getProductosCategoria(c.getIdCategoria())){
            System.out.println(p);
            System.out.println("\t" + servicio.getProveedor(p.getIdProveedor()));
        }
    }
    
}
