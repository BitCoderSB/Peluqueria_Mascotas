/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controladores;

import com.sun.tools.javac.Main;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        String ruta = "/Ventanas/menu.fxml";
        
        // ABRE LA PRIMERA VENTANA
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(main.class.getResource(ruta));
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
   
    }

    public static void main(String[] args) {
        launch(args);
    }

}