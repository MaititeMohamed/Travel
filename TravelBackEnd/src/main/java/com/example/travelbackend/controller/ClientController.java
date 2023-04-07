package com.example.travelbackend.controller;

import com.example.travelbackend.entity.Client;
import com.example.travelbackend.entity.User;
import com.example.travelbackend.service.ClientService;
import com.example.travelbackend.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    public User AddUser(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }



    @DeleteMapping("/deleteClientById/{id}")
    public Integer deleteClientById(@PathVariable("id") Long id){
        return clientService.deleteClientById(id);
    }


    @PutMapping("/updateClient")
    public  Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }
}

