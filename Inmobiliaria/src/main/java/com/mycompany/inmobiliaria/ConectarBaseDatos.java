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
                    + ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertarPropietario(){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement stmt;
            String sql;

            stmt = conn.createStatement();
            sql = "INSERT INTO PROPIETARIOS VALUES( "
                    + "   1, "
                    + "   \'prueba00\', "
                    + "   \'preuba01\' "
                    + ")";

            stmt.executeUpdate(sql);
            System.out.println("Insert table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertarCasa(){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement stmt;
            String sql;

            stmt = conn.createStatement();
            sql = "INSERT INTO CASA VALUES( "
                    + "   1, "
                    + "   10, "
                    + "   2, "
                    + "   \'preuba01\', "
                    + "   true, "
                    + ")";

            stmt.executeUpdate(sql);
            System.out.println("Insert table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void selectPropietarios(){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM PROPIETARIOS");
            while(res.next()){
                System.out.print(res.getInt("PROPIETARIOID") + "; ");
                System.out.print(res.getString("NOMBRE") + "; ");
                System.out.print(res.getString("APELLIDOS") + "; ");
                System.out.println("");
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void selectCasas(){
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC","root","1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM CASAS");
            while(res.next()){
                System.out.print(res.getInt("CASAID") + "; ");
                System.out.print(res.getInt("METROSCUADRADOS") + "; ");
                System.out.print(res.getInt("HABITACIONES") + "; ");
                System.out.print(res.getString("DOMICILIO") + "; ");
                System.out.print(res.getBoolean("GARAJE") + "; ");
                System.out.println("");
            }
            
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static int obtenerIdMaxPropietario(){
        int result = 0;
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
        int result = 0;
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
}

