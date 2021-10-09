public class Ator {

    private String nome;

    private Integer idade;

    private Integer oscarvencidos;

    private Genero genero;

    public Ator(String nome, Integer idade, Integer oscarvencidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.oscarvencidos = oscarvencidos;
        this.genero = genero;
    }

    public void imprimiCaracterisiticas(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero:" + genero.getDescricao());
    }
}
