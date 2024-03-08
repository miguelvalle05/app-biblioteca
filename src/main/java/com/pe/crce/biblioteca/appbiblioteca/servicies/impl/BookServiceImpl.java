package com.pe.crce.biblioteca.appbiblioteca.servicies.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import com.pe.crce.biblioteca.appbiblioteca.constant.GetReportColumnsConstant;
import com.pe.crce.biblioteca.appbiblioteca.dto.BookDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.HrefEntityDTO;
import com.pe.crce.biblioteca.appbiblioteca.dto.request.BookDTORequest;
import com.pe.crce.biblioteca.appbiblioteca.entities.Book;
import com.pe.crce.biblioteca.appbiblioteca.entities.Editorial;
import com.pe.crce.biblioteca.appbiblioteca.entities.SubArea;
import com.pe.crce.biblioteca.appbiblioteca.errorhandler.EntityNotFoundException;
import com.pe.crce.biblioteca.appbiblioteca.export.ResourceExport;
import com.pe.crce.biblioteca.appbiblioteca.mapper.BookMapper;
import com.pe.crce.biblioteca.appbiblioteca.repositories.BookRepository;
import com.pe.crce.biblioteca.appbiblioteca.repositories.EditorialRepository;
import com.pe.crce.biblioteca.appbiblioteca.repositories.SubAreaRepository;
import com.pe.crce.biblioteca.appbiblioteca.servicies.BookService;
import com.pe.crce.biblioteca.appbiblioteca.util.BibliotecaResource;
import com.pe.crce.biblioteca.appbiblioteca.util.BibliotecaUtil;

@Service
@Transactional
public class BookServiceImpl implements BookService {

        final BookRepository bookRepository;

        final BookMapper bookMapper;

        final BibliotecaUtil bibliotecaUtil;

        final EditorialRepository editorialRepository;

        final SubAreaRepository subAreaRepository;

        final ResourceExport resourceExport;

        public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper, BibliotecaUtil bibliotecaUtil,
                        EditorialRepository editorialRepository, SubAreaRepository subAreaRepository,
                        ResourceExport resourceExport) {
                super();
                this.bookRepository = bookRepository;
                this.bookMapper = bookMapper;
                this.bibliotecaUtil = bibliotecaUtil;
                this.editorialRepository = editorialRepository;
                this.subAreaRepository = subAreaRepository;
                this.resourceExport = resourceExport;
        }

        @Override
        public HrefEntityDTO save(BookDTORequest dto) {
                Editorial editorial = this.editorialRepository
                                .findByIdAndState(dto.getIdEditorial(), BibliotecaConstant.STATE_ACTIVE)
                                .orElseThrow(() -> new EntityNotFoundException("Not found editorial"));

                SubArea subArea = this.subAreaRepository
                                .findByIdAndState(dto.getIdSubArea(), BibliotecaConstant.STATE_ACTIVE)
                                .orElseThrow(() -> new EntityNotFoundException("Not found subarea"));

                Book book = Book.builder()
                                .title(dto.getTitle())
                                .subtitle(dto.getSubtitle())
                                .isbn(dto.getIsbn())
                                .description(dto.getDescription())
                                .numberPage(dto.getNumberPage())
                                .yearPublication(dto.getYearPublication())
                                .state(BibliotecaConstant.STATE_ACTIVE)
                                .editorial(editorial)
                                .subArea(subArea).build();

                return bibliotecaUtil.createHrefFromResource(this.bookRepository.save(book).getId(),
                                BibliotecaResource.BOOK);
        }

        @Override
        public HrefEntityDTO update(BookDTORequest dto, Long id) {
                Editorial editorial = this.editorialRepository
                                .findByIdAndState(dto.getIdEditorial(), BibliotecaConstant.STATE_ACTIVE)
                                .orElseThrow(() -> new EntityNotFoundException("Not found editorial"));

                SubArea subArea = this.subAreaRepository
                                .findByIdAndState(dto.getIdSubArea(), BibliotecaConstant.STATE_ACTIVE)
                                .orElseThrow(() -> new EntityNotFoundException("Not found subarea"));

                Book book = this.bookRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                                .orElseThrow(() -> new EntityNotFoundException("Not found book"));

                book.setTitle(dto.getTitle());
                book.setSubtitle(dto.getSubtitle());
                book.setDescription(dto.getDescription());
                book.setNumberPage(dto.getNumberPage());
                book.setYearPublication(dto.getYearPublication());
                book.setEditorial(editorial);
                book.setSubArea(subArea);

                return bibliotecaUtil.createHrefFromResource(this.bookRepository.save(book).getId(),
                                BibliotecaResource.BOOK);
        }

        @Override
        public HrefEntityDTO delete(Long id) {

                Book book = this.bookRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                                .orElseThrow(() -> new EntityNotFoundException("Not found book"));

                book.setState(BibliotecaConstant.STATE_DESABLE);

                return bibliotecaUtil.createHrefFromResource(this.bookRepository.save(book).getId(),
                                BibliotecaResource.BOOK);
        }

        @Override
        public BookDTO findById(Long id) {
                Book book = this.bookRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                                .orElseThrow(() -> new EntityNotFoundException("Not found book"));
                return this.bookMapper.toDto(book);

        }

        @Override
        public Page<BookDTO> findByKeyWordJPQL(String key_word, Pageable pageable) {
                Page<Book> books = this.bookRepository.findByKeyWordJPQL(key_word, BibliotecaConstant.STATE_ACTIVE,
                                pageable);
                return books.map((b) -> this.bookMapper.toDto(b));

        }

        @Override
        public File generateExcel(List<BookDTO> books) {
                List<String> sheets = List.of(BibliotecaConstant.SHEET_BOOK);

                Map<String, List<String>> colsBySheet = new HashMap<>();
                List<String> cols = List.of(GetReportColumnsConstant.COL_BOOK_TITULO,
                                GetReportColumnsConstant.COL_BOOK_EDITORIAL);

                colsBySheet.put(BibliotecaConstant.SHEET_BOOK, cols);

                Map<String, List<Map<String, String>>> valuesBySheet = new HashMap<>();
                List<Map<String, String>> valoresHoja = new ArrayList<>();

                books.forEach(row -> {
                        Map<String, String> valuesHojaRow = new HashMap<>();
                        valuesHojaRow.put(GetReportColumnsConstant.COL_BOOK_TITULO, row.getTitle().toLowerCase());
                        valuesHojaRow.put(GetReportColumnsConstant.COL_BOOK_EDITORIAL,
                                        row.getEditorial().getName().toLowerCase());
                        valoresHoja.add(valuesHojaRow);
                });
                valuesBySheet.put(BibliotecaConstant.SHEET_BOOK, valoresHoja);
                return this.resourceExport.generateExcel(sheets, colsBySheet, valuesBySheet,
                                BibliotecaConstant.REPORT_NAME_BOOK_PAGINABLE);
        }

}
