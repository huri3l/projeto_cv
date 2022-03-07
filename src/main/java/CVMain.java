

import br.edu.ifsul.cc.lpoo.cv.Controle;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author huriel
 */
public class CVMain {

    private Controle controle;

    public CVMain() {
        try {
            controle = new Controle();

            if (controle.conectarBD()) {
                controle.initComponents();
            } else {
                JOptionPane.showMessageDialog(null, "Não conectou no Banco de Dados!", "Banco de Dados", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar conectar no Banco de Dados: " + e.getLocalizedMessage(), "Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        new CVMain();
    }
}
