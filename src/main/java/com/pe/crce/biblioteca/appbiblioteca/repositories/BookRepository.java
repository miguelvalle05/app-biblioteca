package com.pe.crce.biblioteca.appbiblioteca.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pe.crce.biblioteca.appbiblioteca.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional<Book> findByIdAndState(Long id, String state);

    @Query("SELECT eb FROM Book eb \n" +
            "WHERE eb.state= ?2 and \n" +
            "LOWER(CONCAT(eb.title,eb.subtitle,eb.isbn,eb.description,eb.yearPublication)) \n" +
            "LIKE CONCAT('%',?1,'%')")
    public Page<Book> findByKeyWordJPQL(String key_word, String state, Pageable pageable);

}
