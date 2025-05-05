package br.com.saam.cadfuncionario.view.usuario;


import br.com.saam.cadfuncionario.dao.ConexaoDAO;
import br.com.saam.cadfuncionario.model.Usuario;
import br.com.saam.cadfuncionario.view.login.LoginFrame;
import br.com.saam.cadfuncionario.util.StringUtil;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class CadUsuarioFrame extends javax.swing.JFrame {

 
    public CadUsuarioFrame() {
        initComponents();
        connect();
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/saam/cadfuncionario/imagem/icon.PNG")));

    }

        Connection con;
        PreparedStatement pst;

        private void connect(){
            con = con = ConexaoDAO.getConnection();          
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
        labelRepetSenha = new javax.swing.JLabel();
        confirmSenha = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        labelEmail1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelCabecalho.setBackground(new java.awt.Color(102, 153, 255));
        painelCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        painelCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("CADASTRAR USUÁRIO");
        painelCabecalho.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/logo.png"))); // NOI18N
        painelCabecalho.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        painelPrincipal.add(painelCabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 160));

        painelRodape.setBackground(new java.awt.Color(102, 153, 255));
        painelRodape.setForeground(new java.awt.Color(255, 255, 255));
        painelRodape.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelPrincipal.add(painelRodape, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 600, 160));

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 2, true), "Novo Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(102, 153, 255))); // NOI18N
        painelConteudo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(102, 153, 255));
        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEmail.setText("E-mail");
        painelConteudo.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 130, 30));

        campoEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(102, 153, 255));
        campoEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        painelConteudo.add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 340, 30));

        labelSenha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelSenha.setForeground(new java.awt.Color(102, 153, 255));
        labelSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSenha.setText("Senha");
        painelConteudo.add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 130, 30));

        campoSenha.setForeground(new java.awt.Color(102, 153, 255));
        campoSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        painelConteudo.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 340, 30));

        labelRepetSenha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelRepetSenha.setForeground(new java.awt.Color(102, 153, 255));
        labelRepetSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelRepetSenha.setText("Confirmar Senha");
        painelConteudo.add(labelRepetSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, 30));

        confirmSenha.setForeground(new java.awt.Color(102, 153, 255));
        confirmSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        painelConteudo.add(confirmSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 340, 30));

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
        painelConteudo.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 160, 40));

        btnVoltar.setBackground(new java.awt.Color(51, 153, 255));
        btnVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/saam/cadfuncionario/imagem/voltar.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        painelConteudo.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 160, 40));

        labelEmail1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelEmail1.setForeground(new java.awt.Color(102, 153, 255));
        labelEmail1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEmail1.setText("Nome");
        painelConteudo.add(labelEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 130, 30));

        campoNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoNome.setForeground(new java.awt.Color(102, 153, 255));
        campoNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        painelConteudo.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 340, 30));

        painelPrincipal.add(painelConteudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 580, 360));

        getContentPane().add(painelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.hide();
        LoginFrame telaFunc = new LoginFrame();
        telaFunc.show();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(validarCampos()){
            Usuario u = montarObjUsuario();
            if(verificaEmailRepetido(u.getLogin())){
                StringUtil.mensagemAlerta("O email já está cadastrado no sistema, tente cadastrar outro email ou volte e faça o login!");
            }else{
                try{
                    String select = "INSERT INTO usuario ( email, senha, nome) VALUES ( ?, ?, ?)";
                    pst = con.prepareStatement(select);
                    pst.setString(1,u.getLogin());
                    pst.setString(2,u.getSenha());
                    pst.setString(3,u.getNome());
                    pst.executeUpdate();
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Usuário Cadastrado com Sucesso! Tente efetuar o login.");
                    this.hide();
                    LoginFrame telaFunc = new LoginFrame();
                    telaFunc.show();
                }catch (SQLException ex) {
                    StringUtil.mensagemErro("Erro ao tentar cadastrar o Usuário! Tente novamente mais tarde.");
                    Logger.getLogger(CadUsuarioFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }       
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    public Usuario montarObjUsuario(){
        Usuario u = new Usuario();
        u.setNome(campoNome.getText());
        u.setLogin(campoEmail.getText());
        char[] senha = campoSenha.getPassword();
        u.setSenha(StringUtil.criptografarSenha( new String(senha)));
        Arrays.fill(senha, '0');
        return u;
    }
    
    public boolean verificaEmailRepetido(String email){
        boolean verifica = false;
        try{
                Usuario u = montarObjUsuario();
                String select = "SELECT 1 FROM usuario WHERE email = ?";
                pst = con.prepareStatement(select);
                pst.setString(1,email);
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
    
    public boolean validarCampos(){
        boolean verifica = true;
        if(campoNome.getText().isEmpty() || campoNome.getText().isBlank()){
            StringUtil.mensagemAlerta("Preencha o campo Nome!");
            verifica = false;
        }else if(campoEmail.getText().isEmpty() || campoEmail.getText().isBlank()){
            StringUtil.mensagemAlerta("Preencha o campo E-mail!");
            verifica = false;
        }else if(campoSenha.getPassword().length == 0  ){
            StringUtil.mensagemAlerta("Preencha o campo Senha!");
            verifica = false;
        }else if(confirmSenha.getPassword().length == 0  ){
            StringUtil.mensagemAlerta("Preencha o campo Confirmar Senha!");
            verifica = false;
        }else if (compararConfirmarSenha()){
            StringUtil.mensagemAlerta("As Senhas estão divergentes!");
            verifica = false;
        }
        return verifica;
    }
    
    public boolean compararConfirmarSenha(){
        boolean verifica = true;
         char[] senha = campoSenha.getPassword();
         char[] confSenha = confirmSenha.getPassword();
         if((new String(senha)).equals(new String(confSenha))){
             verifica = false;
         }
        return verifica;
    }
    
    public void limparCampos(){
        campoNome.setText("");
        campoEmail.setText("");
        campoSenha.setText(null);        
        confirmSenha.setText(null);        
    }
    
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
            java.util.logging.Logger.getLogger(CadUsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadUsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadUsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadUsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadUsuarioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JPasswordField confirmSenha;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmail1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelRepetSenha;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelRodape;
    // End of variables declaration//GEN-END:variables
}
