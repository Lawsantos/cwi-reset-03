package br.com.cwi.reset.laercio;

import java.time.LocalDate;

public class AtorEmAtividade{

    private Integer id = 0;
    private String nome;
    private LocalDate dataNascimento;

    public AtorEmAtividade(Integer id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }
}
