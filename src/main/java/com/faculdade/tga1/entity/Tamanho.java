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
@SequenceGenerator(name = "seq_id_Tamanho", sequenceName = "seq_id_Tamanho")
public class Tamanho extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @OneToMany(mappedBy = "tamanho", cascade = CascadeType.ALL)
    private List<GradeItem> gradeItem;

    public void addGradeItem(GradeItem gi) {
    	if(this.gradeItem == null)
    		this.gradeItem = new ArrayList<GradeItem>();
    		
    		gradeItem.add(gi);
    }
}
