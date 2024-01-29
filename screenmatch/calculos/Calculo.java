package screenmatch.calculos;

import screenmatch.alura.modelos.Titulo;

public class Calculo {
    private int tempoTotal;

    public void inclui(Titulo titulo) {
        tempoTotal += titulo.getDuracao();

    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}
