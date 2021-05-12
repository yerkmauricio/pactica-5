package com.emergentes.utiles;
import java.sql.*;

public class ConexionDB {
    static String url = "jdbc:mysql://localhost:3306/bd_blog";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;
    
    public ConexionDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK: " + conn);
            }
        } catch (SQLException ex){
            System.out.println("Error de SQL en conexion: " + ex.getMessage());
        } catch (ClassNotFoundException ex){
            System.out.println("Error de SQL en llamar a la clase: " + ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        System.out.println("Cerrando la BD: " + conn);
        try{
            conn.close();
        } catch(SQLException ex) {
            System.out.println("Error de SQL en conexion: " + ex.getMessage());
        }
    }
}
