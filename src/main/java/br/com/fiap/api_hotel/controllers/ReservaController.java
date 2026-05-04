package br.com.fiap.api_hotel.controllers;

import br.com.fiap.api_hotel.models.Reserva;
import br.com.fiap.api_hotel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id, @RequestBody Reserva dadosNovos) {
        Optional<Reserva> optional = reservaRepository.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();

        Reserva reserva = optional.get();
        reserva.setNomeHospede(dadosNovos.getNomeHospede());
        reserva.setNumeroQuarto(dadosNovos.getNumeroQuarto());
        reserva.setDataCheckin(dadosNovos.getDataCheckin());
        reserva.setDataCheckout(dadosNovos.getDataCheckout());
        reserva.setObservacao(dadosNovos.getObservacao());

        return ResponseEntity.ok(reservaRepository.save(reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!reservaRepository.existsById(id)) return ResponseEntity.notFound().build();
        reservaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}