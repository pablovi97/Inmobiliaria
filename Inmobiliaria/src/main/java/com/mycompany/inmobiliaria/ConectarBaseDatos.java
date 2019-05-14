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
}
