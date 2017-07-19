package br.ufc.treinamento.publication;

import br.ufc.treinamento.author.Author;
import br.ufc.treinamento.publisher.Publisher;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date publicationDate;

	@ManyToOne
	private Author author;
	
	@ManyToOne
	private Publisher publisher;
	
	@Enumerated(EnumType.STRING)
	private PublicationType type;
	
	public Publication() {
		// TODO Auto-generated constructor stub
	}

	public Publication(Integer id, String title, Author author, Publisher publisher) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
}
