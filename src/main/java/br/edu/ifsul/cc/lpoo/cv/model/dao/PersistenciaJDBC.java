/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.model.dao;

import br.edu.ifsul.cc.lpoo.cv.model.Fornecedor;
import br.edu.ifsul.cc.lpoo.cv.model.Medico;
import br.edu.ifsul.cc.lpoo.cv.model.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author huriel
 */
public class PersistenciaJDBC implements InterfacePersistencia {
    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "postgres";
    public static final String URL = "jdbc:postgresql://localhost:5432/lpoo_cv";
    private Connection con = null;
    
    public PersistenciaJDBC() throws Exception {
        Class.forName(DRIVER);
        System.out.println("Estabelecendo conexao com JDBC: '" + URL + "' ...");
        
        this.con = (Connection) DriverManager.getConnection(URL, USER, SENHA);
    }
    
    @Override
    public Boolean conexaoAberta() {
        try {
            if(con != null)
                return !con.isClosed();
        } catch (SQLException ex) {
            System.out.println("Falha ao conectar ao JDBC: '" + URL + "'");
        }
        return false;
    }
    
    @Override
    public void fecharConexao() {
        try {
            this.con.close();
            System.out.println("Fechou conexao JDBC: '" + URL + "'");
        } catch (SQLException e) {
            System.out.println("Falha ao fechar conexao com JDBC: '" + URL + "'");
        }
    }
    
    @Override
    public Object find(Class c, Object id) throws Exception {
        if(c == Pessoa.class) {
            PreparedStatement ps = this.con.prepareStatement("select cpf, cep, complemento, data_nascimento, data_cadastro, email, endereco, nome, numero_celular, rg, senha from tb_pessoa where cpf = ?");
            ps.setString(1, id.toString());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Pessoa p = new Pessoa();
                
                p.setCpf(rs.getString("cpf"));
                p.setComplemento(rs.getString("complemento"));
                p.setCep(rs.getString("cep"));
                
                Calendar dtNascimento = Calendar.getInstance();
                dtNascimento.setTimeInMillis(rs.getDate("data_nascimento").getTime());
                p.setData_nascimento(dtNascimento);
                
                Calendar dtCadastro = Calendar.getInstance();
                dtCadastro.setTimeInMillis(rs.getDate("data_cadastro").getTime());
                p.setData_cadastro(dtCadastro);
                
                p.setEmail(rs.getString("email"));
                p.setEndereco(rs.getString("endereco"));
                p.setNome(rs.getString("nome"));
                p.setNumero_celular(rs.getString("numero_celular"));
                p.setRg(rs.getString("rg"));
                p.setSenha(rs.getString("senha"));
                
                ps.close();
                
                return p;
            }
        } else if(c == Fornecedor.class) {
            PreparedStatement ps = this.con.prepareStatement("select pes.cpf, pes.cep, pes.complemento, pes.data_nascimento, pes.data_cadastro, pes.email, pes.endereco, pes.nome, pes.numero_celular, pes.rg, pes.senha, forn.ie, forn.cnpj\n" +
                                                                "from tb_pessoa as pes "
                                                                + "INNER JOIN tb_fornecedor as forn on pes.cpf = forn.cpf WHERE "
                                                                + "pes.cpf = ?;");
            ps.setString(1, id.toString());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                Fornecedor f = new Fornecedor();
                
                f.setCpf(rs.getString("cpf"));
                f.setComplemento(rs.getString("complemento"));
                f.setCep(rs.getString("cep"));
                
                Calendar dtNascimento = Calendar.getInstance();
                dtNascimento.setTimeInMillis(rs.getDate("data_nascimento").getTime());
                f.setData_nascimento(dtNascimento);
                
                Calendar dtCadastro = Calendar.getInstance();
                dtCadastro.setTimeInMillis(rs.getDate("data_cadastro").getTime());
                f.setData_cadastro(dtCadastro);
                
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getString("endereco"));
                f.setNome(rs.getString("nome"));
                f.setNumero_celular(rs.getString("numero_celular"));
                f.setRg(rs.getString("rg"));
                f.setSenha(rs.getString("senha"));
                f.setIe(rs.getString("ie"));
                f.setCnpj(rs.getString("cnpj"));
                
                ps.close();
                
                return f;
            }
        } else if(c == Medico.class) {
            PreparedStatement ps = this.con.prepareStatement("select pes.cpf, pes.cep, pes.complemento, pes.data_nascimento, pes.data_cadastro, pes.email, pes.endereco, pes.nome, pes.numero_celular, pes.rg, pes.senha, med.numero_crmv\n" +
                                                                "from tb_pessoa as pes "
                                                                + "INNER JOIN tb_medico as med on pes.cpf = med.cpf WHERE "
                                                                + "pes.cpf = ?;");
            ps.setString(1, id.toString());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                Medico m = new Medico();
                
                m.setCpf(rs.getString("cpf"));
                m.setComplemento(rs.getString("complemento"));
                m.setCep(rs.getString("cep"));
                
                Calendar dtNascimento = Calendar.getInstance();
                dtNascimento.setTimeInMillis(rs.getDate("data_nascimento").getTime());
                m.setData_nascimento(dtNascimento);
                
                Calendar dtCadastro = Calendar.getInstance();
                dtCadastro.setTimeInMillis(rs.getDate("data_cadastro").getTime());
                m.setData_cadastro(dtCadastro);
                
                m.setEmail(rs.getString("email"));
                m.setEndereco(rs.getString("endereco"));
                m.setNome(rs.getString("nome"));
                m.setNumero_celular(rs.getString("numero_celular"));
                m.setRg(rs.getString("rg"));
                m.setSenha(rs.getString("senha"));
                m.setNumero_crmv(rs.getString("numero_crmv"));
                
                ps.close();
                
                return m;
            }
        }
        
        return null;
    }
    
    @Override
    public void persist(Object o) throws Exception {
        if (o instanceof Fornecedor) {
            Fornecedor f = (Fornecedor) o;
            
            if(f.getData_cadastro() == null) {
                PreparedStatement ps = this.con.prepareStatement("insert into tb_pessoa "
                                                                    + "(cpf, complemento, cep, data_nascimento, data_cadastro, email, endereco, nome, numero_celular, rg, senha, tipo) values "
                                                                    + "(?, ?, ?, ?, now(), ?, ?, ?, ?, ?, ?, ?) ");
                ps.setString(1, f.getCpf());
                ps.setString(2, f.getComplemento());
                ps.setString(3, f.getCep());
                ps.setTimestamp(4, new Timestamp(f.getData_nascimento().getTimeInMillis()));
                ps.setString(5, f.getEmail());
                ps.setString(6, f.getEndereco());
                ps.setString(7, f.getNome());
                ps.setString(8, f.getNumero_celular());
                ps.setString(9, f.getRg());
                ps.setString(10, f.getSenha());
                ps.setString(11, "for");
                
                ps.execute();
                
                PreparedStatement ps2 = this.con.prepareStatement("insert into tb_fornecedor " 
                                                                    + "(cnpj, ie, cpf) values "
                                                                    + "(?, ?, ?) ");
                ps2.setString(1, f.getCnpj());
                ps2.setString(2, f.getIe());
                ps2.setString(3, f.getCpf());
                
                ps2.execute();
                
                System.out.println("Fornecedor com o CPF: " + f.getCpf() + " cadastrado com sucesso!\n");
            }
            else {
                PreparedStatement ps = this.con.prepareStatement("update tb_fornecedor set cnpj = ?, ie = ? where cpf = ?; ");
                ps.setString(1, f.getCnpj());
                ps.setString(2, f.getIe());
                ps.setString(3, f.getCpf());
                
                ps.execute();
                
                PreparedStatement ps2 = this.con.prepareStatement("update tb_pessoa set "
                                                                    + "nome = ?, tipo = 'for', cep = ?, complemento = ?, data_nascimento = ?,"
                                                                    + " email = ?, endereco = ?, numero_celular = ?, rg = ?, senha = ? where cpf = ?");
                ps2.setString(1, f.getNome());
                ps2.setString(2, f.getCep());
                ps2.setString(3, f.getComplemento());
                ps2.setTimestamp(4, new Timestamp(f.getData_nascimento().getTimeInMillis()));
                ps2.setString(5, f.getEmail());
                ps2.setString(6, f.getEndereco());
                ps2.setString(7, f.getNumero_celular());
                ps2.setString(8, f.getRg());
                ps2.setString(9, f.getSenha());
                ps2.setString(10, f.getCpf());
                
                ps2.execute();
                
                System.out.println("Fornecedor com o CPF: " + f.getCpf() + " alterado com sucesso!\n");
            }
        }
        else if (o instanceof Medico) {
            Medico m = (Medico) o;
            
            if(m.getData_cadastro() == null) {
                PreparedStatement ps = this.con.prepareStatement("insert into tb_pessoa "
                                                                    + "(cpf, complemento, cep, data_nascimento, data_cadastro, email, endereco, nome, numero_celular, rg, senha, tipo) values "
                                                                    + "(?, ?, ?, ?, now(), ?, ?, ?, ?, ?, ?, ?) ");
                ps.setString(1, m.getCpf());
                ps.setString(2, m.getComplemento());
                ps.setString(3, m.getCep());
                ps.setTimestamp(4, new Timestamp(m.getData_nascimento().getTimeInMillis()));
                ps.setString(5, m.getEmail());
                ps.setString(6, m.getEndereco());
                ps.setString(7, m.getNome());
                ps.setString(8, m.getNumero_celular());
                ps.setString(9, m.getRg());
                ps.setString(10, m.getSenha());
                ps.setString(11, "med");
                
                ps.execute();
                
                PreparedStatement ps2 = this.con.prepareStatement("insert into tb_medico " 
                                                                    + "(numero_crmv, cpf) values "
                                                                    + "(?, ?) ");
                ps2.setString(1, m.getNumero_crmv());
                ps2.setString(2, m.getCpf());
                
                ps2.execute();
                
                System.out.println("Medico com o CPF: " + m.getCpf() + " cadastrado com sucesso!\n");
            }
            else {
                PreparedStatement ps = this.con.prepareStatement("update tb_medico set numero_crmv = ? where cpf = ?; ");
                ps.setString(1, m.getNumero_crmv());
                ps.setString(2, m.getCpf());
                
                ps.execute();
                
                PreparedStatement ps2 = this.con.prepareStatement("update tb_pessoa set "
                                                                    + "nome = ?, tipo = 'med', cep = ?, complemento = ?, data_nascimento = ?,"
                                                                    + " email = ?, endereco = ?, numero_celular = ?, rg = ?, senha = ? where cpf = ?");
                ps2.setString(1, m.getNome());
                ps2.setString(2, m.getCep());
                ps2.setString(3, m.getComplemento());
                ps2.setTimestamp(4, new Timestamp(m.getData_nascimento().getTimeInMillis()));
                ps2.setString(5, m.getEmail());
                ps2.setString(6, m.getEndereco());
                ps2.setString(7, m.getNumero_celular());
                ps2.setString(8, m.getRg());
                ps2.setString(9, m.getSenha());
                ps2.setString(10, m.getCpf());
                
                ps2.execute();
                
                System.out.println("Medico com o CPF: " + m.getCpf() + " alterado com sucesso!\n");
            }
        }
    }
    
    @Override
    public void remover(Object o) throws Exception {
        if(o instanceof Fornecedor) {
            Fornecedor f = (Fornecedor) o;
            
            PreparedStatement ps = this.con.prepareStatement("delete from tb_fornecedor where cpf = (?);");
            ps.setString(1, f.getCpf());
            ps.execute();
            
            PreparedStatement ps2 = this.con.prepareStatement("delete from tb_pessoa where cpf = (?);");
            ps2.setString(1, f.getCpf());
            ps2.execute();
            
            System.out.println("Fornecedor com CPF: " + f.getCpf() + " deletado com sucesso.");
        } else if (o instanceof Medico) {
            Medico m = (Medico) o;
            
            PreparedStatement ps = this.con.prepareStatement("delete from tb_medico where cpf = (?);");
            ps.setString(1, m.getCpf());
            ps.execute();
            
            PreparedStatement ps2 = this.con.prepareStatement("delete from tb_pessoa where cpf = (?);");
            ps2.setString(1, m.getCpf());
            ps2.execute();
        }
    }

    @Override
    public List<Pessoa> listPessoas() throws Exception {
        List<Pessoa> lista = null;
        
        PreparedStatement ps = this.con.prepareStatement("select cpf, cep, complemento, data_nascimento, data_cadastro, email, endereco, nome, numero_celular, rg, senha from tb_pessoa order by nome asc;");
        
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList();
        while(rs.next()) {
            Pessoa pes = new Pessoa();
            pes.setCpf(rs.getString("cpf"));
            pes.setComplemento(rs.getString("complemento"));
            pes.setCep(rs.getString("cep"));
            
            Calendar dtCadastro = Calendar.getInstance();
            dtCadastro.setTimeInMillis(rs.getDate("data_cadastro").getTime());
            pes.setData_cadastro(dtCadastro);
            
            Calendar dtNascimento = Calendar.getInstance();
            dtNascimento.setTimeInMillis(rs.getDate("data_nascimento").getTime());
            pes.setData_nascimento(dtNascimento);
            
            pes.setEmail(rs.getString("email"));
            pes.setEndereco(rs.getString("endereco"));
            pes.setNome(rs.getString("nome"));
            pes.setNumero_celular(rs.getString("numero_celular"));
            pes.setRg(rs.getString("rg"));
            pes.setSenha(rs.getString("senha"));
            
            lista.add(pes);
        }
        
        return lista;
    }

    @Override
    public List<Fornecedor> listFornecedores() throws Exception {
        List<Fornecedor> lista = null;
        
        PreparedStatement ps = this.con.prepareStatement("select pes.cpf, pes.cep, pes.complemento, pes.data_nascimento, pes.data_cadastro, pes.email, pes.endereco, pes.nome, pes.numero_celular, pes.rg, pes.senha, forn.ie, forn.cnpj from tb_pessoa as pes INNER JOIN tb_fornecedor as forn on pes.cpf = forn.cpf;\n");
    
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList();
        while(rs.next()) {
            Fornecedor forn = new Fornecedor();
            forn.setCpf(rs.getString("cpf"));
            forn.setComplemento(rs.getString("complemento"));
            forn.setCep(rs.getString("cep"));
            
            Calendar dtCadastro = Calendar.getInstance();
            dtCadastro.setTimeInMillis(rs.getDate("data_cadastro").getTime());
            forn.setData_cadastro(dtCadastro);
            
            Calendar dtNascimento = Calendar.getInstance();
            dtNascimento.setTimeInMillis(rs.getDate("data_nascimento").getTime());
            forn.setData_nascimento(dtNascimento);
            
            forn.setEmail(rs.getString("email"));
            forn.setEndereco(rs.getString("endereco"));
            forn.setNome(rs.getString("nome"));
            forn.setNumero_celular(rs.getString("numero_celular"));
            forn.setRg(rs.getString("rg"));
            forn.setSenha(rs.getString("senha"));
            forn.setCnpj(rs.getString("cnpj"));
            forn.setIe(rs.getString("ie"));
            
            lista.add(forn);
        }
        
        return lista;
    }
    
    @Override
    public List<Medico> listMedicos() throws Exception {
        List<Medico> lista = null;
        
        PreparedStatement ps = this.con.prepareStatement("select pes.cpf, pes.cep, pes.complemento, pes.data_nascimento, pes.data_cadastro, pes.email, pes.endereco, pes.nome, pes.numero_celular, pes.rg, pes.senha, med.numero_crmv from tb_pessoa as pes INNER JOIN tb_medico as med on pes.cpf = med.cpf;\n");
    
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList();
        while(rs.next()) {
            Medico med = new Medico();
            med.setCpf(rs.getString("cpf"));
            med.setComplemento(rs.getString("complemento"));
            med.setCep(rs.getString("cep"));
            
            Calendar dtCadastro = Calendar.getInstance();
            dtCadastro.setTimeInMillis(rs.getDate("data_cadastro").getTime());
            med.setData_cadastro(dtCadastro);
            
            Calendar dtNascimento = Calendar.getInstance();
            dtNascimento.setTimeInMillis(rs.getDate("data_nascimento").getTime());
            med.setData_nascimento(dtNascimento);
            
            med.setEmail(rs.getString("email"));
            med.setEndereco(rs.getString("endereco"));
            med.setNome(rs.getString("nome"));
            med.setNumero_celular(rs.getString("numero_celular"));
            med.setRg(rs.getString("rg"));
            med.setSenha(rs.getString("senha"));
            med.setNumero_crmv(rs.getString("numero_crmv"));
            
            lista.add(med);
        }
        
        return lista;
    }
}
