import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setTitulo("Titanic");
        meuFilme.setAnoDeLancamento(1989);
        meuFilme.setDuracaoEmMinutos(190);
        System.out.println(meuFilme.getDuracaoEmMinutos());

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
        serie.setMinutosPorEpisodios(50);
        System.out.println("Duração da série: " + serie.getDuracaoEmMinutos());

        Filme novoFilme = new Filme();
        novoFilme.setTitulo("Enrolados");
        novoFilme.setAnoDeLancamento(2018);
        novoFilme.setDuracaoEmMinutos(130);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(novoFilme);
        calculadora.inclui(serie);
        System.out.println(calculadora.getTempoTotal());

    }
}
