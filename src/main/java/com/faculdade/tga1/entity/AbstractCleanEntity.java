package com.faculdade.tga1.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

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
 */
@MappedSuperclass
public class AbstractCleanEntity<K extends Object & Serializable> implements Serializable {
}
