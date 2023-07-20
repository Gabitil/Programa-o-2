/**
 * @author Gabriel Augusto de Lima Maia
 */

package gui_gabrielaug;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe que representa a janela inicial
 */

public class JanelaInicial extends Application{

    
    /** 
     * Método que inicia a aplicação
     * @param stage  Stage que representa a janela
     * @throws Exception  Exceção que pode ser lançada
     * 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("JanelaInicial.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Gerador de Apostas");
        stage.show();
    }

    /**
     * Método que executa a aplicação
     * @param args Argumentos que podem ser passados
    */
    
    public static void main(String[] args) {
        launch(args);
    }

}
