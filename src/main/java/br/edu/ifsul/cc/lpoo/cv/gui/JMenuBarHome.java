/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author huriel
 */
public class JMenuBarHome extends JMenuBar implements ActionListener {

    private JMenu menuArquivo; 
    private JMenuItem menuItemHome;
    private JMenuItem menuItemLogout;
    private JMenuItem menuItemSair;
    
    private JMenu menuCadastro;
    private JMenuItem menuItemFuncionario;
    private JMenuItem menuItemFornecedor;
    
    private Controle controle;
    
    public JMenuBarHome(Controle controle) {
        this.controle = controle;
        
        initComponents();
    }
    
    private void initComponents() {
        menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);
        menuArquivo.setToolTipText("Arquivo");
        menuArquivo.setFocusable(true);
        
        menuItemHome = new JMenuItem("Home");
        menuItemHome.setToolTipText("Home");
        menuItemHome.setFocusable(true);
        menuItemHome.addActionListener(this);
        menuItemHome.setActionCommand("menu_home");
        menuArquivo.add(menuItemHome);
        
        menuItemLogout = new JMenuItem("Logout");
        menuItemLogout.setToolTipText("Logout");
        menuItemLogout.setFocusable(true);
        menuItemLogout.addActionListener(this);
        menuItemLogout.setActionCommand("menu_logout");
        menuArquivo.add(menuItemLogout);
        
        menuItemSair = new JMenuItem("Sair");
        menuItemSair.setToolTipText("Sair");
        menuItemSair.setFocusable(true);
        menuItemSair.addActionListener(this);
        menuItemSair.setActionCommand("menu_sair");
        menuArquivo.add(menuItemSair);
        
        menuCadastro = new JMenu("Cadastro");
        menuCadastro.setMnemonic(KeyEvent.VK_C);
        menuCadastro.setToolTipText("Cadastro");
        menuCadastro.setFocusable(true);
        
        menuItemFuncionario = new JMenuItem("Funcionário");
        menuItemFuncionario.setToolTipText("Funcionário");
        menuItemFuncionario.setFocusable(true);
        menuItemFuncionario.addActionListener(this);
        menuItemFuncionario.setActionCommand("menu_funcionario");
        menuCadastro.add(menuItemFuncionario);
        
        menuItemFornecedor = new JMenuItem("Fornecedor");
        menuItemFornecedor.setToolTipText("Fornecedor");
        menuItemFornecedor.setFocusable(true);
        menuItemFornecedor.addActionListener(this);
        menuItemFornecedor.setActionCommand("menu_fornecedor");
        menuCadastro.add(menuItemFornecedor);
        
        this.add(menuArquivo);
        this.add(menuCadastro);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(menuItemSair.getActionCommand())) {
            int d = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do sistema?", "Sair", JOptionPane.YES_NO_OPTION, 0);
            
            if(d == 0) {
                controle.fecharBD();
                System.exit(0);
            }
        } else if(e.getActionCommand().equals(menuItemFuncionario.getActionCommand())) {
            controle.showTela("tela_funcionario");
        } else if(e.getActionCommand().equals(menuItemFornecedor.getActionCommand())) {
            controle.showTela("tela_fornecedor");
        } else if(e.getActionCommand().equals(menuItemLogout.getActionCommand())) {
            controle.showTela("tela_autenticacao");
        } else if(e.getActionCommand().equals(menuItemHome.getActionCommand())) {
            controle.showTela("tela_home");
        }
    }
    
}
