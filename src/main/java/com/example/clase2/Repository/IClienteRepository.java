package com.example.clase2.Repository;

import com.example.clase2.Domain.ClienteModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteModels, Long> {


}
