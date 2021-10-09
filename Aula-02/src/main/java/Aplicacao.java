public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Jackal", 50, 50, Genero.MASCULINO);

        Ator ator = new Ator("Thais", 25,4,Genero.FEMININO);

        Filme filme = new Filme("filme de terror", "Pedra",1, 2021, 500, diretor);

        Filme selva = new Filme("Selva perigosa", "Filme com muito terror",60, 2019,5, diretor);

        selva.reproduzirFilmes();

        diretor.imprimiCaracteristicas();

        ator.imprimiCaracterisiticas();
    }

}
