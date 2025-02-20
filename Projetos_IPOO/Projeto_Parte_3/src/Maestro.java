
/**
 * This class Maestro represents the maestro of the orchestra. With this class
 * we can create a maestro, add a music type, show the description of the
 * maestro, show the description of the music types.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */

// imports
import java.util.HashSet;
import java.util.Iterator;

public class Maestro {
    // instance variables
    private HashSet<MusicType> musicTypes;
    // private MusicType[] musicTypes; -- OLD VAR
    private String name;
    private int ranking;

    /**
     * Constructor for objects of class Maestro
     * 
     * @param name    the name of the maestro
     * @param ranking the ranking of the maestro, between 1 and 5, with 5 being the
     *                highest
     */
    public Maestro(String name, int ranking) {
        // initialise instance variables
        this.name = name;
        if (ranking > 0 && ranking < 6) {
            this.ranking = ranking;
        }
        this.musicTypes = new HashSet<MusicType>();
    }

    /**
     * Adds a music type to the maestro's repertoire.
     * 
     * @param type the music type to be added
     */
    public void addMusicType(MusicType type) {
        musicTypes.add(type);
    }

    /**
     * Shows a description of the maestro, including the name, performance ranking,
     * and music types they are capable of conducting.
     * 
     * @return the description of the maestro
     */
    public void showDescription() {
        System.out.println("Nome: " + this.name);
        if (this.ranking < 5) {
            System.out.println("Ranking: " + "\u2605".repeat(this.ranking) + "\u2606".repeat(5 - this.ranking));
        } else {
            System.out.println("Ranking: " + "\u2605".repeat(this.ranking));
        }
        System.out.printf("Estilos de musica: ");
        getMusicTypes();
    }

    /**
     * Prints the names of all music types in the maestro's repertoire.
     * 
     * @return the names of all music types in the maestro's repertoire
     */
    public void getMusicTypes() {
        Iterator<MusicType> it = musicTypes.iterator();
        while (it.hasNext()) {
            System.out.printf(it.next().getName() + " ");
        }
        System.out.println();
    }
    /**
     * Sets the performance ranking of the maestro.
     * 
     * @param ranking the ranking of the maestro, between 1 and 5, with 5 being the
     *                highest
     */
    public void setRanking(int ranking) {
        if (ranking > 0 && ranking < 6) {
            this.ranking = ranking;
        }
    }

    // get name 

    /**
     * Gets the name of the maestro.
     * 
     * @return the name of the maestro
     */
    public String getName() {
        return this.name;
    }

    // get ranking

    /**
     * Gets the performance ranking of the maestro.
     * 
     * @return the ranking of the maestro, between 1 and 5, with 5 being the highest
     */
    public int getRanking() {
        return this.ranking;
    }
}