package com.example.DTOtest.Model.Intermediary;

import javax.persistence.Column;
import java.io.Serializable;

public class EntityAttrib2Key implements Serializable {
    @Column(name="entity1_Id")
    Long Entity1Id;
    @Column(name="attribute2_Id")
    Long Attribute2Id;
}
