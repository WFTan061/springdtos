package com.example.DTOtest.Model.Intermediary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EntityAttrib2Key implements Serializable {
    @Column(name="entity1_Id")
    Long Entity1Id;
    @Column(name="attribute2_Id")
    Long Attribute2Id;
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        EntityAttrib2Key EA2Key = (EntityAttrib2Key) o;
        return Objects.equals(Entity1Id, EA2Key.Entity1Id) &&
                Objects.equals(Attribute2Id,EA2Key.Attribute2Id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(Entity1Id,Attribute2Id);
    }
}
