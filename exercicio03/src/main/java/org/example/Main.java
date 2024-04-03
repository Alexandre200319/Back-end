package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Artista artista1 = context.getBean(Artista.class);
        artista1.setNomeArtista("João");
        artista1.setNacionalidade("Brasileiro");
        artista1.setNumeroIndicacoes((short) 0);
        artista1.setElegivel(true);

        Filme filme1 = context.getBean(Filme.class);
        filme1.setNomeFilme("Velozes e Furiosos");
        filme1.setGenero("ação");
        filme1.setNumeroIndicacoes((short) 0);
        filme1.setElegivel(true);

        OscarService oscarService = context.getBean(OscarService.class);
        oscarService.adicionarIndicacao(artista1, "Artista");
        oscarService.adicionarIndicacao(artista1, "Artista");

        oscarService.adicionarIndicacao(filme1, "Filme");
        oscarService.adicionarIndicacao(filme1, "Filme");
        oscarService.adicionarIndicacao(filme1, "Filme");
        oscarService.mostrarListaDeIndicados();

        context.close();
    }
}
