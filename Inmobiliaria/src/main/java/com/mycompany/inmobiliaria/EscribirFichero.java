/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inmobiliaria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author daw
 */
public class EscribirFichero {
    /*
static Almacen leerDatos(){
    Path p = Paths.get(System.getProperty("user.home"));
    String xml = null;
    Almacen al = null;
}
*/
    public EscribirFichero(){
        
    }
    public void crearFicheroXML(String ruta , String texto) throws IOException{
     
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(texto);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(texto);
        }
        bw.close();
    }

            
    
}
