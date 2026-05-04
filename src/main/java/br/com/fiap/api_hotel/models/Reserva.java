package br.com.fiap.api_hotel.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    private String nomeHospede;

    @Column(nullable = false)
    private Integer numeroQuarto;

    @Column(nullable = false)
    private LocalDate dataCheckin;

    @Column(nullable = false)
    private LocalDate dataCheckout;

    @Column(nullable = true)
    private String observacao;
}
