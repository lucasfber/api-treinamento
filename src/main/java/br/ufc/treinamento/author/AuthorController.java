package br.ufc.treinamento.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lucas on 17/07/17.
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    public static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorRepository repository;



    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Author>> queryAllAuthors(){
        return ResponseEntity.ok(repository.findAll());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException {
        repository.save(author);

        URL createdURL = new URL("http://localhost:8080/authors/" + author.getId().toString());

        return ResponseEntity
                .created(createdURL.toURI())
                .build();
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Author> queryAuthor(@PathVariable Integer id){

        Author authorFounded = repository.findAuthorById(id);

        return ResponseEntity.ok(authorFounded);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeAuthor(@PathVariable Integer id){
        logger.info("Pegando e deletando o author com id {}", id);

        Author authorToRemove = null; // repository.findAuthorById(id);

        if(authorToRemove == null){
            logger.info("Nao foi possivel deletar algum autor com o id {}", id);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        else{
            logger.info("Vou remover o autor: " + authorToRemove.getFirstName());
            repository.remove(authorToRemove);
            return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        return null;
    }

}
