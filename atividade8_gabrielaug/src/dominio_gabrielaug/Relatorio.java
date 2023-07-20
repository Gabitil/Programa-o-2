package dominio_gabrielaug;


public class Relatorio {
    private Hospital hospital;
    private int qtdPacientes;
    private double mediaIdadeHomens;
    private int qtdEspc1;
    private int qtdEspc2;
    private String nomePacienteMaisVelho;
    private String nomeMulherMaisBaixa;
    
    
    public Relatorio(){
        this.hospital = new Hospital();
        this.qtdPacientes = 0;
        this.mediaIdadeHomens = 0;
        this.qtdEspc1 = 0;
        this.qtdEspc2 = 0;
        this.nomePacienteMaisVelho = "";
        this.nomeMulherMaisBaixa = "";
    }

    public Relatorio(Hospital hospital){
        this.hospital = hospital;
        this.qtdPacientes = 0;
        this.mediaIdadeHomens = 0;
        this.qtdEspc1 = 0;
        this.qtdEspc2 = 0;
        this.nomePacienteMaisVelho = "";
        this.nomeMulherMaisBaixa = "";
    }


    public int quantidadePacientes(){
        this.qtdPacientes = this.hospital.getPacientes().size();
        return this.qtdPacientes;
    }

    public double calcularMediaIdadeHomens(){
        int qtdHomens = 0;
        double somaIdadeHomens = 0;
        for (Paciente paciente : this.hospital.getPacientes()) {
            if (paciente.getGenero().equals("Masculino")) {
                qtdHomens++;
                somaIdadeHomens += paciente.getIdade();
            }
        }
        if (qtdHomens > 0){
            this.mediaIdadeHomens = somaIdadeHomens / qtdHomens;
        } else {
            this.mediaIdadeHomens = 0;
        }
        return this.mediaIdadeHomens;
    }

    public int calcularQtdEspc1(){
        // F, peso > 70, altura entre 1.60 e 1.70
        for (Paciente paciente : this.hospital.getPacientes()) {
            if (paciente.getGenero().equals("Feminino") && paciente.getPeso() > 70 && paciente.getAltura() > 1.60 && paciente.getAltura() < 1.70){
                this.qtdEspc1++;
            }
        }
        return this.qtdEspc1;
    }

    public int calcularQtdEspc2(){
        // quantidade de pessoas com a idade entre 18 e 25
        for (Paciente paciente : this.hospital.getPacientes()) {
            if (paciente.getIdade() >= 18 && paciente.getIdade() <= 25){
                this.qtdEspc2++;
            }
        }
        return this.qtdEspc2;
        
    }

    public String nomePacienteMaisVelho(){
        int idadeMaisVelho = 0;
        for (Paciente paciente : this.hospital.getPacientes()) {
            if (paciente.getIdade() > idadeMaisVelho){
                idadeMaisVelho = paciente.getIdade();
                this.nomePacienteMaisVelho = paciente.getNome();
            }
        }
        return this.nomePacienteMaisVelho;
    }

    public String nomeMulherMaisBaixa(){
        double alturaMaisBaixa = 3;
        for (Paciente paciente : this.hospital.getPacientes()) {
            if (paciente.getGenero().equals("Feminino") && paciente.getAltura() < alturaMaisBaixa){
                alturaMaisBaixa = paciente.getAltura();
                this.nomeMulherMaisBaixa = paciente.getNome();
            }
        }
        return this.nomeMulherMaisBaixa;
    }

    @Override
    public String toString() {
        return " Quantidade de Pacientes:" + qtdPacientes +
                "\n Média da Idade dos Homens:" + mediaIdadeHomens +
                "\n Quantidade de Mulheres com mais de 70kg e entre 1.60m e 1.70m:" + qtdEspc1 +
                "\n Quantidade de possoas entre 18 e 25 anos:" + qtdEspc2 +
                "\n Nome do paciente mais velho:" + nomePacienteMaisVelho +
                "\n Nome da mulher mais baixa:" + nomeMulherMaisBaixa;
    }
}
