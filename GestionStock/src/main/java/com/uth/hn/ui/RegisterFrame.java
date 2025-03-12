package com.uth.hn.ui;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        setTitle("SING UP");
        setSize(490, 750);
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

        FlatSVGIcon icon = new FlatSVGIcon("assets/signup.svg").derive(50, 50);
        icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> new Color(250, 128, 0)));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(30, 30, 50, 50);
        panel.add(iconLabel);

        // Título
        JLabel titleLabel = new JLabel("Sign up", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(0, 40, 250, 30); // (x, y, ancho, alto)
        panel.add(titleLabel);

        // Línea decorativa
        JSeparator separator = new JSeparator();
        separator.setBounds(30, 120, 480, 2); // (x, y, ancho, alto)
        separator.setForeground(new Color(200, 200, 200)); // Color gris
        panel.add(separator);

        // Usuario
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(30, 150, 100, 35);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(30, 185, 430, 40);
        emailField.setFont(new Font("Arial", Font.BOLD, 15));
        emailField.setForeground(Color.GRAY);
        panel.add(emailField);

        // Contraseña
        JLabel passLabel = new JLabel("Create a password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passLabel.setForeground(Color.BLACK);
        passLabel.setBounds(30, 250, 150, 35);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(30, 285, 430, 40);
        passField.setFont(new Font("Arial", Font.BOLD, 15));
        passField.setForeground(Color.GRAY);
        panel.add(passField);

        // Birthday
        JLabel birthdayLabel = new JLabel("Date of birth:");
        birthdayLabel.setFont(new Font("Arial", Font.BOLD, 15));
        birthdayLabel.setForeground(Color.BLACK);
        birthdayLabel.setBounds(30, 350, 150, 35);
        panel.add(birthdayLabel);

        JTextField birthdayField = new JTextField();
        birthdayField.setBounds(30, 385, 430, 40);
        birthdayField.setFont(new Font("Arial", Font.BOLD, 15));
        birthdayField.setForeground(Color.GRAY);
        panel.add(birthdayField);

        JLabel notifyBirthLabel = new JLabel("We want to give you an special treat on your birthday");
        notifyBirthLabel.setFont(new Font("Arial", Font.BOLD, 15));
        notifyBirthLabel.setForeground(new Color(200, 200, 200));
        notifyBirthLabel.setBounds(30, 430, 400, 35);
        panel.add(notifyBirthLabel);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(30, 495, 20, 15);
        panel.add(checkBox);

        JLabel subscribeLabel = new JLabel("Subscribe to newsletter");
        subscribeLabel.setForeground(Color.BLACK);
        subscribeLabel.setBounds(55, 487, 150, 30);
        panel.add(subscribeLabel);

        // Botón de Login
        JButton signupButton = new JButton("Sign up");
        signupButton.setBackground(new Color(255, 128, 0));
        signupButton.setForeground(Color.WHITE);
        signupButton.setFont(new Font("Arial", Font.BOLD, 15));
        signupButton.setFocusPainted(false);
        signupButton.setBounds(30, 540, 430, 40);
        panel.add(signupButton);

        // Línea decorativa
        JSeparator separator2 = new JSeparator();
        separator2.setBounds(30, 620, 480, 2); // (x, y, ancho, alto)
        separator2.setForeground(new Color(200, 200, 200)); // Color gris
        panel.add(separator2);

        JLabel noAccountLabel = new JLabel("Already have an account?");
        noAccountLabel.setForeground(Color.BLACK);
        noAccountLabel.setBounds(160, 660, 200, 30);
        panel.add(noAccountLabel);

        JLabel signUpLabel = new JLabel("Login"); // Texto subrayado como enlace
        //signUpLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signUpLabel.setForeground(new Color(250, 128, 0)); // Color naranja como en tu diseño
        signUpLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor al de "mano"
        signUpLabel.setBounds(320, 660, 50, 30); // Posición (ajústala según tu diseño)

        // Agregar evento de clic para abrir la ventana de registro
        signUpLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginFrame().setVisible(true); // Abre la ventana de registro
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

        // Acción del botón de sign up
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = emailField.getText().trim();
                String contraseña = new String(passField.getPassword()).trim();
                String fechaNacimiento = birthdayField.getText().trim(); // Obtener la fecha de nacimiento

                if (usuario.isEmpty() || contraseña.isEmpty() || fechaNacimiento.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(panel);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new RegisterFrame().setVisible(true));
//    }
}

