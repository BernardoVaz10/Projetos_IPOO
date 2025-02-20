
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
public class Maestro {
    // instance variables
    private MusicType[] musicTypes;
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
        musicTypes = new MusicType[5];
    }

    /**
     * Adds a music type to the maestro's repertoire.
     * 
     * @param type the music type to be added
     */
    public void addMusicType(MusicType type) {
        for (int i = 0; i < 5; i++) {
            if (this.musicTypes[i] == null) {
                this.musicTypes[i] = type;
                break;
            } else if (this.musicTypes[i] == type || this.musicTypes[i].getName() == type.getName()) {
                System.out.println("O tipo de musica já foi adicionado.");
                break;
            } else { // NEED TO BE FIXED
                System.out.println("O conjunto do estilos de musica está completo.");
            }
        }
    }

    /**
     * Shows a description of the maestro, including the name, performance ranking,
     * and music types they are capable of conducting.
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
     */
    public void getMusicTypes() {
        for (int i = 0; i < this.musicTypes.length; i++) {
            if (this.musicTypes[i] != null) {
                System.out.printf(this.musicTypes[i].getName() + "; ");
            }
        }
    }
}