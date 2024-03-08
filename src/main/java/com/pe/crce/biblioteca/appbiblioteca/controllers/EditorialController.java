package com.pe.crce.biblioteca.appbiblioteca.controllers;

import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;

import com.pe.crce.biblioteca.appbiblioteca.dto.EditorialDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.PageableDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.EditorialDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.servicies.EditorialService;
import com.pe.crce.biblioteca.appbiblioteca.util.BibliotecaUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC)
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTEND)
@Slf4j
public class EditorialController {

    private final EditorialService editorialService;
    private final BibliotecaUtil bibliotecaUtil;

    public EditorialController(EditorialService editorialService, BibliotecaUtil bibliotecaUtil) {
        this.editorialService = editorialService;
        this.bibliotecaUtil = bibliotecaUtil;
    }

    /*
     * @GetMapping(BibliotecaConstant.RESOUCER_EDITORIALS +
     * BibliotecaConstant.RESOURCE_EDITORIALS_EDITORIAL)
     * public List<EditorialDTO> finAll() {
     * 
     * return this.editorialService.findAll();
     * }
     */

    @GetMapping(BibliotecaConstant.RESOUCER_EDITORIALS + BibliotecaConstant.RESOURCE_EDITORIALS_EDITORIAL
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public EditorialDTO findByiD(@PathVariable Long id) {
        return this.editorialService.findById(id);

    }

    @PostMapping(BibliotecaConstant.RESOUCER_EDITORIALS + BibliotecaConstant.RESOURCE_EDITORIALS_EDITORIAL)
    public Long save(@RequestBody EditorialDTORequest dto) {
        return this.editorialService.save(dto);
    }

    @PutMapping(BibliotecaConstant.RESOUCER_EDITORIALS + BibliotecaConstant.RESOURCE_EDITORIALS_EDITORIAL
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public Long update(@RequestBody EditorialDTORequest dto, @PathVariable Long id) {
        return this.editorialService.update(dto, id);
    }

    @GetMapping(BibliotecaConstant.RESOUCER_EDITORIALS + BibliotecaConstant.RESOURCE_EDITORIALS_EDITORIAL)
    public Page<EditorialDTO> findByName(@RequestParam String name, PageableDTO pageable) {

        log.info("controller-> {}" + pageable.toString());

        return this.editorialService.findByNameLikeAndState(name, this.bibliotecaUtil.getPageable(pageable));

    }

}
