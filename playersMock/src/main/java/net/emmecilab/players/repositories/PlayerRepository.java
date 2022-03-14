package net.emmecilab.players.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.emmecilab.players.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM players  WHERE first_name = ?1")
	List<Player> selActiveName(String nome);

//	@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//	Players findUserByStatusAndName(Integer status, String name);


}
