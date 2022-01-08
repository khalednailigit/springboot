package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Car;
import com.funsoft.cabinet.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImp implements CarService {

    @Autowired // Automatic write and read ( injection d'un objet)
    CarRepository agent;

    @Override
    public void saveorupdate(Car c) {
        agent.save(c);
    }

    @Override
    public Car getById(long idc) {
        return agent.findById(idc).get();
    }

    @Override
    public void delete(long idc) {
        agent.deleteById(idc);
    }

    @Override
    public List<Car> consulte() {
        return (List<Car>) agent.findAll();
    }
}
