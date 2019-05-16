/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inmobiliaria;

//import static com.mycompany.inmobiliaria.Propietario.id;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daw
 */
@XmlRootElement(name = "casa")
public class Casa {

    public Casa(double metrosCuadrados, int habitaciones, String Domicilio) {
        this.metrosCuadrados = metrosCuadrados;
        this.habitaciones = habitaciones;
        this.Domicilio = Domicilio;
    }

    public Casa(double metrosCuadrados, int habitaciones, boolean garaje, String Domicilio) {
        this.metrosCuadrados = metrosCuadrados;
        this.habitaciones = habitaciones;
        this.Domicilio = Domicilio;
        idcasa++;
        nuevoId = idcasa;
    }

    @XmlElement(name = "IDcasa")
    public int getNuevoId() {
        return nuevoId;
    }
    int nuevoId;
    static int idcasa = ConectarBaseDatos.obtenerIdMaxCasa();;

    double metrosCuadrados;

    int habitaciones;

    String Domicilio;

    public Casa() {

    }

    @XmlTransient
    ArrayList<Propietario> propietarios = new ArrayList<>();


    @XmlElement(name = "metrosCuadrados")
    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    @XmlElement(name = "habitaciones")
    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    @XmlElement(name = "domicilio")
    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

}
