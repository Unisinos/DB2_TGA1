package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Created by iuriandreazza on 07/03/14.
 */
@Entity
@SequenceGenerator(name = "seq_id_Secao", sequenceName = "seq_id_Secao")
public class Secao extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja;

}
