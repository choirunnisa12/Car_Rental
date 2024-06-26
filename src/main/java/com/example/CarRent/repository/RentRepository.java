package com.example.CarRent.repository;

import com.example.CarRent.entity.Rent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface RentRepository extends PagingAndSortingRepository<Rent, Long> {
        Iterable<Rent> findByClientId(Long id);

        <T> ScopedValue<T> findById(Long id);

        Rent save(Rent rent);

        void deleteById(Long id);

        Iterable<Rent> findAll();
    }
