package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
