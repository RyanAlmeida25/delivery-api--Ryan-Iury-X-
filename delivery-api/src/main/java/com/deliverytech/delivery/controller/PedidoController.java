package com.deliverytech.delivery.controller;

import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/cliente/{clienteId}")
    public Pedido criar(@PathVariable Long clienteId, @RequestBody Pedido pedido) {
        return pedidoService.criar(clienteId, pedido);
    }

    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return pedidoService.atualizarStatus(id, status);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> buscarPorCliente(@PathVariable Long clienteId) {
        return pedidoService.buscarPorCliente(clienteId);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }
}