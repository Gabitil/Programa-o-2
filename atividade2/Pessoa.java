package atividade2;

public class Pessoa {

    private String nome;
    private String contato;

    public Pessoa() {
        this.nome = "";
        this.contato = "";
    }

    public Pessoa(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public boolean equals(Pessoa pessoa) {
        if (this.nome.equals(pessoa.getNome()) && this.contato.equals(pessoa.getContato())) {
            return true;
        }
        return false;
    }

    
}
