package com.pe.crce.biblioteca.appbiblioteca.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable {
    Long id;
    String authorName;

}
