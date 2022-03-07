/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.test;

import br.edu.ifsul.cc.lpoo.cv.model.Cargo;
import br.edu.ifsul.cc.lpoo.cv.model.Fornecedor;
import br.edu.ifsul.cc.lpoo.cv.model.Funcionario;
import br.edu.ifsul.cc.lpoo.cv.model.Medico;
import br.edu.ifsul.cc.lpoo.cv.model.Pessoa;
import br.edu.ifsul.cc.lpoo.cv.model.dao.PersistenciaJDBC;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author huriel
 */
public class TestPersistenciaJDBC {

    // @Test
    public void testPersistenciaPessoa() throws Exception {
        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {
            List<Pessoa> lista = persistencia.listPessoas();

            if (!lista.isEmpty()) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Pessoa(s) encontrada(s):");

                lista.forEach(p -> {
                    System.out.println("\n=============\n"
                            + "CPF: " + p.getCpf() + " | Nome: " + p.getNome() + " | E-mail: " + p.getEmail()
                            + "\nSenha: " + p.getSenha() + " | Data de Nascimento: " + formatter.format(p.getData_nascimento().getTime())
                            + " | Data de Cadastro: " + formatter.format(p.getData_cadastro().getTime())
                            + "\nNúmero de Celular: " + p.getNumero_celular() + " | RG: " + p.getRg()
                            + " | CEP: " + p.getCep() + " | Endereço: " + p.getEndereco() + "\nComplemento: " + p.getComplemento()
                            + "\n=============");
                });
            } else {
                System.out.println("Pessoas nao encontradas!");
            }

            persistencia.fecharConexao();
        } else {
            System.out.println("A conexao com o Banco de Dados nao foi estabelecida.");
        }
    }

    @Test
    public void testPersistenciaFornecedor() throws Exception {
        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {
            List<Fornecedor> lista = persistencia.listFornecedores();

            if (!lista.isEmpty()) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Fornecedor(es) encontrado(s):");

                for (Fornecedor f : lista) {
                    System.out.println("\n=============\n"
                            + "CPF: " + f.getCpf() + " | Nome: " + f.getNome() + " | E-mail: " + f.getEmail()
                            + "\nSenha: " + f.getSenha() + " | Data de Nascimento: " + formatter.format(f.getData_nascimento().getTime())
                            + " | Data de Cadastro: " + formatter.format(f.getData_cadastro().getTime())
                            + "\nNúmero de Celular: " + f.getNumero_celular() + " | RG: " + f.getRg()
                            + " | CEP: " + f.getCep() + " | Endereço: " + f.getEndereco() + "\nComplemento: " + f.getComplemento()
                            + " | CNPJ: " + f.getCnpj() + " | Inscrição Estadual: " + f.getIe() + "\n=============\n");

                    System.out.println("Removendo fornecedor com CPF: " + f.getCpf() + " ...");
                    persistencia.remover(f);
                }
            } else {
                System.out.println("Fornecedores nao encontrados!");

                Fornecedor forn = new Fornecedor();

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Calendar dtNascimento = Calendar.getInstance();

                forn.setCpf("234.234.234-23");
                forn.setNome("Huriel Ferreira Lopes");
                forn.setEmail("huriel.lopes@teste.com");
                forn.setSenha("234234");

                dtNascimento.setTime(formatter.parse("06/04/2002"));
                forn.setData_nascimento(dtNascimento);

                forn.setNumero_celular("54 77777-7777");
                forn.setRg("2222222222");
                forn.setCep("99999-999");
                forn.setEndereco("Rua Alferes Rodrigues, 137");
                forn.setComplemento("Casa");
                forn.setCnpj("22.222.222/0001-22");
                forn.setIe("111");
                persistencia.persist(forn);

                forn.setCpf("312.312.321-32");
                forn.setNome("Jovita Telles");
                forn.setEmail("jovita.telles@teste.com");
                forn.setSenha("312321");

                dtNascimento.setTime(formatter.parse("10/04/2003"));
                forn.setData_nascimento(dtNascimento);

                forn.setNumero_celular("54 88888-8888");
                forn.setRg("2222222222");
                forn.setCep("88888-888");
                forn.setEndereco("Rua Teste, 128");
                forn.setComplemento("Apartamento");
                forn.setCnpj("33.333.333/0001-33");
                forn.setIe("222");
                persistencia.persist(forn);
            }

            persistencia.fecharConexao();
        } else {
            System.out.println("A conexao com o Banco de Dados nao foi estabelecida.");
        }
    }

    // @Test
    public void testPersistenciaMedico() throws Exception {
        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {
            List<Medico> lista = persistencia.listMedicos();

            if (!lista.isEmpty()) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Medico(s) encontrado(s):");

                for (Medico m : lista) {
                    System.out.println("\n=============\n"
                            + "CPF: " + m.getCpf() + " | Nome: " + m.getNome() + " | E-mail: " + m.getEmail()
                            + "\nSenha: " + m.getSenha() + " | Data de Nascimento: " + formatter.format(m.getData_nascimento().getTime())
                            + " | Data de Cadastro: " + formatter.format(m.getData_cadastro().getTime())
                            + "\nNúmero de Celular: " + m.getNumero_celular() + " | RG: " + m.getRg()
                            + " | CEP: " + m.getCep() + " | Endereço: " + m.getEndereco() + "\nComplemento: " + m.getComplemento()
                            + " | Numero CRMV: " + m.getNumero_crmv() + "\n=============\n");

                    System.out.println("Removendo medico com CPF: " + m.getCpf() + " ...");
                    persistencia.remover(m);
                }
            } else {
                System.out.println("Medicos nao encontrados!");

                Medico med = new Medico();

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Calendar dtNascimento = Calendar.getInstance();

                med.setCpf("456.456.456-45");
                med.setNome("Chrystian Paim Pereira da Silva");
                med.setEmail("chrystian.paim@teste.com");
                med.setSenha("456456");

                dtNascimento.setTime(formatter.parse("23/10/2000"));
                med.setData_nascimento(dtNascimento);

                med.setNumero_celular("54 77777-7777");
                med.setRg("3333333333");
                med.setCep("77777-777");
                med.setEndereco("Rua dos Bala, 348");
                med.setComplemento("Casa");
                med.setNumero_crmv("3333333");
                persistencia.persist(med);

                med.setCpf("645.645.645-65");
                med.setNome("Alex Emanuel Molossi");
                med.setEmail("alex.molossi@teste.com");
                med.setSenha("654654");

                dtNascimento.setTime(formatter.parse("22/12/2000"));
                med.setData_nascimento(dtNascimento);

                med.setNumero_celular("54 66666-6666");
                med.setRg("4444444444");
                med.setCep("66666-666");
                med.setEndereco("Rua dos Mock, 459");
                med.setComplemento("Apartamento");
                med.setNumero_crmv("4444444");
                persistencia.persist(med);
            }

            persistencia.fecharConexao();
        } else {
            System.out.println("A conexao com o Banco de Dados nao foi estabelecida.");
        }
    }

    // @Test
    public void testPersistenciaFuncionario() throws Exception {
        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {

            Funcionario fun = new Funcionario();

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Calendar dtNascimento = Calendar.getInstance();

            fun.setCpf("123.123.123-12");
            fun.setNome("Huriel Ferreira Lopes");
            fun.setEmail("huriel.lopes@email.com");
            fun.setSenha("123123");

            dtNascimento.setTime(formatter.parse("06/04/2002"));
            fun.setData_nascimento(dtNascimento);

            fun.setNumero_celular("54 99999-9999");
            fun.setRg("1231231231");
            fun.setCep("999999-099");
            fun.setEndereco("Rua de Exemplo, 123");
            fun.setComplemento("Casa");
            fun.setNumero_ctps("123.12345.12-1");
            fun.setNumero_pis("123.12345.12-1");
            fun.setCargo(Cargo.ADESTRADOR);
            persistencia.persist(fun);
        }

        persistencia.fecharConexao();
    }
    
    // @Test
    public void testDoLogin() throws Exception {
        PersistenciaJDBC persistencia = new PersistenciaJDBC();

        if (persistencia.conexaoAberta()) {

            Funcionario fun = persistencia.doLogin("123.123.123-12", "123123");
            
            if(fun != null) {
                System.out.println("Usuário logado com sucesso!");
            }
            else {
                System.out.println("Erro ao logar! Verifique as credenciais!");
            }
        }

        persistencia.fecharConexao();
    }
}
