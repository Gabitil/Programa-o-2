package atividade6_gabriel.negocio;

public class Contato {
    public String nome;
    public String telefone;
    public String email;
    public String endereco;
    private boolean excluido;

    public Contato(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Contato() {
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
    }

    public void setTelefone(String telefone) {
        if (telefone.length() > 0) {
            this.telefone = telefone;
        }
    }

    public void setEmail(String email) {
        if (email.length() > 0) {
            this.email = email;
        }
    }

    public void setEndereco(String endereco) {
        if (endereco.length() > 0) {
            this.endereco = endereco;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nEndereço: " + this.endereco + "\nTelefone: " + this.telefone + "\nEmail: " + this.email;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public boolean isExcluido() {
        return this.excluido;
    }
}
