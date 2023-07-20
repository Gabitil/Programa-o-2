package dominio;


import java.util.ArrayList;

public class Cardapio {
    private ArrayList<DiasDaSemana> diasDaSemana;

    //construtor

    public Cardapio() {
        this.diasDaSemana = new ArrayList<>();
    }

    //getters e setters

    public ArrayList<DiasDaSemana> getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(ArrayList<DiasDaSemana> diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }
    //métodos
    
    public void incluir(String descricao, double vCalorico, String dia, String tRefeicao) throws DupilicadeException {
        for (DiasDaSemana diasdaSemana : diasDaSemana) {
            for (Refeicao refeicao : diasdaSemana.getRefeicao()) {
                if (refeicao.getDescricao().equals(descricao)) {
                    throw new DupilicadeException("Já existe uma refeição com essa descrição!");
                }
            }
        }
        
        Refeicao refeicao2 = new Refeicao(descricao, vCalorico, tRefeicao);
        
        for (DiasDaSemana diasdaSemana : diasDaSemana) {
            if (diasdaSemana.getDiaSemana().equals(dia)) {
                diasdaSemana.getRefeicao().add(refeicao2);
                return;
            }
        }
        
        // Se o dia não existir, crie um novo DiasDaSemana
        DiasDaSemana novoDia = new DiasDaSemana(dia);
        novoDia.getRefeicao().add(refeicao2);
        diasDaSemana.add(novoDia);
    }


    public Refeicao consultar(String descricao, String dia, String tRefeicao){
        for (DiasDaSemana diasdaSemana : diasDaSemana) {
            if (diasdaSemana.getDiaSemana().equals(dia)) {
                for (Refeicao refeicao : diasdaSemana.getRefeicao()) {
                    if (refeicao.getDescricao().equals(descricao) && refeicao.gettRefeicao().equals(tRefeicao)) {
                        return refeicao;
                    }
                }
            }
        }
        return null;
    }

    public void alterar(Refeicao refeicao, String descricao, double vCalorico){
        refeicao.setDescricao(descricao);
        refeicao.setvCalorico(vCalorico);
    }

public void excluir(Refeicao refeicao) {
    for (DiasDaSemana diasdaSemana : diasDaSemana) {
        if (diasdaSemana.getRefeicao().contains(refeicao)) {
            diasdaSemana.getRefeicao().remove(refeicao);
            break;
        }
    }
}

}
