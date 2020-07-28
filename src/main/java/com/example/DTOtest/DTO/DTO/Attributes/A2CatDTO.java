package com.example.DTOtest.DTO.DTO.Attributes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Accessors(chain=true)
public class A2CatDTO {
    private Long id;
    private String name;
}
