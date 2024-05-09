/*
 * Niels Morizur
 * 20265535
 */

package assignment2;

import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
	private int numOfEntities;
	private Entity[] entities; 
	private int totalTickets;
	
	public GuessMaster() {
		numOfEntities = 0;
		entities = new Entity[100];
		totalTickets = 0;
	}
	
	// Adds the parameter entity by using the clone method in whichever derived class the entity is
	public void addEntity(Entity entity) {
		entities[numOfEntities++] = entity.clone();
	}
	
	// Starts the game with the entity at the given array index
	public void playGame(int entityId) {
		Entity entity = entities[entityId];
		playGame(entity);
	}
	
	// Starts the game with the given entity
	public void playGame(Entity entity) {
		System.out.println(entity.welcomeMessage());
		System.out.printf("\nGuess %s's birthday\n", entity.getName());
		System.out.println("(mm/dd/yyyy)");
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String answer = scanner.nextLine();
			answer = answer.replace("\n", "").replace("\r", "");
			
			// User can exit the game at any point with quit or exit
			if (answer.equalsIgnoreCase("quit") || answer.equalsIgnoreCase("exit")) {
				System.exit(0);
			}

			Date date = new Date(answer);
			
			// If the guess was a date that precedes the correct answer
			if (date.precedes(entity.getBorn())) {
				System.out.println("Incorrect. Try a later date.");
			} else if (entity.getBorn().precedes(date)) { // If the correct answer precedes the guess
				System.out.println("Incorrect. Try an earlier date.");
			} else { // If the guess is correct, award tickets based on the difficulty of the entity
				int roundTickets = entity.getAwardedTicketNumber();
				totalTickets += roundTickets;
				System.out.println("*************Bingo!***************");
				System.out.printf("You won "+roundTickets+" tickets in this round."+"\n");
				System.out.println("The total number of your tickets is "+totalTickets+".");
				System.out.print(entity.closingMessage());
				break;
			}
		}
	}
	
	// Starts the game with a random entity array index
	public void playGame() {
		while (true) {
			int entityId = genRandomEntityId();
			playGame(entityId);
		}
	}

	public int genRandomEntityId() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(numOfEntities);
	}

	public static void main(String[] args) {
		System.out.println("=========================\n");
		System.out.println("     GuessMaster 2.0 \n");
		System.out.println("=========================\n");
		Politician jTrudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
		Singer cDion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
		Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1);
		Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.", 0.1);

		GuessMaster gm = new GuessMaster();
		gm.addEntity(jTrudeau);
		gm.addEntity(cDion);
		gm.addEntity(myCreator);
		gm.addEntity(usa);
		
		gm.playGame();
	}
}
