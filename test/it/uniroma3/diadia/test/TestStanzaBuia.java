package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {

	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	
	@Before
	public void setUp() {
		stanzaBuia=new StanzaBuia("AulaStudio", "candela");
		attrezzo1= new Attrezzo("candela", 1);
		attrezzo2= new Attrezzo("spada", 4);
	}
	
	@Test
	public void testStanzaBuiaSenzaAttrezzi() {
		assertEquals(stanzaBuia.getDescrizione(),"qui c'è un buio pesto");
	}
	
	@Test
	public void testStanzaBuiaConUnAttrezzo() {
		stanzaBuia.addAttrezzo(attrezzo2);
		assertEquals(stanzaBuia.getDescrizione(),"qui c'è un buio pesto");
	}
	
	@Test
	public void testStanzaBuiaConCandela() {
		stanzaBuia.addAttrezzo(attrezzo1);
		assertNotEquals(stanzaBuia.getDescrizione(),"qui c'è un buio pesto");
		assertEquals(stanzaBuia.getDescrizione(),((Stanza)stanzaBuia).getDescrizione());
	}

}
