package com.faculdade.tga1.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by iuriandreazza on 13/03/14.
 */
@MappedSuperclass
public class AbstractCleanEntity<K extends Object & Serializable> implements Serializable {


}
