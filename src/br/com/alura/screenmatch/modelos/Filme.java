package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Conteudo implements Classificavel {

    private String diretor;

    public Filme(String titulo, int anoDeLancamento) {
        super(titulo, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) retornaMedia() / 2 ;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getTitulo() + " (" + this.getAnoDeLancamento() + ")";
    }
}

