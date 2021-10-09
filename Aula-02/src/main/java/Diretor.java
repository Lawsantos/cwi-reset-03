public class Diretor extends Pessoa{

    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, Integer idade, Genero genero) {
        super(nome, idade, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

}
