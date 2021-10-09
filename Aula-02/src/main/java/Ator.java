public class Ator {

    private String nome;

    private Integer idade;

    private Integer oscarvencidos;

    private Genero genero;

    public Ator(String nome, Integer idade, Integer oscarvencidos) {
        this.nome = nome;
        this.idade = idade;
        this.oscarvencidos = oscarvencidos;
    }

    public void imprimirInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero:" + genero.getDescricao());
    }
}
