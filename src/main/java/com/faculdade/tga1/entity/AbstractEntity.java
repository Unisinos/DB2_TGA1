package com.faculdade.tga1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by iuriandreazza on 06/03/14.
 * <p/>
 * Deacordo com o spec do JPA
 * 9.1.37 SequenceGenerator Annotation
 * The SequenceGenerator annotation defines a primary key generator
 * that may be referenced by name when a generator element is specified
 * for the  GeneratedValue annotation. A sequence generator may be specified
 * on the entity class or on the primary key field or property.
 * The scope of the generator name is global to the persistence unit (across all generator types).
 * <p/>
 * Logo o sequence deve ser anotado nas classes filho
 */
@MappedSuperclass
abstract public class AbstractEntity<K extends Object & Serializable> implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private K Id;

}
