package com.example.DTOtest.DTO.DTO.Entity;

import com.example.DTOtest.DTO.DTO.Attributes.A2LiteDTO;
import com.example.DTOtest.DTO.DTO.Attributes.A2SkelDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Entity1DTO {
    private Long id;
    private String name;
    private Long attrib1Id;
    private String attrib1Name;
    private Set<A2SkelDTO> attribute2s;
}

/**
 * {
 *     id:Long,
 *     name:string
 *     Attrib1Id:string
 * }
 */
