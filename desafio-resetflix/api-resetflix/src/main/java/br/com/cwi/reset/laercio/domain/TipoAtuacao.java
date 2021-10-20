package br.com.cwi.reset.laercio.domain;

public enum TipoAtuacao {

    PRINCIPAL("PRINCIPAL"),
    COADJUVANTE("COADJUVANTE");

    private String tipoAtuacao;

    TipoAtuacao(String tipoAtuacao) {

        this.tipoAtuacao = tipoAtuacao;
    }

    public String getTipoAtuacao() {

        return tipoAtuacao;
    }
}
