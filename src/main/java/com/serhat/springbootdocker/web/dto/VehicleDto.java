package com.serhat.springbootdocker.web.dto;

import lombok.*;

import javax.persistence.*;
import java.math.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VehicleDto {

    private Long id;

    private String type;

    private String modal;

    private BigDecimal price;
}
