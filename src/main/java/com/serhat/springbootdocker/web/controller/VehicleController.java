package com.serhat.springbootdocker.web.controller;

import com.serhat.springbootdocker.entity.*;
import com.serhat.springbootdocker.service.*;
import com.serhat.springbootdocker.web.dto.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Long id){

          VehicleDto dto =  service.getVehicleById(id);

        return new ResponseEntity(dto,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto dto){
         VehicleDto savedDto = service.saveVehicle(dto);

        return  new ResponseEntity<>(savedDto,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(){

        return new ResponseEntity<>(service.getAllVehicles(),HttpStatus.OK);
    }

}
