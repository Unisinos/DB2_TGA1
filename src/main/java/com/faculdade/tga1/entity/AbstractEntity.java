package com.faculdade.tga1.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * Trabalho - GA1
 * Banco de Dados II - 2014/1
 * Gilberto Irajá Müller
 *
 * Integrantes:
 *      Paulo Grabin - plgrabin@gmail.com
 *      Iuri Andreazza - iuri.andreazza@gmail.com
 *      Talita Audibert - tali.audibert@gmail.com
 *      Eduardo Pereira da Silva - eduardobursa@gmail.com
 *
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
    private K id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractEntity other = (AbstractEntity) obj;
        if (this.getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!this.getId().equals(other.getId()))
            return false;
        return true;
    }
}
