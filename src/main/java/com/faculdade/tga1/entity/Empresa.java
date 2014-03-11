package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by iuriandreazza on 06/03/14.
 */
@Entity
@SequenceGenerator(name = "seq_id_Empresa", sequenceName = "seq_id_Empresa")
public class Empresa extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String razaoSocial;

    @Getter
    @Setter
    private String fantasia;

    @Getter
    @Setter
    private String logradouro;

    @Getter
    @Setter
    @OneToMany(mappedBy = "codigoEmpresa", cascade = CascadeType.ALL)
    private List<Loja> lojas;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoHolding")
    @Column(nullable = false)
    private Holding holder;

}
