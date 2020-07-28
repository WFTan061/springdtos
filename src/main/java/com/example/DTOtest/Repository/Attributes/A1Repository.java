package com.example.DTOtest.Repository.Attributes;

import com.example.DTOtest.Model.Attributes.Attribute1;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface A1Repository extends CrudRepository<Attribute1,Long> {
    List<Attribute1> findByName(String name);
}
