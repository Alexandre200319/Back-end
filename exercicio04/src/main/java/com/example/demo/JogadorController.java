package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {
    @Autowired
    private final GeradorJogador geradorJogador;

    public JogadorController(GeradorJogador geradorJogador) {
        this.geradorJogador = geradorJogador;
        this.geradorJogador.atualizaListas(); // Atualiza as listas ao iniciar o controlador
    }

    @GetMapping("/")
    public Jogador geraJogador() {
        return geradorJogador.geraJogador(); // Gera um jogador aleatório
    }
}
