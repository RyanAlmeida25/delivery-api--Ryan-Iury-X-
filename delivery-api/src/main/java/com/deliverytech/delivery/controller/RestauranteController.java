package com.deliverytech.delivery.controller;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public Restaurante cadastrar(@RequestBody Restaurante restaurante) {
        return restauranteService.cadastrar(restaurante);
    }

    @GetMapping
    public List<Restaurante> listarTodos() {
        return restauranteService.listarTodos();
    }

    @GetMapping("/ativos")
    public List<Restaurante> listarAtivos() {
        return restauranteService.listarAtivos();
    }

    @GetMapping("/{id}")
    public Optional<Restaurante> buscarPorId(@PathVariable Long id) {
        return restauranteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Restaurante atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return restauranteService.atualizar(id, restaurante);
    }

    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id) {
        restauranteService.inativar(id);
    }

    @PutMapping("/{id}/ativar")
    public void ativar(@PathVariable Long id) {
        restauranteService.ativar(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Restaurante> buscarPorCategoria(@PathVariable String categoria) {
        return restauranteService.buscarPorCategoria(categoria);
    }
}