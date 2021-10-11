import java.time.LocalDate;

public abstract class Pessoa {

    private String nome;

    private LocalDate dataNascimento;

    private Genero genero;

    public Pessoa(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void imprimiCaracteristicas(){
        System.out.println("Nome: " + nome );
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Genero: " + genero.getDescricao());

    }

    public String getNome() {

        return nome;
    }
}
