package com.pe.crce.biblioteca.appbiblioteca.servicies;

import java.util.List;

import com.pe.crce.biblioteca.appbiblioteca.dto.AuthorDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.AuthorDTORequest;

public interface AuthorSerice {
    public List<AuthorDTO> findByKeyWordSQL(String keyword);

    public AuthorDTO saveSQL(AuthorDTORequest dto);

}
