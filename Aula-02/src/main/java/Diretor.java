public class Diretor {

    private String nome;

    private Integer idade;

    private Integer qtdFilmesDirigidos;

    private Genero genero;

    public Diretor(String nome, Integer idade, Integer qtdFilmesDirigidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }
}
