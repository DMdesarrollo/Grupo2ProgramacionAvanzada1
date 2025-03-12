package com.uth.hn.Interface;

import com.uth.hn.models.Product;
import java.util.List;

public interface StockManager {
    void agregarProducto(Product producto);
    void eliminarProducto(int id);
    void actualizarProducto(int id, String nuevoNombre, int nuevaCantidad, double nuevoPrecio);
    List<Product> obtenerProductos();
}


