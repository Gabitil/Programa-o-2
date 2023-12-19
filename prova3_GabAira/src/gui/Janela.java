/*
 * Nomes: Gabriel Augusto de Lima Maia e Aira Winner 
 */

package gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class represents a JavaFX window that loads a FXML file and displays it as a scene.
 * The FXML file used is "Cardapio.fxml" and it represents the menu of a wellness clinic.
 * The window title is set to "Clinica Bem Estar".
 */
public class Janela  extends Application{   
     @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Cardapio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Clinica Bem Estar");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
