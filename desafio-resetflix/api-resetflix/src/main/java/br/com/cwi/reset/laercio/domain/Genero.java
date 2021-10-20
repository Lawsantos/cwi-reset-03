package br.com.cwi.reset.laercio.domain;

public enum Genero {

    ACAO("AÇÃO"),
    AVENTURA("AVENTURA"),
    COMEDIA("COMÉDIA"),
    DOCUMENTARIO("DOCUMENTÁRIO"),
    DRAMA("DRAMA"),
    ESPIONAGEM("ESPIONAGEM"),
    FICCAO_CIENTIFICA("FICÇÃO CIENTÍFICA"),
    GUERRA("GUERRA"),
    MISTERIO("MISTÉRIO"),
    MUSICAL("MUSICAL"),
    POLICIAL("POLICIAL"),
    ROMANCE("ROMANCE"),
    TERROR("TERROR");

    private String genero;

    Genero(String genero) {

        this.genero = genero;
    }

    public String getGenero() {

        return genero;
    }
}
