package com.faculdade.tga1.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by iuriandreazza on 06/03/14.
 */
@MappedSuperclass
abstract public class AbstractEntity<K extends Object & Serializable> implements Serializable {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //TODO: Validar a geração de Sequence dependente das Classes que herdam esta
    @SequenceGenerator(name = "seq_idx", sequenceName = "sq_idx")
    private K Id;


}
