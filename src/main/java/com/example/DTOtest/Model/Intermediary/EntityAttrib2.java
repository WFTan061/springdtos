package com.example.DTOtest.Model.Intermediary;

import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class EntityAttrib2 implements Serializable {
    @EmbeddedId
    EntityAttrib2Key entityAttrib2Key;
    @ManyToOne
    @MapsId("Entity1_Id")
    Entity1 entity1;

    @ManyToOne
    @MapsId("Attribute2_Id")
    Attribute2 attribute2;

    public EntityAttrib2(){}
    public EntityAttrib2(Entity1 e1, Attribute2 a2){
        entityAttrib2Key = new EntityAttrib2Key();
        System.out.println(a2.getId());
        System.out.println(e1.getId());
        this.setEntity1(e1);
        this.setAttribute2(a2);
        entityAttrib2Key.setAttribute2Id(attribute2.getId());
        entityAttrib2Key.setEntity1Id(entity1.getId());
    }
}
