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
@SequenceGenerator(name = "seq_id_Cor", sequenceName = "seq_id_Cor")
public class Cor extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @OneToMany(mappedBy = "cor", cascade = CascadeType.ALL)
    private List<GradeItem> gradeItem;
    
	public void addGradeItem(GradeItem p) {
		if(gradeItem == null)
			gradeItem = new ArrayList<GradeItem>();

		gradeItem.add(p);
	}
}
