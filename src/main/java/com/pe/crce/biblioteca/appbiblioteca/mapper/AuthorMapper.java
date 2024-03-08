package com.pe.crce.biblioteca.appbiblioteca.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pe.crce.biblioteca.appbiblioteca.dto.AuthorDTO;
import com.pe.crce.biblioteca.appbiblioteca.entities.Author;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AuthorMapper {

    @Mapping(target = "authorName", expression = "java(author.getName() + \" \" + author.getLastName())")
    public AuthorDTO toDto(Author author);
}
