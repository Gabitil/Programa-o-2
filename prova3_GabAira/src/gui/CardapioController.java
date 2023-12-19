package gui;

import dominio.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * This class is the controller for the Cardapio.fxml file, which is responsible for managing the menu items.
 * It initializes the GUI components and handles the button events for including, consulting, altering, and removing menu items.
 * The class also uses the Cardapio class to perform the necessary operations on the menu items.
 */
public class CardapioController {
    private Cardapio cardapio = new Cardapio();
    private ToggleGroup grupoBotoes = new ToggleGroup();

    @FXML
    private Label lbAvisos;

    @FXML
    private TextField tfVCalorico;

    @FXML
    private Button btIncluir;

    @FXML
    private Button btConsultar;

    @FXML
    private RadioButton rbJantar;

    @FXML
    private RadioButton rbCeia;

    @FXML
    private ComboBox<String> cbDSemana;

    @FXML
    private TextField tfDescricao;

    @FXML
    private RadioButton rbAlmoco;

    @FXML
    private Button btLimpar;

    @FXML
    private RadioButton rbLancheT;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btRemover;

    @FXML
    private RadioButton rbLancheM;

    @FXML
    private RadioButton rbCafeM;

    @FXML
    void handleBotões(ActionEvent event) {
        String botao = ((Button)event.getSource()).getText();
        switch(botao){
            case "Incluir":
                try {
                    RadioButton selectedRadioButton = (RadioButton) grupoBotoes.getSelectedToggle();
                    String temporario = selectedRadioButton.getText();

                    cardapio.incluir(tfDescricao.getText(), Double.parseDouble(tfVCalorico.getText()), cbDSemana.getValue(), temporario);
                    lbAvisos.setText("Incluído com sucesso!");
                    
                } catch (DupilicadeException e) {
                    lbAvisos.setText(e.getMessage());
                }
                break;
            case "Consultar":

                Refeicao rConsulta1 = cardapio.consultar(tfDescricao.getText(), cbDSemana.getValue(), ((RadioButton) grupoBotoes.getSelectedToggle()).getText());
                if (rConsulta1 != null){
                    tfVCalorico.setText(String.valueOf(rConsulta1.getvCalorico()));
                    lbAvisos.setText("Consultado com sucesso!");
                } else {
                    lbAvisos.setText("Refeição não encontrada!");
                }

                break;
            case "Alterar":
                Refeicao rConsulta2 = cardapio.consultar(tfDescricao.getText(), cbDSemana.getValue(), ((RadioButton) grupoBotoes.getSelectedToggle()).getText());
                if (rConsulta2 != null) {
                    cardapio.alterar(rConsulta2, tfDescricao.getText(), Double.parseDouble(tfVCalorico.getText()));
                    lbAvisos.setText("Alterado com sucesso!");
                }
                break;
            case "Remover":
                Refeicao rConsulta3 = cardapio.consultar(tfDescricao.getText(), cbDSemana.getValue(), ((RadioButton) grupoBotoes.getSelectedToggle()).getText());
                if (rConsulta3 != null) {
                    cardapio.excluir(rConsulta3);
                    lbAvisos.setText("Removido com sucesso!");
                }
                break;
            case "Limpar":
                tfDescricao.setText("");
                tfVCalorico.setText("");
                lbAvisos.setText("Janela limpa!");
                break;

        }
       

    }


    @FXML
    public void initialize(){
        cbDSemana.getItems().addAll("Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo");

       
        rbAlmoco.setToggleGroup(grupoBotoes);
        rbJantar.setToggleGroup(grupoBotoes);
        rbCeia.setToggleGroup(grupoBotoes);
        rbCafeM.setToggleGroup(grupoBotoes);
        rbLancheM.setToggleGroup(grupoBotoes);
        rbLancheT.setToggleGroup(grupoBotoes);

    }
}
