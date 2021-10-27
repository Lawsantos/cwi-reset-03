package br.com.cwi.reset.laercio.repository;

import br.com.cwi.reset.laercio.domain.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

}
