package screenmatch.principais;

import java.util.ArrayList;

import screenmatch.alura.modelos.Episodio;
import screenmatch.alura.modelos.Filme;
import screenmatch.alura.modelos.Serie;
import screenmatch.calculos.Calculo;
import screenmatch.calculos.Recomendacao;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("Veloses e furiosos", 2022);
        meuFilme.exibeFicha();

        Serie serie = new Serie("Macacos muito bravos", 2022);
        serie.setTemporada(10);
        serie.setMinutosPorEpisodio(10);
        serie.setEpisodiosPorTemporada(10);

        Filme filme1 = new Filme("Meu malvado favorito", 2069);
        filme1.setDuracao(100);

        Calculo calculadora = new Calculo();
        calculadora.inclui(filme1);
        calculadora.inclui(meuFilme);
        calculadora.inclui(serie);
        System.out.println(calculadora.getTempoTotal());

        Episodio primeiro = new Episodio();
        primeiro.setNumero(1);
        primeiro.setSerie(serie);
        primeiro.setTotalVisualizacoes(300);

        Recomendacao filtro = new Recomendacao();
        filtro.filtrar(primeiro);

        ArrayList<Filme> filmes = new ArrayList<>();
        filmes.add(filme1);
        System.out.println(filmes.get(0).toString());

    }
}