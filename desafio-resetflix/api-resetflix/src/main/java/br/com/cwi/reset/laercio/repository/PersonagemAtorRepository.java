package br.com.cwi.reset.laercio.repository;

import br.com.cwi.reset.laercio.domain.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;

public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {
    //PersonagemAtor findByNome(String nome);
}
