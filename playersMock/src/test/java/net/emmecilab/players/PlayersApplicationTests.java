package net.emmecilab.players;

import net.emmecilab.players.models.Player;
import net.emmecilab.players.repositories.PlayerRepository;
import net.emmecilab.players.services.PlayerService;
import net.emmecilab.players.services.PlayerServiceDB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@SpringBootTest
@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class PlayersApplicationTests {
	
//	@Test
//	public void contextLoads() {
//	}


    @Spy
    private PlayerServiceDB  test;

    


	@Test
	public void test() {
		List<Player> listaCategorie = new ArrayList<Player>();
		listaCategorie = test.getAllPlayers();
	//	Mockito.when( test.getAllPlayers( ) );
		assertEquals (true, listaCategorie.isEmpty());
		
		
	}
	@Test
	public void whenCreateSpy_thenCreate() {
		Player p= new Player();
		p.setId(1L);
		p.setFirstName("");
	    List spyList = Mockito.spy(new ArrayList());
	    spyList.add("one");
	    Mockito.verify(spyList).add("one");

	    assertEquals(1, spyList.size());
	}

}
