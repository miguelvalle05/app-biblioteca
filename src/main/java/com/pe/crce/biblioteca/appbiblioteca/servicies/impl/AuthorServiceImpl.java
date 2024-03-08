package com.pe.crce.biblioteca.appbiblioteca.servicies.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.AuthorDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.AuthorDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.entities.Author;
import com.pe.crce.biblioteca.appbiblioteca.mapper.AuthorMapper;
import com.pe.crce.biblioteca.appbiblioteca.repositories.AuthorRepository;
import com.pe.crce.biblioteca.appbiblioteca.servicies.AuthorSerice;

@Service
public class AuthorServiceImpl implements AuthorSerice {

    final AuthorRepository authorRepository;
    final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDTO> findByKeyWordSQL(String keyword) {
        List<Author> list = this.authorRepository.finByKeyWorkSQL(keyword, BibliotecaConstant.STATE_ACTIVE);
        return list.stream()
                .map((bean) -> authorMapper.toDto(bean))
                .collect(Collectors.toList());
    }

    public AuthorDTO convertBeanToDto(Author author) {
        return AuthorDTO.builder()
                .id(author.getId())
                .authorName(author.getName() + " " + author.getLastName())
                .build();

    }

    @Override
    public AuthorDTO saveSQL(AuthorDTORequest dto) {
        return convertBeanToDto(this.authorRepository.saveSQL(dto.getName(), dto.getLastName()));

    }

}
