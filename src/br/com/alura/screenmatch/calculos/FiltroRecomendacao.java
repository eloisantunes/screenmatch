package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel) {

        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Queridinho do público");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Recebeu boas avaliações");
        } else {
            System.out.println("Adicione na lista para assistir depois");
        }
    }
}
