/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author Admin
 */
public class DB {

    // Variavel que vai receber a conexao
    private static Connection conn = null;

    // Atribuicao da conexao para a variavel Conn
    public static Connection getConnection() {
        if (conn == null) {
            try {
                //Atribuindo as propiedades a variavel props
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                // Passando os parametros necessarios para a conexao 
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    // Fechamento da conexao
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    // Leitura das propriedades do banco de um arquivo externo chamado db.properties
    
    private static Properties loadProperties() {
        //Properties é uma classe do java que gere arquivos do tipo proprieades
        try ( FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
    
    public static void closeStatement(Statement st){
        if (st != null){
            try {
                st.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage()); 
            }
        }
    }
    
    public static void closeResultSet(ResultSet rs){
     
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }
}
