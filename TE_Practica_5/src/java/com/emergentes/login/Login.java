package com.emergentes.login;

import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Login extends ConexionDB{
    
    public List<Usuarios> getAll() throws Exception{
        List<Usuarios> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Usuarios>();
            while(rs.next()) {
                Usuarios usu = new Usuarios();
                usu.setId(rs.getInt("id"));
                usu.setUsuarios(rs.getString("usuarios"));
                usu.setPassword(rs.getString("password"));
                lista.add(usu);
            }
            rs.close();
            ps.close();
        } catch(Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return lista;
    }
}
