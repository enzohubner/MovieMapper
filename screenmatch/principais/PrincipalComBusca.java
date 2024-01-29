package screenmatch.principais;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import screenmatch.alura.modelos.Titulo;
import screenmatch.alura.modelos.TituloOmdb;

public class PrincipalComBusca {
        public static void main(String[] args) throws IOException, InterruptedException {
                HttpClient client = HttpClient.newHttpClient();
                Scanner scan = new Scanner(System.in);

                System.out.println("Qual filme quer buscar? ");
                String buscaNomeDoFilme = scan.nextLine();
                String frase = "https://www.omdbapi.com/?t=" + buscaNomeDoFilme.replace(" ", "+") + "&apikey=3f3c4d22";
                try {
                        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(URI.create(frase))
                                        .build();
                        HttpResponse<String> response = client
                                        .send(request, HttpResponse.BodyHandlers.ofString());
                        String json = response.body();

                        Gson gson = new GsonBuilder()
                                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                        .create();
                        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                        Titulo meuTitulo = new Titulo(tituloOmdb);

                        System.out.println(meuTitulo);
                } catch (NumberFormatException e) {
                        System.out.println("Houve um erro" + e.getMessage());
                } catch (IllegalArgumentException e) {
                        System.out.println("Houve um erro" + e.getMessage());
                }

        }
}
