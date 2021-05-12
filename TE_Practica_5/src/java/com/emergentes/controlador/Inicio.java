package com.emergentes.controlador;

import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOimpl;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            try{
                AvisoDAO dao = new AvisoDAOimpl();
                int id;
                Aviso avi = new Aviso();
                String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

                switch(action){
                    case "add":
                        request.setAttribute("aviso", avi);
                        request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                        break;
                    case "edit":
                        id = Integer.parseInt(request.getParameter("id"));
                        avi = dao.getById(id);
                        System.out.println(avi);
                        request.setAttribute("aviso", avi);
                        request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                        break;
                    case "delete":
                        id = Integer.parseInt(request.getParameter("id"));
                        dao.delete(id);
                        response.sendRedirect(request.getContextPath()+"/Inicio");
                        break; 
                    case "view":
                        List<Aviso> lista = dao.getAll();
                        request.setAttribute("avisos", lista);
                        request.getRequestDispatcher("index.jsp").forward(request, response);

                    default:
                        break;
                } 
            } catch(Exception ex) {
                System.out.println("Error en doGet: " + ex.getMessage());
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");

        Aviso avi = new Aviso();
        
        avi.setId(id);
        avi.setFechasql(fecha);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);
        
        if (id == 0) {
            try{
                AvisoDAO dao = new AvisoDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("Error al crear nuevos datos: " + ex.getMessage());
            }
        } else {
            try{
                AvisoDAO dao = new AvisoDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("Error al editar los datos: " + ex.getMessage());
            }
        }
    }
}
