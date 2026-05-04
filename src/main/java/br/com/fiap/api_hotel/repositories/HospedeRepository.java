package br.com.fiap.api_hotel.repositories;

import br.com.fiap.api_hotel.models.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
}
