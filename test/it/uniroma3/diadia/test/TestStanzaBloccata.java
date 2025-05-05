package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBloccata {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanza1;
	private Stanza stanza2;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	
	@Before
	public void setUp() {
		stanza1=new Stanza("Laboratorio");
		stanza2=new Stanza("AulaN10");
		stanzaBloccata=new StanzaBloccata("AulaN12", "nord","chiave");
		attrezzo1= new Attrezzo("chiave", 1);
		attrezzo2= new Attrezzo("spada", 4);
		
		stanza1.impostaStanzaAdiacente("sud", stanzaBloccata);
		stanzaBloccata.impostaStanzaAdiacente("nord", stanza1);
		stanzaBloccata.impostaStanzaAdiacente("est", stanza2);
		stanza2.impostaStanzaAdiacente("ovest", stanzaBloccata);
		
	}
	
	@Test
	public void testStanzaConChiave() {
		stanzaBloccata.addAttrezzo(attrezzo1);
		assertEquals(stanza1,stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaSenzaAttrezzi() {
		assertEquals(stanzaBloccata,stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaConAltriAttrezzi() {
		stanzaBloccata.addAttrezzo(attrezzo2);
		assertEquals(stanzaBloccata,stanzaBloccata.getStanzaAdiacente("nord"));
		assertEquals(stanza2,stanzaBloccata.getStanzaAdiacente("est"));
	}

}
