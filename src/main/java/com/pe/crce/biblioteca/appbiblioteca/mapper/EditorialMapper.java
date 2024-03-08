package com.pe.crce.biblioteca.appbiblioteca.mapper;

import org.mapstruct.Mapper;

import com.pe.crce.biblioteca.appbiblioteca.dto.EditorialDTO;
import com.pe.crce.biblioteca.appbiblioteca.entities.Editorial;

import org.mapstruct.Builder;

@Mapper(builder = @Builder(disableBuilder = true))
public interface EditorialMapper {

    public EditorialDTO toDto(Editorial editorial);

}
