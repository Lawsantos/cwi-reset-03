package br.com.cwi.reset.laercio.service;

import br.com.cwi.reset.laercio.AtorEmAtividade;
import br.com.cwi.reset.laercio.domain.StatusCarreira;
import br.com.cwi.reset.laercio.exception.*;
import br.com.cwi.reset.laercio.repository.AtorRepository;
import br.com.cwi.reset.laercio.domain.Ator;
import br.com.cwi.reset.laercio.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public Ator criarAtor(AtorRequest atorRequest) throws Exception {

        if(atorRequest.getNome().split(" ").length < 2){
            throw new NomeESobrenomeException("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        Iterable<Ator> atoresBd = atorRepository.findAll();
        for (Ator atorTemp : atoresBd){
            if(atorTemp.getNome().equalsIgnoreCase(atorRequest.getNome())){
                throw new NomeIgualException("Já existe um ator cadastrado para o nome " + atorRequest.getNome()+".");
            }
        }

        if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
            throw new AnoAtividadeInvalidoException("Ano de início de atividade inválido para o ator cadastrado.");
        }

        Ator ator = new Ator(
        atorRequest.getNome(),
        atorRequest.getDataNascimento(),
        atorRequest.getStatusCarreira(),
        atorRequest.getAnoInicioAtividade());
        return atorRepository.save(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade( ) throws Exception {

        List<AtorEmAtividade> atoresEmAtividade = new ArrayList<>();
        Iterable<Ator> atoresListados = atorRepository.findAll();

        for (Ator atorCount : atoresListados){
            if(atorCount.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)){
                AtorEmAtividade atorEmAtividade = new AtorEmAtividade(atorCount.getId(),
                        atorCount.getNome(),
                        atorCount.getDataNascimento());
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
            AtorEmAtividade atorEmAtividade = atoresEmAtividade.get(i);

            if(atorEmAtividade.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                atoresFiltrados.add(atorEmAtividade);
            }
        }

        if(atoresFiltrados.size() == 0) {
           throw new NaoEncontradoException("Ator não encontrato com o filtro "+ filtroNome +", favor informar outro filtro.");
        }
//
        return atoresFiltrados;
    }

    public Optional<Ator> consultarAtor(Integer id) throws Exception {

        if(id == null){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo id.");
        }

        if (!atorRepository.existsById(id)) {
            throw new IdNuloException("Nenhum ator encontrado com o parâmetro id = "+ id +", favor verifique os parâmetros informados.");

        }

        return atorRepository.findById(id);

    }

    public List<Ator> consultarAtores(){

        return (List<Ator>) atorRepository.findAll();
    }

    private void VerificaExistenciaDeAtores() throws Exception {
        if(atorRepository.findAll() == null) {
            throw new NenhumCadastroException("Nenhum ator cadastrado, favor cadastar atores.");
        }
    }

    public void removerAtor(Integer id) throws Exception {
        if (!atorRepository.existsById(id)) {
            throw new IdNuloException("Nenhum ator encontrado com o parâmetro id = "+ id +", favor verifique os parâmetros informados.");

        }
        atorRepository.deleteById(id);
    }

    public Ator atualizarAtor(Integer id, AtorRequest atorRequest) throws Exception {
        Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(),
        atorRequest.getAnoInicioAtividade());

        ator.setId(consultarAtor(id).get().getId());

        if (ator != null) {
            return atorRepository.save(ator);
        } else {
            throw new IdNuloException("Nenhum ator encontrado com o parâmetro id = " + id + ", favor verifique os parâmetros informados.");
        }

    }


}