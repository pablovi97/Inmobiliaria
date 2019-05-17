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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrián López
 */
public class ConectarBaseDatos {
    
    public static void crearTablaPropietarios() {
        
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement stmt;
            String sql;
            
            stmt = conn.createStatement();
            sql = "CREATE TABLE CASA "
                    + "("
                    + "   CASAID INTEGER PRIMARY KEY, "
                    + "   METROSCUADRADOS INTEGER, "
                    + "   HABITACIONES INTEGER, "
                    + "   DOMICILIO VARCHAR(255) "
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
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
    
    public static void insertarPropietario(Propietario p) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement stmt;
            String sql;
            
            stmt = conn.createStatement();
            sql = "INSERT INTO PROPIETARIOS VALUES( "
                    + p.getNuevoId() + ", "
                    + " \'" + p.getNombre() + "\', "
                    + " \'" + p.getApellido() + "\' "
                    + ")";
            stmt.executeUpdate(sql);
            System.out.println("Insert table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertarCasa(Casa c) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement stmt;
            String sql;
            
            stmt = conn.createStatement();
            sql = "INSERT INTO CASA VALUES( "
                    + c.getNuevoId() + ", "
                    + c.getMetrosCuadrados() + ", "
                    + c.getHabitaciones() + ", "
                    + " \'" + c.getDomicilio() + " \' "
                    + ")";
            
            stmt.executeUpdate(sql);
            System.out.println("Insert table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList selectPropietarios() {
        ArrayList<Propietario> propietarioResultado = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM PROPIETARIOS");
            while (res.next()) {
                Propietario p = new Propietario();
                p.setApellido(res.getString("APELLIDOS"));
                p.setNombre(res.getString("NOMBRE"));
                p.setNuevoId(res.getInt("PROPIETARIOID"));
                
                propietarioResultado.add(p);
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return propietarioResultado;
    }
    
    public static ArrayList selectCasas() {
        ArrayList<Casa> casasResultado = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM CASA");
            while (res.next()) {
                
                Casa c = new Casa();
                c.setDomicilio(res.getString("DOMICILIO"));
                c.setHabitaciones(res.getInt("HABITACIONES"));
                c.setMetrosCuadrados(res.getInt("METROSCUADRADOS"));
                c.setNuevoId(res.getInt("CASAID"));
                
                casasResultado.add(c);
            }
            
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return casasResultado;
    }
    
    public static int obtenerIdMaxPropietario() {
        int result = -1;
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT MAX(PROPIETARIOID) FROM PROPIETARIOS");
            result = res.getInt("PROPIETARIOID");
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result + 1;
    }
    
    public static int obtenerIdMaxCasa() {
        int result = -1;
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT MAX(CASAID) FROM CASA");
            result = res.getInt("CASAID");
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result + 1;
    }
    
    public static void eliminarCasa(int id) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("DELETE FROM CASAS WHERE CASAID = " + id);
            System.out.println(res.getString(0));
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void eliminarPropietario(int id) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("DELETE FROM PROPIETARIOS WHERE PROPIETARIOID = " + id);
            System.out.println(res.getString(0));
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void insertarPropietarioCasa(Propietario p, Casa c) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement stmt;
            String sql;
            
            stmt = conn.createStatement();
            
            sql = "INSERT INTO PROPIETARIOSCASA VALUES( "
                    + p.nuevoId + ", "
                    + c.nuevoId + " "
                    + ")";
            
            stmt.executeUpdate(sql);
            
            System.out.println("Insert table in given database...");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Inmobiliaria selectPropCasa() {
        Inmobiliaria result = new Inmobiliaria();
        
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/inmobiliariaBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM PROPIETARIOSCASA");
            
            while (res.next()) {
                Propietario p = new Propietario();
                p.setNuevoId(res.getInt("PROPIETARIOID"));
                ResultSet res2 = st.executeQuery("SELECT * FROM PROPIETARIOS WHERE PROPIETARIOID = " + p.getNuevoId());
                p.setApellido(res2.getString("APELLIDOS"));
                p.setNombre(res2.getString("NOMBRE"));
                p.setNuevoId(res2.getInt("PROPIETARIOID"));
                
                Casa c = new Casa();
                c.setNuevoId(res.getInt("CASAID"));
                ResultSet res3 = st.executeQuery("SELECT * FROM CASA WHERE CASAID = " + c.getNuevoId());
                c.setDomicilio(res3.getString("DOMICILIO"));
                c.setHabitaciones(res3.getInt("HABITACIONES"));
                c.setMetrosCuadrados(res3.getInt("METROSCUADRADOS"));
                
                p.casas.add(c);
                
                result.introducirPropietario(p);
                result.introducirCasasaProp(p.getNuevoId(), c);
            }
            
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
}
