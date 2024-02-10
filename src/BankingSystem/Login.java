/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingSystem;

/**
 *
 * @author Naima Rahman
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class Login extends JFrame implements ActionListener {
    private Container c;
    private JLabel password;
    private JLabel email;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton login;
    private JLabel welcome1;
    private JLabel welcome2;

    Login() {
        initComponents();
    }

    public void initComponents() {
        email = new JLabel("E-mail");
        password = new JLabel("Password");
        emailField = new JTextField();
        passwordField = new JPasswordField();
        login = new JButton("LOGIN");
        welcome1 = new JLabel("Welcome!");
        welcome2 = new JLabel("Enter your credentials to login");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        c.add(email);
        c.add(password);
        c.add(emailField);
        c.add(passwordField);
        c.add(login);
        c.add(welcome1);
        c.add(welcome2);

        welcome1.setBounds(50, 30, 100, 20);
        welcome1.setFont(new Font("Verdana", Font.PLAIN, 18));
        welcome2.setBounds(50, 60, 200, 15);
        welcome2.setFont(new Font("Verdana", 0, 12));
        email.setBounds(50, 120, 50, 20);
        emailField.setBounds(120, 120, 180, 20);
        password.setBounds(50, 160, 70, 20);
        passwordField.setBounds(120, 160, 180, 20);
        login.setBounds(150, 220, 110, 30);

        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login) {
            String dummyEmail = "name@gmail.com";
            String dummyPassword = "password";
            String enteredEmail = emailField.getText();
            String enteredPassword = new String(passwordField.getPassword());

            if (dummyEmail.equals(enteredEmail) && dummyPassword.equals(enteredPassword)) {
                Account accFrame = new Account();
                accFrame.setVisible(true);
                this.dispose();
                accFrame.setBounds(200, 50, 380, 450);
                accFrame.setResizable(true);
                accFrame.setTitle("Account");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setBounds(200, 50, 420, 350);
        loginFrame.setResizable(true);
        loginFrame.setTitle("Login");
    }
}
