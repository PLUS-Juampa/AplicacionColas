package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Button btnInsertar, btnExtraer, btnMostrarSize, btnBuscar, btnVaciar;

    @FXML
    TextField txtInsertar, txtBuscar;

  @FXML
    HBox c1;
    public ImageView imagen(){//Método que permite mandar la imagen a donde se requiera solo con su nombre.
        Image image = new Image("sample/persona.png");//Convertimos nuestra imagen en instancia
        ImageView img1=new ImageView();//La imagen anterior se alojara en este objeto iv1.
        img1.setFitHeight(60);//Altura de la imagen
        img1.setFitWidth(30);//Anchura de la imagen
        img1.setImage(image);//Colocamos el objeto imagén el el control ImageView
        return img1;//Retornamos el control con ImageView con la imagen
    }
    public Cola cola = new Cola();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        // Evento clic del botón btnInsertar
        this.btnInsertar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(txtInsertar.getText().equals("")){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Insertar Número");
                    alert.setHeaderText("Número no insertado");
                    alert.setContentText("Este campo no debe estar vacío");
                    alert.showAndWait();

                }else {
                    try {

                        txtInsertar.requestFocus();
                        Label label = new Label( );
                        label.prefWidth(10);
                        label.setText(txtInsertar.getText());
                        HBox hBox = new HBox(5);
                        hBox.getChildren().add(label);
                        hBox.getChildren().add(imagen());
                        c1.getChildren().add(hBox);

                        txtInsertar.setText("");
                        txtInsertar.requestFocus();

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
        this.btnExtraer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            cola.extraer(btnExtraer.getText());
                c1.getChildren().remove(0);//eliminar el primer elemento de la cola

            }
        });

    }
}
