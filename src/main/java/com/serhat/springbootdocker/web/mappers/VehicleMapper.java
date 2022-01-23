package com.serhat.springbootdocker.web.mappers;

import com.serhat.springbootdocker.entity.*;
import com.serhat.springbootdocker.web.dto.*;
import org.mapstruct.*;

@Mapper
public interface VehicleMapper {

    VehicleDto vehicleToVehicleDto(Vehicle vehicle);

    Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto);

}
