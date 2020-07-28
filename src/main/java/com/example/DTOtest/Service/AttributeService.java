package com.example.DTOtest.Service;

import com.example.DTOtest.DTO.DTO.Attributes.A2CatDTO;
import com.example.DTOtest.DTO.DTO.Attributes.A2LiteDTO;
import com.example.DTOtest.DTO.DTO.Attributes.Attribute1DTO;
import com.example.DTOtest.DTO.Mapper.AttributeMapper;
import com.example.DTOtest.Model.Attributes.A2Cat;
import com.example.DTOtest.Model.Attributes.Attribute1;
import com.example.DTOtest.Model.Attributes.Attribute2;
import com.example.DTOtest.Repository.Attributes.A1Repository;
import com.example.DTOtest.Repository.Attributes.A2CatRepository;
import com.example.DTOtest.Repository.Attributes.A2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttributeService {

    @Autowired
    private A2CatRepository catRepo;
    @Autowired
    private A1Repository a1Repo;
    @Autowired
    private A2Repository a2Repo;

    @Autowired
    private AttributeMapper aMap;

    //A1s
    public  List<Attribute1DTO> getAllA1() {
        Iterable<Attribute1> a1Itr = a1Repo.findAll();
        List <Attribute1DTO> a1List = new ArrayList<>();
        a1Itr.forEach(a1-> {
            a1List.add(aMap.toA1DTO(a1));
        });
        return a1List;
    }

    public List<Attribute1DTO> getA1(String name) {
        List<Attribute1> a1List = a1Repo.findByName(name);
        List<Attribute1DTO> a1DtoList = new ArrayList<>();
        a1List.forEach(a1->{
            a1DtoList.add(aMap.toA1DTO(a1));
        });
        return a1DtoList;
    }

    public String addA1(Attribute1DTO a1Dto) {
        Attribute1 a1 = aMap.createA1DTO(a1Dto);
        a1Repo.save(a1);
        return a1.getId() + " added";
    }

    //cats
    public  List<A2CatDTO> getAllCat(){
        List<A2CatDTO> allCats = new ArrayList<A2CatDTO>();
        catRepo.findAll().forEach(
                cat->{allCats.add(aMap.toA2CatDTO(cat));}
        );
        return allCats;
    }
    public String addCat(A2CatDTO catDTO){
        A2Cat newCat = aMap.createA2CatDTO(catDTO);
        catRepo.save(newCat);
        return newCat.getName() + " Added into database.";
    }

    //A2s
    public  List<A2LiteDTO> getAllA2() {
        Iterable<Attribute2> a2Itr = a2Repo.findAll();
        List<A2LiteDTO> a2List = new ArrayList<>();
        a2Itr.forEach(
                a2->{
                    A2LiteDTO newA2Dto = new A2LiteDTO();
                    newA2Dto.setId(a2.getId());
                    newA2Dto.setName(a2.getName());
                    if(a2.getCategory()!=null) {
                        newA2Dto.setA2CatDTOid(a2.getCategory().getId().toString());
                        newA2Dto.setA2CatDTOname(a2.getCategory().getName());
                    }
                    a2List.add(newA2Dto);
                }
        );
        return a2List;
    }
    public List<A2CatDTO> getA2Cat(String name){
        List<A2Cat> getCats = catRepo.findByName(name);
        List<A2CatDTO> a2CatList = new ArrayList<>();
        getCats.forEach(a2Cat->{
            a2CatList.add(new A2CatDTO().setName(a2Cat.getName()));
        });
        return a2CatList;
    }

    public String addA2(A2LiteDTO a2DTO) {
        Attribute2 a2 = aMap.createA2DTO(a2DTO);
        a2Repo.save(a2);
        return a2.getId() + " added";
    }

    public List<A2LiteDTO> getA2(String name) {
        List<Attribute2> getA2s = a2Repo.findByName(name);
        List<A2LiteDTO> a2List = new ArrayList<>();
        getA2s.forEach(a2->{
            a2List.add(aMap.toA2DTO(a2));
        });
        return a2List;
    }

    public Attribute1DTO getA1ById(Long id) {
        Attribute1 a1 = a1Repo.findById(id).get();
        Attribute1DTO toReturn = aMap.toA1DTO(a1);
        return toReturn;

    }

    public A2CatDTO getA2CatById(Long id) {
        A2Cat a2Cat = catRepo.findById(id).get();
        A2CatDTO toReturn = aMap.toA2CatDTO(a2Cat);
        return toReturn;
    }

    public String updateCat(A2CatDTO catDTO) {
        A2Cat a2Cat = catRepo.findById(catDTO.getId()).get();
        if(catDTO.getName()!= null)
        a2Cat.setName(catDTO.getName());
        return null;
    }
    public String updateA1 (Attribute1DTO a1Dto){
        if(a1Dto.getId() == null){
            return "ID required.";
        }
        Attribute1 a1 = a1Repo.findById(a1Dto.getId()).get();
        if(a1Dto.getName() != null ){
            a1.setName(a1Dto.getName());
        }
        return "Success";
    }

    public A2LiteDTO getA2ById(Long id) {
        Attribute2 a2 = a2Repo.findById(id).get();
        A2LiteDTO toReturn = new A2LiteDTO()
                .setId(a2.getId())
                .setName(a2.getName())
                .setA2CatDTOid(a2.getCategory().getId().toString())
                .setA2CatDTOname(a2.getCategory().getName());
        return toReturn;
    }
//    public String updateA2(A2LiteDTO a2Dto){
//        if(a2Dto.getId() == null){
//            return "ID Required to update.";
//        }
//        Attribute2 a2 = a2Repo.findById(a2Dto.getId()).get();
//        if(a2Dto.getName()!= null){
//            a2.setName(a2Dto.getName());
//        }
//        if(a2Dto.getCategory()!= null){
//            a2.setCategory(aMap.fromA2CatDTO(a2Dto.getCategory()));
//        }
//        return null;
//    }
}
