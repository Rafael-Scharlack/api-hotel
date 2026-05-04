package br.com.fiap.api_hotel.repositories;

import br.com.fiap.api_hotel.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
