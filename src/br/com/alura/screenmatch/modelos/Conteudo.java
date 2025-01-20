package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Conteudo implements Comparable<Conteudo> {
    private String titulo;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Conteudo(String titulo, int anoDeLancamento) {
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Conteudo(TituloOmdb meuConteudoOmdb) {
        this.titulo = meuConteudoOmdb.title();

        if (meuConteudoOmdb.year().length() > 4) {
            throw new ConversaoDeAnoException("Formato de ano inválido");
        }
        this.anoDeLancamento = Integer.valueOf(meuConteudoOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuConteudoOmdb.runtime().substring(0, 3));
    }

    public void exibeFichaTecnica() {
        System.out.println("Título do filme: " + titulo);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
        System.out.println("Tempo de duração " + duracaoEmMinutos + " minutos");
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double retornaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Conteudo outroConteudo) {
        return this.getTitulo().compareTo(outroConteudo.getTitulo());
    }

    @Override
    public String toString() {
        return "( Titulo: " + titulo +
                "\nAno de lançamento: " + anoDeLancamento +
                "\nDuração em minutos: " + duracaoEmMinutos + " )\n";
    }
}
