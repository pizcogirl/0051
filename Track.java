/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    // Count the number of times a file is played
    private int playCount;
    // The track's length
    private String length;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename, String length)
    {
        setDetails(artist, title, filename, length);
        playCount = 0;
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename, "unknown");
        playCount = 0;
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + "(Length: " + length +  ") (Played: " + playCount + ")  (file: " + filename + ")";
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename, String length)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
        this.length = length;
    }
    
    /**
     * Reset the play count to 0
     */
    public void resetPlayCount()
    {
        playCount = 0;
    }
    
    /**
     * Increase the play count by 1
     */
    public void increasePlayCount()
    {
        playCount++;
    }
    
    /**
     * Return the length of the track
     */
    public String getLength()
    {
        return length;
    }
    
    /**
     * Set the value of the length of the track
     */
    public void setLength(String length)
    {
        this.length = length;
    }
    
}
