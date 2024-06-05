package hotel.client.hotel_client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.client.hotel_client.repositories.ClientRepository;
import hotel.client.hotel_client.entities.Client;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByNameContaining(name);
    }

    public List<Client> findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

}
