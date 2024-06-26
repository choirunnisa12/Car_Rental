package com.example.CarRent.controller;

import com.example.CarRent.dto.RentDTO;
import com.example.CarRent.entity.Rent;
import com.example.CarRent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rent")
@RestController
public class RentController {

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/{id}")
    public Rent findById(@PathVariable Long id) {
        return rentService.findById(id);
    }

    @GetMapping
    public Iterable<Rent> findAll() {
        return rentService.findAll();
    }

    @GetMapping("/paging")
    public List<Rent> findAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return rentService.findAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rent add(@RequestBody RentDTO rentDto) {
        return rentService.save(rentDto);
    }

    @PutMapping
    public Rent update(@RequestBody RentDTO rentDto) {
        return rentService.save(rentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        rentService.deleteById(id);
    }

    @GetMapping("/clients/{id}")
    public Iterable<Rent> findByClientId(@PathVariable Long id){
        return rentService.findByClientId(id);
    }
}
