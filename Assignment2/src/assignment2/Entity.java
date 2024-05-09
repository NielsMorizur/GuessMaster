/*
 * Niels Morizur
 * 20265535
 */

package assignment2;

public abstract class Entity implements Cloneable{
	private String name;
	private Date born;
	private double difficulty;
	
	public Entity(String name, Date birthDate, double difficulty) {
		this.name = name;
		this.born = new Date(birthDate); //no privacy leak
		this.difficulty = difficulty;
	}
	
	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born); //no privacy leak
		this.difficulty = entity.getDifficulty();
	}

	public String getName() {
		return name;
	}

	public Date getBorn() {
		return new Date(born);
	}
	
	public double getDifficulty() {
		return difficulty;
	}
	
	// Returns the amount of tickets won for guessing the entity of a certain difficulty
	public int getAwardedTicketNumber() {
		return (int) (difficulty*100);
	}
	
	public abstract String entityType();
	
	public abstract Entity clone();
	
	// Called before each round
	public String welcomeMessage() {
		return "**********************************\n"+"Welcome! Let's start the game! "+entityType();
	}
	
	//Called after each round
	public String closingMessage() {
		return "**********************************\n"+"Congratulations! The detailed information of the entity you guessed is:\n"+toString();
	}
	
	public String toString() {
		return "Name: "+name+"\n"+"Born at: "+born.toString()+"\n";
	}
}
