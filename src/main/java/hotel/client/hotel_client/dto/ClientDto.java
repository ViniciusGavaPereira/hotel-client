package hotel.client.hotel_client.dto;

import java.util.stream.Collectors;
import java.util.List;
import hotel.client.hotel_client.entities.Client;

public class ClientDto {

    private String name;
    private String cpf;

    public ClientDto() {
    }

    public ClientDto(Client client) {
        name = client.getName();
        cpf = client.getCpf();
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
        return "ClientDto [name=" + name + ", cpf=" + cpf + "]";
    }

    public static List<ClientDto> inventoryConverter(List<Client> client) {
        return client.stream().map(ClientDto::new).collect(Collectors.toList());
    }

}
