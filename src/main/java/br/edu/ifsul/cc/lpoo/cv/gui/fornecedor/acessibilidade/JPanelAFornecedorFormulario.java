/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.cv.gui.fornecedor.acessibilidade;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import br.edu.ifsul.cc.lpoo.cv.model.Fornecedor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author huriel
 */
public class JPanelAFornecedorFormulario extends JPanel implements ActionListener {
    private JPanelAFornecedor pnlAFornecedor;
    private Controle controle;

    private BorderLayout borderLayout;
    private JTabbedPane tbpAbas;

    private JPanel pnlDadosCadastrais;

    private GridBagLayout gridBagLayoutDadosCadastrais;

    private JLabel lblNome;
    private JTextField txfNome;

    private JLabel lblSenha;
    private JPasswordField txfSenha;

    private JLabel lblCpf;
    private JTextField txfCpf;

    private JLabel lblCep;
    private JTextField txfCep;

    private JLabel lblComplemento;
    private JTextField txfComplemento;

    private JLabel lblDataCadastro;
    private JTextField txfDataCadastro;

    private JLabel lblDataNascimento;
    private JTextField txfDataNascimento;

    private JLabel lblEmail;
    private JTextField txfEmail;

    private JLabel lblEndereco;
    private JTextField txfEndereco;

    private JLabel lblNumeroCelular;
    private JTextField txfNumeroCelular;

    private JLabel lblRg;
    private JTextField txfRg;

    private JLabel lblCnpj;
    private JTextField txfCnpj;

    private JLabel lblIe;
    private JTextField txfIe;

    private Fornecedor fornecedor;
    private SimpleDateFormat sdfformat;

    private JPanel pnlSul;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public JPanelAFornecedorFormulario(JPanelAFornecedor pnlAFornecedor, Controle controle) {
        this.pnlAFornecedor = pnlAFornecedor;
        this.controle = controle;
        this.sdfformat = new SimpleDateFormat("dd/MM/yyyy");

        initComponents();
    }

    public Fornecedor getFornecedorByFormulario() throws ParseException {
        if (txfNome.getText().trim().length() > 2) {
            txfNome.setBorder(new LineBorder(Color.green, 1));

            if (new String(txfSenha.getPassword()).trim().length() > 3) {
                txfSenha.setBorder(new LineBorder(Color.green, 1));

                if (txfCpf.getText().trim().length() == 14) {
                    txfCpf.setBorder(new LineBorder(Color.green, 1));

                    if (txfDataNascimento.getText().trim().length() == 0 || txfDataNascimento.getText().trim().length() == 10) {
                        txfDataNascimento.setBorder(new LineBorder(Color.green, 1));

                        if (txfEmail.getText().trim().length() > 1) {
                            txfEmail.setBorder(new LineBorder(Color.green, 1));

                            if (txfEndereco.getText().trim().length() > 1) {
                                txfEndereco.setBorder(new LineBorder(Color.green, 1));

                                if (txfNumeroCelular.getText().trim().length() == 15) {
                                    txfNumeroCelular.setBorder(new LineBorder(Color.green, 1));

                                    if (txfCnpj.getText().trim().length() == 18) {
                                        txfCnpj.setBorder(new LineBorder(Color.green, 1));

                                        if (txfIe.getText().trim().length() > 1) {
                                            txfIe.setBorder(new LineBorder(Color.green, 1));
                                            
                                            Fornecedor f = new Fornecedor();

                                            f.setNome(txfNome.getText().trim());
                                            f.setSenha(new String(txfSenha.getPassword()).trim());
                                            f.setEmail(txfEmail.getText().trim());
                                            f.setEndereco(txfEndereco.getText().trim());
                                            f.setNumero_celular(txfNumeroCelular.getText().trim());
                                            f.setCnpj(txfCnpj.getText().trim());
                                            f.setIe(txfIe.getText().trim());
                                            f.setCep(txfCep.getText().trim());
                                            f.setComplemento(txfComplemento.getText().trim());
                                            f.setRg(txfRg.getText().trim());
                                            f.setCpf(txfCpf.getText().trim());

                                            if (txfDataNascimento.getText().trim().length() > 1) {
                                                Calendar dtNascimento = Calendar.getInstance();
                                                dtNascimento.setTime(sdfformat.parse(txfDataNascimento.getText()));
                                                f.setData_nascimento(dtNascimento);
                                            }

                                            if (fornecedor != null) {
                                                f.setData_cadastro(fornecedor.getData_cadastro());
                                            }

                                            return f;

                                        } else {
                                            txfIe.setBorder(new LineBorder(Color.red, 1));
                                            JOptionPane.showMessageDialog(this, "Inscrição Estadual é um campo obrigatório!", "Fornecedor", JOptionPane.ERROR_MESSAGE);   
                                        }

                                    } else {
                                        txfCnpj.setBorder(new LineBorder(Color.red, 1));
                                        JOptionPane.showMessageDialog(this, "CNPJ inválido! Tente novamente no seguinte formato: 00.000.000/0001-00", "Fornecedor", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    txfNumeroCelular.setBorder(new LineBorder(Color.red, 1));
                                    JOptionPane.showMessageDialog(this, "Número de celular inválido! Tente novamente no seguinte formato: (00) 90000-0000", "Fornecedor", JOptionPane.ERROR_MESSAGE);
                                }

                            } else {
                                txfEndereco.setBorder(new LineBorder(Color.red, 1));
                                JOptionPane.showMessageDialog(this, "Endereço é um campo obrigatório!", "Fornecedor", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            txfEmail.setBorder(new LineBorder(Color.red, 1));
                            JOptionPane.showMessageDialog(this, "E-mail é um campo obrigatório! Tente novamente com o seguinte formato: email@exemplo.com", "Fornecedor", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        txfDataNascimento.setBorder(new LineBorder(Color.red, 1));
                        JOptionPane.showMessageDialog(this, "Data de Nascimento inválida! Tente novamente com o seguinte formato: dd/mm/aaaa", "Fornecedor", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    txfCpf.setBorder(new LineBorder(Color.red, 1));
                    JOptionPane.showMessageDialog(this, "CPF inválido! Tente novamente com o seguinte formato: 000.000.000-00", "Fornecedor", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                txfSenha.setBorder(new LineBorder(Color.red, 1));
                JOptionPane.showMessageDialog(this, "Senha é um campo obrigatório! Informe, no mínimo, 3 caracteres.", "Fornecedor", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            txfNome.setBorder(new LineBorder(Color.red, 1));
            JOptionPane.showMessageDialog(this, "Nome é um campo obrigatório! Informe, no mínimo, 2 caracteres.", "Fornecedor", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public void setFornecedorFormulario(Fornecedor f) {
        if (f == null) {
            txfNome.setText("");
            txfSenha.setText("");
            txfCpf.setText("");
            txfCep.setText("");
            txfComplemento.setText("");
            txfDataNascimento.setText("");
            txfEmail.setText("");
            txfEndereco.setText("");
            txfNumeroCelular.setText("");
            txfRg.setText("");
            txfCnpj.setText("");
            txfIe.setText("");
            txfDataCadastro.setText(sdfformat.format(Calendar.getInstance().getTime()));
        } else {

            fornecedor = f;

            txfNome.setEditable(false);
            txfNome.setText(fornecedor.getNome());
            txfSenha.setText(fornecedor.getSenha());
            txfCpf.setText(fornecedor.getCpf());
            txfCpf.setEditable(false);
            txfEmail.setText(fornecedor.getEmail());
            txfEndereco.setText(fornecedor.getEndereco());
            txfNumeroCelular.setText(fornecedor.getNumero_celular());
            txfCnpj.setText(fornecedor.getCnpj());
            txfIe.setText(fornecedor.getIe());
            txfDataCadastro.setEditable(false);

            if (f.getData_nascimento() != null) {
                txfDataNascimento.setText(sdfformat.format(fornecedor.getData_nascimento().getTime()));
            }
            
            if (f.getData_cadastro() != null) {
                txfDataCadastro.setText(sdfformat.format(fornecedor.getData_cadastro().getTime()));
            }

            if (f.getCep() != null) {
                txfCep.setText(fornecedor.getCep());
            }

            if (f.getComplemento() != null) {
                txfComplemento.setText(fornecedor.getComplemento());
            }

            if (f.getRg() != null) {
                txfRg.setText(fornecedor.getRg());
            }
        }
    }

    private void initComponents() {
        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        tbpAbas = new JTabbedPane();
        this.add(tbpAbas, BorderLayout.CENTER);

        pnlDadosCadastrais = new JPanel();
        gridBagLayoutDadosCadastrais = new GridBagLayout();
        pnlDadosCadastrais.setLayout(gridBagLayoutDadosCadastrais);

        lblNome = new JLabel("Nome:");
        GridBagConstraints posicionador = new GridBagConstraints();
        posicionador.gridy = 0;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblNome, posicionador);

        txfNome = new JTextField(20);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 0;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfNome, posicionador);

        lblSenha = new JLabel("Senha:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblSenha, posicionador);

        txfSenha = new JPasswordField(10);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 1;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfSenha, posicionador);

        lblCpf = new JLabel("CPF:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblCpf, posicionador);

        txfCpf = new JTextField(14);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 2;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfCpf, posicionador);

        lblCep = new JLabel("CEP:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 3;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblCep, posicionador);

        txfCep = new JTextField(9);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 3;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfCep, posicionador);

        lblComplemento = new JLabel("Complemento:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 4;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblComplemento, posicionador);

        txfComplemento = new JTextField(20);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 4;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfComplemento, posicionador);

        lblDataNascimento = new JLabel("Data de Nascimento:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 5;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblDataNascimento, posicionador);

        txfDataNascimento = new JTextField(10);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 5;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfDataNascimento, posicionador);

        lblDataCadastro = new JLabel("Data de Cadastro:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 6;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblDataCadastro, posicionador);

        txfDataCadastro = new JTextField(10);
        txfDataCadastro.setEditable(false);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 6;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfDataCadastro, posicionador);

        lblEmail = new JLabel("E-mail:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 7;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblEmail, posicionador);

        txfEmail = new JTextField(40);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 7;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfEmail, posicionador);

        lblEndereco = new JLabel("Endereço:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 8;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblEndereco, posicionador);

        txfEndereco = new JTextField(40);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 8;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfEndereco, posicionador);

        lblNumeroCelular = new JLabel("Número de Celular:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 9;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblNumeroCelular, posicionador);

        txfNumeroCelular = new JTextField(40);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 9;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfNumeroCelular, posicionador);

        lblRg = new JLabel("RG:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 10;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblRg, posicionador);

        txfRg = new JTextField(12);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 10;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfRg, posicionador);

        lblCnpj = new JLabel("CNPJ:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 11;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblCnpj, posicionador);

        txfCnpj = new JTextField(18);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 11;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfCnpj, posicionador);

        lblIe = new JLabel("Inscrição Estadual:");
        posicionador = new GridBagConstraints();
        posicionador.gridy = 12;
        posicionador.gridx = 0;
        pnlDadosCadastrais.add(lblIe, posicionador);

        txfIe = new JTextField(40);
        posicionador = new GridBagConstraints();
        posicionador.gridy = 12;
        posicionador.gridx = 1;
        posicionador.anchor = GridBagConstraints.LINE_START;
        pnlDadosCadastrais.add(txfIe, posicionador);

        tbpAbas.addTab("Dados Cadastrais", pnlDadosCadastrais);

        pnlSul = new JPanel();
        pnlSul.setLayout(new FlowLayout());

        btnSalvar = new JButton("Gravar");
        btnSalvar.addActionListener(this);
        btnSalvar.setFocusable(true);
        btnSalvar.setToolTipText("btnGravarJogador");
        btnSalvar.setMnemonic(KeyEvent.VK_G);
        btnSalvar.setActionCommand("botao_gravar_formulario_jogador");

        pnlSul.add(btnSalvar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setFocusable(true);
        btnCancelar.setToolTipText("btnCancelarJogador");
        btnCancelar.setActionCommand("botao_cancelar_formulario_jogador");

        pnlSul.add(btnCancelar);

        this.add(pnlSul, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals(btnSalvar.getActionCommand())) {
            Fornecedor f;
            try {
                f = getFornecedorByFormulario();

                if (f != null) {
                    try {
                        pnlAFornecedor.getControle().getConexaoJDBC().persist(f);

                        JOptionPane.showMessageDialog(this, "Alterações realizadas com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
                        
                        txfNome.setBorder(new LineBorder(Color.GRAY, 1));
                        txfSenha.setBorder(new LineBorder(Color.GRAY, 1));
                        txfCpf.setBorder(new LineBorder(Color.GRAY, 1));
                        txfCep.setBorder(new LineBorder(Color.GRAY, 1));
                        txfComplemento.setBorder(new LineBorder(Color.GRAY, 1));
                        txfDataNascimento.setBorder(new LineBorder(Color.GRAY, 1));
                        txfEmail.setBorder(new LineBorder(Color.GRAY, 1));
                        txfEndereco.setBorder(new LineBorder(Color.GRAY, 1));
                        txfNumeroCelular.setBorder(new LineBorder(Color.GRAY, 1));
                        txfRg.setBorder(new LineBorder(Color.GRAY, 1));
                        txfCnpj.setBorder(new LineBorder(Color.GRAY, 1));
                        txfIe.setBorder(new LineBorder(Color.GRAY, 1));

                        pnlAFornecedor.showTela("tela_fornecedor_listagem");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro ao salvar o Fornecedor! : " + e.getMessage(), "Salvar", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar o Fornecedor! : " + e.getMessage(), "Salvar", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else if (arg0.getActionCommand().equals(btnCancelar.getActionCommand())) {
            setFornecedorFormulario(null);
            pnlAFornecedor.showTela("tela_fornecedor_listagem");
        }
    }
}
