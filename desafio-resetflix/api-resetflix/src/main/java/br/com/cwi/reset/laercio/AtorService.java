package br.com.cwi.reset.laercio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {

        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws Exception {

        if (atorRequest.getNome().equals(null) || atorRequest.getNome().equals("")){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo nome.");
        }

        if(atorRequest.getNome().split(" ").length == 1){
            throw new NomeESobrenomeException("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        for (int i = 0; i < fakeDatabase.recuperaAtores().size(); i++){
            if(fakeDatabase.recuperaAtores().get(i).getNome().equals(atorRequest.getNome())){
                throw new NomeIgualException("Já existe um ator cadastrado para o nome " + atorRequest.getNome()+".");
            }
        }

        if (atorRequest.getDataNascimento().equals(null) || atorRequest.getDataNascimento().equals("")){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar a data de nascimento.");
        }

        if (atorRequest.getDataNascimento().isAfter(LocalDate.now())){
            throw new DataNascimentoException("Não é possível cadastrar atores não nascidos.");
        }

        if(atorRequest.getAnoInicioAtividade().equals("") || atorRequest.getAnoInicioAtividade().equals(null)){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo ano de inicio de atividade.");
        }

        if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
            throw new AnoAtividadeInvalidoException("Ano de início de atividade inválido para o ator cadastrado.");
        }

        Integer idIncremento = fakeDatabase.recuperaAtores().size() + 1; //id autoincrementado

        Ator ator = new Ator(idIncremento,
        atorRequest.getNome(),
        atorRequest.getDataNascimento(),
        atorRequest.getStatusCarreira(),
        atorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteAtor(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade( ) throws Exception {

        List<AtorEmAtividade> atoresEmAtividade = new ArrayList<>();

        if(fakeDatabase.recuperaAtores().size() == 0){
            throw new NenhumCadastroException("Nenhum ator cadastrado, favor cadastar atores.");
        }

        for (int i = 0; i < fakeDatabase.recuperaAtores().size(); i++){
            Ator ator = fakeDatabase.recuperaAtores().get(i);
            if(ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)){
                AtorEmAtividade atorEmAtividade = new AtorEmAtividade(ator.getId(),
                        ator.getNome(),
                        ator.getDataNascimento());
                atoresEmAtividade.add(atorEmAtividade);
            }

        }
        return atoresEmAtividade;
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        this.VerificaExistenciaDeAtores();

        List<AtorEmAtividade> atoresEmAtividade = this.listarAtoresEmAtividade();
        List<AtorEmAtividade> atoresFiltrados = new ArrayList<>();

        for (int i = 0; i < atoresEmAtividade.size(); i++) {
            AtorEmAtividade atorEmAvitidade = atoresEmAtividade.get(i);

            if(atorEmAvitidade.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                atoresFiltrados.add(atorEmAvitidade);
            }
        }

        if(atoresFiltrados.size() == 0) {
            throw new NaoEncontradoException("Ator não encontrato com o filtro "+ filtroNome +", favor informar outro filtro.");
        }

        return atoresFiltrados;
    }

    public Ator consultarAtor(Integer id) throws Exception {

        if(id.equals(null)){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo id.");
        }

        for (int i = 0; i < fakeDatabase.recuperaAtores().size(); i++){

            if(fakeDatabase.recuperaAtores().get(i).getId().equals(id)){

                return fakeDatabase.recuperaAtores().get(i);

            }
        }
        throw new IdNuloException("Nenhum ator encontrado com o parâmetro id = "+ id +", favor verifique os parâmetros informados.");


    }

    public List<Ator> consultarAtores() throws Exception {

        if(fakeDatabase.recuperaAtores().size() == 0){
            throw new NenhumCadastroException("Nenhum ator cadastrado, favor cadastar atores.");
        }

        return fakeDatabase.recuperaAtores();
    }

    private void VerificaExistenciaDeAtores() throws Exception{
        if(this.fakeDatabase.recuperaAtores().size() == 0) {
            throw new NenhumCadastroException("Nenhum ator cadastrado, favor cadastar atores.");
        }
    }

}