/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;

import Logica.Gestion_Mascota;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carlos
 */
public class RegistroController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextField costo;
    @FXML
    private CheckBox bt_Bano;
    @FXML
    private CheckBox bt_Corte;
    @FXML
    private CheckBox bt_Manicure;
    
    private float i = 0;
    private int B = 0;
    private int C = 0;
    private int M = 0;
    private Gestion_Mascota pet;

    private int[] arrayServices = new int[3];

    @FXML
    private TextField T_raza;
    @FXML
    private TextField T_nameH;
    @FXML
    private TextField T_movilH;
    @FXML
    private Button bt_Registrar;
    @FXML
    private TextField bt_nameM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.pet = new Gestion_Mascota();
        arrayServices[0] = 0;
        arrayServices[1] = 0;
        arrayServices[2] = 0;
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
    private void C_Bano(ActionEvent event) {
        
        if(this.bt_Bano.isSelected()){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
        if(B == 0){
            this.i += 100;
            arrayServices[0] = 1;
            B = 1;
        }else{
            this.i -= 100;
            arrayServices[0] = 0;
            B = 0;
        }
        costo.setText(String.valueOf(i));
    }

    @FXML
    private void C_corte(ActionEvent event) {
        if(C == 0){
            this.i += 270;
            arrayServices[1] = 1;
            C = 1;
        }else{
            this.i -= 270;
            arrayServices[1] = 0;
            C = 0;
        }
        costo.setText(String.valueOf(i));
    }

    @FXML
    private void C_Manicure(ActionEvent event) {
        if(M == 0){
            this.i += 180;
            arrayServices[2] = 1;
            M = 1;
        }else{
            this.i -= 180;
            arrayServices[2] = 0;
            M = 0;
        }
        costo.setText(String.valueOf(i));
    }

    @FXML
    private void C_Registrar(ActionEvent event) {
        
        pet.registroMascota(bt_nameM.getText(), T_raza.getText(), arrayServices, i, T_nameH.getText(), T_movilH.getText());
        
    }
    
    
    private boolean verificaText(TextField h){
        String texto = h.getText();
        
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    
}
