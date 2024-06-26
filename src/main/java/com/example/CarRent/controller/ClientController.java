package com.example.CarRent.controller;

import com.example.CarRent.entity.Client;
import com.example.CarRent.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping
    public Iterable<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/paging")
    public List<Client> findAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return clientService.findAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
