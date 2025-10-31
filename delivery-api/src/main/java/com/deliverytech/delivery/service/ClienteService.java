package com.deliverytech.delivery.service;

import com.deliverytech.delivery.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    public Cliente cadastrar(Cliente cliente) {
        Cliente cliente1 = new Cliente();
        return cliente1;
    }

    public List<Cliente> listarAtivos() {
        return new ArrayList<>();
    }

    public Optional<Cliente> buscarPorId(long id) {
        return Optional.of(new Cliente());
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        return new Cliente();
    }

    public void inativar(Long id) {
    }

    public List<Cliente> buscarPorNome(String nome) {
        return new ArrayList<>();
    }

    public Optional<Cliente> buscarPorEmail(String email) {
        return Optional.of(new Cliente());
    }
}
