package com.example.DTOtest.Model.Intermediary;

import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Getter
@Setter
@Entity
public class EntityAttrib2 {
    @EmbeddedId
    EntityAttrib2Key entityAttrib2Key;
    @ManyToOne
    @MapsId("Entity1_Id")
    Entity1 entity1;

    @ManyToOne
    @MapsId("Attribute2_Id")
    Attribute2 attribute2;

}
