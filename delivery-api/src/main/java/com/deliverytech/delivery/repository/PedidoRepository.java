package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Buscar pedidos por cliente
    List<Pedido> findByCliente(Cliente cliente);

    // Buscar pedidos por status
    List<Pedido> findByStatus(String status);

    // Buscar pedidos por data específica
    List<Pedido> findByDataPedido(LocalDate dataPedido);

    // Buscar pedidos entre duas datas
    List<Pedido> findByDataPedidoBetween(LocalDate inicio, LocalDate fim);

    // Buscar pedidos por cliente e status
    List<Pedido> findByClienteAndStatus(Cliente cliente, String status);

    // Buscar pedidos por cliente e intervalo de datas
    List<Pedido> findByClienteAndDataPedidoBetween(Cliente cliente, LocalDate inicio, LocalDate fim);

    // Buscar pedidos por status e intervalo de datas
    List<Pedido> findByStatusAndDataPedidoBetween(String status, LocalDate inicio, LocalDate fim);

    // Relatório: total de pedidos por cliente
    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.cliente = :cliente")
    Long contarPedidosPorCliente(Cliente cliente);

    // Relatório: valor total de pedidos por cliente em um período
    @Query("SELECT SUM(p.valorTotal) FROM Pedido p WHERE p.cliente = :cliente AND p.dataPedido BETWEEN :inicio AND :fim")
    Double calcularValorTotalPedidosPorCliente(Cliente cliente, LocalDate inicio, LocalDate fim);

    // Relatório: pedidos agrupados por status
    @Query("SELECT p.status, COUNT(p) FROM Pedido p GROUP BY p.status")
    List<Object[]> agruparPedidosPorStatus();
}