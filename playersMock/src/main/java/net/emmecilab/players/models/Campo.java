package net.emmecilab.players.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="campi")
public class Campo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	@Column(name = "nome_campo")
	private String nomeCampo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_player",referencedColumnName = "id")
	private Player player;
	
	public  Campo() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCampo() {
		return nomeCampo;
	}
	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}
//	public Long getIdPlayer() {
//		return idPlayer;
//	}
//	public void setIdPlayer(Long idPlayer) {
//		this.idPlayer = idPlayer;
//	}
//	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}


}
