    package com.deliverytech.delivery.service;

    import com.deliverytech.delivery.entity.Restaurante;
    import com.deliverytech.delivery.repository.RestauranteRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    @Transactional
    public class RestauranteService {

        @Autowired
        private RestauranteRepository restauranteRepository;

        // Cadastrar restaurante
        public Restaurante cadastrar(Restaurante restaurante) {
            restaurante.setAtivo(true);
            return restauranteRepository.save(restaurante);
        }

        // Atualizar restaurante
        public Restaurante atualizar(Long id, Restaurante dadosAtualizados) {
            Restaurante restaurante = restauranteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
            restaurante.setNome(dadosAtualizados.getNome());
            restaurante.setCategoria(dadosAtualizados.getCategoria());
            restaurante.setAvaliacao(dadosAtualizados.getAvaliacao());
            return restauranteRepository.save(restaurante);
        }

        // Inativar restaurante
        public void inativar(Long id) {
            Restaurante restaurante = restauranteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
            restaurante.setAtivo(false);
            restauranteRepository.save(restaurante);
        }

        // Ativar restaurante
        public void ativar(Long id) {
            Restaurante restaurante = restauranteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
            restaurante.setAtivo(true);
            restauranteRepository.save(restaurante);
        }

        // Buscar por ID
        public Optional<Restaurante> buscarPorId(Long id) {
            return restauranteRepository.findById(id);
        }

        // Listar todos os restaurantes
        public List<Restaurante> listarTodos() {
            return restauranteRepository.findAll();
        }

        // Listar restaurantes ativos
        public List<Restaurante> listarAtivos() {
            return restauranteRepository.findByAtivoTrue();
        }

        // Buscar por nome
        public List<Restaurante> buscarPorNome(String nome) {
            return restauranteRepository.findByNomeContainingIgnoreCase(nome);
        }

        // Buscar por categoria
        public List<Restaurante> buscarPorCategoria(String categoria) {
            return restauranteRepository.findByCategoriaIgnoreCase(categoria);
        }

        // Listar ativos ordenados por avaliação
        public List<Restaurante> listarAtivosOrdenadosPorAvaliacao() {
            return restauranteRepository.findByAtivoTrueOrderByAvaliacaoDesc();
        }
    }