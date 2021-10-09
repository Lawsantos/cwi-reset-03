public class Filme {

    private String nome;

    private String descricao;

    private Integer duracao;

    private Integer anoDeLancamento;

    private Integer avaliacao;

    private Diretor diretor;


    public Filme(String nome, String descricao, Integer duracao, Integer anoDeLancamento, Integer avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }
    public void reproduzirFilmes(){
        System.out.println("Nome: " + nome + ": Descrição: " + descricao + ": Duração do filme: " + duracao + ": Nome do diretor: " + diretor.getNome());
    }

}
