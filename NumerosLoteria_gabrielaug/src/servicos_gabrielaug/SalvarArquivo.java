package servicos_gabrielaug;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que salva uma arquivo com todos os argumentos passados
 */

public class SalvarArquivo {
    /**
     * Atributos
     */
    private String nomeArquivo;
    private String conteudoArquivo;

    /**
     * Construtor
     * @param nomeArquivo
     * @param conteudoArquivo
     * @param caminhoArquivo
     */
    public SalvarArquivo(String nomeArquivo, String conteudoArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.conteudoArquivo = conteudoArquivo;
    }


    /**
     * Salva o arquivo
     * @throws IOException
     */
    public void salvar() throws IOException {
        FileWriter escritor;
        File arquivo;
        String diretorioAtual = System.getProperty("user.dir");
        arquivo = new File(diretorioAtual + File.separator + nomeArquivo);
        escritor = new FileWriter(arquivo);
        escritor.write(conteudoArquivo);
        escritor.close();
    }
}
