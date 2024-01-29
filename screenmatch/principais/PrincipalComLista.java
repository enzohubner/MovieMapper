package screenmatch.principais;

import java.util.ArrayList;
import java.util.Collections;

import screenmatch.alura.modelos.Filme;
import screenmatch.alura.modelos.Serie;
import screenmatch.alura.modelos.Titulo;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme favorito = new Filme("The Matrix", 1999);
        favorito.avalia(8);

        Filme outro = new Filme("John Wick", 2014);
        outro.avalia(9);

        Serie serie = new Serie("La Casa de Papel", 2017);

        ArrayList<Titulo> titulos = new ArrayList<>();
        titulos.add(serie);
        titulos.add(favorito);
        titulos.add(outro);

        for (Titulo item : titulos) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme) {
                System.out.println(item.getClassicao());
            }
        }

        Collections.sort(titulos);
        System.out.println(titulos);
    }
}
