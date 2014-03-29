package com.faculdade.tga1.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

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
    
	@Getter
	@Setter
	@OneToMany(mappedBy="secao")
	private List<Categoria> categoria;
}
