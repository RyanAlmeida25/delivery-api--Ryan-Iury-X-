package com.deliverytech.delivery.controller;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/restaurante/{restauranteId}")
    public Produto cadastrar(@PathVariable Long restauranteId, @RequestBody Produto produto) {
        return produtoService.cadastrar(restauranteId, produto);
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<Produto> listarPorRestaurante(@PathVariable Long restauranteId) {
        return produtoService.listarPorRestaurante(restauranteId);
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @PutMapping("/{id}/disponibilidade")
    public void alterarDisponibilidade(@PathVariable Long id, @RequestParam boolean disponivel) {
        produtoService.alterarDisponibilidade(id, disponivel);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Produto> buscarPorCategoria(@PathVariable String categoria) {
        return produtoService.buscarPorCategoria(categoria);
    }

    @GetMapping("/nome/{nome}")
    public List<Produto> buscarPorNome(@PathVariable String nome) {
        return produtoService.buscarPorNome(nome);
    }
}