package com.example.CarRent.repository;

import com.example.CarRent.entity.Car;
import com.example.CarRent.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    <T> ScopedValue<T> findById(long clientId);

    Client save(Client client);

    void deleteById(Long id);
}
