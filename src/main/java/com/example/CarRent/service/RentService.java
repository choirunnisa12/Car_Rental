package com.example.CarRent.service;

import com.example.CarRent.dto.RentDTO;
import com.example.CarRent.entity.Car;
import com.example.CarRent.entity.Client;
import com.example.CarRent.entity.Rent;
import com.example.CarRent.exception.car.CarNotFoundException;
import com.example.CarRent.exception.client.ClientNotFoundException;
import com.example.CarRent.exception.rent.RentNotFoundException;
import com.example.CarRent.repository.CarRepository;
import com.example.CarRent.repository.ClientRepository;
import com.example.CarRent.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentService {

    private final RentRepository rentRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;

    @Autowired
    public RentService(RentRepository rentRepository, ClientRepository clientRepository, CarRepository carRepository) {
        this.rentRepository = rentRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }

    public Rent findById(Long id) {
        return (Rent) rentRepository.findById(id).orElseThrow(() -> new RentNotFoundException(id));
    }

    public Iterable<Rent> findAll() {
        return rentRepository.findAll();
    }

    public List<Rent> findAll(int page, int size) {
        if (size > 0) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Rent> pageResult = rentRepository.findAll(pageable);
            if (pageResult.hasContent()) {
                return pageResult.getContent();
            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public Rent save(RentDTO rentDto) {
        return rentRepository.save(convertDto(rentDto));
    }

    public void deleteById(Long id) {
        rentRepository.deleteById(id);
    }

    public Iterable<Rent> findByClientId(Long id) {
        return rentRepository.findByClientId(id);
    }

    public Rent convertDto(RentDTO rentDto) {
        return Rent.builder()
                .id(rentDto.getId())
                .rentDay(rentDto.getRentDay())
                .rentEnd(rentDto.getRentEnd())
                .car(carRepository.findById(rentDto.getCarId()).orElseThrow(() -> new CarNotFoundException(rentDto.getCarId())))
                .client((Client) clientRepository.findById(rentDto.getClientId()).orElseThrow(() -> new ClientNotFoundException(rentDto.getClientId())))
                .build();
    }
}
