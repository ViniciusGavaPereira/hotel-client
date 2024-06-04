package hotel.client.hotel_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Client> findAll() {
        return clientService.findAll();
    }
}
