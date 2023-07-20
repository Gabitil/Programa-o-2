package dominio;

public class Peca {
    private String valorFace;
    private String valorCostas;
    private String valorVisual;
    private int virada; // se 0 igual costas, se 1 igual face

    public Peca(String valorFace) {
        this.valorFace = valorFace;
        this.valorCostas = "?";
        this.valorVisual = valorCostas;
    }

    public String getValorFace() {
        return valorFace;
    }

    public void setValorFace(String valorFace) {
        this.valorFace = valorFace;
    }

    public String getValorCostas() {
        return valorCostas;
    }

    public void setValorCostas(String valorCostas) {
        this.valorCostas = valorCostas;
    }

    public String getValorVisual() {
        return valorVisual;
    }

    public int getVirada() {
        return virada;
    }

    public void virar() {
        this.virada = (this.virada == 0) ? 1 : 0;
        this.valorVisual = (this.virada == 0) ? this.valorCostas : this.valorFace;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Peca peca = (Peca) obj;
        return valorVisual.equals(peca.valorVisual);
    }

    @Override
    public int hashCode() {
        return valorVisual.hashCode();
    }

    @Override
    public String toString() {
        return valorVisual;
    }
}
