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

    @FXML   // Inicialización de botones
    Button btnInsertar, btnExtraer, btnMostrarSize, btnBuscar, btnVaciar;

    @FXML   // Inicialización de texBox's
    TextField txtInsertar, txtBuscar;

    int size = 0, aux = 0;  // Declaración de variables globales para controlar el tamaño de la Cola

  @FXML
    HBox c1;    // Inicialización de un elemento Hbox
    public ImageView imagen(){//Método que permite mandar la imagen a donde se requiera solo con su nombre.
        Image image = new Image("sample/persona.png");//Convertimos nuestra imagen en instancia
        ImageView img1=new ImageView();//La imagen anterior se alojara en este objeto iv1.
        img1.setFitHeight(60);//Altura de la imagen
        img1.setFitWidth(30);//Anchura de la imagen
        img1.setImage(image);//Colocamos el objeto imagén el el control ImageView
        return img1;//Retornamos el control con ImageView con la imagen
    }
    public Cola cola = new Cola();  // Creación de instancia de clase Cola

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Evento clic del botón btnInsertar
        this.btnInsertar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(txtInsertar.getText().equals("")){   // Condición campo txt vacío
                    Alert alert = new Alert(Alert.AlertType.WARNING);   // Mensaje de advertencia tipo alert
                    alert.setTitle("Insertar Número");
                    alert.setHeaderText("Número no insertado");
                    alert.setContentText("Este campo no debe estar vacío");
                    alert.showAndWait();
                    txtInsertar.setText("");
                    txtInsertar.requestFocus();

                }else { // Si campo txt no está vacío
                    try {
                        if(Integer.parseInt(txtInsertar.getText()) == 0 ){  // Condición para atrapar errores
                        }
                        /*Insersión de números e imagenes en la contenedor Hbox*/
                        Label label = new Label( );
                        label.prefWidth(10);
                        label.setText(txtInsertar.getText());
                        HBox hBox = new HBox(5);
                        hBox.getChildren().add(label);
                        hBox.getChildren().add(imagen());
                        c1.getChildren().add(hBox); // Agregando elemento nuevo

                        cola.setTamaño(size++); // Invocación de método para incrementar una unidad al tamaño de la cola
                        cola.insertar(Integer.parseInt(txtInsertar.getText())); // Insertamos el valor en instancia cola
                        aux++;  // Incremento en variable auxiliar

                        txtInsertar.setText("");    // Limpiar el campo del txt
                        txtInsertar.requestFocus(); // Referencia al txt

                    }catch (Exception e){   // En caso de no ser un número entero se mostrará un mensaje de error
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Insertar Número");
                        alert.setHeaderText("Insersión de Número");
                        alert.setContentText("Sólo puede ingresar números enteros");
                        alert.showAndWait();
                        txtInsertar.setText("");
                        txtInsertar.requestFocus();
                    }
                }
            }
        });
        //  Acción clic del botón exxtraer
        this.btnExtraer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    cola.extraer(btnExtraer.getText());// Extrae el número de la cola existente
                    c1.getChildren().remove(0);//eliminar el primer elemento de la cola
                    cola.setTamaño(--size); // Decremento en tamaño de la cola
                    aux--;  // Decremento de variable auxiliar
                }catch (Exception e){   // En caso de que la cola esté sin elementos mostrará un mensaje de error
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Extracción de Elementos");
                    alert.setHeaderText("Números");
                    alert.setContentText("No hay ningún número por extraer");
                    alert.showAndWait();
                }
            }
        });
        // Acción clic del botón Bucar
        this.btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(txtBuscar.getText().isEmpty()){  // Sí el campo txt Está vacío
                        Alert alert = new Alert(Alert.AlertType.WARNING);   // Mostrará mensaje de advertencia para ingresar un número
                        alert.setTitle("Búsqueda de número");
                        alert.setHeaderText("Número en Cola");
                        alert.setContentText("Debe ingresar un número");
                        alert.showAndWait();
                        txtBuscar.setText("");
                        txtBuscar.requestFocus();
                        return;
                    }else { // En caso de no estar vacío invoca a método para buscar el elemento y muestra el resultado dentro de un mensaje alert
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Búsqueda de número");
                        alert.setHeaderText("Número en Cola");
                        alert.setContentText(cola.buscar(Integer.parseInt(txtBuscar.getText())));   // Invocación del método
                        alert.showAndWait();
                        txtBuscar.setText("");
                    }
                }catch (Exception e){   // En caso de no ser un número entero se mostrará el mensaje de error
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Búsqueda de número");
                    alert.setHeaderText("Número en Cola");
                    alert.setContentText("Sólo se permiten números enteros");
                    alert.showAndWait();
                    txtBuscar.setText("");
                    txtBuscar.requestFocus();
                }
            }
        });
        //  Acción clic de Botón Mostrar Tamaño
        this.btnMostrarSize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { // Muestra el tamaño mediante la invocación del método que devuelve el tamaño dentro de un mensaje alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Tamaño de cola");
                alert.setHeaderText("Tamaño");
                alert.setContentText("El tamaño de la Cola es: " + cola.getTamaño());   // Invocación del método
                alert.showAndWait();
            }
        });
        // Acción clic del método Vaciar Cola
        this.btnVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c1.getChildren().clear();   // Remueve todos los elementos de la cola
                for(int i=0; i<aux; i++){   // Hasta que la variable auxiliar sea menor a cero
                    cola.auxiliar();    // Se invoca un método para extraer el elemento de la cola en posición cero
                    cola.setTamaño(--size); // EL tamaño decrementa tantos elementos existan en la Cola
                }
                aux = 0;    // variable se iguala en cero
            }
        });
    }
}
