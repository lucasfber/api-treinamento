package br.ufc.treinamento.author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService{

	@Autowired
	private AuthorRepository repository;
	
	public Iterable<Author> findAll(){
		return repository.findAll();
	}
	
	public void save(Author author){
        repository.save(author);
    }

    public Author findAuthorById(Integer id) {
        return repository.findOne(id);
    }
 
    public void remove(Author author) {
		this.repository.delete(author);
    }
    
    public Author update(Author author) {
    	return repository.save(author);
    }
}
