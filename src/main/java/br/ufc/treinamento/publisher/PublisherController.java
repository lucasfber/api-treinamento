package br.ufc.treinamento.publisher;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/publishers")
public class PublisherController {

	@Autowired
	private PublisherRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Publisher>> queryAllPublishers(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	
}
