package com.example.DTOtest.Repository.Intermediary;

import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import com.example.DTOtest.Model.Intermediary.EntityAttrib2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EntityAttrib2Repository extends CrudRepository<EntityAttrib2,Long> {
    Set<EntityAttrib2> findByEntity1(Entity1 entity1);
    Set<EntityAttrib2> findByAttribute2(Attribute2 attribute2);
}
