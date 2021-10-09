public class Filme {

    private String nome;

    private String descricao;

    private Integer duracao;

    private Integer anoDeLancamento;

    private Integer avaliacao;

    private Pessoa pessoa;


    public Filme(String nome, String descricao, Integer duracao, Integer anoDeLancamento, Integer avaliacao, Pessoa pessoa) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = avaliacao;
        this.pessoa = pessoa;
    }
    public void reproduzirFilmes(){
        System.out.println("Nome do filme: " + nome + "\nDescrição: " + descricao + " \nDuração do filme: " + duracao + "\nNome do diretor: " + pessoa.getNome());
    }

}
