package com.deliverytech.delivery.service;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.repository.ClienteRepository;
import com.deliverytech.delivery.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar pedido
    public Pedido criar(Long clienteId, Pedido pedido) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus("PENDENTE");
        calcularValorTotal(pedido);
        return pedidoRepository.save(pedido);
    }

    // Calcular valor total do pedido
    private void calcularValorTotal(Pedido pedido) {
        // Simulação: valor fixo ou baseado em itens (se houver)
        pedido.setValorTotal(100.0); // ajustar conforme lógica real
    }

    // Atualizar status do pedido
    public Pedido atualizarStatus(Long id, String novoStatus) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }

    // Buscar por cliente
    public List<Pedido> buscarPorCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        return pedidoRepository.findByCliente(cliente);
    }

    // Buscar por status
    public List<Pedido> buscarPorStatus(String status) {
        return pedidoRepository.findByStatus(status);
    }

    // Buscar por data
    public List<Pedido> buscarPorData(LocalDate data) {
        return pedidoRepository.findByDataPedido(data);
    }

    // Buscar por intervalo de datas
    public List<Pedido> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return pedidoRepository.findByDataPedidoBetween(inicio, fim);
    }

    // Buscar por cliente e status
    public List<Pedido> buscarPorClienteEStatus(Long clienteId, String status) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        return pedidoRepository.findByClienteAndStatus(cliente, status);
    }

    // Buscar por cliente e período
    public List<Pedido> buscarPorClienteEPeriodo(Long clienteId, LocalDate inicio, LocalDate fim) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        return pedidoRepository.findByClienteAndDataPedidoBetween(cliente, inicio, fim);
    }

    // Buscar por status e período
    public List<Pedido> buscarPorStatusEPeriodo(String status, LocalDate inicio, LocalDate fim) {
        return pedidoRepository.findByStatusAndDataPedidoBetween(status, inicio, fim);
    }

    // Buscar por ID
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }
}