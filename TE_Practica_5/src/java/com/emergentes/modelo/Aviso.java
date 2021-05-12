package com.emergentes.modelo;
import java.util.Date;
import java.text.*;

public class Aviso {
    private int id;
    private String titulo;
    private String contenido;
    private String fechasql;
    private String fechaformato;
    protected String fecha;
    protected Date FechaJava;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechasql() {
        return fechasql;
    }

    public void setFechasql(String fechasql) {
        this.fechasql = fechasql;
    }

    public String getFechaformato() {
        return fechaformato;
    }

    public void setFechaformato(String fechaformato) {
        SimpleDateFormat FormatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");

        try{
            FechaJava = FormatoDeFecha.parse(fechaformato);
            fecha = Formato.format(FechaJava);
        } catch (ParseException e){
            System.out.println("Error al convertir: " + e);
        }
        this.fechaformato = fecha;
    }

    @Override
    public String toString() {
        return "Aviso{"+"id = " + id + ", fecha = " + fechasql + " titulo = " + titulo + ", contenido = " + contenido + "}";
    }
}
