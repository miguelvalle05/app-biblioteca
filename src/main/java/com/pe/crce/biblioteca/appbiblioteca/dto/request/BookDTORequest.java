package com.pe.crce.biblioteca.appbiblioteca.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTORequest {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String subtitle;
    private String isbn;
    private String description;
    private String numberPage;
    private String yearPublication;

    @NotNull
    private Long idEditorial;

    @NotNull
    private Long idSubArea;
}
