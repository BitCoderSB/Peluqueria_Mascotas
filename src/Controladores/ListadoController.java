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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class ListadoController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    public TextArea T_area;
    
    private Gestion_Mascota pet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pet = new Gestion_Mascota();
        ArrayList<Mascota> w = pet.getList();
        Mascota t;
        int[] d = new int[3];
        String L;
        for(int i = 0; i < w.size(); i++){
            t = w.get(i);
            T_area.appendText("Nombre Mascota: " + t.getName() + "\n");
            T_area.appendText("Raza Mascota: " + t.getBreed()+ "\n");
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
            T_area.appendText(L);
            T_area.appendText("\nCosto: " + t.getPrecio());
            T_area.appendText("\nNombre Humano: " + t.getNameHuman()+ "\n");
            T_area.appendText("Tel. Humano: " + t.getMovilHuman()+ "\n");
            T_area.appendText("--------------------------------------"+ "\n"+ "\n");
            
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
