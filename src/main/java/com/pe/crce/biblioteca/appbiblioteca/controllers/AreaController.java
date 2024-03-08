package com.pe.crce.biblioteca.appbiblioteca.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.AreaDTO;

import com.pe.crce.biblioteca.appbiblioteca.dto.HrefEntityDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.PageableDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.AreaDTORequest;

import com.pe.crce.biblioteca.appbiblioteca.servicies.AreaService;
import com.pe.crce.biblioteca.appbiblioteca.util.BibliotecaUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC)
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTEND)
@Slf4j
public class AreaController {

    final AreaService areaService;
    final BibliotecaUtil bibliotecaUtil;

    public AreaController(AreaService areaService, BibliotecaUtil bibliotecaUtil) {
        this.areaService = areaService;
        this.bibliotecaUtil = bibliotecaUtil;
    }

    @GetMapping(BibliotecaConstant.RESOURCE_AREAS + BibliotecaConstant.RESOURCE_AREAS_AREA)
    public ResponseEntity<Page<AreaDTO>> findByName(@RequestParam String description, PageableDTO pageable) {
        log.info("controller -> {} " + pageable.toString());
        return new ResponseEntity<Page<AreaDTO>>(
                this.areaService.findByDescription(description, this.bibliotecaUtil.getPageable(pageable)),
                HttpStatus.OK);
    }

    @GetMapping(BibliotecaConstant.RESOURCE_AREAS + BibliotecaConstant.RESOURCE_AREAS_AREA
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public ResponseEntity<AreaDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<AreaDTO>(this.areaService.findById(id), HttpStatus.OK);
    }

    @PostMapping(BibliotecaConstant.RESOURCE_AREAS + BibliotecaConstant.RESOURCE_AREAS_AREA)
    public ResponseEntity<HrefEntityDTO> save(@RequestBody @Valid AreaDTORequest dto) {
        return new ResponseEntity<HrefEntityDTO>(this.areaService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping(BibliotecaConstant.RESOURCE_AREAS + BibliotecaConstant.RESOURCE_AREAS_AREA
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public ResponseEntity<HrefEntityDTO> update(@RequestBody AreaDTORequest dto, @PathVariable Long id) {
        return new ResponseEntity<HrefEntityDTO>(this.areaService.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping(BibliotecaConstant.RESOURCE_AREAS + BibliotecaConstant.RESOURCE_AREAS_AREA
            + BibliotecaConstant.RESOURCE_GENERID_ID)
    public ResponseEntity<HrefEntityDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<HrefEntityDTO>(this.areaService.delete(id), HttpStatus.OK);
    }

}
