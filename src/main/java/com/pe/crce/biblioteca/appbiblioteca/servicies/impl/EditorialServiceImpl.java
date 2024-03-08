package com.pe.crce.biblioteca.appbiblioteca.servicies.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.AuthorDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.EditorialDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.EditorialDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.entities.Author;
import com.pe.crce.biblioteca.appbiblioteca.entities.Editorial;
import com.pe.crce.biblioteca.appbiblioteca.errorhandler.EntityNotFoundException;
import com.pe.crce.biblioteca.appbiblioteca.mapper.EditorialMapper;
import com.pe.crce.biblioteca.appbiblioteca.repositories.EditorialRepository;
import com.pe.crce.biblioteca.appbiblioteca.servicies.EditorialService;

@Service
public class EditorialServiceImpl implements EditorialService {

    EditorialRepository editorialRepository;

    EditorialMapper editorialMapper;

    public EditorialServiceImpl(EditorialRepository editorialRepository, EditorialMapper editorialMapper) {
        this.editorialRepository = editorialRepository;
        this.editorialMapper = editorialMapper;
    }

    @Override
    public Long save(EditorialDTORequest dto) {
        Editorial editorial = new Editorial();
        editorial.setName(dto.getName());
        editorial.setState(BibliotecaConstant.STATE_ACTIVE);

        return this.editorialRepository.save(editorial).getId();
    }

    @Override
    public Long update(EditorialDTORequest dto, Long id) {

        Editorial bean = this.editorialRepository.findById(id).get();
        bean.setName(dto.getName());
        return this.editorialRepository.save(bean).getId();

    }

    @Override
    public EditorialDTO findById(Long id) {
        Editorial editorial = this.editorialRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("La editorial con id %s no existe", id.toString())));
        return editorialMapper.toDto(editorial);
    }

    @Override
    public List<EditorialDTO> findAll() {
        List<Editorial> list = this.editorialRepository.findAll();
        List<EditorialDTO> listdto = new ArrayList<>();

        list.forEach((bean) -> {

            EditorialDTO dto = new EditorialDTO();
            dto.setId(bean.getId());
            dto.setName(bean.getName());

            listdto.add(dto);

        });

        return listdto;

    }

    public EditorialDTO convertBeanToDto(Editorial editorial) {
        return EditorialDTO.builder()
                .id(editorial.getId())
                .name(editorial.getName())
                .build();

    }

    @Override
    public Page<EditorialDTO> findByNameLikeAndState(String name, Pageable pageable) {
        Page<Editorial> editorialPages = this.editorialRepository.findByNameLikeAndState("%" + name + "%",
                BibliotecaConstant.STATE_ACTIVE, pageable);

        return editorialPages.map((bean) -> editorialMapper.toDto(bean));
    }

}
