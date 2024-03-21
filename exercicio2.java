import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JogadorGerador {
    private String textoNomes;
    private String textoSobrenomes;
    private String textoPosicoes;
    private String textoClubes;

    public JogadorGerador() {
        try {
            this.textoNomes = retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
            this.textoSobrenomes = retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
            this.textoPosicoes = retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
            this.textoClubes = retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
        } catch (Exception e) {
            System.err.println("Erro ao inicializar o gerador de jogadores: " + e.getMessage());
        }
    }

    public Jogador criarJogador() {
        String nome = retornaElementoAleatorio(textoNomes);
        String sobrenome = retornaElementoAleatorio(textoSobrenomes);
        String posicao = retornaElementoAleatorio(textoPosicoes);
        String clube = retornaElementoAleatorio(textoClubes);
        short idade = geraNumeroAleatorio((short) 17, (short) 40);
        return new Jogador(nome, sobrenome, posicao, clube, idade);
    }

    private String retornaTextoDoServidor(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        return resposta.body();
    }

    private String retornaElementoAleatorio(String texto) {
        String[] listaDeElementos = texto.split("\n");
        int indiceAleatorio = (int) (Math.random() * listaDeElementos.length);
        return listaDeElementos[indiceAleatorio];
    }

    private short geraNumeroAleatorio(short menor, short maior) {
        return (short) (Math.random() * (maior - menor) + menor);
    }
}

public class Jogador {
    private String nome;
    private String sobrenome;
    private String posicao;
    private String clube;
    private short idade;

    public Jogador(String nome, String sobrenome, String posicao, String clube, short idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.clube = clube;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getClube() {
        return clube;
    }

    public short getIdade() {
        return idade;
    }

    public String getDescricao() {
        return nome + " " + sobrenome +
                " é um futebolista brasileiro de " +
                idade +
                " anos que atua como " +
                posicao +
                ". Atualmente defende o " +
                clube;
    }
}

public class Main {
    public static void main(String[] args) {
        JogadorGerador gerador = new JogadorGerador();
        Jogador jogador1 = gerador.criarJogador();
        Jogador jogador2 = gerador.criarJogador();

        System.out.println(jogador1.getDescricao());
        System.out.println(jogador2.getDescricao());
    }
}
