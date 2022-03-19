package com.serhat.springbootdocker.service.impl;

import com.serhat.springbootdocker.entity.*;
import com.serhat.springbootdocker.repository.*;
import com.serhat.springbootdocker.service.*;
import com.serhat.springbootdocker.web.dto.*;
import com.serhat.springbootdocker.web.mappers.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {


    private final VehicleRepository repository;

    private final VehicleMapper mapper;

    @Override
    public VehicleDto getVehicleById(Long id)  {

        Optional<Vehicle> vehicle= repository.findById(id);
        return vehicle.map(mapper::vehicleToVehicleDto).orElse(null);
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {

        Vehicle savedVehicle = mapper.vehicleDtoToVehicle(vehicleDto);

        return mapper.vehicleToVehicleDto(repository.save(savedVehicle));
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
          List<Vehicle> entityList =  repository.findAll();

          if(!entityList.isEmpty()){
              List<VehicleDto> dtoList = new ArrayList<>();
              for (Vehicle vehicle:entityList) {
                  dtoList.add( mapper.vehicleToVehicleDto(vehicle));
              }
              return dtoList;
          }
        return Collections.emptyList();
    }
}
