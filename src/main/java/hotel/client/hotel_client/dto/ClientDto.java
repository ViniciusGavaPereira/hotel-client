package hotel.client.hotel_client.dto;

import java.util.stream.Collectors;
import java.util.List;
import hotel.client.hotel_client.entities.Client;

public class ClientDto {

    private Integer id;
    private String name;
    private String cpf;

    public ClientDto() {
    }

    public ClientDto(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClientDto\nId: " + id + "\nName: " + name + "\nCpf: " + cpf;
    }

    public static List<ClientDto> clientConverter(List<Client> client) {
        return client.stream().map(ClientDto::new).collect(Collectors.toList());
    }

}
