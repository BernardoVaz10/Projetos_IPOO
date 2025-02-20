
/**
 * This class Concert represents a concert. It has a orchestra, a description, a music type and a list of music.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt) 
 * @version 1
 */

/**
 * Constructor for objects of class Concerts.
 * 
 * @param description a description of the concert
 * @param musicType   the type of music that will be played at the concert
 */
public class Concert {
    // instance variables
    private Orchestra orchestra;
    private String description;
    private MusicType musicType;
    private Music[] music;

    /**
     * Constructor for objects of class Concert
     */
    public Concert(String description, MusicType musicType) {
        // initialise instance variables
        this.music = new Music[20];
        this.description = description;
        this.musicType = musicType;
    }

    /**
     * Adds an orchestra to the concert.
     * 
     * @param orchestra the orchestra that will perform at the concert
     */
    public void addOrchestra(Orchestra orchestra) {
        this.orchestra = orchestra;
    }

    /**
     * Adds a music piece to the list of music that will be played at the concert.
     * The music piece will only be added if
     * the orchestra is capable of playing it and if it is of the same type of music
     * as the concert.
     * 
     * @param music the music piece to be added
     */
    public void addMusic(Music music) {
        for (int i = 0; i < this.music.length; i++) {
            if (this.orchestra != null && this.orchestra.checkOrchestra(music)
                    && music.getMusicType() == this.musicType) {
                this.music[i] = music;
                break;
            }
        }
    }

    /**
     * Returns the maestro of the orchestra that will perform at the concert.
     * 
     * @return the maestro of the orchestra
     */
    public Maestro accessMaestro() {
        return this.orchestra.getMaestro();
    }

    /**
     * Calculates and returns the total duration of the concert, including intervals
     * between music pieces.
     * 
     * @return the duration of the concert in minutes
     */
    public double concertDuration() {
        double sum = 0;
        for (Music music1 : this.music) {
            if (music1 != null && sum <= 60) {
                sum += music1.getDuration();
                sum++;
            }
        }
        return sum + 15;
    }

    /**
     * Prints the names of all musicians in the orchestra that will perform at the
     * concert.
     */
    public void getAllMusicians() {
        this.orchestra.getAllMusiciansNames();
    }

    /**
     * Prints the list of music pieces that will be played at the concert.
     */
    public void showMusicList() {
        for (Music music1 : this.music) {
            // System.out.printf("%s: %dm\n", music1.getTitle(), music1.getDuration());
            System.out.println(music1.getTitle() + ": " + music1.getDuration() + "m");
        }
    }

    /**
     * 
     * Shows the alignment of the concert, including the start time and interval
     * between each music piece.
     * 
     * @param startTime the start time of the concert in minutes
     */
    public void showAlignment(double startTime) {
        double sum = startTime;
        for (Music music1 : this.music) {
            if (music1 != null) {
                System.out.printf("Início: %.2f - Intervalo: %.2f - %s", sum, sum - startTime, music1.getTitle());
                sum += music1.getDuration();
                sum++;
            }
        }
    }

    /**
     * 
     * Shows the information of the maestro and all musicians in the orchestra that
     * will perform at the concert.
     */
    public void showMaestroAndMusicians() {
        this.orchestra.showMaestroAndMusicians();
    }

    /**
     * 
     * Shows the description of the concert and the type of music that will be
     * played.
     */
    public void showDescription() {
        System.out.println("Descrição do concerto: " + description);
        System.out.println("Tipo de música tocado: " + this.musicType.getName());
    }

    /**
     * 
     * Returns the description of the concert.
     * 
     * @return a String representing the concert's description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * Sets the description of the concert.
     * 
     * @param description a String representing the concert's new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * Returns the orchestra that is performing at the concert.
     * 
     * @return an Orchestra object representing the concert's orchestra.
     */
    public Orchestra getOrchestra() {
        return this.orchestra;
    }

    /**
     * 
     * Sets the orchestra that will be performing at the concert.
     * 
     * @param orchestra an Orchestra object representing the concert's new
     *                  orchestra.
     */
    public void setOrchestra(Orchestra orchestra) {
        this.orchestra = orchestra;
    }

    /**
     * 
     * Returns the type of music that will be performed at the concert.
     * 
     * @return a MusicType object representing the concert's music type.
     */
    public MusicType getMusicType() {
        return this.musicType;
    }

    /**
     * 
     * Sets the type of music that will be performed at the concert.
     * 
     * @param musicType a MusicType object representing the concert's new music
     *                  type.
     */
    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }
}
