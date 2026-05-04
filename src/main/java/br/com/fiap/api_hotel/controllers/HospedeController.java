package br.com.fiap.api_hotel.controllers;

import br.com.fiap.api_hotel.models.Hospede;
import br.com.fiap.api_hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping
    public List<Hospede> listarTodos() {
        return hospedeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> buscarPorId(@PathVariable Long id) {
        Optional<Hospede> hospede = hospedeRepository.findById(id);
        return hospede.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hospede criar(@RequestBody Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> atualizar(@PathVariable Long id, @RequestBody Hospede dadosNovos) {
        Optional<Hospede> optional = hospedeRepository.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();

        Hospede hospede = optional.get();
        hospede.setNome(dadosNovos.getNome());
        hospede.setEmail(dadosNovos.getEmail());
        hospede.setCpf(dadosNovos.getCpf());
        hospede.setTelefone(dadosNovos.getTelefone());
        hospede.setObservacao(dadosNovos.getObservacao());

        return ResponseEntity.ok(hospedeRepository.save(hospede));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!hospedeRepository.existsById(id)) return ResponseEntity.notFound().build();
        hospedeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}