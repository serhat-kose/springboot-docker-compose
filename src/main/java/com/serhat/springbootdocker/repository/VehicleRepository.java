package com.serhat.springbootdocker.repository;

import com.serhat.springbootdocker.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
