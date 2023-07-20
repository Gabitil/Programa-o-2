/*
 * Nomes: Gabriel Augusto de Lima Maia e Aira Winner 
 */

package gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
