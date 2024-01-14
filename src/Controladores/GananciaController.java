/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ArrayList;
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
public class GananciaController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextArea tex_area;
    @FXML
    private TextField bt_cost;

    ArrayList<Mascota> Mascotas;
    private Gestion_Mascota pet;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pet = new Gestion_Mascota();
        Mascotas = pet.getList();
        bt_cost.setText(String.valueOf(pet.gananciaDia()));

        Mascota t;
        
        for(int i = 0; i < Mascotas.size(); i++){
            t = Mascotas.get(i);
            tex_area.appendText("Nombre Mascota: " + t.getName() + "\n");
            
            tex_area.appendText("Costo: " + t.getPrecio());

            tex_area.appendText("\n------------------------------\n\n");
            
            
        }
        
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
    
}
