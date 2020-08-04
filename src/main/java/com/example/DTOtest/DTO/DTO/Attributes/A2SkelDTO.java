package com.example.DTOtest.DTO.DTO.Attributes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
public class A2SkelDTO {
    private Long id;
    private String name;
}
