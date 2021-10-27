package br.com.cwi.reset.laercio.service;

import br.com.cwi.reset.laercio.domain.Estudio;
import br.com.cwi.reset.laercio.exception.*;
import br.com.cwi.reset.laercio.repository.EstudioRepository;
import br.com.cwi.reset.laercio.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static java.util.Objects.isNull;
@Service
public class EstudioService {

   @Autowired
   private EstudioRepository estudioRepository;


     public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

         Iterable<Estudio> estudioBd = estudioRepository.findAll();
         for (Estudio estudioTemp : estudioBd){
             if(estudioTemp.getNome().equalsIgnoreCase(estudioRequest.getNome())){
                 throw new NomeIgualException("Já existe um estudio cadastrado para o nome " + estudioRequest.getNome()+".");
             }
         }

         Estudio estudio = new Estudio(
                 estudioRequest.getNome(),
                 estudioRequest.getDescricao(),
                 estudioRequest.getDataCriacao(),
                 estudioRequest.getStatusAtividade());

         estudioRepository.save(estudio);
     }

    public Iterable<Estudio> consultarEstudios(String filtroNome) throws Exception {

        if(estudioRepository.findAll() == null){
            throw new NenhumCadastroException("Nenhum estudio cadastrado, favor cadastar estudios.");
        }

        List<Estudio> estudioLista = new ArrayList<>();
        Iterable<Estudio> estudioTemp = estudioRepository.findAll();
        if (!isNull(filtroNome)) {
            for (Estudio estudio : estudioTemp) {
                if (estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                    estudioLista.add(estudio);
                }
            }
        }

        if(estudioLista.size() == 0) {
            throw new NaoEncontradoException("Estudio não encontrato com o filtro "+ filtroNome +", favor informar outro filtro.");
        }

        return estudioLista;

    }

    public Optional<Estudio> consultarEstudio(Integer id) throws Exception {

        if(id == null){
            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o campo id.");
        }

        if (!estudioRepository.existsById(id)) {
            throw new IdNuloException("Nenhum estudio encontrado com o parâmetro id = "+ id +", favor verifique os parâmetros informados.");

        }

        return estudioRepository.findById(id);

    }
}
