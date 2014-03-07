package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by iuriandreazza on 06/03/14.
 */
@Entity
@SequenceGenerator(name = "seq_id_Loja", sequenceName = "seq_id_Loja")
public class Loja extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

    @Getter
    @Setter
    private int nroFuncionario;

    @Getter
    @Setter
    @OneToMany(mappedBy = "codigoLoja", cascade = CascadeType.ALL)
    private List<Departamento> departamentos;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoEmpresa")
    @Column(nullable = false)
    private Empresa empresa;


}
