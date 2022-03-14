package net.emmecilab.players.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.emmecilab.players.models.Campo;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Long> {


	@Query(nativeQuery = true, value = "SELECT * FROM campi as c JOIN players as p on c.id_player =p.id where nome_campo=?1")
	List<Campo> allCampo(String nomeCampo);

}
