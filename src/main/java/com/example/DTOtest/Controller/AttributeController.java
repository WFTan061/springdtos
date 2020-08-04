package com.example.DTOtest.Controller;

import com.example.DTOtest.DTO.DTO.Attributes.A2CatDTO;
import com.example.DTOtest.DTO.DTO.Attributes.A2LiteDTO;
import com.example.DTOtest.DTO.DTO.Attributes.Attribute1DTO;
import com.example.DTOtest.Service.AttributeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 1) Add a1 d
 * 2) Add a2 d
 * 3) Add a2Cat d
 * 4) Search a2 by e1. (is this needed? maybe by admins.)
 * 5) Search a1 by e1. (is this needed? maybe by admins.)
 * 6) Search all a2. d
 * 7) Search all a1. d
 * 8) search all a2cat
 * 9) search a1 by name. d
 * 10) search a2 by name.
 * 11) search a2cat by name. d
 */

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/attributes")
public class AttributeController {
    @Autowired
    private AttributeServiceImpl attrService;
    //get all a1
    @GetMapping
    @RequestMapping(path="/a1/all")
    public @ResponseBody
    List<Attribute1DTO> getAllA1(){
        List<Attribute1DTO> a1List = attrService.getAllA1();
        return a1List;
    }
    //search a1 by name
    @GetMapping
    @RequestMapping(path="/a1/searchName/{name}")
    public @ResponseBody
    List<Attribute1DTO> getA1ByName(@PathVariable String name){
        List<Attribute1DTO> a1 = attrService.getA1(name);
        return a1;
    }
    //search a1 by id
    @GetMapping
    @RequestMapping(path = "/a1/searchId/{id}")
    public @ResponseBody
    Attribute1DTO getA1ById(@PathVariable Long id){
        Attribute1DTO a1 = attrService.getA1ById(id);
        return a1;
    }
    //add a1 to sql
    @PostMapping
    @RequestMapping(path = "/a1/add")
    public ResponseEntity<String>addA1(@RequestBody(required=false) Attribute1DTO a1DTO){
        return new ResponseEntity<>(attrService.addA1(a1DTO),HttpStatus.OK);
    }
    //getting all a2
    @GetMapping
    @RequestMapping(path="/a2/all")
    public @ResponseBody
    List <A2LiteDTO> getAllA2(){
        List<A2LiteDTO> a2List = attrService.getAllA2();
        return a2List;
    }
    @GetMapping
    @RequestMapping(path="/a2/{name}")
    public @ResponseBody
    List <A2LiteDTO> getA2ByName(String name){
        List<A2LiteDTO> a2List = attrService.getA2(name);
        return a2List;
    }
    @GetMapping
    @RequestMapping(path="/a2/{id}")
    public @ResponseBody
    A2LiteDTO getA2ById(Long id){
        A2LiteDTO a2 = attrService.getA2ById(id);
        return a2;
    }
    //soft add a2. only give its name but not the categroy etc.
    @PostMapping
    @RequestMapping(path="/a2/add")
    public
    ResponseEntity<String> addA2(@RequestBody(required=false) A2LiteDTO a2DTO){
        return new ResponseEntity<String>(attrService.addA2(a2DTO),HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(path="/a2Cat")
    public @ResponseBody
    List <A2CatDTO> getAllA2Cat(){
        List <A2CatDTO> a2Cats = attrService.getAllCat();
        return a2Cats;
    }
    @GetMapping
    @RequestMapping(path="/a2Cat/{name}")
    public @ResponseBody
    List<A2CatDTO> getA2Cat(@PathVariable String name){
        List<A2CatDTO> a2Cat = attrService.getA2Cat(name);
        return a2Cat;
    }
    @GetMapping
    @RequestMapping(path = "/a2Cat/{id}")
    public @ResponseBody
    A2CatDTO getA2CatById(@PathVariable Long id){
        A2CatDTO a2Cat = attrService.getA2CatById(id);
        return a2Cat;
    }
    @PostMapping
    @RequestMapping(path="/a2Cat/add")
    public ResponseEntity<String> addA2Cat(@RequestBody(required=false) A2CatDTO catDTO){
        return new ResponseEntity<String>(attrService.addCat(catDTO), HttpStatus.OK);
    }
//    @PutMapping
//    @RequestMapping(path="/a2Cat/{id}")
//    public ResponseEntity<String> editA2Cat(@RequestBody(required=false) A2CatDTO catDTO){
//        return new ResponseEntity<String>(attrService.updateCat(catDTO), HttpStatus.OK);
//    }

}
