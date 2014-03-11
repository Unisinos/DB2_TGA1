package com.faculdade.tga1.entity;

import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

public class Cor extends AbstractEntity<Long>{
	
	@SequenceGenerator(name = "seq_id_Cor", sequenceName = "seq_id_Cor")
	
    @Getter
    @Setter
    private String nome;

}
