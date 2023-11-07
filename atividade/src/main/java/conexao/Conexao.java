/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author rcosta
 */
public class Conexao {
    private static final String DATABASEURL = "jdbc:mysql://localhost:3306/supermercado";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static  Connection ConexaoSQL() throws Exception {

        Connection connection = DriverManager.getConnection(DATABASEURL, USER, PASSWORD);

        return connection;

    }

    public static void main(String[] args) throws Exception {

        Connection connection = ConexaoSQL();

        if (connection != null) {

            JOptionPane.showMessageDialog(null, "Conectado com sucesso");

            connection.close();

        }

    }

}
   
