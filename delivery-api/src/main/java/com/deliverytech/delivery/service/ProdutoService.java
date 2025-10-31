package com.deliverytech.delivery.service;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.repository.ProdutoRepository;
import com.deliverytech.delivery.repository.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    // Cadastrar produto vinculado a um restaurante
    public Produto cadastrar(Long restauranteId, Produto produto) {
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
        if (produto.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");
        }
        produto.setRestaurante(restaurante);
        produto.setDisponivel(true);
        return produtoRepository.save(produto);
    }

    // Atualizar produto
    public Produto atualizar(Long id, Produto dadosAtualizados) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
        if (dadosAtualizados.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");
        }
        produto.setNome(dadosAtualizados.getNome());
        produto.setDescricao(dadosAtualizados.getDescricao());
        produto.setPreco(dadosAtualizados.getPreco());
        produto.setCategoria(dadosAtualizados.getCategoria());
        produto.setDisponivel(dadosAtualizados.isDisponivel());
        return produtoRepository.save(produto);
    }

    // Alterar disponibilidade
    public void alterarDisponibilidade(Long id, boolean disponivel) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
        produto.setDisponivel(disponivel);
        produtoRepository.save(produto);
    }

    // Buscar por restaurante
    public List<Produto> listarPorRestaurante(Long restauranteId) {
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
        return produtoRepository.findByRestaurante(restaurante);
    }

    // Buscar produtos disponíveis por restaurante
    public List<Produto> listarDisponiveisPorRestaurante(Long restauranteId) {
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
        return produtoRepository.findByRestauranteAndDisponivelTrue(restaurante);
    }

    // Buscar por categoria
    public List<Produto> buscarPorCategoria(String categoria) {
        return produtoRepository.findByCategoriaIgnoreCase(categoria);
    }

    // Buscar por nome
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Buscar por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
}