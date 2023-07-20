package dominio_gabrielaug;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Hospital {
    private List<Paciente> pacientes;


    public Hospital(){
        this.pacientes = new ArrayList<>();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes){
        this.pacientes = pacientes;
    }

    public void adicionarPaciente(Paciente paciente){
        this.pacientes.add(paciente);
    }

    public void ordenarPacientesPorIdade(){
        this.pacientes.sort(Paciente::compareTo);
    }

    public Paciente consultarPaciente(String nome){
        for (Paciente paciente : this.pacientes) {
            if (paciente.getNome().equals(nome)){
                return paciente;
            }
        }
        return null;
    }

    public void alterarPaciente(String nome, Paciente paciente) {
        for (Paciente paciente1 : this.pacientes) {
            if (paciente1.getNome().equals(nome)) {
                paciente1.setNome(paciente.getNome());
                paciente1.setPeso(paciente.getPeso());
                paciente1.setGenero(paciente.getGenero());
                paciente1.setIdade(paciente.getIdade());
                paciente1.setAltura(paciente.getAltura());
                break; // interrompe a iteração após a modificação do paciente desejado
            }
        }
    }
    

    public void removerPaciente(String nome) {
        Iterator<Paciente> iterator = pacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getNome().equals(nome)) {
                iterator.remove();
                break; // opcional, se você quiser parar a iteração após remover o paciente
            }
        }
    }
    

    public int codigoDoUltimoPaciente(){
        if (pacientes.isEmpty()) {
            return 0;
        } else {
            return pacientes.get(pacientes.size() - 1).getCodigo();
        }
    }

    public boolean pacienteExistente(String nome){
        for (Paciente paciente : this.pacientes) {
            if (paciente.getNome().trim().equalsIgnoreCase(nome.trim())) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String str = "";
        for (Paciente paciente : this.pacientes) {
            str += paciente.toString() + "\n";
        }
        return str;
    }
    
    
}