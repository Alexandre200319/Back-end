package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OscarService {
    private List<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacao(Indicavel indicado, String categoria) {
        if (indicado.isElegivel()) {
            Short novoNumeroIndicacoes = (short) (indicado.getNumeroIndicacoes() + 1);

            boolean indicacaoJaExistente = false;
            for (Indicacao i : indicacoes) {
                if (i.getIndicado().equals(indicado)) {
                    i.getIndicado().setNumeroIndicacoes(novoNumeroIndicacoes);
                    indicacaoJaExistente = true;
                    break;
                }
            }

            if (!indicacaoJaExistente) {
                indicado.setNumeroIndicacoes(novoNumeroIndicacoes);
                Indicacao indicacao = new Indicacao(indicado, categoria);
                indicacoes.add(indicacao);
            }
        } else {
            System.out.println("Indicado não é elegível para a categoria: " + categoria);
        }
    }

    public void mostrarListaDeIndicados() {
        System.out.println("Lista de indicados:");
        for (Indicacao item : this.indicacoes) {
            System.out.println(item);
        }
    }
}
