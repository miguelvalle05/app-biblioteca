package com.pe.crce.biblioteca.appbiblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.AuthorDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.AuthorDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.servicies.AuthorSerice;

import jakarta.validation.Valid;

@RestController
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC)
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTEND)
public class AuthorController {

    final AuthorSerice authorSerice;

    public AuthorController(AuthorSerice authorSerice) {
        this.authorSerice = authorSerice;
    }

    @GetMapping(BibliotecaConstant.RESOUCER_AUTHORS + BibliotecaConstant.RESOUCER_AUTHORS_AUTHOR)
    public List<AuthorDTO> findByKeywordSQL(@RequestParam String key_word) {

        return this.authorSerice.findByKeyWordSQL(key_word);

    }

    @PostMapping(BibliotecaConstant.RESOUCER_AUTHORS + BibliotecaConstant.RESOUCER_AUTHORS_AUTHOR)
    public ResponseEntity<AuthorDTO> saveSQL(@Valid @RequestBody AuthorDTORequest dto) {

        return new ResponseEntity<AuthorDTO>(this.authorSerice.saveSQL(dto), HttpStatus.CREATED);

    }

}
