
package br.edu.ifsul.cc.lpoo.cv.gui.fornecedor.acessibilidade;

import br.edu.ifsul.cc.lpoo.cv.Controle;
import br.edu.ifsul.cc.lpoo.cv.model.Fornecedor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author huriel
 */
public class JPanelAFornecedorListagem extends JPanel implements ActionListener{
    private JPanelAFornecedor pnlAFornecedor;
    private Controle controle;
    
    private BorderLayout borderLayout;
    private JPanel pnlCentro;
    private JScrollPane scpListagem;
    private JTable tblListagem;
    private DefaultTableModel modeloTabela;
    
    private JPanel pnlSul;
    private JButton btnCriar;
    private JButton btnEditar;
    private JButton btnRemover;
 
    private SimpleDateFormat sdfformat;
    
    public JPanelAFornecedorListagem(JPanelAFornecedor pnlAFornecedor, Controle controle) {
        this.pnlAFornecedor = pnlAFornecedor;
        this.controle = controle;
        
        initComponents();
    }
    
    
    public void populaTable() {
        DefaultTableModel model = (DefaultTableModel) tblListagem.getModel();

        model.setRowCount(0);

        try {

            List<Fornecedor> listFornecedores = controle.getConexaoJDBC().listFornecedores();
            for(Fornecedor f : listFornecedores) {        
                model.addRow(new Object[]{f.getCpf(), f.getNome(), sdfformat.format(f.getData_cadastro().getTime()), f.getCnpj(), f.getIe(), f.getEmail(), f.getNumero_celular(), f.getEndereco()});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Houver um erro ao listar os Fornecedores:"+e.getLocalizedMessage(), "Fornecedores", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }        
    }
    
    private void initComponents() {
        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        
        pnlCentro = new JPanel();
        pnlCentro.setLayout(new BorderLayout());
           
        scpListagem = new JScrollPane();
        tblListagem =  new JTable();
        
        modeloTabela = new DefaultTableModel(
            new Object [][] {}, new String[]{
                    "CPF", "Nome", "Data Cadastro", "CNPJ", "IE", "E-mail", "Celular", "Endereço"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        tblListagem.setModel(modeloTabela);
        scpListagem.setViewportView(tblListagem);
    
        pnlCentro.add(scpListagem, BorderLayout.CENTER);
        this.add(pnlCentro, BorderLayout.CENTER);
        
        pnlSul = new JPanel();
        pnlSul.setLayout(new FlowLayout());
        
        btnCriar = new JButton("Criar");
        btnCriar.addActionListener(this);
        btnCriar.setFocusable(true);
        btnCriar.setToolTipText("Criar");
        btnCriar.setMnemonic(KeyEvent.VK_N);
        btnCriar.setActionCommand("botao_criar");
        pnlSul.add(btnCriar);
        
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(this);
        btnEditar.setFocusable(true);
        btnEditar.setToolTipText("btnAlterar");
        btnEditar.setActionCommand("botao_alterar");
        pnlSul.add(btnEditar);
        
        btnRemover = new JButton("Remover");
        btnRemover.addActionListener(this);
        btnRemover.setFocusable(true);
        btnRemover.setToolTipText("btnRemvoer");
        btnRemover.setActionCommand("botao_remover");
        pnlSul.add(btnRemover);
        
        this.add(pnlSul, BorderLayout.SOUTH);
      
        sdfformat = new SimpleDateFormat("dd/MM/yyyy");
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    
        if(arg0.getActionCommand().equals(btnCriar.getActionCommand())) {
            pnlAFornecedor.showTela("tela_fornecedor_formulario");
            pnlAFornecedor.getFormulario().setFornecedorFormulario(null);                        
            
        } else if(arg0.getActionCommand().equals(btnEditar.getActionCommand())) {
            int indice = tblListagem.getSelectedRow();
            if(indice > -1){
                try {
                    DefaultTableModel model =  (DefaultTableModel) tblListagem.getModel();
                    
                    Vector linha = (Vector) model.getDataVector().get(indice);
                    
                    Fornecedor f = new Fornecedor();
                    
                    f = (Fornecedor) controle.getConexaoJDBC().find(Fornecedor.class, linha.get(0));
                    
                    pnlAFornecedor.showTela("tela_fornecedor_formulario"); 
                    pnlAFornecedor.getFormulario().setFornecedorFormulario(f);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao selecionar o Fornecedor para Editar! Tente novamente mais tarde." + e.getMessage(), "Edição", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                  JOptionPane.showMessageDialog(this, "Selecione uma linha para editar!", "Edição", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if(arg0.getActionCommand().equals(btnRemover.getActionCommand())) {
            int indice = tblListagem.getSelectedRow();
            if(indice > -1) {
                DefaultTableModel model = (DefaultTableModel) tblListagem.getModel();

                Vector linha = (Vector) model.getDataVector().get(indice);
                
                Fornecedor f = new Fornecedor();
                f.setCpf((String) linha.get(0));

                try {
                    pnlAFornecedor.getControle().getConexaoJDBC().remover(f);
                    JOptionPane.showMessageDialog(this, "Fornecedor removido!", "Fornecedor", JOptionPane.INFORMATION_MESSAGE);
                    populaTable();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao remover Fornecedor:" + e.getLocalizedMessage(), "Fornecedor", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }                        

            } else {
                  JOptionPane.showMessageDialog(this, "Selecione uma linha para remover!", "Remoção", JOptionPane.INFORMATION_MESSAGE);
            }        
        }
    }
    
}
