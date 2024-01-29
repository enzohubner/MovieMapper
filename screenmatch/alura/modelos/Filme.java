package screenmatch.alura.modelos;

import screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public int getClassicao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
