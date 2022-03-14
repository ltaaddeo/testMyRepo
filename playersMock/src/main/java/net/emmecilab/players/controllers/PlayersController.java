package net.emmecilab.players.controllers;

import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;

import net.emmecilab.players.PlayersApplication;
import net.emmecilab.players.models.Campo;
import net.emmecilab.players.models.Player;
import net.emmecilab.players.services.PlayerServiceDB;

import org.apache.log4j.spi.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
public class PlayersController {
//	private static final Class<LoggerFactory> logger = LoggerFactory.class;

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(PlayersApplication.class);

	@Autowired
	private PlayerServiceDB playerService;

	@GetMapping("/players")
	public List<Player> getAllPlayers() {
		// ERROR, WARN, INFO, DEBUG, o TRACE

		LOG.info("This is an info message");
		LOG.info("Ciao Laura");
		LOG.info("This is an info message");
		LOG.info("Ciao Laura");
		LOG.debug("PROVA");

		return playerService.getAllPlayers();
	}

	@GetMapping("/players/{id}")
	public Player getPlayer(@PathVariable Long id) {
		return playerService.getPlayer(id);
	}

	@PostMapping("/players")
	// Alternative
	// @RequestMapping(value = "/players", method = RequestMethod.POST)
	public void addPlayer(@RequestBody Player player) {
		playerService.addPlayer(player);
	}

	@RequestMapping(value = "/players/{id}", method = RequestMethod.PUT)
	public void updatePlayer(@PathVariable Long id, @RequestBody Player player) {
		playerService.updatePlayer(id, player);
	}

	@RequestMapping(value = "/players/{id}", method = RequestMethod.DELETE)
	public void deletePlayer(@PathVariable Long id) {
		playerService.deletePlayer(id);
	}

	@GetMapping(value = "/active/{filter}", produces = "application/json")
	public ResponseEntity<List<Player>> listPromoActive(@PathVariable("filter") String filter)  {
				
		List<Player> promo = playerService.selActiveName(filter);

		if (promo == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Player>>(promo, HttpStatus.OK);
	}
	
	@GetMapping(value = "/campi/{filter}", produces = "application/json")
	public List<Campo> listCampi(@PathVariable("filter") String filter)  {
		LOG.info("****** tutti i campi*******");

	
		return playerService.allCampo(filter);
	}

	
}
