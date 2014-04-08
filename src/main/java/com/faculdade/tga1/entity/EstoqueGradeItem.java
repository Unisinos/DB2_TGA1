package com.faculdade.tga1.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"codigoProduto", "codigoGradeItem", "codigoLoja", "codigoEmpresa"})})
public class EstoqueGradeItem extends AbstractEntity<Long> {

    @Getter
    @Setter
    private int estoqueAtual;

    @Getter
    @Setter
    private int estoqueMinimo = -1; //Pré inicializado em -1 (infinito)

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoProduto")
    private Produto produto;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoGradeItem")
    private GradeItem gradeItem;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoLoja")
    private Loja loja;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoEmpresa")
    private Empresa Empresa;
}
