import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        try {
            String textoNomes = retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
            String nome = retornaElementoAleatorio(textoNomes);

            String textoSobrenomes = retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
            String sobrenome = retornaElementoAleatorio(textoSobrenomes);

            String textoPosicoes = retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
            String posicao = retornaElementoAleatorio(textoPosicoes);

            String textoClubes = retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
            String clube = retornaElementoAleatorio(textoClubes);

            short idade = geraNumeroAleatorio((short) 17, (short) 50);

            System.out.println(nome + " " + sobrenome +
                    " é um futebolista brasileiro de " +
                    idade +
                    " anos que atua como " +
                    posicao +
                    ". Atualmente defende o " +
                    clube);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static String retornaTextoDoServidor(String url) throws Exception {
        // Cria um cliente HTTP com try-with-resources
        HttpClient cliente = HttpClient.newHttpClient();
        // Cria uma requisição HTTP
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        // Executa a requisição e recebe uma resposta
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        // Retorna o corpo da resposta
        return resposta.body();
    }

    public static String retornaElementoAleatorio(String texto) {
        // Divide o texto em várias strings (uma para cada elemento)
        String[] listaDeElementos = texto.split("\n");
        // Cria um número aleatório de acordo com o tamanho do vetor
        int indiceAleatorio = (int) (Math.random() * listaDeElementos.length);
        // Retorna um elemento aleatório da lista
        return listaDeElementos[indiceAleatorio];
    }

    public static short geraNumeroAleatorio(short menor, short maior) {
        // Gera um número aleatório entre menor e maior
        return (short) (Math.random() * (maior - menor) + menor);
    }
}
