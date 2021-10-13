package br.com.cwi.reset.laercio;

public enum Mensagens {

    CAMPO_VAZIO("Campo obrigatório não informado. Favor informar o campo {campo}."),
    NOME_SOBRENOME("Deve ser informado no mínimo nome e sobrenome para o ator."),
    DATA_NASCIMENTO_MAIOR_DATA_ATUAL("Não é possível cadastrar atores não nascidos."),
    ANO_ATIVIDADE_MAIOR_ANO_NASCIMENTO("Ano de início de atividade inválido para o ator cadastrado."),
    ATOR_EXISTENTE("Já existe um ator cadastrado para o nome {nome}."),
    VALOR_INESPERADO("Valor deve ser entre os números do menu");

    private String descricao;

    Mensagens(String descricao) {
        this.descricao = descricao;
    }
}
