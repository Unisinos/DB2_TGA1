package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_id_GradeItem", sequenceName = "seq_id_GradeItem")
public class GradeItem extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Grade grade;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Cor cor;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Tamanho tamanho;


}
