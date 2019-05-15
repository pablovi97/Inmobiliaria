package com.mycompany.inmobiliaria;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private TextField txIdUser;
    @FXML
    private TextField txNombreUser;
    @FXML
    private TextField txApellidosUser;
    @FXML
    private Button btnAtrasUser;
    @FXML
    private Button btnCrearUser;
    @FXML
    private Button btnAdelanteUser;
    @FXML
    private Button btnEliminarUser;
    @FXML
    private Button btnModificarUser;
    @FXML
    private Button btnOkUser;
    @FXML
    private Button btnCancelarUser;
    @FXML
    private Button btnAtrasCasa;
    @FXML
    private Button btnAgregarCasa;
    @FXML
    private Button btnAdelanteCasa;
    @FXML
    private Button btnQuitarCasa;
    @FXML
    private TextField txIdCasa;
    @FXML
    private TextField txMetrosCasa;
    @FXML
    private TextField txHabitacionesCasa;
    @FXML
    private TextField txDomicilioCasa;
    @FXML
    private CheckBox chkGarajeCasa;
    @FXML
    private Button btnOkCasa;
    @FXML
    private Button btnCancelarCasa;
    @FXML
    private Button btnAtrasCasa_Casas;
    @FXML
    private Button btnAgregarCasa_Casas;
    @FXML
    private Button btnAdelanteCasa_Casas;
    @FXML
    private Button btnQuitarCasa_Casas;
    @FXML
    private TextField txMetrosCasa_Casas;
    @FXML
    private TextField txHabitacionesCasa_Casas;
    @FXML
    private TextField txDomicilioCasa_Casas;
    @FXML
    private CheckBox chkGarajeCasa_Casas;
    @FXML
    private Button btnOkCasa_Casas;
    @FXML
    private Button btnCancelarCasa_Casas;
    Inmobiliaria inmobiliaria;
    @FXML
    private Label lbl;
    @FXML
    private TextField txIdCasa_Casas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inmobiliaria = new Inmobiliaria();
        btnOkUser.setVisible(false);
        btnCancelarUser.setVisible(false);
        txApellidosUser.setDisable(true);
        txNombreUser.setDisable(true);
        btnCancelarCasa_Casas.setVisible(false);
        btnOkCasa_Casas.setVisible(false);
        txDomicilioCasa_Casas.setDisable(true);
        txHabitacionesCasa_Casas.setDisable(true);
        txMetrosCasa_Casas.setDisable(true);
        txMetrosCasa.setDisable(true);
        txHabitacionesCasa.setDisable(true);
        txDomicilioCasa.setDisable(true);
        txIdCasa.setDisable(true);
        btnCancelarCasa.setDisable(true);
        btnOkCasa.setDisable(true);
        chkGarajeCasa.setDisable(true);

    }

    @FXML
    private void atrasPropietario(MouseEvent event) {

        txApellidosUser.setDisable(true);
        txNombreUser.setDisable(true);
        btnOkUser.setVisible(false);
        btnCancelarUser.setVisible(false);
        System.out.println(inmobiliaria.propietarios.size());
        if (inmobiliaria.propietarios.size() >= 2) {

            System.out.println("hola que tal");

            Propietario p = inmobiliaria.retrocederPropietario();

            txNombreUser.setText(p.nombre);
            txApellidosUser.setText(p.apellido);
            txIdUser.setText(String.valueOf(p.getNuevoId()));

        } else {
            lbl.setText("no hay un propietario anterior!");
        }

    }

    @FXML
    private void anhadirPropietario(MouseEvent event) {
        txApellidosUser.setDisable(false);
        txNombreUser.setDisable(false);
        btnOkUser.setVisible(true);
        btnCancelarUser.setVisible(true);

        lbl.setText("Escriba los datos y pulse OK");

        txNombreUser.setText("");
        txApellidosUser.setText("");

    }

    @FXML
    private void avanzarPropietario(MouseEvent event) {
        txApellidosUser.setDisable(true);
        txNombreUser.setDisable(true);
        btnOkUser.setVisible(false);
        btnCancelarUser.setVisible(false);
        System.out.println(inmobiliaria.propietarios.size());

 

        Propietario p = inmobiliaria.avanzarPropietario();

        txNombreUser.setText(p.nombre);
        txApellidosUser.setText(p.apellido);
        txIdUser.setText(String.valueOf(p.getNuevoId()));

    }

    @FXML
    private void eliminarPropietario(MouseEvent event) {
        
        
        
    }

    @FXML
    private void crearPropietario(MouseEvent event) {
        Propietario p = new Propietario();
        p.setNombre(txNombreUser.getText());
        p.setApellido(txApellidosUser.getText());
        inmobiliaria.introducirPropietario(p);
        System.out.println(p);
        lbl.setText("");
        txNombreUser.setText("");
        txApellidosUser.setText("");
        inmobiliaria.verArrayListPropietario();
        txMetrosCasa.setDisable(false);
        txHabitacionesCasa.setDisable(false);
        txDomicilioCasa.setDisable(false);
        txIdCasa.setDisable(false);
        btnCancelarCasa.setDisable(false);
        btnOkCasa.setDisable(false);
        chkGarajeCasa.setDisable(false);
    }

    @FXML
    private void CancelarPropietario(MouseEvent event) {
        lbl.setText("");
        txNombreUser.setText("");
        txApellidosUser.setText("");
        txApellidosUser.setDisable(true);
        txNombreUser.setDisable(true);
        btnOkUser.setVisible(false);
        btnCancelarUser.setVisible(false);
    }

    @FXML
    private void anhadirCasa(MouseEvent event) {
        /*
        txMetrosCasa.setDisable(false);
        txHabitacionesCasa.setDisable(false);
        txDomicilioCasa.setDisable(false);
        txIdCasa.setDisable(false);
        btnCancelarCasa.setDisable(false);
        btnOkCasa.setDisable(false);
        chkGarajeCasa.setDisable(false);
         */

    }

    @FXML
    private void anhadirCasaPropietario(MouseEvent event) {

        Casa c = inmobiliaria.casas.get(Integer.parseInt(txIdCasa.getText()));
        txHabitacionesCasa.setText(String.valueOf(c.getHabitaciones()));
        txDomicilioCasa.setText(c.getDomicilio());
        txMetrosCasa.setText(String.valueOf(c.getMetrosCuadrados()));
        inmobiliaria.introducirCasasaProp(Integer.parseInt(txIdUser.getText()), c);
        inmobiliaria.verArrayListCasadePropietarios(Integer.parseInt(txIdUser.getText()));

    }

    @FXML
    private void cancelarCasaPropietario(MouseEvent event) {
        // txMetrosCasa.setDisable(true);
        // txHabitacionesCasa.setDisable(true);
        // txDomicilioCasa.setDisable(true);
        // txIdCasa.setDisable(true);
        //  chkGarajeCasa.setDisable(true);
        txMetrosCasa.setText("");
        txHabitacionesCasa.setText("");
        txDomicilioCasa.setText("");
        txIdCasa.setText("");
        // btnCancelarCasa.setVisible(false);
        // btnOkCasa.setVisible(false);
    }

    @FXML
    private void atrasCasa(MouseEvent event) {

        Casa c = inmobiliaria.retrocederCasa();

        txDomicilioCasa_Casas.setText(c.Domicilio);
        txHabitacionesCasa_Casas.setText(String.valueOf(c.habitaciones));
        txMetrosCasa_Casas.setText(String.valueOf(c.metrosCuadrados));
        txIdCasa_Casas.setText(String.valueOf(c.getNuevoId()));

    }

    @FXML
    private void avanzarCasa(MouseEvent event) {
        Casa c = inmobiliaria.avanzarCasa();

        txDomicilioCasa_Casas.setText(c.Domicilio);
        txHabitacionesCasa_Casas.setText(String.valueOf(c.habitaciones));
        txMetrosCasa_Casas.setText(String.valueOf(c.metrosCuadrados));
        txIdCasa_Casas.setText(String.valueOf(c.getNuevoId()));

    }

    @FXML
    private void crearCasa(MouseEvent event) {

        String domicilio = txDomicilioCasa_Casas.getText();
        int habitaciones = Integer.parseInt(txHabitacionesCasa_Casas.getText());
        double metros = Double.parseDouble(txMetrosCasa_Casas.getText());
        boolean garaje = chkGarajeCasa_Casas.isPressed();
        inmobiliaria.introducirCasa(new Casa(metros, habitaciones, garaje, domicilio));
        inmobiliaria.verArrayListCasa();
        txDomicilioCasa_Casas.setText("");
        txHabitacionesCasa_Casas.setText("");
        txMetrosCasa_Casas.setText("");

    }

    @FXML
    private void cancelarCasa(MouseEvent event) {
        txDomicilioCasa_Casas.setText("");
        txHabitacionesCasa_Casas.setText("");
        txMetrosCasa_Casas.setText("");
        txIdCasa_Casas.setText("");
        txIdCasa_Casas.setDisable(true);
        txDomicilioCasa_Casas.setDisable(true);
        txHabitacionesCasa_Casas.setDisable(true);
        txMetrosCasa_Casas.setDisable(true);
        btnCancelarCasa_Casas.setVisible(false);
        btnOkCasa_Casas.setVisible(false);

    }

    @FXML
    private void anhadirCasa_casas(MouseEvent event) {
        txDomicilioCasa_Casas.setDisable(false);
        txHabitacionesCasa_Casas.setDisable(false);
        txMetrosCasa_Casas.setDisable(false);
        btnCancelarCasa_Casas.setVisible(true);
        btnOkCasa_Casas.setVisible(true);
    }

    @FXML
    private void eliminarCasa_Casas(MouseEvent event) {
    }

}
