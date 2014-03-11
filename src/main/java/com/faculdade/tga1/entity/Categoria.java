package com.faculdade.tga1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @JoinColumn(name = "codigoSecao")
    @Column(nullable = true)
	private Secao secao;
    
}
