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

@Entity
@SequenceGenerator(name = "seq_id_Categoria", sequenceName = "seq_id_Categoria")
public class Categoria extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Secao secao;

    @Getter
    @Setter
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produtos;
    
	public void addProduto(Produto p) {
		if(produtos == null)
			produtos = new ArrayList<Produto>();

		produtos.add(p);
	}
}
