package com.example.DTOtest.Service;

import com.example.DTOtest.DTO.DTO.Attributes.A2SkelDTO;
import com.example.DTOtest.DTO.DTO.Entity.Entity1DTO;
import com.example.DTOtest.DTO.Mapper.EntityMapper;
import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Model.Entity.Entity1;
import com.example.DTOtest.Model.Intermediary.EntityAttrib2;
import com.example.DTOtest.Repository.Attributes.A1Repository;
import com.example.DTOtest.Repository.Attributes.A2Repository;
import com.example.DTOtest.Repository.Entity.Entity1Repository;
import com.example.DTOtest.Repository.Intermediary.EntityAttrib2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityServiceImpl {
    @Autowired
    private Entity1Repository e1Repo;

    @Autowired
    private EntityAttrib2Repository ea2Repo;

    @Autowired
    private A2Repository a2Repo;

    @Autowired
    private A1Repository a1Repo;

    @Autowired
    private EntityMapper e1Mapper;

    public void createE1(Entity1DTO e1Dto){
        Entity1 newE1 = e1Repo.save(e1Mapper.createEntity1(e1Dto));
        //update roles... if present in e1.
        for(A2SkelDTO a2Dto:e1Dto.getAttribute2s()){
            Optional<Attribute2> a2Opt = a2Repo.findById(a2Dto.getId());
            //confirm have no matter what. don't care null
            Attribute2 a2 = a2Opt.get();
            EntityAttrib2 ea2 = new EntityAttrib2(newE1,a2);
            ea2Repo.save(ea2);
        }
    }
    public String removeId(Long id){
        e1Repo.deleteById(id);
        return "Id " + id + " removed.";
    }
}
