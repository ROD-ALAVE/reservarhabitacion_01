package com.example.clase2.Infraestructure;

import com.example.clase2.Domain.ClienteModels;
import com.example.clase2.Services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteServices;

    @GetMapping
    public List<ClienteModels> getAllClientes() {
        return clienteServices.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModels> getClienteById(@PathVariable Long id) {
        return clienteServices.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClienteModels createCliente(@RequestBody ClienteModels cliente) {
        return clienteServices.createCliente(cliente);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ClienteModels> updateCliente(@PathVariable Long id, @RequestBody ClienteModels clienteDetails) {
//        try {
//            ClienteModels updatedCliente = clienteServices.updateCliente(id, clienteDetails);
//            return ResponseEntity.ok(updatedCliente);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        try {
            clienteServices.deleteCliente(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
