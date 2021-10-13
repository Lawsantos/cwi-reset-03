package br.com.cwi.reset.laercio;

public class MensagensDeErro extends Exception{

    public MensagensDeErro(Mensagens mensagens ) {
        super(String.valueOf(Mensagens.values()));
    }

}
