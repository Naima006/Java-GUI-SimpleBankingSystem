/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Account extends JFrame implements ActionListener {
    private Container c;
    private JLabel currentBalanceLabel;
    private JButton withdrawButton;
    private JButton depositButton;
    private JTextField withdrawField;
    private JTextField depositField;
    private JTextArea transactionHistory;
    private JScrollPane scroll;
    private double currentBalance = 0;
    
    Account() {
        initComponents();
    }

    public void initComponents() {
        currentBalanceLabel = new JLabel("Current Balance: Tk " + currentBalance);
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        transactionHistory = new JTextArea();
        scroll = new JScrollPane(transactionHistory);
        JLabel transactionLabel = new JLabel("Transaction :");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        c.add(currentBalanceLabel);
        c.add(withdrawButton);
        c.add(depositButton);
        c.add(transactionLabel);
        c.add(scroll);

        withdrawField = new JTextField();
        depositField = new JTextField();
        c.add(withdrawField);
        c.add(depositField);

        currentBalanceLabel.setBounds(30, 30, 150, 20);
        withdrawField.setBounds(30, 60, 120, 20);
        depositField.setBounds(30, 90, 120, 20);
        withdrawButton.setBounds(180, 60, 100, 20);
        depositButton.setBounds(180, 90, 100, 20);
        transactionLabel.setBounds(30, 120, 100, 30);
        scroll.setBounds(30, 150, 300, 200);
        transactionHistory.setEditable(false);

        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            try {
                double amount = Double.parseDouble(withdrawField.getText());
                if (currentBalance >= amount) {
                    currentBalance -= amount;
                    transactionHistory.append("Withdrawal: -Tk " + amount + "\n");
                    withdrawField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Withdrawal failed: Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == depositButton) {
            try {
                double amount = Double.parseDouble(depositField.getText());
                currentBalance += amount;
                transactionHistory.append("Deposit: +Tk " + amount + "\n");
                depositField.setText("");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        currentBalanceLabel.setText("Current Balance: Tk " + currentBalance);
    }

    public static void main(String[] args) {
        Account frame = new Account();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 50, 380, 450);
        frame.setResizable(true);
        frame.setTitle("Account");
    }
}

