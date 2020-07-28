package com.example.DTOtest.Model.Attributes;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Accessors(chain=true)
public class A2Cat {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
