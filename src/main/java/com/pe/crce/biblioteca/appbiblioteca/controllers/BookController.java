package com.pe.crce.biblioteca.appbiblioteca.controllers;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.BookDTO;

import com.pe.crce.biblioteca.appbiblioteca.dto.HrefEntityDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.PageableDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.BookDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.servicies.BookService;
import com.pe.crce.biblioteca.appbiblioteca.util.BibliotecaUtil;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC)
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTEND)
@Slf4j
public class BookController {

    final BookService bookService;

    final BibliotecaUtil bibliotecaUtil;

    public BookController(BookService bookService, BibliotecaUtil bibliotecaUtil) {
        this.bookService = bookService;
        this.bibliotecaUtil = bibliotecaUtil;
    }

    @GetMapping(BibliotecaConstant.RESOURCE_BOOKS + BibliotecaConstant.RESOURCE_BOOKS_BOOK
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<BookDTO>(this.bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping(BibliotecaConstant.RESOURCE_BOOKS + BibliotecaConstant.RESOURCE_BOOKS_BOOK)
    public ResponseEntity<HrefEntityDTO> save(@RequestBody @Valid BookDTORequest dto) {
        return new ResponseEntity<HrefEntityDTO>(this.bookService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping(BibliotecaConstant.RESOURCE_BOOKS + BibliotecaConstant.RESOURCE_BOOKS_BOOK
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public ResponseEntity<HrefEntityDTO> update(@RequestBody BookDTORequest dto, @PathVariable Long id) {
        return new ResponseEntity<HrefEntityDTO>(this.bookService.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping(BibliotecaConstant.RESOURCE_BOOKS + BibliotecaConstant.RESOURCE_BOOKS_BOOK
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public ResponseEntity<HrefEntityDTO> delete(@PathVariable Long id) {
        log.info("crce controler delete -> {} " + id);
        return new ResponseEntity<HrefEntityDTO>(this.bookService.delete(id), HttpStatus.OK);
    }

    @GetMapping(BibliotecaConstant.RESOURCE_BOOKS + BibliotecaConstant.RESOURCE_BOOKS_BOOK)
    public ResponseEntity<Page<BookDTO>> findByKeyWord(@RequestParam String key_word, PageableDTO pageable) {
        return new ResponseEntity<Page<BookDTO>>(
                this.bookService.findByKeyWordJPQL(key_word, this.bibliotecaUtil.getPageable(pageable)), HttpStatus.OK);
    }

    @GetMapping(BibliotecaConstant.RESOURCE_BOOKS + BibliotecaConstant.RESOURCE_BOOKS_BOOK
            + BibliotecaConstant.RESOURCE_EXPORT_EXCEL)
    public ResponseEntity<Resource> generateExcel(@RequestParam String key_word, PageableDTO pageable) {
        Page<BookDTO> pages = this.bookService.findByKeyWordJPQL(key_word, this.bibliotecaUtil.getPageable(pageable));
        File file = this.bookService.generateExcel(pages.getContent());

        // Configuracion de la cabecera de las respuesta

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());

        // crear respuesta htttp cpn el objeto file

        FileSystemResource fileResource = new FileSystemResource(file);
        return new ResponseEntity<Resource>(fileResource, headers, HttpStatus.OK);

    }

}
