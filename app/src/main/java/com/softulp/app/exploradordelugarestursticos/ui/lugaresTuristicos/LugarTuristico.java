package com.softulp.app.exploradordelugarestursticos.ui.lugaresTuristicos;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LugarTuristico implements Serializable {
    private String nombre;
    private String descripcion;
    private String masInfo;
    private List<Integer> fotos;
    private String horarios;
    public LugarTuristico(){}

    public LugarTuristico(String nombre, String descripcion, List<Integer> fotos, String horarios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.horarios = horarios;
    }

    public LugarTuristico(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Integer> getFotos() {
        return fotos;
    }

    public void setFotos(List<Integer> fotos) {
        this.fotos = fotos;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getMasInfo() {
        return masInfo;
    }

    public void setMasInfo(String masInfo) {
        this.masInfo = masInfo;
    }

    @Override
    public String toString() {
        return "LugarTuristico{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", masInfo='" + masInfo + '\'' +
                ", fotos=" + fotos +
                ", horarios='" + horarios + '\'' +
                '}';
    }
}
