package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

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


}
