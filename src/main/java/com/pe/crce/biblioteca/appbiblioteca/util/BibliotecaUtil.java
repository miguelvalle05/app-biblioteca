package com.pe.crce.biblioteca.appbiblioteca.util;

import java.util.Optional;

import java.lang.reflect.Field;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.HrefEntityDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.PageableDTO;
import com.pe.crce.biblioteca.appbiblioteca.errorhandler.EntityGenericServerException;

@Component
public final class BibliotecaUtil {

    public Pageable getPageable(PageableDTO pageableDTO) {

        Optional<Integer> sortOrder = pageableDTO.getOrder();
        Optional<String> sortField = pageableDTO.getField();
        Integer pageNumber = pageableDTO.getPageNumber();
        Integer perPage = pageableDTO.getPageSize();

        Pageable pageable;

        if (sortOrder.isPresent() && sortField.isPresent()) {
            Sort.Direction direction = sortOrder.get().equals(1) ? Sort.Direction.ASC : Sort.Direction.DESC;
            pageable = PageRequest.of(pageNumber, perPage, Sort.by(direction, sortField.get()));

        } else {
            pageable = PageRequest.of(pageNumber, perPage, Sort.by(Sort.Direction.DESC, "id"));

        }

        return pageable;
    }

    public HrefEntityDTO createHrefFromResource(Object id, BibliotecaResource resource)
            throws EntityGenericServerException {
        HrefEntityDTO hrefEntity = new HrefEntityDTO();
        try {
            StringBuilder builder = new StringBuilder();
            Field field = BibliotecaConstant.class.getDeclaredField("RESOURCE_" + resource + "S");
            Object valueResource = field.get("");
            builder.append(valueResource);
            field = BibliotecaConstant.class.getDeclaredField("RESOURCE_" + resource + "S_" + resource);
            valueResource = field.get("");
            builder.append(valueResource).append("/").append(id);
            hrefEntity.setId(id);
            hrefEntity.setHref(builder.toString());
        } catch (Exception e) {
            throw new EntityGenericServerException("Error generating href resource");
        }
        return hrefEntity;
    }

}
