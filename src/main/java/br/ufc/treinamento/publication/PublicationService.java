package br.ufc.treinamento.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PublicationService {

	@Autowired
	private PublicationRepository repository;
	
	public Iterable<Publication> findAll(){
		return repository.findAll();
	}
	
	public void save(Publication Publication){
        repository.save(Publication);
    }

    public Publication findPublicationById(Integer id) {
        return repository.findOne(id);
    }
 
    public void remove(Publication Publication) {
		this.repository.delete(Publication);
    }
    
    public Publication update(Publication Publication) {
    	return repository.save(Publication);
    }
}
