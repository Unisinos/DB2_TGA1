package com.faculdade.tga1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@SequenceGenerator(name = "seq_id_Grade", sequenceName = "seq_id_Grade")
public class Grade extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<GradeItem> gradesItens;
	
    @Getter
    @Setter
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Produto> produtos;
    
    public void addGradeItem(GradeItem gi) {
		if(gradesItens == null)
			gradesItens = new ArrayList<GradeItem>();

		gradesItens.add(gi);
	}
    
	public void addProduto(Produto p) {
		if(produtos == null)
			produtos = new ArrayList<Produto>();

		produtos.add(p);
	}
}
