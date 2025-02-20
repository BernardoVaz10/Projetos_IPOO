/**
 * This class Music represents the music, with the title, duration, music type
 * and the instruments family. With this class we can add a family into the
 * instrumentsFamily array.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */

// imports
import java.util.HashSet;

public class Music {
    // instance variables
    private HashSet<InstrumentsFamily> instrumentsFamilies;
    // InstrumentsFamily[] instrumentsFamilies; -- OLD VAR
    private String title;
    private Double duration;
    private MusicType musicType;

    /**
     * Constructor for objects of class Music
     * 
     * @param musicType the type of music
     * @param title     the title of the music
     * @param duration  the duration of the music in minutes
     */
    public Music(MusicType musicType, String title, Double duration) {
        // initialise instance variables
        this.title = title;
        this.duration = duration;
        this.musicType = musicType;
        this.instrumentsFamilies = new HashSet<InstrumentsFamily>();
    }

    /**
     * Adds an instrument family to the music.
     * 
     * @param family the instrument family to be added
     */
    public void addInstrumentsFamily(InstrumentsFamily family) {
        instrumentsFamilies.add(family);
    }

    /**
     * Returns the title of the music.
     * 
     * @return the title of the music
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the music.
     * 
     * @param title the new title of the music
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the duration of the music in minutes.
     * 
     * @return the duration of the music
     */
    public Double getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the music in minutes.
     * 
     * @param duration the new duration of the music
     */
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    /**
     * 
     * This method gets the music type for this {@link Music} object.
     * 
     * @return the music type for this music object
     */
    public MusicType getMusicType() {
        return this.musicType;
    }

    /**
     * 
     * This method sets the music type for this {@link Music} object.
     * 
     * @param musicType the music type to be set for this music object
     */
    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    /**
     * 
     * This method gets the instruments family at the specified index for this
     * {@link Music} object.
     * 
     * @param value the index of the instruments family to get
     * @return the instruments family at the specified index for this music object
     */
    public InstrumentsFamily getInstrumentsFamily(int value) {
        int i = 0;
        for (InstrumentsFamily family : instrumentsFamilies) {
            if (i == value) {
                return family;
            }
            i++;
        }
        return null;
    }

    // get all instruments family
    public HashSet<InstrumentsFamily> getAllInstrumentsFamily() {
        return instrumentsFamilies;
    }

    /**
     * 
     * This method gets the instruments family length.
     * 
     * @return the instruments family length
     */
    public int getInstrumentsFamilyLength() {
        return instrumentsFamilies.size();
    }
}
