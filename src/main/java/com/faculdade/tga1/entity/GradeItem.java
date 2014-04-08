package com.faculdade.tga1.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * Trabalho - GA1
 * Banco de Dados II - 2014/1
 * Gilberto Irajá Müller
 *
 * Integrantes:
 *      Paulo Grabin - plgrabin@gmail.com
 *      Iuri Andreazza - iuri.andreazza@gmail.com
 *      Talita Audibert - tali.audibert@gmail.com
 *      Eduardo Pereira da Silva - eduardobursa@gmail.com
 *
 */
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
