/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inmobiliaria;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daw
 */
@XmlRootElement(name = "propietario")
public class Propietario {

    public Propietario() {
        id++;
        nuevoId = id;
    }

    public Propietario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        id++;
        nuevoId = id;
    }

    String nombre;

    // @XmlElement(name = "ID")
    //  public static int getId() {
    //      return id;
    // }
    @XmlElement(name = "IDpropietario")
    public int getNuevoId() {
        return nuevoId;
    }
    int nuevoId;
    static int id = ConectarBaseDatos.obtenerIdMaxPropietario();;

    String apellido;
    ArrayList<Casa> casas = new ArrayList<>();

    @XmlElement(name = "name")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @XmlElementWrapper(name = "casas")
    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }

}
