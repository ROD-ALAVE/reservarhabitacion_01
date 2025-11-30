package com.example.clase2.Services;

import com.example.clase2.Domain.ClienteModels;
import com.example.clase2.Repository.IClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    private final IClienteRepository clienteRepository;


    public List<ClienteModels> getAllClientes() {
        return clienteRepository.findAll();
    }
    public Optional<ClienteModels> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }
    public ClienteModels createCliente(ClienteModels cliente) {
//        // Validar que el email no exista
//        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
//            throw new RuntimeException("El email ya está registrado");
//        }
//        // Validar que el documento no exista
//        if (clienteRepository.findByDocumentoIdentidad(cliente.getDocumentoIdentidad()).isPresent()) {
//            throw new RuntimeException("El documento de identidad ya está registrado");
//        }
        return clienteRepository.save(cliente);
    }
    public void deleteCliente(Long id) {
        ClienteModels cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteRepository.deleteById(id);
    }
}
