/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui.funcionario.acessibilidade;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author huriel
 */
public class JPanelAFuncionario extends JPanel {
    private CardLayout cardLayout;
    private Controle controle;
    
    private JPanelAFuncionarioFormulario formulario;
    private JPanelAFuncionarioListagem listagem;
    
    public JPanelAFuncionario(Controle controle) {
        this.controle = controle;
        initComponents();
    }
    
    private void initComponents() {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        
        formulario = new JPanelAFuncionarioFormulario(this, controle);
        listagem = new JPanelAFuncionarioListagem(this, controle);
        
        this.add(getFormulario(), "tela_funcionario_formulario");
        this.add(listagem, "tela_funcionario_listagem");
    }
    
    public void showTela(String nomeTela) {
        if(nomeTela.equals("tela_funcionario_listagem")) {
            listagem.populaTable();
        } else if(nomeTela.equals("tela_funcionario_formulario")) {
            getFormulario().populaComboCargo();
        }
        
        cardLayout.show(this, nomeTela);
    }
    
    public Controle getControle() {
        return controle;
    }
    
    public JPanelAFuncionarioFormulario getFormulario() {
        return formulario;
    }
}
