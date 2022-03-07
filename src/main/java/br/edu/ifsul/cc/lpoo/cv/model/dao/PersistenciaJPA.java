/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.model.dao;

import br.edu.ifsul.cc.lpoo.cv.model.Fornecedor;
import br.edu.ifsul.cc.lpoo.cv.model.Funcionario;
import br.edu.ifsul.cc.lpoo.cv.model.Medico;
import br.edu.ifsul.cc.lpoo.cv.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author huriel
 */
public class PersistenciaJPA implements InterfacePersistencia {
    public EntityManagerFactory factory;
    public EntityManager entity;
    
    public PersistenciaJPA(){
        factory = Persistence.createEntityManagerFactory("lpoo_cv");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();   
    }

    @Override
    public void fecharConexao() {
        entity.close();        
    }
    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }

    @Override
    public void persist(Object o) throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }

    @Override
    public void remover(Object o) throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }

    @Override
    public List<Pessoa> listPessoas() throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }

    @Override
    public List<Fornecedor> listFornecedores() throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }

    @Override
    public List<Medico> listMedicos() throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }

    @Override
    public Funcionario doLogin(String nickname, String senha) throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }

    @Override
    public List<Funcionario> listFuncionarios() throws Exception {
        throw new UnsupportedOperationException("Funcionalidade indisponivel no momento.");
    }
}
