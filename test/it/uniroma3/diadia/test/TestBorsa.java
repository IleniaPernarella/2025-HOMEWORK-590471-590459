package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestBorsa {

	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo10;
	private Borsa borsa;
	
	@Before
	public void setUp() {
		attrezzo= new Attrezzo("sasso", 3);
		borsa=new Borsa(10);
	}
	
	@Test
	public void testAggiuntaAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo,borsa.getAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testBorsaPiena() {
		attrezzo10=new Attrezzo("spada",10);
		borsa.addAttrezzo(attrezzo10);
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testRimuoviAttrezzo() {
		attrezzo2=new Attrezzo("torcia", 2);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo2);
		borsa.removeAttrezzo(attrezzo.getNome());
		assertTrue(borsa.hasAttrezzo(attrezzo2.getNome()));
		assertFalse(borsa.hasAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testBorsaVuota() {
		borsa.addAttrezzo(attrezzo);
		borsa.removeAttrezzo(attrezzo.getNome());
		assertTrue(borsa.isEmpty());
	}

}
