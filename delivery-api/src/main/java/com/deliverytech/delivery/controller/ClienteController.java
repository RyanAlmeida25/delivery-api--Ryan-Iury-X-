package com.deliverytech.delivery.controller;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    @GetMapping
    public List<Cliente> listarAtivos() {
        return clienteService.listarAtivos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id) {
        clienteService.inativar(id);
    }
}