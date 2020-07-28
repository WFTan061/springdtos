package com.example.DTOtest.Repository.Attributes;

import com.example.DTOtest.Model.Attributes.A2Cat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface A2CatRepository extends CrudRepository<A2Cat,Long> {
    List<A2Cat> findByName(String name);
}
