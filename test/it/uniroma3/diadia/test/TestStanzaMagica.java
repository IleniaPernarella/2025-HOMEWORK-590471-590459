package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaMagica {

	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;
	
	@Before
	public void setUp() {
		stanzaMagica=new StanzaMagica("AulaN9");
		attrezzo1= new Attrezzo("candela", 1);
		attrezzo2= new Attrezzo("spada", 4);
		attrezzo3= new Attrezzo("scala", 2);
		attrezzo4= new Attrezzo("piccone", 2);
	}
	
	@Test
	public void testStanzaConUnAttrezzo() {
		stanzaMagica.addAttrezzo(attrezzo1);
		assertEquals(stanzaMagica.getAttrezzo(attrezzo1.getNome()).getPeso(),attrezzo1.getPeso());
		assertEquals(stanzaMagica.getAttrezzo(attrezzo1.getNome()).getNome(),attrezzo1.getNome());
	}
	
	@Test
	public void testStanzaConDueAttrezzi() {
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo2);
		assertEquals(stanzaMagica.getAttrezzo(attrezzo1.getNome()).getPeso(),attrezzo1.getPeso());
		assertEquals(stanzaMagica.getAttrezzo(attrezzo1.getNome()).getNome(),attrezzo1.getNome());
		assertEquals(stanzaMagica.getAttrezzo(attrezzo2.getNome()).getPeso(),attrezzo2.getPeso());
		assertEquals(stanzaMagica.getAttrezzo(attrezzo2.getNome()).getNome(),attrezzo2.getNome());
	}
	
	@Test
	public void testStanzaConAttrezziEComportamentoMagico() {
		stanzaMagica.addAttrezzo(attrezzo1);
		stanzaMagica.addAttrezzo(attrezzo2);
		stanzaMagica.addAttrezzo(attrezzo3);
		stanzaMagica.addAttrezzo(attrezzo4);
		String nomeInvertito = new StringBuilder(attrezzo4.getNome()).reverse().toString();
		 Attrezzo magico = stanzaMagica.getAttrezzo(nomeInvertito);

		assertEquals(stanzaMagica.getAttrezzo(attrezzo3.getNome()).getPeso(),attrezzo3.getPeso());
		assertEquals(stanzaMagica.getAttrezzo(attrezzo3.getNome()).getNome(),attrezzo3.getNome());
		assertEquals(stanzaMagica.getAttrezzo(nomeInvertito).getPeso(),attrezzo4.getPeso()*2);
		assertEquals(nomeInvertito, magico.getNome());
		
		
	}

}
