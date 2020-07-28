package com.example.DTOtest.Controller;

import com.example.DTOtest.DTO.DTO.Attributes.Attribute1DTO;
import com.example.DTOtest.DTO.DTO.Entity.Entity1DTO;
import com.example.DTOtest.DTO.Mapper.EntityMapper;
import com.example.DTOtest.Model.Entity.Entity1;
import com.example.DTOtest.Repository.Entity.Entity1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/entity")
public class EntityController {
    //Get all entities.
    //Set entity, optionals.
    //Get by attribute 1.
    //Get by attribute 2
    @Autowired
    private Entity1Repository et1Repo;

    @Autowired
    private EntityMapper eMap;

    @GetMapping
    @RequestMapping(path="/all")
    @ResponseBody
    List<Entity1DTO> getAllEnt1(){
        Iterable<Entity1> et1List = et1Repo.findAll();
        List<Entity1DTO> et1Dtos = new ArrayList<>();
        et1List.forEach(ent1->{
            Entity1DTO et1Dto = eMap.toEntity1DTO(ent1);
            et1Dtos.add(et1Dto);
        });
        return et1Dtos;
    }

    @GetMapping
    @RequestMapping(path="/{id}")
    @ResponseBody
    Entity1DTO getEnt1(@PathVariable long id){
        Entity1 toGet = et1Repo.findById(id).get();
        Entity1DTO toReturn = eMap.toEntity1DTO(toGet);
        return toReturn;
    }

    @PostMapping
    @RequestMapping(path="/add")
    public ResponseEntity<String> addA1(@RequestBody Entity1DTO e1DTO){
        et1Repo.save(eMap.toEntity1(e1DTO));
        return new ResponseEntity<String>("e1Dto saved", HttpStatus.OK);
    }

}
