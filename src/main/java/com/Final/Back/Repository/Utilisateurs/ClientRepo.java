package com.Final.Back.Repository.Utilisateurs;

import com.Final.Back.Modles.Utilisateurs.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    @Override
    List<Client> findAll();
    Client findByCin(Long cin);

}
