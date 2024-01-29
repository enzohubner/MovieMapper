package screenmatch.alura.modelos;

import screenmatch.excecoes.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private int duracao;
    private boolean incluidoNoPlano;
    private int somaDasAvaliacoes;
    private int totalAvalicoes;
    private int classificacao;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracao = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    public void exibeFicha() {
        System.out.println(nome);
        System.out.println(duracao);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalAvalicoes++;
    }

    double pegaMedia() {
        return somaDasAvaliacoes / totalAvalicoes;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getTotalAvaliacoes() {
        return this.totalAvalicoes;
    }

    public int getClassicao() {
        return this.classificacao;
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }

    @Override
    public String toString() {
        return "Titulo - Nome: " + nome + "; Data de lançamento: " + anoDeLancamento + "; Duracao: " + duracao;
    }
}
