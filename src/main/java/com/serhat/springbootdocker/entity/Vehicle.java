package com.serhat.springbootdocker.entity;

import lombok.*;

import javax.persistence.*;
import java.io.*;
import java.math.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String modal;
    private BigDecimal price;


}
