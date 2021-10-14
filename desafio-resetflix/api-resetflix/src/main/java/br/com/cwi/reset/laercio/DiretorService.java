package br.com.cwi.reset.laercio;

import java.time.LocalDate;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {

        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {
        if (diretorRequest.getNome().equals(null) || diretorRequest.getNome().equals("")){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo nome.");
        }

        if(diretorRequest.getNome().split(" ").length == 1){
            throw new NomeESobrenomeException("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        }

        for (int i = 0; i < fakeDatabase.recuperaDiretores().size(); i++){
            if(fakeDatabase.recuperaDiretores().get(i).getNome().equals(diretorRequest.getNome())){
                throw new NomeIgualException("Já existe um diretor cadastrado para o nome " + diretorRequest.getNome()+".");
            }
        }

        if (diretorRequest.getDataNascimento().equals(null) || diretorRequest.getDataNascimento().equals("")){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar a data de nascimento.");
        }

        if (diretorRequest.getDataNascimento().isAfter(LocalDate.now())){
            throw new DataNascimentoException("Não é possível cadastrar diretores não nascidos.");
        }

        if(diretorRequest.getAnoInicioAtividade().equals("") || diretorRequest.getAnoInicioAtividade().equals(null)){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo ano de inicio de atividade.");
        }

        if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()) {
            throw new AnoAtividadeInvalidoException("Ano de início de atividade inválido para o diretor cadastrado.");
        }

        Integer idIncremento = fakeDatabase.recuperaDiretores().size() + 1; //id autoincrementado

        Diretor diretor = new Diretor(idIncremento,
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteDiretor(diretor);
    }
    public List<Diretor> listarDiretores() throws Exception {

        if(fakeDatabase.recuperaDiretores().size() == 0){
            throw new NenhumCadastroException("Nenhum diretor cadastrado, favor cadastar diretores.");
        }
        return fakeDatabase.recuperaDiretores();
    }

    public Diretor consultarDiretor(Integer id) throws Exception {

        if(id.equals(null)){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo id.");
        }

        for (int i = 0; i < fakeDatabase.recuperaDiretores().size(); i++){

            if(fakeDatabase.recuperaDiretores().get(i).getId().equals(id)){

                return fakeDatabase.recuperaDiretores().get(i);

            }
        }
        throw new IdNuloException("Nenhum diretor encontrado com o parâmetro id = "+ id +", favor verifique os parâmetros informados.");


    }
}
