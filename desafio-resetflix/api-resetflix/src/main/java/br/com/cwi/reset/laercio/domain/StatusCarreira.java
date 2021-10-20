package br.com.cwi.reset.laercio.domain;

public enum StatusCarreira {

    EM_ATIVIDADE("EM ATIVIDADE"),
    APOSENTADO("APOSENTADO");

    private String statusCarreira;

    StatusCarreira(String statusCarreira) {

        this.statusCarreira = statusCarreira;
    }

    public String getStatusCarreira() {

        return statusCarreira;
    }
}
