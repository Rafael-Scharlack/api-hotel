package br.com.fiap.api_hotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {

    @GetMapping("/reservas")
    public String listarReservas() {
        return "Lista de reservas: Quarto 101 (Ocupado), Quarto 102 (Livre).";
    }

    @GetMapping("/reservas/disponibilidade")
    public String checarDisponibilidade() {
        return "Temos 15 quartos disponíveis para o próximo final de semana.";
    }
}