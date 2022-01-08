package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Car;
import com.funsoft.cabinet.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CarRest {
    @Autowired
    CarService agent ;

    @GetMapping("/car")
    public List<Car> List_med() {
        return agent.consulte();
    }

    @PostMapping("/car")
    public String addcar(@RequestBody Car car) {
        agent.saveorupdate(car);
        return "sucsess";
    }

}
