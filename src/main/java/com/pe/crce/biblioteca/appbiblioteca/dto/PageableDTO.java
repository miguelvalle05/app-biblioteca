package com.pe.crce.biblioteca.appbiblioteca.dto;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageableDTO implements Pageable {

    private Integer page;
    private Integer size;
    private Optional<Integer> order;
    private Optional<String> field;

    public Optional<String> getField() {
        return field;
    }

    public Optional<Integer> getOrder() {
        return order;
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public long getOffset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOffset'");
    }

    @Override
    public Sort getSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSort'");
    }

    @Override
    public Pageable next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public Pageable previousOrFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previousOrFirst'");
    }

    @Override
    public Pageable first() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'first'");
    }

    @Override
    public Pageable withPage(int pageNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withPage'");
    }

    @Override
    public boolean hasPrevious() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasPrevious'");
    }

}
