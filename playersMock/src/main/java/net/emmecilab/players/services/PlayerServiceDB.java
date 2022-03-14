package net.emmecilab.players.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.emmecilab.players.models.Campo;
import net.emmecilab.players.models.Player;
import net.emmecilab.players.repositories.CampoRepository;
import net.emmecilab.players.repositories.PlayerRepository;

@Service
@Transactional
public class PlayerServiceDB implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private CampoRepository campoRepository;
	
	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
	@Override
	public Player getPlayer(Long id) {
		return playerRepository.getOne(id);
	}
	@Override
	public void addPlayer(Player player) {
		playerRepository.save(player);
	}
	@Override
	public void updatePlayer(Long id, Player player) {
		Player p= playerRepository.getOne(id);
		playerRepository.save(p);
	}
	@Override
	public void deletePlayer(Long id) {
		playerRepository.delete(id);
	}
	@Override
	public List<Player> selActiveName(String Data) {
		return playerRepository.selActiveName(Data);
	}
	@Override
	public List<Campo> allCampo(String nome) {
		return campoRepository.allCampo(nome);
	}


}
