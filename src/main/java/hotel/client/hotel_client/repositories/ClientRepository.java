package hotel.client.hotel_client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel.client.hotel_client.entities.Client;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByNameContaining(String name);

    List<Client> findByCpf(String cpf);

}
