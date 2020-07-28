package com.example.DTOtest.Model.Attributes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Accessors(chain=true)
public class Attribute1 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
//    private String internalName; //search by this, no pt searching with
}
