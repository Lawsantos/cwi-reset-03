package br.com.cwi.reset.laercio.repository;

import br.com.cwi.reset.laercio.domain.Ator;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    void deleteById(ID id);

    Optional<Ator> findById(Integer id);

}
