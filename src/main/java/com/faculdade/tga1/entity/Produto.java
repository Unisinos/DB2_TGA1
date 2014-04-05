package com.faculdade.tga1.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@SequenceGenerator(name = "seq_id_Produto", sequenceName = "seq_id_Produto")
public class Produto extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private int estoqueAtual;

    @Getter
    @Setter
    private int estoqueMinimo;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Grade grade;

    @Getter
    @Setter
    @OneToMany(mappedBy="produto")
    private List<EstoqueGradeItem> estoqueGradeItem;
}
