package net.zabalburu.ofertas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.zabalburu.ofertas.modelo.Oferta;

@Repository
public interface OfertasRepositorio extends JpaRepository<Oferta, Integer> {
	@Query("Select o From Oferta o Where o.activa = TRUE and o.fecha >= CURRENT_TIMESTAMP")
	List<Oferta> getOfertasVigentes();
}
