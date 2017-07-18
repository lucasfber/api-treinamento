package br.ufc.treinamento.author;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by lucas on 17/07/17.
 */
@Component
public class InMemoryAuthorRepository implements AuthorRepository{

    private static final List<Author> AUTHORS = new ArrayList<>();

    static {
        AUTHORS.addAll(Arrays.asList(
                new Author(1, "Lucas", "Bertoldo"),
                new Author(2, "Maria", "Pereira")
        ));
    }

    @Override
    public Collection<Author> findAll() {
        return Collections.unmodifiableList(AUTHORS);
    }

    public void save(Author author){
        AUTHORS.add(author);
    }

    @Override
    public Author findAuthorById(Integer id) {
        return AUTHORS.get(id-1);
    }

    @Override
    public void remove(Author author) {
        AUTHORS.remove(author);
    }
}
