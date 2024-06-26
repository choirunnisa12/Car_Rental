package com.example.CarRent.service;

import com.example.CarRent.entity.Car;
import com.example.CarRent.exception.car.CarNotFoundException;
import com.example.CarRent.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    public Iterable<Car> findAll() {
        return carRepository.findAll(Sort.by(Sort.Direction.ASC, "brand", "model"));
    }

    public List<Car> findAll(int page, int size) {
        if (size > 0) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Car> pageResult = carRepository.findAll(pageable);
            if (pageResult.hasContent()) {
                return pageResult.getContent();
            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();

        }
    } public Car save(Car car) {
        return carRepository.save(car);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

}
