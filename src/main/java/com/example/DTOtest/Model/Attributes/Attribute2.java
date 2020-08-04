package com.example.DTOtest.Model.Attributes;

import com.example.DTOtest.Model.Intermediary.EntityAttrib2;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Accessors(chain=true)
public class Attribute2 {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "attribute2",cascade=CascadeType.ALL)
    private Set<EntityAttrib2> entity1s;

    @ManyToOne()
    @JoinColumn(name="category_id",referencedColumnName="id")
    private A2Cat category;
}
