package it.uniroma3.diadia.test;

import static org.junit.Assert.*; 

import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

public class TestAccettazione {

	@Test
    public void testPartitaFineImmediata() {
        String[] comandi = {"fine"};
        IOSimulator ioSim = new IOSimulator(comandi);
        new DiaDia(ioSim).gioca();

        String[] uscita = ioSim.getmessaggiMostrati();
        assertTrue(uscita.length > 0);
        assertTrue(uscita[0].contains("Ti trovi nell'Universita'"));
        assertEquals("Grazie di aver giocato!", uscita[uscita.length - 1]);
    }
	
	@Test
    public void testPartitaVintaSubito() {
        String[] comandi = {"vai nord"};
        IOSimulator ioSim = new IOSimulator(comandi);
        new DiaDia(ioSim).gioca();

        String[] uscita = ioSim.getmessaggiMostrati();
        String[] input = ioSim.getRigheLette();
        assertTrue(uscita.length > 0);
        assertTrue(input[0].contains("vai nord"));
        assertEquals("Hai vinto!", uscita[uscita.length - 1]);
    }
	
	@Test
    public void testComandoNonValido() {
        String[] comandi = {"s","fine"};
        IOSimulator ioSim = new IOSimulator(comandi);
        new DiaDia(ioSim).gioca();

        String[] uscita = ioSim.getmessaggiMostrati();
        String[] input = ioSim.getRigheLette();
        assertTrue(uscita.length > 0);
        assertTrue(input[0].contains("s"));
        assertEquals("Comando non valido", uscita[uscita.length - 2]);
    }

}
