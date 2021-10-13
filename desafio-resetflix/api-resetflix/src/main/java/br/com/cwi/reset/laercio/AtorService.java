package br.com.cwi.reset.laercio;

import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {

        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest){

        Ator ator = new Ator(0,
        atorRequest.getNome(),
        atorRequest.getDataNascimento(),
        atorRequest.getStatusCarreira(),
        atorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteAtor(ator);
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) {
        return fakeDatabase.recuperaAtores();
    }

    public List<Ator> consultarAtor(Integer id) {
        return fakeDatabase.recuperaAtores();
    }

    public List<Ator> consultarAtores() {
        return fakeDatabase.recuperaAtores();
    }

    public void ImprimiInformacoes(Integer id) {
        System.out.println("Nome do ator: \nData de nascimento: \nStatus da carreira: \nAno de inicio da atividade: ");
    }

    // Demais métodos da classe
}