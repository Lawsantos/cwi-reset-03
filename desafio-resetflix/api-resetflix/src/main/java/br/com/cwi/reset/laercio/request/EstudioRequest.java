package br.com.cwi.reset.laercio.request;

import br.com.cwi.reset.laercio.domain.StatusAtividade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class EstudioRequest {
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo descricao.")
    private String descricao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo dataCriacao.")
    @Past(message = "Não é possível cadastrar estudio do futuro.")
    private LocalDate dataCriacao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo statusAtividade.")
    private StatusAtividade statusAtividade;

    public EstudioRequest(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {

        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setStatusAtividade(StatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }
}
