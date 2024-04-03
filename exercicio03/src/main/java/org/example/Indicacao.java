package org.example;

import org.springframework.stereotype.Component;

@Component
public class Indicacao {
    private Indicavel indicado;
    private String categoria;

    public Indicacao() {
    }

    public Indicacao(Indicavel indicado, String categoria) {
        this.indicado = indicado;
        this.categoria = categoria;
    }

    public Indicavel getIndicado() {
        return indicado;
    }

    public void setIndicado(Indicavel indicado) {
        this.indicado = indicado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return indicado.toString() + "Categoria: " + categoria + " || ";
    }
}
