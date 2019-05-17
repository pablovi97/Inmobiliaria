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
    static int posCasa = ConectarBaseDatos.obtenerIdMaxCasa();
    static int posPropietario = ConectarBaseDatos.obtenerIdMaxPropietario();

    public Casa avanzarCasa() {
        Casa casaResultado = casas.get(posCasa);
        try {
            if (casas.get(posCasa + 1) != null) {
                posCasa++;
                casaResultado = casas.get(posCasa);

            }
        } catch (Exception e) {
            casaResultado = casas.get(posCasa);
        }
        return casaResultado;
    }

    public void insertarDatosCasa() {
        ArrayList<Casa> cas = ConectarBaseDatos.selectCasas();
        for (Casa casa : cas) {
            this.casas.add(casa);
        }
    }

    public void insertarDatosPropietarios() {
        ArrayList<Propietario> props = ConectarBaseDatos.selectPropietarios();
        for (Propietario prop : props) {
            this.propietarios.add(prop);
        }
    }

    public Casa retrocederCasa() {
        Casa casaResultado = casas.get(posCasa);
        try {
            if (casas.get(posCasa - 1) != null) {
                posCasa--;
                casaResultado = casas.get(posCasa);

            }
        } catch (Exception e) {
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

        Propietario p = null;
        try {

            if (propietarios.get(posPropietario) != null) {
                p = propietarios.get(posPropietario);

                if (propietarios.get(posPropietario - 1) != null) {

                    posPropietario--;
                    p = propietarios.get(posPropietario);

                    System.out.println(p.nombre);

                }
            } else {

                do {

                    if (propietarios.get(posPropietario) == null) {
                        posPropietario--;
                    }

                } while (propietarios.get(posPropietario) != null);

                p = propietarios.get(posPropietario);

            }

        } catch (Exception e) {
            p = propietarios.get(posPropietario);
        }
        return p;
    }

    public Propietario avanzarPropietario() {
        Propietario p = propietarios.get(posPropietario);
        try {
            if (propietarios.get(posPropietario + 1) != null) {
                posPropietario++;
                p = propietarios.get(posPropietario);

            }
        } catch (Exception e) {
            p = propietarios.get(posPropietario);
        }
        return p;
    }

    public void introducirPropietario(Propietario p) {

        propietarios.add(p);
        posPropietario++;

        System.out.println("posProp" + posPropietario);

    }
    static int posPropcasa = -1;

    public Casa avanzarCasaPropietario(int i) {
        Casa result = null;
        Propietario p = propietarios.get(i);
        try {

            if (posPropcasa + 1 <= p.casas.size()) {
                posPropcasa++;

            }
        } catch (Exception e) {
        }
        result = p.casas.get(posPropcasa);
        return result;

    }

    public Casa RetrocederCasaPropietario(int i) {
        Casa result = null;
        Propietario p = propietarios.get(i);

        try {
            if (posPropcasa - 1 > -1) {
                posPropcasa--;

            }
        } catch (Exception e) {
        }

        result = p.casas.get(posPropcasa);
        return result;

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
