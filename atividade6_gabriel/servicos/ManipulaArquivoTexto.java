package atividade6_gabriel.servicos;

import atividade6_gabriel.negocio.Contato;
import atividade6_gabriel.negocio.ContatoInexistenteException;
import atividade6_gabriel.negocio.Agenda;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class ManipulaArquivoTexto {

    private File arquivo;
    private Formatter gravador;
    public Scanner leitor;

    public ManipulaArquivoTexto() {
        this.arquivo = null;
        this.gravador = null;
        this.leitor = null;
    }




    public void abrirArquivoParaGravacao(String nomeArquivo) throws IOException {
       try { this.arquivo = new File(nomeArquivo); }
       catch (SecurityException securityException) {
           throw new IOException("Permissão negada");
       } catch (NullPointerException nullPointerException) {
           throw new IOException("Nome de arquivo inválido");
       } catch (Exception exception) {
           throw new IOException("Erro ao abrir arquivo");
       }

    }
    
    public void gravarContato(Contato contato) throws IOException {
        if (this.gravador == null) {
            this.gravador = new Formatter(arquivo);
        }
        try {
            gravador.format("%s %s %s %s\n", contato.getNome(), contato.getEndereco(), contato.getTelefone(), contato.getEmail());
        } catch (FormatterClosedException formatterClosedException) {
            throw new IOException("Erro ao gravar no arquivo");
        }
    }
    
    
    public void fecharArquivoGravacao() throws IOException{
        if (gravador != null) {
            try {gravador.close();
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Erro ao fechar arquivo");
            }
        }
    }
    

    public void abrirArquivoParaLeitura(String nomeArquivo) throws FileNotFoundException {
        try {this.arquivo = new File(nomeArquivo);
        } catch (NullPointerException nullPointerException) {
            throw new FileNotFoundException("Nome de arquivo inválido");
        } catch (Exception exception) {
            throw new FileNotFoundException("Erro ao abrir arquivo");
        }
    }
    
    public ArrayList<Contato> lerArquivo() throws FileNotFoundException {
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        this.leitor = new Scanner(arquivo);
    
        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            System.out.println(linha);
            String[] dados = linha.split(" ");
            contatos.add(new Contato(dados[0], dados[1], dados[2], dados[3]));
        }
    
        leitor.close();
        return contatos;
    }
    
    public void fecharArquivoLeitura() {
        leitor.close();
    }
    
}