package com.example.travelbackend.controller;

import com.example.travelbackend.entity.Client;
import com.example.travelbackend.entity.User;
import com.example.travelbackend.service.ClientService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;



    @GetMapping("/getClientById/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Long id){ return  clientService.getClientById(id);}
    @GetMapping("/getAllClient")
    public List<Client> getAllClient(){return clientService.getAllClient();}
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

