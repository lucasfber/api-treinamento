package br.ufc.treinamento.author;

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

    @Autowired
    private AuthorRepository repository;

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Author>> queryAllAuthors(){
        return ResponseEntity.ok(repository.findAll());
    }


    @RequestMapping(
            method = RequestMethod.POST
    )
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

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Author> removeAuthor(@PathVariable Integer id){
        Author authorToRemove = repository.findAuthorById(id);

        System.out.println("Chamei");

        if(authorToRemove != null){
            repository.remove(authorToRemove.getId());
            return new ResponseEntity<Author>(HttpStatus.OK);
        }

        else return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
    }

}
