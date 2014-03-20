package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq_id_Tamanho", sequenceName = "seq_id_Tamanho")
public class Tamanho extends AbstractEntity<Long> {


    @Getter
    @Setter
    private String nome;


    @Getter
    @Setter
    @OneToMany(mappedBy = "codigoTamanho", cascade = CascadeType.ALL)
    private List<GradeItem> gradeItem;

}
