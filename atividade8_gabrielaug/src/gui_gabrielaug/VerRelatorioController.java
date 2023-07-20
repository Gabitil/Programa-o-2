package gui_gabrielaug;

import dominio_gabrielaug.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VerRelatorioController {
    private Hospital hospital = new Hospital();

    @FXML
    private Label lb_texto;

    @FXML
    private TextArea ta_relatorio;

    @FXML
    private Button bt_voltar;

    @FXML
    private Button bt_grrelatorio;

    
    public VerRelatorioController( Hospital hospital) {
        this.hospital = hospital;
    }

    public VerRelatorioController() {
    }
    
    @FXML
    private void handleGrRelatorio(ActionEvent event){
        Relatorio relatorio;
        relatorio = new Relatorio(this.hospital);
        relatorio.quantidadePacientes();
        relatorio.calcularMediaIdadeHomens();
        relatorio.calcularQtdEspc1();
        relatorio.calcularQtdEspc2();
        relatorio.nomePacienteMaisVelho();
        relatorio.nomeMulherMaisBaixa();
        if (relatorio.quantidadePacientes() != 0) {
            ta_relatorio.setText(relatorio.toString());
            
        } else {
            ta_relatorio.setText("Não há pacientes cadastrados");
        }
    }

    @FXML
    private void handleVoltar(ActionEvent event) {
        // Lógica para voltar para a janela cadastrar paciente
        try{
             // Carrega o arquivo FXML da janela de cadasto
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastroPaciente.fxml"));       

            // Carrega o nó raiz da cena do arquivo FXML
            Parent root = loader.load();

            // Obtém o controlador da janela de consulta
            CadastroPacienteController consultarController = loader.getController();

            // Define o hospital no controlador da janela de consulta
            consultarController.setHospital(hospital);                    

            // Cria uma nova cena com o nó raiz
            Scene scene = new Scene(root);

            // Obtém o palco principal
            Stage stage = (Stage) bt_voltar.getScene().getWindow();

            // Define a cena no palco e exibe a janela
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }




}
