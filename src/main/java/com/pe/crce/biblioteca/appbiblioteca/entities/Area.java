package com.pe.crce.biblioteca.appbiblioteca.entities;

import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = BibliotecaConstant.TAB_NAME_AREA, schema = BibliotecaConstant.SEC_NAME_DBO)
public class Area {

    @Id
    @Column(name = "idarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "state", insertable = false)
    private String state;

}
