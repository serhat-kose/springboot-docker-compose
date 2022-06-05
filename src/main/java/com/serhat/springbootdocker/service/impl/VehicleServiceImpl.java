package com.serhat.springbootdocker.service.impl;

import com.serhat.springbootdocker.entity.*;
import com.serhat.springbootdocker.repository.*;
import com.serhat.springbootdocker.service.*;
import com.serhat.springbootdocker.web.dto.*;
import com.serhat.springbootdocker.web.mappers.*;
import lombok.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "vehicleCache")
public class VehicleServiceImpl implements VehicleService {


    private final VehicleRepository repository;

    private final VehicleMapper mapper;


    @Cacheable(cacheNames = "vehicle", key = "#id", unless = "#result == null")
    @Override
    public Optional<VehicleDto> getVehicleById(Long id)  {
        timeBreak();
        Optional<Vehicle> vehicle= repository.findById(id);
        return vehicle.map(mapper::vehicleToVehicleDto);
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {

        return mapper.vehicleToVehicleDto(repository.save(mapper.vehicleDtoToVehicle(vehicleDto)));
    }

    @Cacheable(cacheNames = "vehicles")
    @Override
    public List<VehicleDto> getAllVehicles() {
        timeBreak();
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

    private  void timeBreak(){

        System.out.println("Heeeey This is Time Break method Begin !!! ");

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
    }
}
