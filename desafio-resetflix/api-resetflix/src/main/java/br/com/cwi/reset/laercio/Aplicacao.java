package br.com.cwi.reset.laercio;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


public class Aplicacao {

    public static void main(String[] args) throws Exception {

        try {
            FakeDatabase fakeDatabase = new FakeDatabase();

            AtorService atorService = new AtorService(fakeDatabase);

            String nome = "Will Smith";
            LocalDate dataNascimento = LocalDate.of(1979, Month.SEPTEMBER, 25);
            StatusCarreira statusCarreira = StatusCarreira.APOSENTADO;
            Integer anoInicioAtividade = 2000;

            AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

            atorService.criarAtor(atorRequest);

            List<Ator> atores = fakeDatabase.recuperaAtores();

            System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
            System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

            nome = "Laercio Beulcke";
            dataNascimento = LocalDate.of(1979, Month.SEPTEMBER, 25);
            statusCarreira = StatusCarreira.APOSENTADO;
            anoInicioAtividade = 2000;
            atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

            atorService.criarAtor(atorRequest);

            atorService.consultarAtor(1);
            atorService.consultarAtores();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}