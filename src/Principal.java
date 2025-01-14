import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setTitulo("Titanic");
        meuFilme.setAnoDeLancamento(1989);
        meuFilme.setDuracaoEmMinutos(190);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(6);
        meuFilme.avalia(9);
        meuFilme.avalia(9);

        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.retornaMedia());

        Serie serie = new Serie();
        serie.setTitulo("A ordem");
        serie.setAnoDeLancamento(2022);
        serie.exibeFichaTecnica();
        serie.setTemporadas(2);
        serie.setEpsPorTemporada(10);


    }
}
