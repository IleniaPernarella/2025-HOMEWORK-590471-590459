package it.uniroma3.diadia.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class TestComandoPosa {
	private Partita partita;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private ComandoPosa posa;
	private IO io;
	
	@Before
	public void setUp() {
		
		io=new IOConsole();
		partita=new Partita(io);
		attrezzo1=new Attrezzo("spada", 5);
		attrezzo2=new Attrezzo("martello", 4);
		posa= new ComandoPosa();
	}
	
	@Test
	public void testPosaElementoDaBorsaConDueAttrezzi() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo2);
		
		posa.setParametro(attrezzo1.getNome());
		posa.esegui(partita);
		
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(attrezzo1.getNome()));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo2.getNome()));
	}
	
	
	@Test
	public void testPosaElementoDaBorsaConUnAttrezzo() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		
		
		posa.setParametro(attrezzo1.getNome());
		posa.esegui(partita);
		
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(attrezzo1.getNome()));
		assertTrue( partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	public void testPosaElementoDaBorsaVuota() {
		
		
		posa.setParametro(attrezzo1.getNome());
		posa.esegui(partita);
		
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(attrezzo1.getNome()));
		
	}
}
