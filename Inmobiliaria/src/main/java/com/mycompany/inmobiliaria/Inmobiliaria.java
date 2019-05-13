/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inmobiliaria;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daw
 */
@XmlRootElement(name = "Inmobiliaria")
public class Inmobiliaria {

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    ArrayList<Propietario> propietarios = new ArrayList<>();

    public Inmobiliaria() {
    }

    ArrayList<Casa> casas = new ArrayList<>();
    static int posCasa = 0;
    static int posPropietario = 0;

    public Casa avanzarCasa() {
        Casa casaResultado = casas.get(posCasa);
        if (casas.get(posCasa + 1) != null) {
            posCasa++;
            casaResultado = casas.get(posCasa);

        }
        return casaResultado;
    }

    public Casa retrocederCasa() {
        Casa casaResultado = casas.get(posCasa);
        if (casas.get(posCasa - 1) != null) {
            posCasa--;
            casaResultado = casas.get(posCasa);

        }
        return casaResultado;
    }

    public void verArrayListPropietario(){
        for (Propietario propietario : propietarios) {
            System.out.println(propietario.nombre);
        }
    }
    public Propietario retrocederPropietario() {
      int pos = posPropietario;
        Propietario p = propietarios.get(pos);
         System.out.println("entra");
        if (propietarios.get(pos-1) != null) {
            System.out.println("entra dentro del if");
            posPropietario--;
            p = propietarios.get(pos);
            System.out.println("retroceder Prop");
            System.out.println(p.nombre);

        }
        return p;
    }

    public Propietario avanzarPropietario() {
        Propietario p = propietarios.get(posPropietario);
        if (propietarios.get(posPropietario + 1) != null) {
            posPropietario++;
            p = propietarios.get(posPropietario);

        }
        return p;
    }

    public void introducirPropietario(Propietario p) {

        propietarios.add(p);
        posPropietario = p.getNuevoId();
                

    }

    public void introducirCasa(Casa c) {

        casas.add(c);

    }

    public void introducirCasasaProp(int i, Casa c) {

        if (i <= propietarios.size()) {
            Propietario p = propietarios.get(i);
            p.casas.add(c);
        }

    }
}
