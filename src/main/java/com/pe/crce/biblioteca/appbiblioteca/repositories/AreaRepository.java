package com.pe.crce.biblioteca.appbiblioteca.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.crce.biblioteca.appbiblioteca.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    public Page<Area> findByDescriptionContainingAndState(String descripcion, String sate, Pageable pageable);

    public Optional<Area> findById(Long id);

    public Optional<Area> findByIdAndState(Long id, String state);

}
