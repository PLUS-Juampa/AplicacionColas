package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Button btnInsertar, btnExtraer, btnMostrarSize, btnBuscar, btnVaciar;

    @FXML
    TextField txtInsertar, txtBuscar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Cola cola = new Cola();

        // Evento clic del botón btnInsertar
        this.btnInsertar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(txtInsertar.getText().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Insertar Número");
                    alert.setHeaderText("Insersión de Número");
                    alert.setContentText("Este campo no debe estar vacío");
                    alert.showAndWait();
                    txtInsertar.requestFocus();
                }else {
                    try {
                        cola.insertar(Integer.parseInt(txtInsertar.getText()));

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Insertar Número");
                        alert.setHeaderText("Insersión de Número");
                        alert.setContentText("Número Agregado Correctamente");
                        alert.showAndWait();

                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Insertar Número");
                        alert.setHeaderText("Insersión de Número");
                        alert.setContentText("Sólo puede ingresar números enteros");
                        alert.showAndWait();
                        txtInsertar.requestFocus();
                    }
                }
            }
        });

    }
}
