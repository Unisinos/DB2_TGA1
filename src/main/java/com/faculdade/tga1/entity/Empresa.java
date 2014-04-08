package com.faculdade.tga1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Loja> lojas;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Holding holder;
    
	public void addLoja(Loja l) {
		if(lojas == null)
			lojas = new ArrayList<Loja>();

		lojas.add(l);
	}
}
