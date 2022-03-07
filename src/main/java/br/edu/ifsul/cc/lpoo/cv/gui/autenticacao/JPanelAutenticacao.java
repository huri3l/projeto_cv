/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui.autenticacao;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import br.edu.ifsul.cc.lpoo.cv.util.Util;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author huriel
 */
public class JPanelAutenticacao extends JPanel implements ActionListener {

    private Controle controle;
    private GridBagLayout gridLayout;
    private GridBagConstraints posicionador;

    private JLabel lblTitle;
    private JLabel lblCpf;
    private JLabel lblSenha;
    private JTextField txfCpf;
    private JPasswordField psfSenha;
    private JButton btnLogar;
    private Border defaultBorder;

    public JPanelAutenticacao(Controle controle) {
        this.controle = controle;
        initComponents();
    }

    private void initComponents() {
        gridLayout = new GridBagLayout();
        this.setLayout(gridLayout);

        lblTitle = new JLabel("<html><h1 style='text-align: center'>Seja bem-vindo!</h1><h3>Por favor, informe seus dados de Login no sistema.</h3></html>");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;
        posicionador.gridx = 0;
        posicionador.insets = new Insets(0, 0, 10, 0);
        this.add(lblTitle, posicionador);
        
        
        lblCpf = new JLabel("CPF");
        lblCpf.setToolTipText("lblCpf");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;
        posicionador.gridx = 0;
        this.add(lblCpf, posicionador);

        txfCpf = new JTextField(10);
        txfCpf.setFocusable(true);
        txfCpf.setToolTipText("txfCpf");
        Util.enterComoTab(txfCpf);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;
        posicionador.gridx = 0;
        this.add(txfCpf, posicionador);

        lblSenha = new JLabel("Senha");
        lblSenha.setToolTipText("lblSenha");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 3;
        posicionador.gridx = 0;
        this.add(lblSenha, posicionador);

        psfSenha = new JPasswordField(10);
        psfSenha.setFocusable(true);
        psfSenha.setToolTipText("psfSenha");
        Util.enterComoTab(psfSenha);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 4;
        posicionador.gridx = 0;
        this.add(psfSenha, posicionador);

        btnLogar = new JButton("Autenticar");
        btnLogar.setFocusable(true);
        btnLogar.setToolTipText("btnLogar");
        Util.enterComoTab(btnLogar);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 5;
        posicionador.gridx = 0;
        posicionador.insets = new Insets(10, 0, 0, 0);
        btnLogar.addActionListener(this);
        btnLogar.setActionCommand("comando_autenticar");
        this.add(btnLogar, posicionador);
    }
    
    @Override
    public void requestFocus(){
        
        txfCpf.requestFocus();
    }
    
    public void cleanForm(){
        txfCpf.setText("");
        psfSenha.setText("");        
        
        txfCpf.setBorder(defaultBorder);        
        psfSenha.setBorder(defaultBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnLogar.getActionCommand())) {
            if (txfCpf.getText().trim().length() == 14) {

                txfCpf.setBorder(new LineBorder(Color.green, 1));

                if (new String(psfSenha.getPassword()).trim().length() > 3) {
                    psfSenha.setBorder(new LineBorder(Color.green, 1));

                    controle.autenticar(txfCpf.getText().trim(), new String(psfSenha.getPassword()).trim());
                } else {
                    JOptionPane.showMessageDialog(this, "Informe Senha com 4 ou mais dígitos", "Autenticação", JOptionPane.ERROR_MESSAGE);
                    psfSenha.setBorder(new LineBorder(Color.red, 1));
                    psfSenha.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(this, "O CPF precisa ter 14 caracteres (com pontuação)", "Autenticação", JOptionPane.ERROR_MESSAGE);
                txfCpf.setBorder(new LineBorder(Color.red, 1));
                txfCpf.requestFocus();
            }
        }
    }
}
