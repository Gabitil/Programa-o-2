package dominio_gabrielaug;

public class Paciente implements Comparable<Paciente>{
    private static int proximoCodigo = 1;

    private int codigo;
    private String nome;
    private double peso;
    private String genero;
    private int idade;
    private double altura;

    public Paciente(String nome, double peso, String genero, int idade, double altura) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.peso = peso;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
    }

    public Paciente(){
        this.codigo = proximoCodigo++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public String getGenero() {
        return genero;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public static void setProximoCodigo(int proximoCodigo) {
        Paciente.proximoCodigo = proximoCodigo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", genero='" + genero + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }

    @Override
    public int compareTo(Paciente outroPaciente) {
        return Integer.compare(this.idade, outroPaciente.idade);
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }

    Paciente outroPaciente = (Paciente) obj;

    return idade == outroPaciente.idade;
    }

    @Override
    public int hashCode() {
        return idade;
    }
}
