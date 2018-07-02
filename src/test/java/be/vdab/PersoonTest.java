package be.vdab;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersoonTest {

	@Test
	public void eenPersoonMet1VoornaamIsOK() {
		new Persoon("Jimmy");
	}
	
	@Test
	public void eenPersoonMetMeerdereVoornamenIsOK() {
		new Persoon("Sonja", "Marleen");
	}
	
	@Test
	public void eenPersoonMetMeerdereKerenDezelfdeVoornaamGeeftGeenFoutmeldingOmdatEenSetGeenDubbelElementenKanBevatten() {
		new Persoon("Sonja", "Sonja"); 
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonMetNullAlsParameterIsNietToegelaten() {
		new Persoon((String[])null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonZonderVoornaamIsNietToegelaten() {
		new Persoon();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonWaarvanEenVanDeVoornamenNullIsIsNietToegelaten() {
		new Persoon(null, "Jimmy");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonWaarvanEenVanDeVoornamenEenLegeStringIsIsNietToegelaten() {
		new Persoon("Jimmy", "", "Bart");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonWaarvanEenVanDeVoornamenEenSpatieIsIsNietToegelaten() {
		new Persoon("Jimmy", " ", "Bart");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonMetAlsVoornaamEenLegeStringIsNietToegelaten() {
		new Persoon("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonMetAlsVoornaamEenSpatieIsNietToegelaten() {
		new Persoon(" ");
	}
	@Test
	public void toStringMoetAlleVoornamenTerugevenGescheidenDoorEenSpatieEnInZelfdeVolgorde() {
		String firstnames = "Sonja Marleen";
		assertEquals(firstnames, new Persoon("Sonja", "Marleen").toString());
	}
	
	@Test
	public void toStringGeeftDeVoornaamTerugAlsErMaar1VoornaamIs() {
		String firstname = "Sonja";
		assertEquals(firstname, new Persoon("Sonja").toString());
	}

}
