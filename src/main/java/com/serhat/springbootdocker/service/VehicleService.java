package com.serhat.springbootdocker.service;

import com.serhat.springbootdocker.entity.*;
import com.serhat.springbootdocker.web.dto.*;

import java.util.*;

public interface VehicleService {

    VehicleDto getVehicleById(Long id);

    VehicleDto saveVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getAllVehicles();



}
