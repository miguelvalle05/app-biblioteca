package com.pe.crce.biblioteca.appbiblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.pe.crce.biblioteca.appbiblioteca.constant.BibliotecaConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = BibliotecaConstant.TAB_NAME_SUB_AREA, schema = BibliotecaConstant.SEC_NAME_DBO)
public class SubArea {

    @Id
    @Column(name = "idsubarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "state", insertable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "idarea")
    private Area area;
}