package br.edu.ifsul.cc.lpoo.cv.test;


import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJPA;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huriel
 */
public class TestPersistenciaJPA {
    
    @Test
    public void testConexaoGeracaoTabelas() {
        PersistenciaJPA persistencia = new PersistenciaJPA();
        
        if(persistencia.conexaoAberta()) {
            System.out.println("Abriu conexao com o Banco de Dados via JPA.");
        
            persistencia.fecharConexao();
        } 
        else {
            System.out.println("Nao abriu conexao com o Banco de Dados via JPA.");
        }
    }
}
