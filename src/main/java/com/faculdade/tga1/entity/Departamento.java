package com.faculdade.tga1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

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
    @OneToMany(mappedBy = "departamento")
    private List<Secao> secoes;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja;
    
	public void addSecao(Secao s) {
		if(secoes == null)
			secoes = new ArrayList<Secao>();

		secoes.add(s);
	}
}
