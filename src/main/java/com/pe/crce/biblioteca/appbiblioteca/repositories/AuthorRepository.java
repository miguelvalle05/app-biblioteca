package com.pe.crce.biblioteca.appbiblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;

import com.pe.crce.biblioteca.appbiblioteca.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = BibliotecaConstant.FN_SEARCH_AUTHOR, nativeQuery = true)
    List<Author> finByKeyWorkSQL(String keyword, String state);

    @Query(value = BibliotecaConstant.FN_SAVE_AUTHOR, nativeQuery = true)
    Author saveSQL(String name, String lastName);

}
