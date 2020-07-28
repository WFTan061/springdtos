package com.example.DTOtest.DTO.DTO.Intermediary;

import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import com.example.DTOtest.Model.Intermediary.EntityAttrib2Key;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Getter
@Setter
public class EntityAttrib2DTO {
    @EmbeddedId
    EntityAttrib2Key entityAttrib2Key;
    @ManyToOne
    @MapsId("Entity1_Key")
    Entity1 entity1;

    @ManyToOne
    @MapsId("Attribute2_Id")
    Attribute2 attribute2;

}
