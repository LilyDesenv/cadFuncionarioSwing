package br.com.saam.cadfuncionario.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class StringUtil {
    public static String formataData(Date data){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data);
    }
    
    public static Date stringParaDate(String dataString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formato.parse(dataString);
        } catch (ParseException ex) {
            Logger.getLogger(StringUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static String formataMoeda(double valor){
         // Configura o formato para o padrão brasileiro
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        return df.format(valor);
    }
    
    public static String verificaStatus(boolean status){
        return status ? "Ativo": "Inativo";
    }
    
    public static boolean statusParaBoolean(String status){
        return status.equals("Ativo");
    }
    
    public static double stringParaDouble(String numero) {
        // Remove pontos usados como separador de milhar
        String valorSemPontos = numero.replaceAll("\\.", "");
        // Troca vírgula por ponto para o parseDouble entender
        String valorParaParse = valorSemPontos.replaceAll(",", ".");
        // Converte para double
        return Double.parseDouble(valorParaParse);
    }
    
    public static String removeRS(String valor) {
         return valor.replace(".", "");
    }
    
     public static void mensagemErro(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem,"Erro",JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensagemAlerta(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem,"Atenção",JOptionPane.WARNING_MESSAGE);
    }
    
     public static String criptografarSenha(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senha.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
     
 
    
}
