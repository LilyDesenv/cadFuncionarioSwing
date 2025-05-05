package br.com.saam.cadfuncionario.view.login;

import br.com.saam.cadfuncionario.dao.ConexaoDAO;
import br.com.saam.cadfuncionario.view.funcionario.FuncionarioFrame;
import br.com.saam.cadfuncionario.view.usuario.CadUsuarioFrame;
import br.com.saam.cadfuncionario.util.StringUtil;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
public class LoginFrame extends javax.swing.JFrame {

   
    public LoginFrame() {
        initComponents();
        this.setResizable(false);
        connect();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/saam/cadfuncionario/imagem/icon.PNG")));
    }

    Connection con;
    PreparedStatement pst;

    private void connect(){
        con = ConexaoDAO.getConnection();           
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        painelCabecalho = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        painelRodape = new javax.swing.JPanel();
        painelConteudo = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelCabecalho.setBackground(new java.awt.Color(102, 153, 255));
        painelCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        painelCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("CADASTRO DE FUNCIONÁRIOS");
        painelCabecalho.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/logo.png"))); // NOI18N
        painelCabecalho.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        painelPrincipal.add(painelCabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 160));

        painelRodape.setBackground(new java.awt.Color(102, 153, 255));
        painelRodape.setForeground(new java.awt.Color(255, 255, 255));
        painelRodape.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelPrincipal.add(painelRodape, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 600, 160));

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 2, true), "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(102, 153, 255))); // NOI18N
        painelConteudo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(102, 153, 255));
        labelEmail.setText("E-mail");
        painelConteudo.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 90, 30));

        campoEmail.setBackground(new java.awt.Color(236, 251, 255));
        campoEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(102, 153, 255));
        campoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 1, true));
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });
        painelConteudo.add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 370, 30));

        labelSenha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelSenha.setForeground(new java.awt.Color(102, 153, 255));
        labelSenha.setText("Senha");
        painelConteudo.add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 90, 30));

        campoSenha.setBackground(new java.awt.Color(236, 251, 255));
        campoSenha.setForeground(new java.awt.Color(102, 153, 255));
        campoSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 1, true));
        painelConteudo.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 370, 30));

        btnCadastrar.setBackground(new java.awt.Color(51, 153, 255));
        btnCadastrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/add-func.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        painelConteudo.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 160, 50));

        btnEntrar.setBackground(new java.awt.Color(51, 153, 255));
        btnEntrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/login.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        painelConteudo.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 160, 50));

        painelPrincipal.add(painelConteudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 580, 360));

        getContentPane().add(painelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        this.hide();
        CadUsuarioFrame telaFunc = new CadUsuarioFrame();
        telaFunc.show();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if(validarCampos()){
            if(verificaLoginCadastrado()){
                if(verificaSenha()){
                    this.hide();
                    FuncionarioFrame telaFunc = new FuncionarioFrame();
                    telaFunc.show();
                }else{
                    StringUtil.mensagemAlerta("A Senha está incorreta!");
                }
            }else{
                StringUtil.mensagemAlerta("E-mail não Cadastrado no sistema. Efetue o cadastro e tente novamente!");
            } 
        }
       
       
    }//GEN-LAST:event_btnEntrarActionPerformed


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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
    
    public boolean validarCampos(){
        boolean verifica = true;
        if(campoEmail.getText().isEmpty() || campoEmail.getText().isBlank()){
            StringUtil.mensagemAlerta("Preencha o campo E-mail!");
            verifica = false;
        }else if(campoSenha.getPassword().length == 0  ){
            StringUtil.mensagemAlerta("Preencha o campo Senha!");
            verifica = false;
        }
        return verifica;
    }
    
    public boolean verificaLoginCadastrado(){
        boolean verifica = false;
        try{
            String select = "SELECT 1 FROM usuario WHERE email = ?";
            pst = con.prepareStatement(select);
            pst.setString(1,campoEmail.getText());
            ResultSet resultado = pst.executeQuery();
            if(resultado.next()){
                verifica = true;
            }
        }catch (SQLException ex) {
                StringUtil.mensagemErro("Erro ao buscar as informações de Usuário! Tente novamente mais tarde.");
                Logger.getLogger(CadUsuarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verifica;
    }
    
    public boolean verificaSenha(){
        boolean verifica = false;
        try{
            String select = "SELECT 1 FROM usuario WHERE email = ? AND senha = ?";
            pst = con.prepareStatement(select);
            pst.setString(1,campoEmail.getText());
            char[] senha = campoSenha.getPassword();
            pst.setString(2,StringUtil.criptografarSenha( new String(senha)));
            ResultSet resultado = pst.executeQuery();
            if(resultado.next()){
                verifica = true;
            }
        }catch (SQLException ex) {
                StringUtil.mensagemErro("Erro ao buscar as informações de Usuário! Tente novamente mais tarde.");
                Logger.getLogger(CadUsuarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verifica;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelRodape;
    // End of variables declaration//GEN-END:variables
}
