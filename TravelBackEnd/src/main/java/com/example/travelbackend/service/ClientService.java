package com.example.travelbackend.service;

import com.example.travelbackend.entity.Client;
import com.example.travelbackend.repository.ClientRepository;
import com.example.travelbackend.repository.RoleRepository;
import com.example.travelbackend.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Client saveClient(Client client) {
        Message message = new Message ( );
        Optional<Client> clientOptional=clientRepository.findClientByEmail(client.getEmail());

        if (client.getAddress()==null || client.getEmail()==null || client.getPassword()==null ||  client.getFirstName()==null || client.getLastName()==null
        ||client.getPassword()==null)
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


    public Message deleteClient( Long clientId) {
        Message message = new Message (  );
        Boolean exists = clientRepository.existsById(clientId);
        if(!exists)
        {
            message.setState ( "Error" );
            message.setMessage ( "Client not exists" );
            return message;

        } else {
            clientRepository.deleteById(clientId);
            message.setState ( "Success" );
            message.setMessage ( "Client has ben deleted" );
            return message;
        }
    }



}
