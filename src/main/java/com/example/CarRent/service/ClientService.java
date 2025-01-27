package com.example.CarRent.service;

import com.example.CarRent.entity.Client;
import com.example.CarRent.exception.client.ClientNotFoundException;
import com.example.CarRent.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findById(Long id) {
        return (Client) clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }

    public List<Client> findAll(int page, int size) {
        if (size > 0) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Client> pageResult = clientRepository.findAll(pageable);
            if (pageResult.hasContent()) {
                return pageResult.getContent();
            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}

