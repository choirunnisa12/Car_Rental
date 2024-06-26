package com.example.CarRent.controller;

import com.example.CarRent.entity.Car;
import com.example.CarRent.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Iterable<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/paging")
    public List<Car> findAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return carService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car addCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        return carService.save(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        carService.deleteById(id);
    }

}
