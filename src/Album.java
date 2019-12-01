
public class Album {

	private String albumName;
	private String artist;
	private int year;
	private String genre;

	// getters and setters
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// constructors
	public Album(String albumName, String artist, int year, String genre) {
		super();
		this.albumName = albumName;
		this.artist = artist;
		this.year = year;
		this.genre = genre;
	}

	public Album() {
		super();
	}

}
