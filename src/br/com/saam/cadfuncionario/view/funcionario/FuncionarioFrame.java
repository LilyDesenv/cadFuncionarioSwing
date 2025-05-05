package br.com.saam.cadfuncionario.view.funcionario;

import br.com.saam.cadfuncionario.dao.ConexaoDAO;
import br.com.saam.cadfuncionario.model.Funcionario;
import br.com.saam.cadfuncionario.view.login.LoginFrame;
import br.com.saam.cadfuncionario.util.StringUtil;
import java.sql.*;
import java.awt.Toolkit;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioFrame extends javax.swing.JFrame {

    public FuncionarioFrame() {
        initComponents();
        connect();
        listarFuncionarios();
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/saam/cadfuncionario/imagem/icon.PNG")));
    }
    
    Connection con;
    PreparedStatement pst;

    private void connect(){
        con = con = ConexaoDAO.getConnection();             
    }
    
    private void listarFuncionarios(){
        try {
            String select = "SELECT * FROM funcionario ORDER BY id";
            pst = con.prepareStatement(select);
            ResultSet resultado = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
            
            ResultSetMetaData rsmd = resultado.getMetaData();
            int qtdCol = rsmd.getColumnCount();
            DefaultTableModel defaultModel = (DefaultTableModel) tabelaFuncionarios.getModel();
            defaultModel.setRowCount(0);
            
            while(resultado.next()){
                Vector registro = new Vector();
                for(int i = 1; i<=qtdCol; i++){
                    registro.add(resultado.getLong("id"));
                    registro.add(resultado.getString("nome"));
                    registro.add(StringUtil.formataData(resultado.getDate("dtAdmissao")));//formata a data para exibição na tela 
                    registro.add(StringUtil.formataMoeda(resultado.getDouble("salario")));//formata o valor para exibição na tela 
                    registro.add(StringUtil.verificaStatus(resultado.getBoolean("status")));//exibe o texto de status  
                }               
                defaultModel.addRow(registro);
            }
            tabelaFuncionarios.setModel(model);
        } catch (SQLException ex) {
            StringUtil.mensagemErro("Erro ao buscar a lista de Funcionários!");
            Logger.getLogger(FuncionarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limparCampos(){
        campoNome.setText("");
        campoDataAdmissao.setDate(null);
        campoSalario.setText("");
        checkStatus.setSelected(true);
        campoNome.requestFocus();
    }
    
    public boolean validarCampos(){
        boolean verifica = true;
      
        if(campoNome.getText().isEmpty() || campoNome.getText().isBlank() ){
            StringUtil.mensagemAlerta("Preencha o campo Nome!");
            verifica = false;
        }else if(campoDataAdmissao.getDate() == null){
            StringUtil.mensagemAlerta("Selecione a Data de Admissão!");
            verifica = false;
        }else if(campoSalario.getText().isEmpty() || campoSalario.getText().isBlank()){
            StringUtil.mensagemAlerta("Preencha o campo Salário!");
            verifica = false;
        }
        
        return verifica;
    }
    
    
    
    public Funcionario montarObjetoFuncionario(){
        Funcionario f = new Funcionario();
        f.setNome(campoNome.getText());
        f.setDtAdmissao(campoDataAdmissao.getDate()) ;
        f.setSalario(StringUtil.stringParaDouble(campoSalario.getText())) ;
        f.setStatus(checkStatus.isSelected()) ;
        
        return f;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        painelCabecalho = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        painelRodape = new javax.swing.JPanel();
        painelConteudo = new javax.swing.JPanel();
        painelTabelaFuncionarios = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        painelFuncionarioForm = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelDtAdmissao = new javax.swing.JLabel();
        campoDataAdmissao = new com.toedter.calendar.JDateChooser();
        labelSalario = new javax.swing.JLabel();
        campoSalario = new javax.swing.JFormattedTextField();
        labelStatus = new javax.swing.JLabel();
        checkStatus = new javax.swing.JCheckBox();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelCabecalho.setBackground(new java.awt.Color(102, 153, 255));
        painelCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        painelCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("CADASTRO DE FUNCIONÁRIOS");
        painelCabecalho.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/logo.png"))); // NOI18N
        painelCabecalho.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        btnSair.setBackground(new java.awt.Color(51, 153, 255));
        btnSair.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/log-out.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setActionCommand("");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        painelCabecalho.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 100, 40));

        painelPrincipal.add(painelCabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 120));

        painelRodape.setBackground(new java.awt.Color(102, 153, 255));
        painelRodape.setForeground(new java.awt.Color(255, 255, 255));
        painelRodape.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelPrincipal.add(painelRodape, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1170, 110));

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelTabelaFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        painelTabelaFuncionarios.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true), "Lista de Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        painelTabelaFuncionarios.setForeground(new java.awt.Color(51, 153, 255));
        painelTabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelTabelaFuncionariosMouseClicked(evt);
            }
        });

        tabelaFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data Adimissão", "Salário", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        painelTabelaFuncionarios.setViewportView(tabelaFuncionarios);

        painelConteudo.add(painelTabelaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 650, 450));

        painelFuncionarioForm.setBackground(new java.awt.Color(255, 255, 255));
        painelFuncionarioForm.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)), "Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        painelFuncionarioForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelNome.setForeground(new java.awt.Color(102, 153, 255));
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNome.setText("Nome");
        painelFuncionarioForm.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 130, 30));

        campoNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        painelFuncionarioForm.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 310, 30));

        labelDtAdmissao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDtAdmissao.setForeground(new java.awt.Color(102, 153, 255));
        labelDtAdmissao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDtAdmissao.setText("Data de Admissão");
        painelFuncionarioForm.add(labelDtAdmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, 30));

        campoDataAdmissao.setDateFormatString("dd '/' MM '/' y");
        campoDataAdmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        painelFuncionarioForm.add(campoDataAdmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 310, 30));

        labelSalario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelSalario.setForeground(new java.awt.Color(102, 153, 255));
        labelSalario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSalario.setText("Valor do Salário");
        painelFuncionarioForm.add(labelSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, 30));

        campoSalario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        campoSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        campoSalario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        painelFuncionarioForm.add(campoSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 310, 30));

        labelStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(102, 153, 255));
        labelStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStatus.setText("Status");
        painelFuncionarioForm.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 130, 30));

        checkStatus.setBackground(new java.awt.Color(255, 255, 255));
        checkStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        checkStatus.setForeground(new java.awt.Color(102, 153, 255));
        checkStatus.setSelected(true);
        checkStatus.setText("Ativo");
        checkStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 1, true));
        checkStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStatusActionPerformed(evt);
            }
        });
        painelFuncionarioForm.add(checkStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 70, 30));

        painelConteudo.add(painelFuncionarioForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 380));

        btnCadastrar.setBackground(new java.awt.Color(51, 153, 255));
        btnCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/add-func.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        painelConteudo.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 150, 50));

        btnAlterar.setBackground(new java.awt.Color(51, 153, 255));
        btnAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/edit-func.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        painelConteudo.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 150, 50));

        btnExcluir.setBackground(new java.awt.Color(51, 153, 255));
        btnExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/delete-func.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        painelConteudo.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 150, 50));

        painelPrincipal.add(painelConteudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1160, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.hide();
        LoginFrame telaLogin = new LoginFrame();
        telaLogin.show();
    }//GEN-LAST:event_btnSairActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void checkStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkStatusActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tabelaFuncionarios.getSelectedRow() < 0){
            StringUtil.mensagemAlerta("Selecione um Funcionário para Excluir!");
        }else{
            Object[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(
                            this, 
                            "Tem certeza que deseja excluir?", 
                            "Confirmação de Exclusão", 
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]);
            if(escolha == JOptionPane.YES_OPTION){
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
                    int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
                    Long id = Long.valueOf(model.getValueAt(linhaSelecionada, 0).toString());
                    String delete = "DELETE FROM funcionario WHERE id = ?";
                    pst = con.prepareStatement(delete);
                    pst.setLong(1,id);
                    pst.executeUpdate();
                    listarFuncionarios();
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Funcionário Excluído com Sucesso!");
                }catch (SQLException ex) {
                        StringUtil.mensagemErro("Erro ao tentar excluir o Funcionário!");
                        Logger.getLogger(FuncionarioFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(validarCampos()){
             try {
                Funcionario f = montarObjetoFuncionario() ;
                String insert = "INSERT INTO funcionario(nome, dtAdmissao, salario, status) VALUES ( ?, ?, ?, ?)";
                pst = con.prepareStatement(insert);
                pst.setString(1,f.getNome());
                pst.setDate(2,new java.sql.Date(f.getDtAdmissao().getTime()));
                pst.setDouble(3,f.getSalario());
                pst.setBoolean(4,f.getStatus());
                pst.executeUpdate();
                listarFuncionarios();
                limparCampos();
                JOptionPane.showMessageDialog(this, "Funcionário Cadastrado com Sucesso!");
            } catch (SQLException ex) {
                StringUtil.mensagemErro("Erro ao tentar cadastrar o Funcionário!");
                Logger.getLogger(FuncionarioFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(tabelaFuncionarios.getSelectedRow() < 0){
            StringUtil.mensagemAlerta("Selecione um Funcionário para Alterar!");
        }else{
            if(validarCampos()){
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
                    int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
                    Long id = Long.valueOf(model.getValueAt(linhaSelecionada, 0).toString());
                    Funcionario f = montarObjetoFuncionario();
                    String update = "UPDATE funcionario set nome = ?, dtAdmissao = ?, salario = ?, status = ? WHERE id = ?";
                    pst = con.prepareStatement(update);
                    pst.setString(1,f.getNome());
                    pst.setDate(2,new java.sql.Date(f.getDtAdmissao().getTime()));// convertendo o tipo java.util.date para java.sql.date
                    pst.setDouble(3,f.getSalario());
                    pst.setBoolean(4,f.getStatus()); 
                    pst.setLong(5,id);
                    pst.executeUpdate();
                    listarFuncionarios();
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Funcionário Alterado com Sucesso!");
                }catch (SQLException ex) {
                    StringUtil.mensagemErro("Erro ao tentar alterar o Funcionário!");
                    Logger.getLogger(FuncionarioFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void painelTabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelTabelaFuncionariosMouseClicked

    }//GEN-LAST:event_painelTabelaFuncionariosMouseClicked

    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
        int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
        
        Long id = Long.valueOf(model.getValueAt(linhaSelecionada, 0).toString());
        campoNome.setText(model.getValueAt(linhaSelecionada, 1).toString());
        campoDataAdmissao.setDate(StringUtil.stringParaDate(model.getValueAt(linhaSelecionada,2).toString()));
        campoSalario.setText(StringUtil.removeRS(model.getValueAt(linhaSelecionada, 3).toString()));
        checkStatus.setSelected(StringUtil.statusParaBoolean(model.getValueAt(linhaSelecionada, 4).toString()));
    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private com.toedter.calendar.JDateChooser campoDataAdmissao;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoSalario;
    private javax.swing.JCheckBox checkStatus;
    private javax.swing.JLabel labelDtAdmissao;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSalario;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelFuncionarioForm;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelRodape;
    private javax.swing.JScrollPane painelTabelaFuncionarios;
    private javax.swing.JTable tabelaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
