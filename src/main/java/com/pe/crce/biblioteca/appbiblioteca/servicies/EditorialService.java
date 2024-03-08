package com.pe.crce.biblioteca.appbiblioteca.servicies;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pe.crce.biblioteca.appbiblioteca.dto.EditorialDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.EditorialDTORequest;

@Service
public interface EditorialService {

    public Long save(EditorialDTORequest dto);

    public Long update(EditorialDTORequest dto, Long id);

    public EditorialDTO findById(Long id);

    public List<EditorialDTO> findAll();

    public Page<EditorialDTO> findByNameLikeAndState(String name, Pageable pageable);
}
