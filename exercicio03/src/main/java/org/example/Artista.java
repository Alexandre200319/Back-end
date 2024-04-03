package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Artista implements Indicavel {
    private String nomeArtista;
    private String nacionalidade;
    private Short numeroIndicacoes = 0;
    private Boolean elegivel = false;

    public Artista() {
    }

    @Autowired
    public Artista(String nomeArtista, String nacionalidade, Short numeroIndicacoes, Boolean elegivel) {
        this.nomeArtista = nomeArtista;
        this.nacionalidade = nacionalidade;
        this.numeroIndicacoes = numeroIndicacoes;
        this.elegivel = elegivel;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public Short getNumeroIndicacoes() {
        return numeroIndicacoes;
    }

    @Override
    public void setNumeroIndicacoes(Short numeroIndicacoes) {
        this.numeroIndicacoes = numeroIndicacoes;
    }

    @Override
    public Boolean isElegivel() {
        return elegivel;
    }

    @Override
    public void setElegivel(Boolean elegivel) {
        this.elegivel = elegivel;
    }

    @Override
    public String toString() {
        return "Artista: " + this.nomeArtista + " || " + "Número de indicações: " + this.numeroIndicacoes + " || ";
    }
}
