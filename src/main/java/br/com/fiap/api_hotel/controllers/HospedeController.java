package br.com.fiap.api_hotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospedeController {

    @GetMapping("/hospedes")
    public String listarHospedes() {
        return "Hóspedes atuais: João Silva, Maria Oliveira, Carlos Souza.";
    }
}