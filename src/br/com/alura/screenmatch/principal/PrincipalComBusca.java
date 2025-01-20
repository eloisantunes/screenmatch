package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Conteudo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Conteudo> conteudos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Busque seu filme: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=a6550bb9";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                TituloOmdb meuConteudoOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuConteudoOmdb);

//        try {
                Conteudo meuConteudo = new Conteudo(meuConteudoOmdb);
                System.out.println("Titulo formatado");
                System.out.println(meuConteudo);

//                FileWriter escrita = new FileWriter("filmes.txt");
//                escrita.write(meuConteudo.toString());
//                escrita.close();

                conteudos.add(meuConteudo);

            } catch (NumberFormatException e) {
                System.out.println("Opss, algo deu errado: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Consulta inválida");
            } catch (ConversaoDeAnoException e) {
                System.out.println(e.getMensagem());
            }
        }

        System.out.println(conteudos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(conteudos));
        escrita.close();
        System.out.println("OK");
    }
}
