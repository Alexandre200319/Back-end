package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    public Artista artistaBean(){
        return new Artista("John Doe", "Americano", (short) 0, false);
    }

    @Bean
    public Filme filmeBean(){
        return new Filme("Stars Wars", "Ficção", (short) 0, false);
    }

    @Bean
    public OscarService oscarService() {
        return new OscarService();
    }
}
