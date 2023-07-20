package gui_gabrielaug;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import dominio_gabrielaug.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class ConsultarPacienteController{

    private Hospital hospital = new Hospital();

    @FXML
    private Label lb_textoconsult;

    @FXML
    private Label lb_nome;

    @FXML
    private Label lb_codigo;

    @FXML
    private Label lb_idade;

    @FXML
    private Label lb_peso;

    @FXML
    private Label lb_altura;

    @FXML
    private Label lb_genero;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_codigo;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_peso;

    @FXML
    private TextField tf_altura;

    @FXML
    private Button bt_excluir;

    @FXML
    private Button bt_alterar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Button bt_consultar;

    @FXML
    private Button bt_novo;

    @FXML
    private ComboBox<String> cb_genero;

    public ConsultarPacienteController( Hospital hospital) {
        this.hospital = hospital;
    }

    public ConsultarPacienteController() {
    }

    @FXML
    private void handleExcluir(ActionEvent event) {
        // Lógica para excluir o item
        hospital.removerPaciente(tf_nome.getText());
        lb_textoconsult.setText("Paciente excluído com sucesso!");
        
    }

    @FXML
    private void handleAlterar(ActionEvent event) {
        // Lógica para alterar o item
        Paciente paciente = new Paciente();
        paciente.setNome(tf_nome.getText());
        paciente.setIdade(Integer.parseInt(tf_idade.getText()));
        paciente.setPeso(Double.parseDouble(tf_peso.getText()));
        paciente.setAltura(Double.parseDouble(tf_altura.getText()));
        paciente.setGenero(cb_genero.getValue());
        hospital.alterarPaciente(tf_nome.getText(), paciente);

        lb_textoconsult.setText("Paciente alterado com sucesso!");
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

    @FXML
    private void handleConsultar(ActionEvent event) {
        //Consultar novo paciente
        Paciente paciente;
        paciente = hospital.consultarPaciente(tf_nome.getText());
        if (paciente == null) {
            lb_textoconsult.setText("Paciente não existe!");
            return;
        } else {
            lb_textoconsult.setText("Paciente encontrado!");
        }

        //adicionar os dados nos textfield
        tf_codigo.setText(String.valueOf(paciente.getCodigo()));
        tf_idade.setText(String.valueOf(paciente.getIdade()));
        tf_peso.setText(String.valueOf(paciente.getPeso()));
        tf_altura.setText(String.valueOf(paciente.getAltura()));
        cb_genero.setValue(paciente.getGenero());

        bt_novo.setVisible(true);
        bt_consultar.setVisible(false);

    }

    @FXML
    private void handleNovo(ActionEvent event){
        bt_novo.setVisible(false);
        bt_consultar.setVisible(true);

        tf_nome.clear();
        tf_idade.clear();
        tf_peso.clear();
        tf_altura.clear();
        cb_genero.getSelectionModel().clearSelection();
        tf_codigo.clear();

        lb_textoconsult.setText("Preencha os campos acima para consultar um novo paciente.");

        bt_novo.setVisible(false);
        bt_consultar.setVisible(true);

    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    
    public void initialize() {
        ObservableList<String> generos = FXCollections.observableArrayList("Masculino", "Feminino", "Não binário");
        cb_genero.setItems(generos);

        bt_novo.setVisible(false);
        bt_consultar.setVisible(true);


    }


}
