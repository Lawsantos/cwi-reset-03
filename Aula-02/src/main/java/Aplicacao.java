public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Laercio", 29, Genero.MASCULINO);

        Ator ator1 = new Ator("Thais", 31, Genero.FEMININO);

        Filme kill = null;
        try {
            kill = new Filme("Cena de terror", "Pedra",1, 2021, 500, diretor);

            kill.reproduzirFilmes();

        } catch (AvaliacaoForaDoPadrao e) {

            System.out.println(e.getMessage() + "\n");
        }

        try {
            Filme selva = new Filme("Selva perigosa", "Filme com muito terror",60, 2019,5, diretor);
            selva.reproduzirFilmes();

        } catch (AvaliacaoForaDoPadrao e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n");

        diretor.imprimiCaracteristicas();

        System.out.println("\n");

        ator1.imprimiCaracteristicas();
    }

}
