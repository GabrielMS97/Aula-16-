package br.ufjf.dcc171;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Aula16Exr01 {

    public static void main(String[] args) {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver carregado com sucesso!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aula16Exr01.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Aula16Exr01.class.getName()).log(Level.SEVERE, "Driver de banco não disponível!");
            System.exit(-1);
        }
        
        String driverURL = "jdbc:derby://localhost:1527/Aula16Exr01BD";
        Connection conexao = null;
        try {
             conexao = DriverManager.getConnection(driverURL, "usuario", "senha");
             System.out.println("Conexão aberta com sucesso!!");
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexão!!");
            Logger.getLogger(Aula16Exr01.class.getName()).log(Level.SEVERE, null, ex);  
        }
        JanelaAplicacao j = new JanelaAplicacao(conexao);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }

}
