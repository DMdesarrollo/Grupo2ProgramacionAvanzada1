package com.uth.hn.Implementation;

import com.uth.hn.Interface.StockManager;
import com.uth.hn.models.Product;
import java.util.ArrayList;
import java.util.List;

public class StockManagerImpl implements StockManager {
    private List<Product> inventario = new ArrayList<>();

    @Override
    public void agregarProducto(Product producto) {
        inventario.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    @Override
    public void eliminarProducto(int id) {
        inventario.removeIf(product -> product.getId() == id);
        System.out.println("Producto con ID " + id + " eliminado.");
    }

    @Override
    public void actualizarProducto(int id, String nuevoNombre, int nuevaCantidad, double nuevoPrecio) {
        for (Product product : inventario) {
            if (product.getId() == id) {
                product.setNombre(nuevoNombre);
                product.setCantidad(nuevaCantidad);
                product.setPrecio(nuevoPrecio);
                System.out.println("Producto actualizado: " + product);
                return;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado.");
    }

    @Override
    public List<Product> obtenerProductos() {
        return inventario;
    }
}
