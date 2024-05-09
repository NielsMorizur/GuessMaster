/*
 * Niels Morizur
 * 20265535
 */

package assignment2;

public class Singer extends Person{
	private String debutAlbum;
	Date debutAlbumReleaseDate;
	
	public Singer(String name, Date birthDate, String gender, String albumName, Date albumDate, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.debutAlbum = albumName;
		this.debutAlbumReleaseDate = new Date(albumDate);
	}
	
	public Singer(Singer singer) {
		super(singer);
		this.debutAlbum = singer.getDebutAlbum();
		this.debutAlbumReleaseDate = new Date(singer.getDebutAlbumReleaseDate()); // no privacy leak
	}
	
	public String getDebutAlbum() {
		return this.debutAlbum;
	}
	
	public Date getDebutAlbumReleaseDate() {
		return new Date(this.debutAlbumReleaseDate);
	}
	
	public Singer clone() {
		return new Singer(this);
	}
	
	// Is used to print out detailed description of the entity
	public String toString() {
		return super.toString()+"Debut Album: "+debutAlbum+"\nRelease Date: "+debutAlbumReleaseDate+"\n";
	}
	
	public String entityType() {
		return "This entity is a singer!";
	}
}
