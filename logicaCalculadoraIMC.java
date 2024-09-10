/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoraimc;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class logicaCalculadoraIMC  extends Tela{

     private JLabel lblPeso, lblAltura, lblResultado;
    private JTextField txtPeso, txtAltura;
    private JButton btnCalcular;

    public logicaCalculadoraIMC() {
        // Configurações básicas da janela
        setTitle("Calculadora de IMC");
        setLayout(null); // Layout absoluto
        setSize(350, 250); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializando os componentes
        lblPeso = new JLabel("Peso (kg):");
        txtPeso = new JTextField();
        lblAltura = new JLabel("Altura (m):");
        txtAltura = new JTextField();
        btnCalcular = new JButton("Calcular IMC");
        lblResultado = new JLabel("IMC: ");

        // Posicionando os componentes na janela
        lblPeso.setBounds(30, 30, 100, 30);
        txtPeso.setBounds(150, 30, 150, 30);
        lblAltura.setBounds(30, 70, 100, 30);
        txtAltura.setBounds(150, 70, 150, 30);
        btnCalcular.setBounds(100, 120, 150, 30);
        lblResultado.setBounds(30, 170, 250, 30);

        // Adicionando os componentes à janela
        add(lblPeso);
        add(txtPeso);
        add(lblAltura);
        add(txtAltura);
        add(btnCalcular);
        add(lblResultado);

        // Adicionando a lógica para o botão "Calcular IMC"
        btnCalcular.addActionListener((ActionEvent e) -> {
            try {
                // Obtendo os valores de peso e altura
                double peso = Double.parseDouble(txtPeso.getText());
                double altura = Double.parseDouble(txtAltura.getText());

                // Calculando o IMC
                double imc = peso / (altura * altura);

                // Determinando a categoria de peso com base no IMC
                String categoria;
                if (imc < 18.5) {
                    categoria = "Abaixo do peso";
                } else if (imc >= 18.5 && imc <= 24.9) {
                    categoria = "Peso normal";
                } else if (imc >= 25 && imc <= 29.9) {
                    categoria = "Sobrepeso";
                } else if (imc >= 30 && imc <= 34.9) {
                    categoria = "Obesidade grau 1";
                } else if (imc >= 35 && imc <= 39.9) {
                    categoria = "Obesidade grau 2";
                } else {
                    categoria = "Obesidade grau 3";
                }

                // Exibindo o resultado do IMC e a categoria
                lblResultado.setText(String.format("IMC: %.2f (%s)", imc, categoria));

            } catch (NumberFormatException ex) {
                // Tratamento para entradas inválidas
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos.");
            }
        });
        
        

        // Tornando a janela visível
        setVisible(true);
    }

    }
    

