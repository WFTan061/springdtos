package com.example.DTOtest.DTO.Mapper;

import com.example.DTOtest.DTO.DTO.Attributes.A2SkelDTO;
import com.example.DTOtest.DTO.DTO.Entity.E1LiteDTO;
import com.example.DTOtest.DTO.DTO.Entity.Entity1DTO;
import com.example.DTOtest.Model.Attributes.Attribute1;
import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import com.example.DTOtest.Model.Intermediary.EntityAttrib2;
import com.example.DTOtest.Repository.Attributes.A1Repository;
import com.example.DTOtest.Repository.Attributes.A2Repository;
import com.example.DTOtest.Repository.Entity.Entity1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class EntityMapper {
    @Autowired
    private AttributeMapper aMap;
    @Autowired
    private Entity1Repository eRepo;
    @Autowired
    private A1Repository a1repo;
//    @Autowired
//    private EntityAttrib2Repository ea2Repo;
    @Autowired
    private A2Repository a2Repo;

    public Entity1DTO toEntity1DTO(Entity1 ent1){
        Entity1DTO toReturn = new Entity1DTO();
        toReturn.setId(ent1.getId());
        if(ent1.getAttribute1() !=null) {
            toReturn.setAttrib1Id(ent1.getAttribute1().getId());
            toReturn.setAttrib1Name(ent1.getAttribute1().getName());
        }
        Set<EntityAttrib2> att2s = ent1.getAttribute2s();
        Set<A2SkelDTO> att2ss = new HashSet<>();
        att2s.forEach(entatt -> {
            att2ss.add(new A2SkelDTO()
                    .setId(entatt.getAttribute2().getId())
                    .setName(entatt.getAttribute2().getName()))
                    ;
        });
        toReturn.setAttribute2s(att2ss);
        att2s.forEach(test-> System.out.println(test));
        return toReturn;
    }
    public E1LiteDTO toE1LiteDTO (Entity1 ent1){
        E1LiteDTO toReturn = new E1LiteDTO();
        toReturn.setName(ent1.getName());
        toReturn.setId(ent1.getId());
        return toReturn;
    }

    public Entity1 createEntity1(Entity1DTO et1Dto){
        Entity1 toReturn = new Entity1();
        if(et1Dto.getAttrib1Id() != null){
            Optional<Attribute1> att1Opt = a1repo.findById(Long.valueOf(et1Dto.getAttrib1Id()));
            System.out.println(Long.valueOf(et1Dto.getAttrib1Id()));
            att1Opt.ifPresent(
                    attribute1 -> {
                        toReturn.setAttribute1(attribute1);
                    }
            );
        }
        Set<EntityAttrib2> ea2Set = new HashSet<>();
        if(et1Dto.getAttribute2s()!=null){
            et1Dto.getAttribute2s().forEach(
                    a2Dto->{
                        System.out.println("###################FOUND: " + a2Dto.getId());
                        Attribute2 a2 = a2Repo.findById(a2Dto.getId()).get();
                        EntityAttrib2 ea2 = new EntityAttrib2();
                        ea2.setEntity1(toReturn);
                        ea2.setAttribute2(a2);
                        ea2Set.add(ea2);
                    }
            );
        }
        toReturn.setAttribute2s(ea2Set);
        System.out.println("Setting Attribute2Set!");
        toReturn.setName(et1Dto.getName());
        return toReturn;
    }
    public Entity1 toEntity1(Entity1DTO ent1dto){
        Entity1 toReturn = new Entity1();
        Attribute1 att1 = a1repo.findById(Long.valueOf(ent1dto.getAttrib1Id())).get();
        toReturn.setAttribute1(att1);
        toReturn.setId(ent1dto.getId());
        toReturn.setName(ent1dto.getName());
        Set<EntityAttrib2> ea2 = new HashSet<>();
        ent1dto.getAttribute2s().forEach(a2Dto->{
            Attribute2 toAdd = aMap.fromA2SkelDTO(a2Dto);
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
