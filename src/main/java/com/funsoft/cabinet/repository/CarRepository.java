package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {

}
