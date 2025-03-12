package com.uth.hn.ui;

import com.uth.hn.Implementation.StockManagerImpl;
import com.uth.hn.Interface.StockManager;
import com.uth.hn.models.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StockFrame extends JFrame {
    private StockManager stockManager;
    private JTable table;
    private DefaultTableModel model;

    public StockFrame() {
        stockManager = new StockManagerImpl();
        setTitle("Inventario");
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Crear la tabla
        String[] columnNames = {"ID", "Nombre", "Cantidad", "Precio"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(e -> agregarProducto());
        add(btnAgregar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void agregarProducto() {
        Product nuevo = new Product(1, "Laptop", 5, 799.99);
        stockManager.agregarProducto(nuevo);
        model.addRow(new Object[]{nuevo.getId(), nuevo.getNombre(), nuevo.getCantidad(), nuevo.getPrecio()});
    }
}
