/*
 * Niels Morizur
 * 20265535
 */

package assignment2;

public class Country extends Entity {
	private String capital;
	
	public Country(String name, Date birthDate, String capital, double difficulty) {
		super(name, birthDate, difficulty);
		this.capital = capital;
	}
	
	public Country(Country country) {
		super(country);
		capital = country.getCapital();
	}
	
	public String getCapital() {
		return capital;
	}
	
	public String entityType() {
		return "This entity is a country!";
	}

	public Country clone() {
		return new Country(this);
	}
	
	// Is used to print out detailed description of the entity
	public String toString() {
		return super.toString()+"Capital: "+capital+"\n";
	}
}
