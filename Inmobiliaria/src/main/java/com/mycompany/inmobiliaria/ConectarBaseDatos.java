/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inmobiliaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrián López
 */
public class ConectarBaseDatos {

    public static void crearTablaPropietarios() {

        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement stmt;
            String sql;

            stmt = conn.createStatement();
            sql = "CREATE TABLE PROPIETARIOS "
                    + "("
                    + "   PROPIETARIOID INTEGER PRIMARY KEY, "
                    + "   NOMBRE VARCHAR(255), "
                    + "   APELLIDOS VARCHAR(255)"
                    + ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crearTablaCasa() {

        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement stmt;
            String sql;

            stmt = conn.createStatement();
            sql = "CREATE TABLE CASA "
                    + "("
                    + "   CASAID INTEGER PRIMARY KEY, "
                    + "   METROSCUADRADOS INTEGER, "
                    + "   HABITACIONES INTEGER, "
                    + "   DOMICILIO VARCHAR(255), "
                    + "   GARAJE BOOLEAN, "
                    + ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crearTablaPropietariosCasa() {

        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement stmt;
            String sql;

            stmt = conn.createStatement();
            sql = "CREATE TABLE PROPIETARIOSCASA "
                    + "("
                    + "   PROPIETARIOID INTEGER, "
                    + "   CASAID INTEGER "
                    + ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertarPropietario(Propietario p){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement stmt;
            String sql;

            stmt = conn.createStatement();
            sql = "INSERT INTO PROPIETARIOS VALUES( "
                    + p.getNuevoId()+", "
                    + p.getNombre()+", "
                    + p.getApellido()+" "
                    + ")";
            stmt.executeUpdate(sql);
            System.out.println("Insert table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertarCasa(Casa c){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement stmt;
            String sql;

            stmt = conn.createStatement();
            sql = "INSERT INTO CASAS VALUES( "
                    + c.getNuevoId()+", "
                    + c.getMetrosCuadrados()+", "
                    + c.getHabitaciones()+", "
                    + c.getDomicilio()+", "
                    + c.isGaraje()+", "
                    + ")";

            stmt.executeUpdate(sql);
            System.out.println("Insert table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList selectPropietarios(){
        ArrayList<Propietario> propietarioResultado = new ArrayList<>();
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM PROPIETARIOS");
            while(res.next()){
                Propietario p = new Propietario();
                p.setApellido(res.getString("APELLIDOS"));
                p.setNombre(res.getString("NOMBRE"));
                System.out.print(res.getInt("PROPIETARIOID") + "; ");
                propietarioResultado.add(p);
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return propietarioResultado;
    }
    
    public static ArrayList selectCasas(){
        ArrayList<Casa> casasResultado = new ArrayList<>();
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM CASAS");
            while(res.next()){
                Casa c = new Casa();
                c.setDomicilio(res.getString("DOMICILIO"));
                c.setGaraje(res.getBoolean("GARAJE"));
                c.setHabitaciones(res.getInt("HABITACIONES"));
                c.setMetrosCuadrados(res.getInt("METROSCUADRADOS"));
                System.out.print(res.getInt("CASAID") + "; ");
                casasResultado.add(c);
            }
            
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return casasResultado;
    }
    
    public static int obtenerIdMaxPropietario(){
        int result = -1;
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT MAX(PROPIETARIOID) FROM PROPIETARIOS");
            result = res.getInt("PROPIETARIOID");
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static int obtenerIdMaxCasa(){
        int result = -1;
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT MAX(CASAID) FROM PROPIETARIOS");
            result = res.getInt("CASAID");
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static void eliminarCasa(int id){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("DELETE FROM CASAS WHERE CASAID = "+id);
            System.out.println(res.getString(0));
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void eliminarPropietario(int id){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("DELETE FROM PROPIETARIOS WHERE PROPIETARIOID = "+id);
            System.out.println(res.getString(0));
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

