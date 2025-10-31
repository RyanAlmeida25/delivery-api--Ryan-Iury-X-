package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Buscar produtos por restaurante
    List<Produto> findByRestaurante(Restaurante restaurante);

    // Buscar produtos por categoria
    List<Produto> findByCategoriaIgnoreCase(String categoria);

    // Buscar produtos disponíveis
    List<Produto> findByDisponivelTrue();

    // Buscar produtos disponíveis por restaurante
    List<Produto> findByRestauranteAndDisponivelTrue(Restaurante restaurante);

    // Buscar produtos por restaurante e categoria
    List<Produto> findByRestauranteAndCategoriaIgnoreCase(Restaurante restaurante, String categoria);

    // Buscar produtos disponíveis por restaurante e categoria
    List<Produto> findByRestauranteAndCategoriaIgnoreCaseAndDisponivelTrue(Restaurante restaurante, String categoria);

    // Buscar produtos por nome (contendo, ignorando maiúsculas/minúsculas)
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    // Exemplo com @Query: Buscar produtos disponíveis com nome parcial
    @Query("SELECT p FROM Produto p WHERE p.disponivel = true AND LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Produto> buscarProdutosDisponiveisPorNome(String nome);
}