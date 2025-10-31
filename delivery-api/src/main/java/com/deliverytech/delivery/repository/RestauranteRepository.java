package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    // Buscar restaurantes por nome (contendo, ignorando maiúsculas/minúsculas)
    List<Restaurante> findByNomeContainingIgnoreCase(String nome);

    // Buscar restaurantes por categoria
    List<Restaurante> findByCategoriaIgnoreCase(String categoria);

    // Buscar restaurantes ativos
    List<Restaurante> findByAtivoTrue();

    // Buscar restaurantes ativos por categoria
    List<Restaurante> findByAtivoTrueAndCategoriaIgnoreCase(String categoria);

    // Buscar restaurantes ordenados por avaliação (decrescente)
    List<Restaurante> findAllByOrderByAvaliacaoDesc();

    // Buscar restaurantes ativos ordenados por avaliação
    List<Restaurante> findByAtivoTrueOrderByAvaliacaoDesc();

    // Buscar restaurantes por nome ou categoria
    List<Restaurante> findByNomeContainingIgnoreCaseOrCategoriaContainingIgnoreCase(String nome, String categoria);

    // Buscar restaurantes com avaliação acima de um valor específico
    List<Restaurante> findByAvaliacaoGreaterThanEqual(double avaliacaoMinima);

    // Exemplo com @Query: Buscar restaurantes com avaliação acima de X e ativos
    @Query("SELECT r FROM Restaurante r WHERE r.ativo = true AND r.avaliacao >= :avaliacaoMinima")
    List<Restaurante> findRestaurantesAtivosComAvaliacaoMinima(double avaliacaoMinima);
}