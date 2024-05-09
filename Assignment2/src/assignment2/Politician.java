/*
 * Niels Morizur
 * 20265535
 */

package assignment2;

public class Politician extends Person{
	private String party;
	
	public Politician(String name, Date birthDate, String gender, String party, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.party = party;
	}
	
	public Politician(Politician politician) {
		super(politician);
		this.party = politician.getParty();
	}
	
	public String getParty() {
		return this.party;
	}
	
	public Politician clone() {
		return new Politician(this);
	}
	
	// Is used to print out detailed description of the entity
	public String toString() {
		return super.toString()+"Party: "+party+"\n";
	}
	
	public String entityType() {
		return "This entity is a politician!";
	}
}
