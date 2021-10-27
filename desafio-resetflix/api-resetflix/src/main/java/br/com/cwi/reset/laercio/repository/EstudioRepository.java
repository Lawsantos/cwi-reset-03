package br.com.cwi.reset.laercio.repository;

import br.com.cwi.reset.laercio.domain.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {


}
