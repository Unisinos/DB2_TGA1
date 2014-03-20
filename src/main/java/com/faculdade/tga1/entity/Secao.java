package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @JoinColumn(name = "secoes")
    private Departamento departamento;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoEmpresa")
    @Column(nullable = false)
    private Empresa empresa;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoLoja")
    @Column(nullable = false)
    private Loja loja;

}
