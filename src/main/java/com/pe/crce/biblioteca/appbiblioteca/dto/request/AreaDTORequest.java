package com.pe.crce.biblioteca.appbiblioteca.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTORequest {

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 100)
    private String description;

}
