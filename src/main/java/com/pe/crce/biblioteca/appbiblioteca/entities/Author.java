package com.pe.crce.biblioteca.appbiblioteca.entities;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = BibliotecaConstant.TAB_NAME_AUTHOR, schema = BibliotecaConstant.SEC_NAME_DBO)
public class Author {

    @Id
    @Column(name = "idauthor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "lastname")
    String lastName;

    @Column(name = "state")
    String state;
}
