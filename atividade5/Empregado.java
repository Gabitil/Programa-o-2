package atividade5;

public abstract class Empregado implements Passivo {
    protected String nome;
    protected String sobrenome;
    protected int numIdent;

    protected Empregado(String nome, String sobrenome, int numIdent) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numIdent = numIdent;
    }
}
