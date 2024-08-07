package hotel.client.hotel_client.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exception.CustomApplicationException;
import hotel.client.hotel_client.repositories.ClientRepository;
import hotel.client.hotel_client.dto.ClientDto;
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

    public ClientDto findByCpf(String cpf) {
        Optional<Client> result = clientRepository.findByCpf(cpf);
        if (result.isPresent()) {
            ClientDto clientDto = new ClientDto(result.get());
            return clientDto;
        } else {
            throw new CustomApplicationException("Client with CPF " + cpf + " not found", HttpStatus.NOT_FOUND);
        }

    }

    public Client createClient(Client client) {

        return clientRepository.save(client);
    }

    public Client updateClient(Integer idInput, Client clientInput) {
        Client client = clientRepository.findById(idInput)
                .orElseThrow(() -> new CustomApplicationException("Client not found", HttpStatus.NOT_FOUND));

        client.setName(clientInput.getName());
        client.setCpf(clientInput.getCpf());

        clientRepository.save(client);

        return client;
    }

    public Client deleteById(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Client not found", HttpStatus.NOT_FOUND));

        clientRepository.deleteById(id);
        return client;

    }

}
