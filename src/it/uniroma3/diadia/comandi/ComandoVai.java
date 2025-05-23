package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{

	private String direzione;


	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}


	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Stanza prossimaStanza= null;
		
		if(direzione==null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		
		if(prossimaStanza==null) {
			System.out.println("Direzione inesistente");
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		
		System.out.println(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}


	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}


	
}
