/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;

import Datos.Mascota;
import Logica.Gestion_Mascota;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class BuscarController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextField nameMascota;
    @FXML
    private Button btnBuscar;
    @FXML
    public TextArea tex_inf;

    private Gestion_Mascota pet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pet = new Gestion_Mascota();
    }    

    @FXML
    private void click(ActionEvent event) {
        try {
            // Obtener el Stage actual
            Stage stageActual = (Stage) btn.getScene().getWindow();

            // Cargar la nueva ventana desde un archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/menu.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena y establecerla en el escenario
            Scene scene = new Scene(root);
            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(scene);

            // Mostrar la nueva ventana
            nuevaVentana.show();

            // Cerrar la ventana actual
            stageActual.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir al cargar la nueva ventana
        }
    }

    @FXML
    private void C_Buscar(ActionEvent event) {
        tex_inf.setText("");
        Mascota t;
        int[] d = new int[3];
        String L;
        Mascota M = pet.buscarMascota(nameMascota.getText());
        if(M == null){
            tex_inf.setText("No se encontro Mascota.");
        }else{
            t = M;
            tex_inf.appendText("Nombre Mascota: " + t.getName() + "\n");
            tex_inf.appendText("Raza Mascota: " + t.getBreed()+ "\n");
            d = t.getService();
            L = "Services: ";
            if(d[0] == 1){
                L = L + "Bano, ";
            }
            if(d[1] == 1){
                L = L + "Corte, ";
            }
            if(d[2] == 1){
                L = L + "Manicure";
            }
            tex_inf.appendText(L);
            tex_inf.appendText("\nCosto: " + t.getPrecio());
            tex_inf.appendText("\nNombre Humano: " + t.getNameHuman()+ "\n");
            tex_inf.appendText("Tel. Humano: " + t.getMovilHuman()+ "\n");
        }

    }
    
}
