/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author huriel
 */
public class JFramePrincipal extends JFrame implements WindowListener {
    public CardLayout cardLayout;
    
    public JPanel painel;
    
    public JFramePrincipal() {
        initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Clínica Veterinária");
        
        this.setMinimumSize(new Dimension(700, 700));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(this);
        
        cardLayout = new CardLayout();
        painel = new JPanel();
        painel.setLayout(cardLayout);
        
        this.add(painel);
    }
    
    public void addTela(JPanel p, String nome) {
        painel.add(p, nome);
    }
    
    public void showTela(String nome) {
        cardLayout.show(painel, nome);
    }
    
    @Override
    public void windowOpened(WindowEvent we) {
        System.out.println("Abrindo o JFrame...");
    }
    
    @Override
    public void windowClosing(WindowEvent we) {
        System.out.println("Fechando o JFrame...");
    }
    
    @Override
    public void windowClosed(WindowEvent we) {}

    @Override
    public void windowIconified(WindowEvent we) {}

    @Override
    public void windowDeiconified(WindowEvent we) {}

    @Override
    public void windowActivated(WindowEvent we) {}

    @Override
    public void windowDeactivated(WindowEvent we) {}
    
}
