package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by iuriandreazza on 06/03/14.
 */
@Entity
@SequenceGenerator(name = "seq_id_Departamento", sequenceName = "seq_id_Departamento")
public class Departamento extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @OneToMany(mappedBy = "codigoDepartamento")
    private List<Secao> secoes;

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
