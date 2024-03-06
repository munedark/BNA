package com.Final.Back.Repository;

import com.Final.Back.Modles.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    Client save(Client client);
}
