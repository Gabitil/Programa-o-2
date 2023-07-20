/**
 * @author Gabriel Augusto de Lima Maia
 */

package gui_gabrielaug;

import dominio_gabrielaug.*;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import servicos_gabrielaug.*;



public class JanelaInicialController {

    /**  
     * Atributos
     */

    @FXML
    private Label lb_nadisponivel;

    @FXML
    private Label lb_napostas;

    @FXML
    private TextArea ta_ngerados;

    @FXML
    private Label lb_ndisponiveis;

    @FXML
    private Button bt_mais;

    @FXML
    private Button bt_gerarNum;

    @FXML
    private Button bt_github;

    @FXML
    private Button bt_instagram;

    @FXML
    private Button bt_linkedin;

    @FXML
    private Button bt_menos;

    @FXML
    private ComboBox<String> cb_jogos;

    private Jogo jogo;

    private String conteudoArquivo;

    
    /** 
     * Evento que ocorre quando o usuário seleciona um jogo: Mega-Sena, Quina ou Lotofácil
     * @param event
     * @param jogoSelecionado
     * @param cb_jogos
     * @param lb_napostas
     * @param lb_nadisponivel
     * @param lb_ndisponiveis
     * @param jogo
     */
    @FXML
    public void handleCombobox(ActionEvent event) {
       
    String jogoSelecionado = cb_jogos.getValue();

    

        switch (jogoSelecionado) {
            case "Mega-Sena":
                jogo = new MegaSena();
                lb_napostas.setText(jogo.salvarNumerosApostados());
                break;
            case "Quina":
                jogo = new Quina();
                lb_napostas.setText(jogo.salvarNumerosApostados());
                break;
            case "Lotofácil":
                jogo = new Lotofacil();
                lb_napostas.setText(jogo.salvarNumerosApostados());
                break;
            // Adicione outros casos para outros jogos
            default:
                jogo = null; // Tratamento para caso não selecionado
        }

        if (jogo != null) {
            lb_nadisponivel.setText(jogo.salvarNumerosPossiveisAposta());
            lb_ndisponiveis.setText(jogo.salvarNumerosPossiveisDominio());
        }
    }

    
    /** 
     * Evento que ocorre quando o usuário clica em um dos botões do rodapé: Instagram, GitHub ou LinkedIn
     * @param event
     * @param botaoSelecionado
     * @param Desktop
     * @param URI
     * @param URISyntaxException
     */
    @FXML
    public void handleFooter(ActionEvent event) {

        String botaoSelecionado = ((Button) event.getSource()).getText();

        switch (botaoSelecionado) {
            case "Instagram":

                try {
                    Desktop.getDesktop().browse(new URI("https://www.instagram.com/gabriel_lm10011/"));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
                break;

            case "GitHub":

                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Gabitil"));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
                break;

            case "LinkedIn":

                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/gabriaug/"));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

    
    /**
     * Evento que ocorre quando o usuário clica em um dos botões de ação +, _ ou Gerar Números
     * @param event evento
     * @param botao botão
     * @param idBotao id do botão
     * @throws IOException
     */
    @FXML
    public void handleBotoes(ActionEvent event) throws IOException {
        if (jogo == null) {
            mostrarErro("Selecione um jogo antes de realizar essa operação.");
            return;
        }

        if (event.getSource() instanceof Button) {
            Button botao = (Button) event.getSource();
            String idBotao = botao.getId();

            switch (idBotao) {
                case "bt_mais":
                    // Aumentar a quantidade de números apostados
                    jogo.aumentarAposta();
                    lb_napostas.setText(jogo.salvarNumerosApostados());
                    break;
                case "bt_menos":
                    // Diminuir a quantidade de números apostados
                    jogo.diminuirAposta();
                    lb_napostas.setText(jogo.salvarNumerosApostados());
                    break;
                    case "bt_gerarNum":
                    // Gerar números aleatórios
                    ta_ngerados.setText(jogo.salvarNumerosGerados(jogo.gerarAposta()));
                    guardarVariaveis();
                    SalvarArquivo salvarArquivo = new SalvarArquivo("aposta.txt", conteudoArquivo);
                    salvarArquivo.salvar();  // Chamar o método salvar() para salvar o arquivo
                    break;                
                default:
                    break;
            }
        }
    }

    /**
     * Método que guarda todas as váriaveis em uma string
     * @param conteudoArquivo conteúdo do arquivo é salvo com os dados
     */

    public void guardarVariaveis() {
        conteudoArquivo = "Jogo: " + cb_jogos.getValue() + "\n" + "Números apostados: " + lb_napostas.getText() + "\n"
                + "Números disponíveis para apostar: " + lb_nadisponivel.getText() + "\n"
                + "Números disponíveis no domínio: " + lb_ndisponiveis.getText() + "\n" + "Números gerados: "
                + ta_ngerados.getText();
    }
    


    /**
     * Método que mostra uma mensagem de erro
     * @param mensagem
     * @param Alert
     */
    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    /**
     * Método que inicializa a aplicação
     */
    @FXML
    public void initialize() {
    
        ObservableList<String> jogos = FXCollections.observableArrayList("Mega-Sena", "Lotofácil", "Quina");
        cb_jogos.setItems(jogos);

    }


}
