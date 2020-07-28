package com.example.DTOtest.Repository.Entity;

import com.example.DTOtest.Model.Attributes.Attribute1;
import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Entity1Repository extends CrudRepository<Entity1,Long> {
    List<Entity1> findByName(String name);
    List<Entity1> findByAttribute1(Attribute1 a1);
    List<Entity1> findByAttribute2s_Attribute2(Attribute2 a2);
}
