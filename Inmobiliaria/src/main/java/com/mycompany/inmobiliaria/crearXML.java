/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inmobiliaria;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author pablo
 */
public class crearXML {

    public void crearxml(Inmobiliaria alm, String ruta) throws IOException {
        try {
            //Informamos la clase que queremos llevar a XML
            JAXBContext context = JAXBContext.newInstance(Inmobiliaria.class);
            Marshaller marshaller = context.createMarshaller();

            //queremos saltos de linea identación etc:
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //marshal() es convertir a XML El método permite salida 
            //a un tipo: File, Writer, OutputStream entre otros
            //primero vemos volcando en un OutputStream:
            //marshaller.marshal(p, System.out);
            //Volcando en un Writer. En este caso un StringWriter
            StringWriter sw = new StringWriter();
            marshaller.marshal(alm, sw);

            String textoXML = sw.toString();
            System.out.println(textoXML);
            //System.out.println("aqui ya volco en un string xml");

            //
            //   Ahora veamos la lectura y obtener un Alumno desde el XML
            //
            JAXBContext context2 = JAXBContext.newInstance(Inmobiliaria.class);
            Unmarshaller marshaller2 = context2.createUnmarshaller();

            //creamos un reader desde el Strin con el XML que obtuvimos antes
            StringReader sr = new StringReader(textoXML);

            //unmarshal recibe el equivalente de antes: File, Reader, InputStream
            //como devuelve Object hay que castear
            Inmobiliaria q = (Inmobiliaria) marshaller2.unmarshal(sr);

            System.out.println(q);
            //  String ruta = "C:\\Users\\pablo\\Desktop\\archivo.xml";

            EscribirFichero ef = new EscribirFichero();
            ef.crearFicheroXML(ruta, textoXML);

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

}
