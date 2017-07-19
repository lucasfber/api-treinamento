package br.ufc.treinamento.author;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.treinamento.publication.Publication;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Author>> queryAllAuthors(){
		return new ResponseEntity<Iterable<Author>>(service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException {
        service.save(author);

        URL createdURL = new URL("http://localhost:8080/authors/" + author.getId().toString());

        return ResponseEntity
                .created(createdURL.toURI())
                .build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> queryAuthor(@PathVariable Integer id){
    	
        Author authorFounded = service.findAuthorById(id);
        if(authorFounded == null) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        	
        return ResponseEntity.ok(authorFounded);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeAuthor(@PathVariable Integer id) {

         Author authorToRemove = service.findAuthorById(id);

         if(authorToRemove == null){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

         service.remove(authorToRemove);
         
         return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody Author author){
    	Author authorToUpdate = service.findAuthorById(id);
    	
    	
    	if(authorToUpdate == null) {    		
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
    	authorToUpdate.setFirstName(author.getFirstName());
    	authorToUpdate.setLastName(author.getLastName());
    	
    	Author authorUpdated = service.update(authorToUpdate);
    	
    	return new ResponseEntity<Author>(authorUpdated, HttpStatus.OK);
  
    }
    
    @RequestMapping("{id}/pubs")
    public ResponseEntity<Iterable<Publication>> getAuthorPublications(@PathVariable Integer id){
    	
    	Author author = service.findAuthorById(id);
    	
    	if(author == null) {
    		return new ResponseEntity<Iterable<Publication>>(HttpStatus.NOT_FOUND);
    	}
    		
    	return new ResponseEntity<Iterable<Publication>>(author.getPubs(), HttpStatus.OK);
    }

}
