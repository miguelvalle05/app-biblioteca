package com.pe.crce.biblioteca.appbiblioteca.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import com.pe.crce.biblioteca.appbiblioteca.dto.AreaDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.AreaDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.entities.Area;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AreaMapper {

    public Area toBean(AreaDTORequest dto);

    public AreaDTO toDto(Area area);
}