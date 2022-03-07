/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv;

import br.edu.ifsul.cc.lpoo.cv.gui.JFramePrincipal;
import br.edu.ifsul.cc.lpoo.cv.gui.JMenuBarHome;
import br.edu.ifsul.cc.lpoo.cv.gui.JPanelHome;
import br.edu.ifsul.cc.lpoo.cv.gui.autenticacao.JPanelAutenticacao;
import br.edu.ifsul.cc.lpoo.cv.gui.fornecedor.acessibilidade.JPanelAFornecedor;
import br.edu.ifsul.cc.lpoo.cv.gui.funcionario.acessibilidade.JPanelAFuncionario;
import br.edu.ifsul.cc.lpoo.cv.model.Funcionario;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;
import javax.swing.JOptionPane;

/**
 *
 * @author huriel
 */
public class Controle {

    private PersistenciaJDBC conexaoJDBC;
    private JFramePrincipal frame;
    private JPanelAutenticacao pnlAutenticacao;
    private JPanelHome pnlHome;
    private JPanelAFornecedor pnlAFornecedor;
    private JPanelAFuncionario pnlAFuncionario;
    private JMenuBarHome menuBar;

    public boolean conectarBD() throws Exception {
        conexaoJDBC = new PersistenciaJDBC();

        if (getConexaoJDBC() != null) {
            return getConexaoJDBC().conexaoAberta();
        }

        return false;
    }

    public void fecharBD() {
        System.out.println("Fechando conexão com o Banco de Dados");
        getConexaoJDBC().fecharConexao();
    }

    public void initComponents() {
        frame = new JFramePrincipal();
        pnlAutenticacao = new JPanelAutenticacao(this);
        pnlHome = new JPanelHome(this);
        pnlAFornecedor = new JPanelAFornecedor(this);
        pnlAFuncionario = new JPanelAFuncionario(this);
        menuBar = new JMenuBarHome(this);
        
        frame.addTela(pnlAutenticacao, "tela_autenticacao");
        frame.addTela(pnlHome, "tela_home");
        frame.addTela(pnlAFornecedor, "tela_fornecedor");
        frame.addTela(pnlAFuncionario, "tela_funcionario");

        frame.showTela("tela_autenticacao");
        frame.setVisible(true);

    }

    public void autenticar(String cpf, String senha) {
        try {
            Funcionario f = getConexaoJDBC().doLogin(cpf, senha);

            if (f != null) {
                JOptionPane.showMessageDialog(pnlAutenticacao, "Funcionário " + f.getNome() + " autenticado com sucesso!", "Autenticação", JOptionPane.INFORMATION_MESSAGE);

                frame.setJMenuBar(menuBar);
                frame.showTela("tela_home");
            } else {
                JOptionPane.showMessageDialog(pnlAutenticacao, "Credenciais incorretas! Verifique os dados informados e tente novamente.", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(pnlAutenticacao, "Houve um erro ao autenticar! Tente novamente mais tarde.", "Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showTela(String nomeTela) {
        if (nomeTela.equals("tela_autenticacao")) {
            pnlAutenticacao.cleanForm();
            frame.showTela(nomeTela);
            pnlAutenticacao.requestFocus();
        } else if(nomeTela.equals("tela_home")) {
            frame.showTela(nomeTela);
        } else if(nomeTela.equals("tela_funcionario")) {
            pnlAFuncionario.showTela("tela_funcionario_listagem");
            frame.showTela(nomeTela);
        } else if(nomeTela.equals("tela_fornecedor")) {
            pnlAFornecedor.showTela("tela_fornecedor_listagem");
            frame.showTela(nomeTela);
        }
    }

    public PersistenciaJDBC getConexaoJDBC() {
        return conexaoJDBC;
    }
}
