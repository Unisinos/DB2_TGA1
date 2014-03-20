package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

/**
 * Created by iuriandreazza on 06/03/14.
 */
@Entity
@SequenceGenerator(name = "seq_id_Holding", sequenceName = "seq_id_Holding")
public class Holding extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL)
    private List<Empresa> empresas;

}
