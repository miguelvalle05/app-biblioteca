package com.pe.crce.biblioteca.appbiblioteca.servicies;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.pe.crce.biblioteca.appbiblioteca.dto.AreaDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.HrefEntityDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.AreaDTORequest;

@Service
public interface AreaService {

    public HrefEntityDTO save(AreaDTORequest dto);

    public HrefEntityDTO update(AreaDTORequest dto, Long id);

    public HrefEntityDTO delete(Long id);

    public Page<AreaDTO> findByDescription(String description, Pageable pageable);

    public AreaDTO findById(Long id);

}
