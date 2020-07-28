package com.example.DTOtest.DTO.Mapper;

import com.example.DTOtest.DTO.DTO.Attributes.A2LiteDTO;
import com.example.DTOtest.DTO.DTO.Entity.E1LiteDTO;
import com.example.DTOtest.DTO.DTO.Entity.Entity1DTO;
import com.example.DTOtest.Model.Attributes.Attribute1;
import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import com.example.DTOtest.Model.Intermediary.EntityAttrib2;
import com.example.DTOtest.Repository.Attributes.A1Repository;
import com.example.DTOtest.Repository.Entity.Entity1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EntityMapper {
    @Autowired
    private static AttributeMapper aMap;
    @Autowired
    private static Entity1Repository eRepo;
    @Autowired
    private static A1Repository a1Repo;

    public static Entity1DTO toEntity1DTO(Entity1 ent1){
        Entity1DTO toReturn = new Entity1DTO();
        toReturn.setId(ent1.getId());
        toReturn.setAttrib1Id(ent1.getAttribute1().getId().toString());
        toReturn.setAttrib1Name(ent1.getAttribute1().getName());
        Set<EntityAttrib2> att2s = ent1.getAttribute2s();
        Set<A2LiteDTO> att2ss = new HashSet<>();
        att2s.forEach(entatt -> {
            att2ss.add(new A2LiteDTO()
                    .setId(entatt.getAttribute2().getId())
                    .setName(entatt.getAttribute2().getName())
                    .setA2CatDTOname(entatt.getAttribute2().getCategory().getName())
                    .setA2CatDTOid(entatt.getAttribute2().getCategory().getId().toString()))
                    ;
        });
        toReturn.setAttribute2s(att2ss);
        att2s.forEach(test-> System.out.println(test));
        return toReturn;
    }
    public static E1LiteDTO toE1LiteDTO (Entity1 ent1){
        E1LiteDTO toReturn = new E1LiteDTO();
        toReturn.setName(ent1.getName());
        toReturn.setId(ent1.getId());
        return toReturn;
    }
    public static Entity1 toEntity1(Entity1DTO ent1dto){
        Entity1 toReturn = new Entity1();
        Attribute1 att1 = a1Repo.findById(Long.valueOf(ent1dto.getAttrib1Id())).get();
        toReturn.setAttribute1(att1);
        toReturn.setId(ent1dto.getId());
        toReturn.setName(ent1dto.getName());
        Set<EntityAttrib2> ea2 = new HashSet<>();
        ent1dto.getAttribute2s().forEach(a2Dto->{
            Attribute2 toAdd = aMap.fromA2LiteDTO(a2Dto);
            EntityAttrib2 inter = new EntityAttrib2();
            inter.setAttribute2(toAdd);
            inter.setEntity1(toReturn);
            ea2.add (inter);
        });
        toReturn.setAttribute2s(ea2);
        return toReturn;
    }
//    public static Entity1 toEntity1(E1LiteDTO e1LiteDto){
//        //grab existing for non-visible ea2.
//        Entity1 toReturn = eRepo.findById(e1LiteDto.getId()).get();
//        if(toReturn == null){
//            //basically might be a new entity1
//            toReturn = new Entity1();
//        }
//        toReturn.setAttribute1(aMap.fromA1DTO(e1LiteDto.getAttribute1()));
//        toReturn.setName(e1LiteDto.getName());
//        return toReturn;
//    }

}
