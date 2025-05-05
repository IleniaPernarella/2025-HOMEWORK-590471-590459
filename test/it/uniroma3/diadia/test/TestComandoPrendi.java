package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class TestComandoPrendi {

	private Partita partita;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private ComandoPrendi prendi;
	private IO io;
	
	@Before
	public void setUp() {
		
		io=new IOConsole();
		partita=new Partita(io);
		attrezzo1=new Attrezzo("lancia", 5);
		attrezzo2=new Attrezzo("spada", 4);
		attrezzo3=new Attrezzo("incudine", 10);
		prendi= new ComandoPrendi();
	}
	
	@Test
	public void testPrendiAttrezzoDaStanzaVuota() {
		prendi.setParametro(attrezzo1.getNome());
		prendi.esegui(partita);
		
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo1.getNome()));
		
	}
	
	@Test
	public void testPrendiAttrezzoDaStanzaConDueAttrezzi() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		partita.getStanzaCorrente().addAttrezzo(attrezzo2);
		
		prendi.setParametro(attrezzo1.getNome());
		prendi.esegui(partita);
		
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo1.getNome()));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo2.getNome()));
		
	}
	
	@Test
	public void testBorsaPiena() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo3);
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		
		prendi.setParametro(attrezzo1.getNome());
		prendi.esegui(partita);
		
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo1.getNome()));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo3.getNome()));
	}

}
