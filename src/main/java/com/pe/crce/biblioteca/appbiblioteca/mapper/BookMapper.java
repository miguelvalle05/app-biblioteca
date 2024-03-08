package com.pe.crce.biblioteca.appbiblioteca.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import com.pe.crce.biblioteca.appbiblioteca.dto.BookDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.BookDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.entities.Book;

@Mapper(builder = @Builder(disableBuilder = true))
public interface BookMapper {

    public BookDTO toDto(Book book);

    public Book toBean(BookDTORequest dto);

}
