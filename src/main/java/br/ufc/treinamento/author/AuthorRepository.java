package br.ufc.treinamento.author;

import java.util.Collection;

/**
 * Created by lucas on 17/07/17.
 */
public interface AuthorRepository {

    Iterable<Author> findAll();

    void save(Author author);

    Author findAuthorById(Integer id);

    void remove(Integer id);
}
