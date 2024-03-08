package com.pe.crce.biblioteca.appbiblioteca.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.crce.biblioteca.appbiblioteca.entities.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    public Page<Editorial> findByNameLikeAndState(String name, String state, Pageable pageable);

    public Optional<Editorial> findByIdAndState(Long id, String state);

}
