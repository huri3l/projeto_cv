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

/**
 *
 * @author huriel
 */
public interface InterfacePersistencia {
    
    public Boolean conexaoAberta();
    
    public void fecharConexao();
    
    public Object find(Class c, Object id) throws Exception;
    
    public void persist(Object o) throws Exception;
    
    public void remover(Object o) throws Exception;
    
    public List<Pessoa> listPessoas() throws Exception;
    
    public List<Fornecedor> listFornecedores() throws Exception;
    
    public List<Medico> listMedicos() throws Exception;
    
    public List<Funcionario> listFuncionarios() throws Exception;
    
    public Funcionario doLogin(String cpf, String senha) throws Exception;
}
