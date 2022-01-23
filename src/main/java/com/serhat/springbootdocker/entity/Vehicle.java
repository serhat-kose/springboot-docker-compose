package com.serhat.springbootdocker.entity;

import lombok.*;

import javax.persistence.*;
import java.math.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String modal;

    private BigDecimal price;


}
