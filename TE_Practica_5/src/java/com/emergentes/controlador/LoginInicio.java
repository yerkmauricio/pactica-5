package com.emergentes.controlador;

import com.emergentes.login.Usuarios;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginInicio", urlPatterns = {"/LoginInicio"})
public class LoginInicio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usu = request.getParameter("usuario");
        String pass = request.getParameter("password");
        
        if (usu != null && pass != null) {
            List<Usuarios> lista = null;
            
            String url = "jdbc:mysql://localhost:3306/bd_blog";
            String usuario = "root";
            String password = "";
            Connection conn = null;

            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, usuario, password);
                if (conn != null) {
                System.out.println("Conexion OK: " + conn);
                }
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios");
                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<Usuarios>();
                while(rs.next()) {
                    Usuarios usua = new Usuarios();
                    usua.setId(rs.getInt("id"));
                    usua.setUsuarios(rs.getString("usuarios"));
                    usua.setPassword(rs.getString("password"));
                    lista.add(usua);
                    
                    if (usua.getUsuarios().equals(usu) && usua.getPassword().equals(pass)) {
                        System.out.println("Conexion Correcta....");
                        response.sendRedirect(request.getContextPath()+"/Inicio");
                    }
                }
                rs.close();
                ps.close();
            } catch(Exception e) {
                System.out.println("Error en la obtencion de usuarios BD "+e);
            } finally{
                System.out.println("Cerrando la BD: " + conn);
                try{
                    conn.close();
                } catch(SQLException ex) {
                    System.out.println("Error de SQL en conexion: " + ex.getMessage());
                }
            }      
        } else {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }    
    }
}
