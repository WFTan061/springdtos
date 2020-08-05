package com.example.DTOtest.DTO.DTO.Attributes;

import com.example.DTOtest.DTO.DTO.Entity.Entity1DTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain=true)
//v1 stuff
public class A2LiteDTO {
    private Long id;
    private String name;
    private String a2CatDTOid;//id of a2catdto
    private String a2CatDTOname;
}
