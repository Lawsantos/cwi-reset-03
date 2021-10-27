package br.com.cwi.reset.laercio.service;


import br.com.cwi.reset.laercio.repository.DiretorRepository;
import br.com.cwi.reset.laercio.request.DiretorRequest;
import br.com.cwi.reset.laercio.domain.Diretor;
import br.com.cwi.reset.laercio.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public Diretor cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {


        if(diretorRequest.getNome().split(" ").length == 1){
            throw new NomeESobrenomeException("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        }

        Iterable<Diretor> diretoresBd = diretorRepository.findAll();
        for (Diretor diretorTemp : diretoresBd){
            if(diretorTemp.getNome().equalsIgnoreCase(diretorRequest.getNome())){
                throw new NomeIgualException("Já existe um diretor cadastrado para o nome " + diretorRequest.getNome()+".");
            }
        }

        if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear() || diretorRequest.getAnoInicioAtividade() > LocalDate.now().getYear()) {
            throw new AnoAtividadeInvalidoException("Ano de início de atividade inválido para o diretor cadastrado.");
        }

        Diretor diretor = new Diretor(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade());

        return diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores() {

       return (List<Diretor>) diretorRepository.findAll();
    }

    public Optional<Diretor> consultarDiretor(Integer id) throws Exception {

        if(id == null){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo id.");
        }

        if (!diretorRepository.existsById(id)) {
            throw new IdNuloException("Nenhum diretor encontrado com o parâmetro id = "+ id +", favor verifique os parâmetros informados.");

        }
        return diretorRepository.findById(id);

    }

    public void removerDiretor(Integer id) throws Exception {

        if (!diretorRepository.existsById(id)) {
            throw new IdNuloException("Nenhum diretor encontrado com o parâmetro id = "+ id +", favor verifique os parâmetros informados.");

        }
        diretorRepository.deleteById(id);
    }

    //    public void atualizarDiretor(Integer id, DiretorRequest DiretorRequest) throws Exception {
//        Optional<Diretor> diretor = diretorRepository.findById(id);
//
//        if (diretor.isPresent()) {
//            diretorRepository.save(diretor);
//        } else {
//            throw new IdNuloException("Nenhum diretor encontrado com o parâmetro id = " + id + ", favor verifique os parâmetros informados.");
//        }
//
//    }
}
