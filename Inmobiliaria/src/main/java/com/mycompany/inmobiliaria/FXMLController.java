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
    private TextField btnIdCasa_Casas;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inmobiliaria = new Inmobiliaria();
        btnOkUser.setVisible(false);
        btnCancelarUser.setVisible(false);
        txApellidosUser.setDisable(true);
        txNombreUser.setDisable(true);
    }

    @FXML
    private void atrasPropietario(MouseEvent event) {

        txApellidosUser.setDisable(true);
        txNombreUser.setDisable(true);
        btnOkUser.setVisible(false);
        btnCancelarUser.setVisible(false);
        System.out.println(inmobiliaria.propietarios.size());
        if (inmobiliaria.propietarios.size() >= 2) {
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
        inmobiliaria.avanzarPropietario();
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

        txNombreUser.setText("");
        txApellidosUser.setText("");
        inmobiliaria.verArrayListPropietario();
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
    private void anhadirCasaPropietario(MouseEvent event) {
    }

    @FXML
    private void cancelarCasaPropietario(MouseEvent event) {
    }

    @FXML
    private void atrasCasa(MouseEvent event) {
    }

    @FXML
    private void avanzarCasa(MouseEvent event) {
    }

    @FXML
    private void crearCasa(MouseEvent event) {
    }

    @FXML
    private void cancelarCasa(MouseEvent event) {
    }

}
