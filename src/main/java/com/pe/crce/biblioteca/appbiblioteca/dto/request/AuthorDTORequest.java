package com.pe.crce.biblioteca.appbiblioteca.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthorDTORequest implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 10, max = 60)
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 10, max = 60)
    private String lastName;

}
