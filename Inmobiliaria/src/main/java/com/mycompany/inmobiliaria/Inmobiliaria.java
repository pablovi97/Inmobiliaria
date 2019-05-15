/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inmobiliaria;

import java.util.ArrayList;

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
    static int posCasa = -1;
    static int posPropietario = -1;

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

    public void verArrayListPropietario() {
        for (Propietario propietario : propietarios) {
            System.out.println(propietario.nombre + " " + propietario.getNuevoId());
        }
    }

    public void verArrayListCasadePropietarios(int i) {
        Propietario p = propietarios.get(i);

        for (Casa casa : p.casas) {
            System.out.println(casa.Domicilio);
        }
    }

    public void verArrayListCasa() {
        for (Casa casa : casas) {
            System.out.println(casa.Domicilio);
        }
    }

    public Propietario retrocederPropietario() {

        Propietario p = propietarios.get(posPropietario);
        System.out.println(posPropietario);
        if (propietarios.get(posPropietario - 1) != null) {

            posPropietario--;
            p = propietarios.get(posPropietario);

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
        posPropietario++;

    }

    public void introducirCasa(Casa c) {

        casas.add(c);
        posCasa++;

    }

    public void introducirCasasaProp(int i, Casa c) {

        if (i <= propietarios.size()) {
            Propietario p = propietarios.get(i);
            p.casas.add(c);
        }

    }
}
