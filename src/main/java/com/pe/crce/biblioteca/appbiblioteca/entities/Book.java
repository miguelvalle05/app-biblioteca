package com.pe.crce.biblioteca.appbiblioteca.entities;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = BibliotecaConstant.TAB_NAME_BOOK, schema = BibliotecaConstant.SEC_NAME_DBO)
public class Book {
    @Id
    @Column(name = "idbook")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "description")
    private String description;

    @Column(name = "numberpage")
    private String numberPage;

    @Column(name = "yearpublication")
    private String yearPublication;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "ideditorial")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "idsubarea")
    private SubArea subArea;

}
