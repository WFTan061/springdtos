package com.example.DTOtest.DTO.DTO.Attributes;

import com.example.DTOtest.DTO.DTO.Entity.Entity1DTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain=true)
public class A2LiteDTO extends A2SkelDTO{
    private String a2CatDTOId;//id of a2catdto
    private String a2CatDTOName;
}
