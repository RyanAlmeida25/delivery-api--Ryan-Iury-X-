package com.deliverytech.delivery.service;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Cadastro com validação de e-mail
    public Cliente cadastrar(Cliente cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }
        cliente.setAtivo(true);
        return clienteRepository.save(cliente);
    }

    // Listar clientes ativos
    public List<Cliente> listarAtivos() {
        return clienteRepository.findByAtivoTrue();
    }

    // Buscar cliente por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Atualizar dados do cliente
    public Cliente atualizar(Long id, Cliente dadosAtualizados) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        cliente.setNome(dadosAtualizados.getNome());
        cliente.setTelefone(dadosAtualizados.getTelefone());
        // outros campos que desejar atualizar...
        return clienteRepository.save(cliente);
    }

    // Inativar cliente
    public void inativar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        cliente.setAtivo(false);
        clienteRepository.save(cliente);
    }

    // Buscar clientes por nome
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Buscar cliente por e-mail
    public Optional<Cliente> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}