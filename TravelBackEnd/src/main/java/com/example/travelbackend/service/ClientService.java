package com.example.travelbackend.service;

import com.example.travelbackend.entity.Client;
import com.example.travelbackend.repository.ClientRepository;
import com.example.travelbackend.repository.RoleRepository;
import com.example.travelbackend.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }

    public List<Client> getAllClient(){return  clientRepository.findAll();}
    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }
    public Optional<Client> getClientByEmail(String email){
        return clientRepository.findClientByEmail(email);
    }
    public Client saveClient(Client client) {
        Message message = new Message ( );
        Optional<Client> clientOptional=clientRepository.findClientByEmail(client.getEmail());

        if (client.getAddress()==null || client.getEmail()==null || client.getPassword()==null ||  client.getFirstName()==null || client.getLastName()==null
        ||client.getPassword()==null ||client.getPhoneNumber()==null )
        {
            message.setState ( "Error" );
            message.setMessage ( "fill  information's " );
            client.setMessage ( message );
            return client;

        }
        if (clientOptional.isPresent())
        {
            message.setState ( "Error" );
            message.setMessage ( "email already  exist" );
            client.setMessage ( message );
            return client;

        }

        message.setState ( "Success" );
        message.setMessage ( "Client has ben created" );
        client.setMessage(message);
        client.setRole(roleRepository.getRoleByRoleName("Client"));
        clientRepository.save(client);
        return client;
    }


    public Integer deleteClientById(Long id){
        boolean exists =clientRepository.existsById(id);
        if(!exists){
            return  -1;
        }else {

            try {
                clientRepository.deleteById(id);
                return 1;
            } catch (Exception e){
                return 0;
            }
        }
    }



    public Client updateClient(Client client) {
        Message message = new Message();

        // check if client exists
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if (!clientOptional.isPresent()) {
            message.setState("Error");
            message.setMessage("Client not found");
            client.setMessage(message);
            return client;
        }

        // check if required fields are not null
        if (client.getAddress() == null || client.getEmail() == null || client.getFirstName() == null ||
                client.getLastName() == null || client.getPassword() == null ||client.getPhoneNumber()==null  ||client.getFirstName().isEmpty()
                ||client.getAddress().isEmpty() ||client.getEmail().isEmpty() ||client.getLastName().isEmpty()
                ||client.getPassword().isEmpty()  ||client.getPhoneNumber().isEmpty()
        ) {
            message.setState("Error");
            message.setMessage("Please fill in all required fields");
            client.setMessage(message);
            return client;
        }

        // check if email is not already taken by another client
        Optional<Client> existingClientOptional = clientRepository.findClientByEmail(client.getEmail());
        if (existingClientOptional.isPresent() && !existingClientOptional.get().getUserId().equals(clientOptional.get().getUserId())) {
            message.setState("Error");
            message.setMessage("Email is already taken");
            client.setMessage(message);
            return client;
        }

        // update client information
        Client existingClient = clientOptional.get();
        existingClient.setAddress(client.getAddress());
        existingClient.setEmail(client.getEmail());
        existingClient.setPhoneNumber(client.getPhoneNumber());
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setPassword(client.getPassword());
        clientRepository.save(existingClient);

        message.setState("Success");
        message.setMessage("Client information updated");
        client.setMessage(message);
        return client;
    }



}
