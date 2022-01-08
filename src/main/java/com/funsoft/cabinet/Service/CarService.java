package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {
    public void saveorupdate(Car c);
    public Car getById(long idc);
    public void delete(long idc);
    public List<Car> consulte();
}
