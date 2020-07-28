package com.example.DTOtest.Repository.Attributes;

import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface A2Repository extends CrudRepository<Attribute2,Long> {
    List<Attribute2> findByName(String name);
    List<Attribute2> findByEntity1s_Entity1(Entity1 entity);

}
