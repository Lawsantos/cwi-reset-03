package br.com.cwi.reset.laercio.domain;

public enum StatusAtividade {

    EM_ATIVIDADE("EM ATIVIDADE"),
    ENCERRADO("ENCERRADO");

    private String statusAtividade;

    StatusAtividade(String statusAtividade) {

        this.statusAtividade = statusAtividade;
    }

    public String getStatusAtividade() {

        return statusAtividade;
    }
}
