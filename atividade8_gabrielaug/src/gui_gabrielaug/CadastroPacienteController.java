package gui_gabrielaug;

import java.io.IOException;

import dominio_gabrielaug.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





public class CadastroPacienteController{
    private Hospital hospital = new Hospital();

    @FXML
    private Label lb_textocd;

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
    private Button bt_novo;

    @FXML
    private Button bt_incluir;

    @FXML
    private Button bt_relatorio;

    @FXML
    private Button bt_sair;

    @FXML
    private Button bt_consultar;

    @FXML
    private ComboBox<String> cb_genero;

    public CadastroPacienteController(Hospital hospital) {
        this.hospital = hospital;
    }

    public CadastroPacienteController(){

    }

    @FXML
    private void handleNovo(ActionEvent event) {
        bt_novo.setVisible(false);
        bt_incluir.setVisible(true);

        tf_nome.clear();
        tf_idade.clear();
        tf_peso.clear();
        tf_altura.clear();
        cb_genero.getSelectionModel().clearSelection();
        tf_codigo.setText(String.valueOf(hospital.codigoDoUltimoPaciente()+1));

        lb_textocd.setText("Preencha os campos acima para cadastrar um novo paciente e clique em Incluir.");

    }

    @FXML
    private void handleIncluir(ActionEvent event) {
        // Lógica para incluir o item
        bt_novo.setVisible(true);
        bt_incluir.setVisible(false);
    
        // Verifica se os campos estão vazios
        if (tf_nome.getText().isEmpty() || tf_idade.getText().isEmpty() || tf_peso.getText().isEmpty() || tf_altura.getText().isEmpty()) {
            // Exibe uma mensagem de erro ou faz algo apropriado
            lb_textocd.setText("Preencha todos os campos para cadastrar um novo paciente.");
            return;
        }
    
        // Verifica se o combobox foi selecionado
        if (cb_genero.getValue() == null) {
            // Exibe uma mensagem de erro ou faz algo apropriado
            lb_textocd.setText("Selecione o gênero do paciente.");
            return;
        }
    
        // Obtém os valores dos campos de texto
        String nome = tf_nome.getText();
        int idade;
        double peso, altura;
    
        try {
            idade = Integer.parseInt(tf_idade.getText());
            peso = Double.parseDouble(tf_peso.getText());
            altura = Double.parseDouble(tf_altura.getText());
        } catch (NumberFormatException e) {
            // Exibe uma mensagem de erro ou faz algo apropriado para valores inválidos
            lb_textocd.setText("Preencha os campos de idade, peso e altura com valores válidos.");
            return;
        }
    
        // Verifica se o paciente já existe no hospital (com base no nome, por exemplo)
        if (hospital.pacienteExistente(nome)) {
            // Exibe uma mensagem de erro ou faz algo apropriado
            lb_textocd.setText("Paciente já cadastrado.");
            return;
        }
    
        // Cria um novo paciente
        Paciente paciente = new Paciente();
    
        // Define os atributos do paciente
        paciente.setNome(nome);
        paciente.setIdade(idade);
        paciente.setPeso(peso);
        paciente.setAltura(altura);
        paciente.setGenero(cb_genero.getValue());
    
        // Adiciona o paciente no hospital
        hospital.adicionarPaciente(paciente);

        // Exibe uma mensagem de sucesso ou faz algo apropriado
        lb_textocd.setText("Paciente cadastrado com sucesso! Clique em Novo para cadastrar outro paciente.");

        
    }
    

    @FXML
    private void handleRelatorio(ActionEvent event) {
        try {
            // Carrega o arquivo FXML da janela de relatório
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VerRelatorio.fxml"));

            // Carrega o nó raiz da cena do arquivo FXML
            Parent root = loader.load();

            // Obtém o controlador da janela de consulta
            VerRelatorioController consultarController = loader.getController();

            // Define o hospital no controlador da janela de consulta
            consultarController.setHospital(hospital);           
    
            // Cria uma nova cena com o nó raiz
            Scene scene = new Scene(root);
    
            // Obtém o palco principal
            Stage stage = (Stage) bt_relatorio.getScene().getWindow();
    
            // Define a cena no palco e exibe a janela de relatório
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    private void handleSair(ActionEvent event) {
        // Lógica para sair do programa

        // Obtém o palco principal
        Stage stage = (Stage) bt_sair.getScene().getWindow();

        // Fecha o palco
        stage.close();
    }

    @FXML
    private void handleConsultar(ActionEvent event) {
        try{
            // Carrega o arquivo FXML da janela de consulta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultarPaciente.fxml"));

            // Carrega o nó raiz da cena do arquivo FXML
            Parent root = loader.load();

            // Obtém o controlador da janela de consulta
            ConsultarPacienteController consultarController = loader.getController();

            // Define o hospital no controlador da janela de consulta
            consultarController.setHospital(hospital);

            // Cria uma nova cena com o nó raiz
            Scene scene = new Scene(root);

            // Obtém o palco principal
            Stage stage = (Stage) bt_consultar.getScene().getWindow();

            // Define a cena no palco e exibe a janela de consulta
            stage.setScene(scene);
            stage.show();    
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void initialize() {
        ObservableList<String> generos = FXCollections.observableArrayList("Masculino", "Feminino", "Não binário");
        cb_genero.setItems(generos);

        bt_novo.setVisible(false);
        bt_incluir.setVisible(true);

        tf_codigo.setText("1");
    }


}
