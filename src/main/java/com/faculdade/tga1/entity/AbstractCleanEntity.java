package com.faculdade.tga1.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * Created by iuriandreazza on 13/03/14.
 */
@MappedSuperclass
public class AbstractCleanEntity<K extends Object & Serializable> implements Serializable {

}
