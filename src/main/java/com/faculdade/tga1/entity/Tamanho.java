package com.faculdade.tga1.entity;

import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class Tamanho extends AbstractEntity<Long>{
	
	@SequenceGenerator(name = "seq_id_Tamanho", sequenceName = "seq_id_Tamanho")
	
    @Getter
    @Setter
    private String nome;

}
