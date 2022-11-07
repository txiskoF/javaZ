package net.zabalburu.avisos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.zabalburu.avisos.modelo.Aviso;

@Repository
public interface AvisoRepositorio extends JpaRepository<Aviso, Integer> {
	
	@Query("Select a FROM Aviso a Order By a.fecha DESC")
	List<Aviso> getAvisos();

}
