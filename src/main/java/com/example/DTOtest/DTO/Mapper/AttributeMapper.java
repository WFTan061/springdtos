package com.example.DTOtest.DTO.Mapper;

import com.example.DTOtest.DTO.DTO.Attributes.A2CatDTO;
import com.example.DTOtest.DTO.DTO.Attributes.A2LiteDTO;
import com.example.DTOtest.DTO.DTO.Attributes.A2SkelDTO;
import com.example.DTOtest.DTO.DTO.Attributes.Attribute1DTO;
import com.example.DTOtest.Model.Attributes.A2Cat;
import com.example.DTOtest.Model.Attributes.Attribute1;
import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Repository.Attributes.A1Repository;
import com.example.DTOtest.Repository.Attributes.A2CatRepository;
import com.example.DTOtest.Repository.Attributes.A2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AttributeMapper {
    @Autowired
    private A2CatRepository catRepo;
    @Autowired
    private A1Repository a1Repo;
    @Autowired
    private A2Repository a2Repo;

    public A2LiteDTO toA2DTO(Attribute2 a2){
        A2LiteDTO a2Dto = new A2LiteDTO();
        a2Dto.setA2CatDTOid(a2.getCategory().getId().toString());
        a2Dto.setA2CatDTOname(a2.getCategory().getName());
        a2Dto.setName(a2.getName());
        a2Dto.setId(a2.getId());
        return a2Dto;
    }
    public Attribute2 createA2DTO(A2LiteDTO a2Dto){
        Attribute2 a2 = new Attribute2();
        a2.setName(a2Dto.getName());
        Optional<A2Cat> a2CatOptional = catRepo.findById(Long.valueOf(a2Dto.getA2CatDTOid()));
        System.out.println(Long.valueOf(a2Dto.getA2CatDTOid()));
        System.out.println(a2CatOptional);
        a2CatOptional.ifPresent(value->{
           a2.setCategory(a2CatOptional.get());
        });
        return a2;
    }

    public A2CatDTO toA2CatDTO(A2Cat a2cat){
        String name = a2cat.getName();
        A2CatDTO toReturn = new A2CatDTO().setName(a2cat.getName());
        toReturn.setId(a2cat.getId());
        return toReturn;
    }
    public A2Cat createA2CatDTO(A2CatDTO a2CatDTO){
        A2Cat toReturn = new A2Cat();
        toReturn.setName(a2CatDTO.getName());
        return toReturn;
    }
    public A2Cat fromA2CatDTO(A2CatDTO a2CatDTO){
        A2Cat toReturn = new A2Cat();
        toReturn.setName(a2CatDTO.getName());
        return toReturn;
    }
    public Attribute1DTO toA1DTO(Attribute1 a1){
        String name=a1.getName();
        Attribute1DTO toReturn = new Attribute1DTO().setName(name);
        toReturn.setId(a1.getId());
        return toReturn;
    }
    public Attribute1 createA1DTO(Attribute1DTO a1dto){
        String name = a1dto.getName();
        Attribute1 toReturn = new Attribute1().setName(name);
        return toReturn;
    }

    public Attribute1 fromA1DTO(Attribute1DTO a1dto){
        Attribute1 toReturn = a1Repo.findById(a1dto.getId()).get();
        return toReturn;
    }

    public Attribute2 fromA2LiteDTO(A2LiteDTO a2Dto) {
        Attribute2 toReturn = a2Repo.findById(a2Dto.getId()).get();
        return toReturn;
    }

    public Attribute2 fromA2SkelDTO(A2SkelDTO a2Dto) {
        Attribute2 toReturn = a2Repo.findById(a2Dto.getId()).get();
        return toReturn;
    }
}
