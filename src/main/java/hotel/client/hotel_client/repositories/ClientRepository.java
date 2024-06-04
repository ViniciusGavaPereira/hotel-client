package hotel.client.hotel_client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel.client.hotel_client.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
