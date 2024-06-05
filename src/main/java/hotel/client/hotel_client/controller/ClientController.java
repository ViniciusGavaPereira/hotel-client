package hotel.client.hotel_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.client.hotel_client.dto.ClientDto;
import hotel.client.hotel_client.entities.Client;
import java.util.List;

import hotel.client.hotel_client.services.ClientService;

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

}
