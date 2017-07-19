package br.ufc.treinamento.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.treinamento.author.Author;

@RestController
@RequestMapping("/publications")
public class PublicationController {

	@Autowired
	private PublicationService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Publication>> queryAllAuthors(){
		return new ResponseEntity<Iterable<Publication>>(service.findAll(), HttpStatus.OK);
	}
}
