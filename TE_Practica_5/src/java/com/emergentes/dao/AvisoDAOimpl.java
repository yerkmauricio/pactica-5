package com.emergentes.dao;

import com.emergentes.login.Usuarios;
import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimpl extends ConexionDB implements AvisoDAO{
    
    @Override
    public void insert(Aviso aviso) throws Exception {
        
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into posts (fecha, titulo, contenido) values (?, ?, ?)");
            ps.setString(1, aviso.getFechasql());
            ps.setString(2, aviso.getTitulo());
            ps.setString(3, aviso.getContenido());
            ps.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }    
    
    @Override
    public void update(Aviso aviso) throws Exception{

        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE posts set fecha = ?, titulo = ?, contenido = ? where id = ?");
            ps.setString(1, aviso.getFechasql());
            ps.setString(2, aviso.getTitulo());
            ps.setString(3, aviso.getContenido());
            ps.setInt(4, aviso.getId());
            ps.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }    
    
    @Override
    public void delete(int id) throws Exception{
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM posts WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }
           
    @Override
    public Aviso getById(int id) throws Exception{
        
        Aviso avi = new Aviso();
        try{
            
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts WHERE id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setFechasql(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
            }
        } catch(Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return avi;
    }
    
    @Override
    public List<Aviso> getAll() throws Exception{
        List<Aviso> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Aviso>();
            while(rs.next()) {
                Aviso avi = new Aviso();
                avi.setId(rs.getInt("id"));
                avi.setFechaformato(rs.getString("fecha"));
                avi.setFechasql(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
                lista.add(avi);
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
    
    @Override
    public List<Usuarios> getList() throws Exception{
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
