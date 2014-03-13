package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_id_Cor", sequenceName = "seq_id_Cor")
public class Cor extends AbstractEntity<Long>{


    @Getter
    @Setter
    private String nome;

}
