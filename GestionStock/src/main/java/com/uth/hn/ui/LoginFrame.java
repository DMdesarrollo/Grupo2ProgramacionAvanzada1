package com.uth.hn.ui;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Inicio de Sesión");
        setSize(490, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Aplicar FlatLaf
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            UIManager.put("TextComponent.arc", 30); // Aplica a todos los JTextField y JPasswordField
            UIManager.put("Button.arc", 30);
            UIManager.put("Component.focusWidth", 0); // Grosor del borde de enfoque
            UIManager.put("Component.focusedBorderColor", new Color(250, 128, 0)); // Naranja al enfocar
            UIManager.put("Component.borderColor", new Color(200, 200, 200)); // Normal (gris claro)

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Panel principal con layout absoluto
        JPanel panel = new JPanel();
        panel.setLayout(null); // Desactiva los layouts automáticos
        panel.setBackground(new Color(240, 240, 240));

        FlatSVGIcon icon = new FlatSVGIcon("assets/account.svg").derive(50, 50);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> new Color(250, 128, 0)));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(30, 30, 50, 50);
        panel.add(iconLabel);

        // Título
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(-5, 40, 250, 30); // (x, y, ancho, alto)
        panel.add(titleLabel);

        // Línea decorativa
        JSeparator separator = new JSeparator();
        separator.setBounds(30, 120, 480, 2); // (x, y, ancho, alto)
        separator.setForeground(new Color(200, 200, 200)); // Color gris
        panel.add(separator);

        // Usuario
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 15));
        userLabel.setForeground(Color.BLACK);
        userLabel.setBounds(30, 150, 100, 35);
        panel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setFont(new Font("Arial", Font.BOLD, 15));
        userField.setForeground(Color.gray);
        userField.setBounds(30, 185, 430, 40);
        panel.add(userField);

        // Contraseña
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passLabel.setForeground(Color.BLACK);
        passLabel.setBounds(30, 250, 100, 35);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(30, 285, 430, 40);
        passField.setFont(new Font("Arial", Font.BOLD, 15));
        passField.setForeground(Color.GRAY);
        panel.add(passField);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(30, 365, 20, 15);
        panel.add(checkBox);

        JLabel RememberMeLabel = new JLabel("Remember me");
        RememberMeLabel.setForeground(Color.BLACK);
        RememberMeLabel.setBounds(55, 357, 100, 30);
        panel.add(RememberMeLabel);

        JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setForeground(new Color(250, 128, 0));
        forgotPasswordLabel.setBounds(355,357,150,30);
        panel.add(forgotPasswordLabel);

        // Botón de Login
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(255, 128, 0));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setFocusPainted(false);
        loginButton.setBounds(30, 430, 430, 40);
        panel.add(loginButton);

        // Línea decorativa
        JSeparator separator2 = new JSeparator();
        separator2.setBounds(30, 500, 480, 2); // (x, y, ancho, alto)
        separator2.setForeground(new Color(200, 200, 200)); // Color gris
        panel.add(separator2);

        JLabel noAccountLabel = new JLabel("Don't have an account?");
        noAccountLabel.setForeground(Color.BLACK);
        noAccountLabel.setBounds(165, 520, 200, 30);
        panel.add(noAccountLabel);

        JLabel signUpLabel = new JLabel("Sign Up"); // Texto subrayado como enlace
        signUpLabel.setForeground(new Color(250, 128, 0)); // Color naranja como en tu diseño
        signUpLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor al de "mano"
        signUpLabel.setBounds(315, 520, 50, 30); // Posición (ajústala según tu diseño)

        // Agregar evento de clic para abrir la ventana de registro
        signUpLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterFrame().setVisible(true); // Abre la ventana de registro
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpLabel.setForeground(new Color(255, 165, 0)); // Cambio de color al pasar el mouse
            }
            @Override
            public void mouseExited(MouseEvent e) {
                signUpLabel.setForeground(new Color(250, 128, 0)); // Regresa al color original
            }
        });
        // Agregar al panel
        panel.add(signUpLabel);

        // Acción del botón de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String contraseña = new String(passField.getPassword());

                if (usuario.equals("admin") && contraseña.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

