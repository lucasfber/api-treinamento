package br.ufc.treinamento.publication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Integer>{


}
