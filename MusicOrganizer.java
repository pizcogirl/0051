import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;

    /**
     * Create a MusicOrganizer. Add as parameter the directory where the
     * music is stores
     */
    public MusicOrganizer(String folder)
    {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary(folder);
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }

    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }

    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if((player.isPlaying()) == false && (indexValid(index)))
        {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            track.increasePlayCount();
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
        }
        else if (player.isPlaying())
        {
            System.out.println("Ya se esta reproduciendo una canción");
        }
    }

    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }

    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }

    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if(tracks.size() > 0 && (player.isPlaying() == false)) {
            Track firstTrack = tracks.get(0);
            player.startPlaying(firstTrack.getFilename());
            firstTrack.increasePlayCount();
        }
        else if (player.isPlaying())
        {
            System.out.println("Ya se esta reproduciendo una canción");
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }

    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }

    /**
     * Find tracks with the given string in the title
     */
    public void findInTitle(String searchString)
    {
        // Recorre la lista de tracks y comprueba los titulos
        for(Track track : tracks) {
            if(track.getTitle().contains(searchString)) {
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * Set the value of the length of the given track
     */
    public void setLengthOf(int index, String length)
    {
        tracks.get(index).setLength(length);
    }

    /**
     * Check if theres a file being played
     */
    public void isPlaying()
    {
        if (player.isPlaying())
        {
            System.out.println("Se esta reproduciendo una canción");
        }
    }

    /**
     * List all tracks using an iterator
     */
    public void listAllTrackWithIterator()
    {
        Iterator<Track> it = tracks.iterator();
        while (it.hasNext())
        {
            Track track = it.next();
            System.out.println(track.getDetails());
        }
    }

    /**
     * Remove the tracks from the given artist
     */
    public void removeByArtist(String artist)
    {
        Iterator<Track> it = tracks.iterator();
        while (it.hasNext())
        {
            Track track = it.next();
            // Recorre la lista, si la cancion contiene ese artista, la borra
            if (track.getArtist().contains(artist))
            {
                it.remove();
            }
        }
    }

    /**
     * Remove the track with the given title
     */
    public void removeByTitle(String title)
    {
        Iterator<Track> it = tracks.iterator();
        while (it.hasNext())
        {
            Track track = it.next();
            // Recorre la lista, si la cancion contiene ese titulo, la borra
            if (track.getTitle().contains(title))
            {
                it.remove();
            }
        }
    }
    
    

}
