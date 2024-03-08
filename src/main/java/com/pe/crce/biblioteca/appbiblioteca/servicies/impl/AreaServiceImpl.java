package com.pe.crce.biblioteca.appbiblioteca.servicies.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.AreaDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.HrefEntityDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.AreaDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.entities.Area;
import com.pe.crce.biblioteca.appbiblioteca.errorhandler.EntityNotFoundException;
import com.pe.crce.biblioteca.appbiblioteca.mapper.AreaMapper;
import com.pe.crce.biblioteca.appbiblioteca.repositories.AreaRepository;
import com.pe.crce.biblioteca.appbiblioteca.servicies.AreaService;
import com.pe.crce.biblioteca.appbiblioteca.util.BibliotecaResource;
import com.pe.crce.biblioteca.appbiblioteca.util.BibliotecaUtil;

@Service
public class AreaServiceImpl implements AreaService {

    final AreaRepository areaRepository;

    final BibliotecaUtil bibliotecaUtil;

    final AreaMapper areaMapper;

    public AreaServiceImpl(AreaRepository areaRepository, BibliotecaUtil bibliotecaUtil, AreaMapper areaMapper) {
        super();
        this.areaRepository = areaRepository;
        this.bibliotecaUtil = bibliotecaUtil;
        this.areaMapper = areaMapper;
    }

    @Override
    public HrefEntityDTO save(AreaDTORequest dto) {
        Area area = this.areaRepository.save(this.areaMapper.toBean(dto));
        return this.bibliotecaUtil.createHrefFromResource(area.getId(), BibliotecaResource.AREA);

    }

    @Override
    public HrefEntityDTO update(AreaDTORequest dto, Long id) {
        Area area = this.areaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(() -> new EntityNotFoundException("not found"));
        area.setDescription(dto.getDescription());
        return this.bibliotecaUtil.createHrefFromResource(this.areaRepository.save(area).getId(),
                BibliotecaResource.AREA);
    }

    @Override
    public HrefEntityDTO delete(Long id) {
        Area area = this.areaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(() -> new EntityNotFoundException("not found"));
        area.setState(BibliotecaConstant.STATE_DESABLE);
        return this.bibliotecaUtil.createHrefFromResource(this.areaRepository.save(area).getId(),
                BibliotecaResource.AREA);
    }

    @Override
    public Page<AreaDTO> findByDescription(String description, Pageable pageable) {
        Page<Area> areas = this.areaRepository.findByDescriptionContainingAndState(description,
                BibliotecaConstant.STATE_ACTIVE, pageable);
        return areas.map((bean) -> this.areaMapper.toDto(bean));
    }

    @Override
    public AreaDTO findById(Long id) {
        Area area = this.areaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));

        return this.areaMapper.toDto(area);
    }

}
