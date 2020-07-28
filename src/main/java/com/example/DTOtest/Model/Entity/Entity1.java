package com.example.DTOtest.Model.Entity;

import com.example.DTOtest.Model.Attributes.Attribute1;
import com.example.DTOtest.Model.Intermediary.EntityAttrib2;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Entity1 {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "attribute1_id",referencedColumnName = "id")
    private Attribute1 attribute1;

    @OneToMany(mappedBy="entity1")
    private Set<EntityAttrib2> attribute2s;
}
