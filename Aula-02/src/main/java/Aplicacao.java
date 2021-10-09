public class Aplicacao {
    public static void main(String[] args) {

        Pessoa diretor = new Pessoa("Laercio", 29, Genero.MASCULINO);

        Pessoa ator1 = new Pessoa("Thais", 31, Genero.FEMININO);

        Filme kill = new Filme("Cena de terror", "Pedra",1, 2021, 500, diretor);

        Filme selva = new Filme("Selva perigosa", "Filme com muito terror",60, 2019,5, diretor);

        kill.reproduzirFilmes();

        System.out.println("\n");

        diretor.imprimiCaracteristicas();

        System.out.println("\n");

        ator1.imprimiCaracteristicas();
    }

}
