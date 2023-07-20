package atividade6_gabriel.negocio;

import java.util.HashMap;

import javax.lang.model.util.ElementScanner14;

import java.io.FileNotFoundException;
import java.io.IOException;

import atividade6_gabriel.negocio.ContatoInexistenteException;
import atividade6_gabriel.servicos.ManipulaArquivoTexto;


public class Agenda {
    private HashMap <String, Contato> contatos;
    ManipulaArquivoTexto manipulaArquivoTexto = new ManipulaArquivoTexto();

    public Agenda() {
        this.contatos = new HashMap<>();
    }

    public void incluirContato (Contato contato) throws ContatoJaExisteException{
        if (this.contatos.containsKey(contato.getNome())){
            String mensagemErro = "Contato " + contato.getNome() + " ja existe";
            throw new ContatoJaExisteException(mensagemErro);
        } else {
            this.contatos.put(contato.getNome(), contato);
        }
    }

    public boolean existeContato (String nome) throws ContatoInexistenteException{
        if (this.contatos.containsKey(nome)){
            return true;
        } else {
            String mensagemErro = "Contato " + nome + " nao existe";
            throw new ContatoInexistenteException(mensagemErro);
        }

    }

    public Contato consultarContato (String nome){
        return this.contatos.get(nome);
    }

public void removerContato(String nome) throws ContatoInexistenteException {
    Contato contato = this.contatos.get(nome);
    if (contato != null) {
        contato.setExcluido(true);
    } else {
        String mensagemErro = "Contato " + nome + " nao existe";
        throw new ContatoInexistenteException(mensagemErro);
    }
}


public void persistirAgenda(String nomeArquivo) {
    try {
        manipulaArquivoTexto.abrirArquivoParaGravacao(nomeArquivo);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    for (Contato contato : this.contatos.values()) {
        if (!contato.isExcluido()) {
            try {
                manipulaArquivoTexto.gravarContato(contato);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    try {
        manipulaArquivoTexto.fecharArquivoGravacao();
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}

    
    public void lerAgenda(String nomeArquivo) {
        try {
            manipulaArquivoTexto.abrirArquivoParaLeitura(nomeArquivo);
            manipulaArquivoTexto.lerArquivo();
            manipulaArquivoTexto.fecharArquivoLeitura();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    

}    