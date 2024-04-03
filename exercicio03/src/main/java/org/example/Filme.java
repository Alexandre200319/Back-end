package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Filme implements Indicavel {
    private String nomeFilme;
    private String genero;
    private Short numeroIndicacoes = 0;
    private Boolean elegivel = false;

    public Filme() {
    }

    @Autowired
    public Filme(String nomeFilme, String genero, Short numeroIndicacoes, Boolean elegivel) {
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.numeroIndicacoes = numeroIndicacoes;
        this.elegivel = elegivel;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
        return "Filme: " + this.nomeFilme + " || " + "Número de indicações: " + this.numeroIndicacoes + " || ";
    }
}
