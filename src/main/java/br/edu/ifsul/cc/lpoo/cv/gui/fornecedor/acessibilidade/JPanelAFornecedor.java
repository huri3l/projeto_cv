/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui.fornecedor.acessibilidade;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author huriel
 */
public class JPanelAFornecedor extends JPanel {
    private CardLayout cardLayout;
    private Controle controle;
    
    private JPanelAFornecedorFormulario formulario;
    private JPanelAFornecedorListagem listagem;
    
    public JPanelAFornecedor(Controle controle) {
        this.controle = controle;
        initComponents();
    }
    
    private void initComponents() {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        
        formulario = new JPanelAFornecedorFormulario(this, controle);
        listagem = new JPanelAFornecedorListagem(this, controle);
        
        this.add(getFormulario(), "tela_fornecedor_formulario");
        this.add(listagem, "tela_fornecedor_listagem");
    }
    
    public void showTela(String nomeTela) {
        if(nomeTela.equals("tela_fornecedor_listagem")) {
            listagem.populaTable();
        }
        
        cardLayout.show(this, nomeTela);
    }
    
    public Controle getControle() {
        return controle;
    }

    public JPanelAFornecedorFormulario getFormulario() {
        return formulario;
    }
}
