package br.com.cwi.reset.laercio.service;

import br.com.cwi.reset.laercio.FakeDatabase;
import br.com.cwi.reset.laercio.domain.PersonagemAtor;
import br.com.cwi.reset.laercio.exception.CampoNuloException;
import br.com.cwi.reset.laercio.exception.NaoEncontradoException;
import br.com.cwi.reset.laercio.exception.NomeIgualException;
import br.com.cwi.reset.laercio.repository.PersonagemAtorRepository;
import br.com.cwi.reset.laercio.request.PersonagemAtorRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonagemAtorService {

    private PersonagemAtorRepository personagemAtorRepository;

//    public PersonagemAtor cadastrarPersonagemAtor(PersonagemRequest personagemRequest) throws Exception {
//        new PersonagemRequestCamposObrigatoriosValidator().accept(personagemRequest);
//
//        final Integer idGerado = fakeDatabase.recuperaPersonagens().size() + 1;
//        //final Ator ator = atorService.consultarAtor(personagemRequest.getIdAtor());
//
//        //final PersonagemAtor personagemAtor = new PersonagemAtor(idGerado, ator, personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());
//
//        //fakeDatabase.persistePersonagem(personagemAtor);
//
//        return personagemAtor;
//    }

//    public List<PersonagemAtor> consultarPersonagemAtor(String nome) throws Exception {
//
//        if(personagemAtorRepository.findByNome(nome) == null){
//
//            throw new NaoEncontradoException("PersonagemAtor não encontrato com o filtro "+ nome +", favor informar outro filtro.");
//        } else{
//
//            if (personagemAtorRepository.findByNome(nome.toLowerCase(Locale.ROOT)).getAtor().contains(nome.toLowerCase(Locale.ROOT))) {
//                estudioLista.add(estudio);
//            }
    //    }

        //return personagemAtorRepository;
   // }

//    private void validarPersonagensAtoresFilme(final List<PersonagemAtorRequest> personagens) throws Exception {
//        if (personagens.isEmpty()) {
//            throw new CampoNuloException("Campo obrigatório não informado. Favor informar o personagem.");
//        }
//
//        final Set<PersonagemAtorRequest> personagemAtorRequestSet = new HashSet<>();
//
//        for (PersonagemAtorRequest personagemAtorRequest : personagens) {
////            new PersonagemRequestCamposObrigatoriosValidator().accept(personagemRequest);
//
//            /**
//             * A linha: "if (personagemRequestSet.contains(personagemRequest))"
//             *
//             * Cai na implementação do Set abaixo
//             * Implementação macro
//             * https://docs.oracle.com/javase/7/docs/api/java/util/Set.html#contains(java.lang.Object)
//             *
//             * Que por sua vez chama o equals da classe da chave
//             * Na prática:
//             * PersonagemRequest.equals(PersonagemRequest);
//             * {@link br.com.cwi.reset.josealencar.request.PersonagemRequest#equals(Object)}
//             */
//            if (personagemAtorRequestSet.contains(personagemAtorRequest)) {
//                throw new NomeIgualException("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
//            } else {
//                personagemAtorRequestSet.add(personagemAtorRequest);
//            }
//        }
//    }
//
//    public List<PersonagemAtor> cadastrarPersonagensFilme(final List<PersonagemAtorRequest> personagens) throws Exception {
//        validarPersonagensAtoresFilme(personagens);
//
//        final List<PersonagemAtor> personagensAtores = new ArrayList<>();
//
////        for (PersonagemRequest request : personagens) {
////            personagensAtores.add(cadastrarPersonagemAtor(request));
////        }
//
//        return personagensAtores;
//    }
}
