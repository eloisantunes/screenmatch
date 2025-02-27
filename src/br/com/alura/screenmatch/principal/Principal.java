package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("Titanic", 1989);
//        meuFilme.setTitulo("Titanic");
//        meuFilme.setAnoDeLancamento(1989);
        meuFilme.setDuracaoEmMinutos(190);
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.setDiretor("James Cameron");

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(6);
        meuFilme.avalia(10);
        meuFilme.avalia(5);
        meuFilme.avalia(7);

        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.retornaMedia());

        Serie serie = new Serie("Breaking bad", 2008 );
//        serie.setTitulo("Breaking bad");
//        serie.setAnoDeLancamento(2008);
        serie.exibeFichaTecnica();
        serie.setTemporadas(5);
        serie.setEpsPorTemporada(10);
        serie.setMinutosPorEpisodios(50);
        System.out.println("Duração da série: " + serie.getDuracaoEmMinutos());

        Filme novoFilme = new Filme("Moana", 2016);
//        novoFilme.setTitulo("Moana");
//        novoFilme.setAnoDeLancamento(2016);
        novoFilme.setDuracaoEmMinutos(130);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(novoFilme);
        calculadora.inclui(serie);
        System.out.println("Tempo total: " + calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(2);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(200);
        filtro.filtra(episodio);

        var outroFilme = new Filme("Metropolis", 1930);
//        outroFilme.setTitulo("Metropolis");
//        outroFilme.setAnoDeLancamento(1930);

        outroFilme.setDuracaoEmMinutos(110);
        outroFilme.avalia(9);

        ArrayList<Filme> listaFilmes = new ArrayList<>();
        listaFilmes.add(outroFilme);
        listaFilmes.add(novoFilme);
        listaFilmes.add(meuFilme);

        System.out.println("Essa lista contém " + listaFilmes.size() + " filmes");
        System.out.println("Primeiro filme: " + listaFilmes.get(0).getTitulo());
        System.out.println(listaFilmes.get(0).toString());
        System.out.println(listaFilmes);



    }
}
