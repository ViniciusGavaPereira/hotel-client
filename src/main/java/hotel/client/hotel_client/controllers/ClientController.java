package hotel.client.hotel_client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.CustomApplicationException;
import hotel.client.hotel_client.dto.ClientDto;
import hotel.client.hotel_client.entities.Client;
import java.util.List;

import hotel.client.hotel_client.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/all")
    public List<ClientDto> findAll() {

        List<Client> result = clientService.findAll();
        return ClientDto.inventoryConverter(result);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ClientDto>> findByName(@PathVariable String name) {
        List<Client> result = clientService.findByName(name);
        return new ResponseEntity<List<ClientDto>>(ClientDto.inventoryConverter(result), HttpStatus.OK);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<ClientDto>> findByCpf(@PathVariable String cpf) {
        List<Client> result = clientService.findByCpf(cpf);
        return new ResponseEntity<List<ClientDto>>(ClientDto.inventoryConverter(result), HttpStatus.OK);
    }

    @PostMapping("/create/v1/")
    public ResponseEntity<?> createClient(@RequestBody Client clientInput) {

        clientService.createClient(clientInput);

        return new ResponseEntity<>(new ClientDto(clientInput).toString(),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Integer id, @RequestBody Client client) {

        try {
            Client result = clientService.updateClient(id, client);
            return new ResponseEntity<ClientDto>(new ClientDto(result), HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            throw new CustomApplicationException("Client not found", HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
        clientService.deleteById(id);
        return new ResponseEntity<>("Client was deleted", HttpStatus.ACCEPTED);
    }

}
