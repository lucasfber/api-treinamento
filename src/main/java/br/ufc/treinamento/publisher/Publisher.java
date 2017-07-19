package br.ufc.treinamento.publisher;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.ufc.treinamento.publication.Publication;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String city;
	
	private String country;
	
	@OneToMany(mappedBy = "publisher")
	@JsonIgnore
	private Collection<Publication> publications;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
		
	public Publisher() {}
	
	public Publisher(Integer id, String name, String city, String country) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Collection<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Collection<Publication> publications) {
		this.publications = publications;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date date) {
		this.createdAt = date;
	}
	
}
