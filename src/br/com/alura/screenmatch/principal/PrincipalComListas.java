package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Conteudo;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Titanic", 1989);
        meuFilme.avalia(7);
        Filme novoFilme = new Filme("Moana", 2016);
        novoFilme.avalia(8);
        var outroFilme = new Filme("Metropolis", 1930);
        outroFilme.avalia(9);
        Serie serie = new Serie("Breaking bad", 2008 );

//        ArrayList<Conteudo> catalogo = new ArrayList<>();
        List<Conteudo> catalogo = new LinkedList<>();
        catalogo.add(outroFilme);
        catalogo.add(novoFilme);
        catalogo.add(meuFilme);
        catalogo.add(serie);

        for (Conteudo item: catalogo) {
            System.out.println(item.getTitulo());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaArtista = new ArrayList<>();
        buscaArtista.add("Fernanda Torres");
        buscaArtista.add("Julia Roberts");
        buscaArtista.add("Demi Moore");
        System.out.println(buscaArtista);

        Collections.sort(buscaArtista);
        System.out.println(buscaArtista);
        System.out.println("A-Z");
        Collections.sort(catalogo);
        System.out.println(catalogo);

        catalogo.sort(Comparator.comparing(Conteudo::getAnoDeLancamento));
        System.out.println("Ano de lançamento");
        System.out.println(catalogo);
    }
}
