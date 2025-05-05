package br.com.saam.cadfuncionario.dao;
import br.com.saam.cadfuncionario.util.StringUtil;
import br.com.saam.cadfuncionario.view.usuario.CadUsuarioFrame;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDAO {
       
    public static final String DRIVER_BANCO = "org.postgresql.Driver";
    public static final String URL_BANCO = "jdbc:postgresql://localhost:5432/cadFuncionario";
    public static final String USER_BANCO = "postgres";
    public static final String PSW_BANCO = "admin123";
    
     public static Connection getConnection()  {
         Connection conexao = null;
         try{
            Class.forName(DRIVER_BANCO);
            conexao = DriverManager.getConnection(URL_BANCO, USER_BANCO, PSW_BANCO);
        } catch (ClassNotFoundException ex) {
            StringUtil.mensagemErro("Erro ao encontrar o Driver do Banco!");
            Logger.getLogger(CadUsuarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            StringUtil.mensagemErro("Erro ao tentar conectar ao Banco!");
            Logger.getLogger(CadUsuarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         return conexao;
    }
}
