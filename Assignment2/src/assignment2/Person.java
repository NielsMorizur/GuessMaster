/*
 * Niels Morizur
 * 20265535
 */

package assignment2;

public class Person extends Entity{
	private String gender;
	
	public Person(String name, Date birthDate, String gender, double difficulty) {
		super(name, birthDate, difficulty);
		this.gender = gender;
	}
	
	public Person(Person person) {
		super(person);
		this.gender = person.getGender();
	}
	
	public String getGender() {
		return gender;
	}
	
	public Person clone() {
		return new Person(this);
	}
	
	// Is used to print out detailed description of the entity
	public String toString() {
		return super.toString()+"Gender: "+gender+"\n";
	}

	public String entityType() {
		return "This entity is a person!";
	}
}
