/**
 * 
 * This class Orchestra represents the orchestra, with a maestro and a group of
 * musicians.
 * With this class we can create an orchestra, add a musician, remove a
 * musician, show the description of the orchestra.
 * 
 * @author Tiago Ramada (202200354) and Bernardo Vaz (202200278)
 * @email Tiago (202200354@estudantes.ips.pt) and Bernardo
 *        (202200278@estudantes.ips.pt)
 * @version 1
 */

// imports 
import java.util.HashMap;
import java.util.HashSet;

public class Orchestra {
    // instance variables
    private Maestro maestro;
    private HashMap<InstrumentsFamily, HashSet<Musician>> musicians;
    // private Musician[] musicians; -- OLD VAR

    /**
     * Constructor for objects of class Orchestra
     * 
     * @param maestro the maestro of the orchestra
     */
    public Orchestra(Maestro maestro) {
        // initialise instance variables
        this.maestro = maestro;
        this.musicians = new HashMap<InstrumentsFamily, HashSet<Musician>>();
    }

    /**
     * Adds a musician to the orchestra
     * 
     * @param musician the musician to be added
     */
    public void addMusician(Musician musician) {
        HashSet<InstrumentsFamily> musicianFamilies = musician.getInstrumentsFamilies();
        for (InstrumentsFamily instrumentsFamily : musicianFamilies) {
            if (!musicians.containsKey(instrumentsFamily)) {
                musicians.put(instrumentsFamily, new HashSet<Musician>());
            }
            if (musicians.get(instrumentsFamily).add(musician)) {
                System.out.println("Musician added successfully to " + instrumentsFamily.getName() + " family.");
            } else {
                System.out
                        .println("The musician has already been added to " + instrumentsFamily.getName() + " family.");
            }
        }
    }

    /**
     * Removes a musician from the orchestra by name
     * 
     * @param name the name of the musician to be removed
     */
    public void removeMusician(String name) {
        for (HashMap.Entry<InstrumentsFamily, HashSet<Musician>> entry : musicians.entrySet()) {
            HashSet<Musician> familyMusicians = entry.getValue();
            for (Musician musician : familyMusicians) {
                if (musician.getName().equals(name)) {
                    familyMusicians.remove(musician);
                    return;
                }
            }
        }
        System.out.println("The musician does not exist.");
    }

    /**
     * Gets a list of musicians who are experts in a specific instrument family
     * 
     * @param instrumentsFamily the instrument family to filter by
     */
    public void getMusiciansByInstrumentFamily(InstrumentsFamily instrumentsFamily) {
        HashSet<Musician> musiciansByInstrumentFamily = musicians.get(instrumentsFamily);
        if (musiciansByInstrumentFamily != null && !musiciansByInstrumentFamily.isEmpty()) {
            for (Musician musician : musiciansByInstrumentFamily) {
                System.out.println(musician);
            }
        } else {
            System.out.println("There are no musicians with that instrument.");
        }
    }

    // get musicians by instrument family
    public HashSet<Musician> getAllMusiciansByInstrumentFamily(InstrumentsFamily instrumentsFamily) {
        return musicians.get(instrumentsFamily);
    }

    /**
     * Removes a musician from the orchestra by position
     * 
     * @param position the position of the musician to be removed
     */
    public void removeMusician(Musician musician) {
        musicians.remove(musician.getInstrumentsFamilies(), musician);
    }

    /**
     * 
     * Returns the number of musicians in the orchestra who are experts in a
     * specific instrument family.
     * 
     * @param instrumentsFamily the instrument family to check against
     * @return the number of musicians who are experts in the specified instrument
     *         family
     */
    public int getNumberOfMusicians(InstrumentsFamily instrumentsFamily) {
        if (musicians.containsKey(instrumentsFamily)) {
            return musicians.get(instrumentsFamily).size();
        } else {
            return 0;
        }
    }

    /**
     * 
     * Prints the names of all musicians in the orchestra.
     */
    public void getAllMusiciansNames() {
        int count = 1;
        for (InstrumentsFamily family : musicians.keySet()) {
            System.out.println("Musicians in " + family.getName() + " family:");
            for (Musician musician : musicians.get(family)) {
                System.out.printf("%d: " + musician.getName() + "\n", count);
                count++;
            }
        }
    }

    /**
     * 
     * Shows the composition of the orchestra by printing the number of instrument
     * families represented.
     * 
     * @param instrumentsFamily the instrument family to check against
     */
    public void showCompositionOfOrchestra(InstrumentsFamily instrumentsFamily) {
        if (musicians.containsKey(instrumentsFamily)) {
            System.out.printf("The orchestra is composed of %d musicians from the %s family.\n",
                    musicians.get(instrumentsFamily).size(), instrumentsFamily.getName());
        } else {
            System.out.println(
                    "The orchestra doesn't have any musician from the " + instrumentsFamily.getName() + " family.");
        }
    }

    /**
     * 
     * Determines if the orchestra is able to play a specific piece of music.
     * 
     * @param music the music to check against
     * @return true if the orchestra has musicians who are experts in all of the
     *         instrument families required for the music, false otherwise
     */
    public boolean checkOrchestra(Music music) {
        for (int i = 0; i < music.getInstrumentsFamilyLength(); i++) {
            InstrumentsFamily family = music.getInstrumentsFamily(i);
            if (!musicians.containsKey(family)) {
                System.err.println("The orchestra doesn't have any musician from the " + family.getName() + " family.");
                return false;
            }
            for (Musician musician : musicians.get(family)) {
                if (!musician.haveTunedInstrument()) {
                    System.err.println("The musician " + musician.getName() + " doesn't have a tuned instrument.");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 
     * Shows the information of the maestro and all musicians in the orchestra.
     */
    public void showMaestroAndMusicians() {
        System.out.println("Maestro: " + this.maestro);
        for (HashMap.Entry<InstrumentsFamily, HashSet<Musician>> entry : musicians.entrySet()) {
            for (Musician musician : entry.getValue()) {
                System.out.println(musician);
            }
        }
    }

    public void act(Music music) {
        // Irá ainda ser atribuído ao Maestro um ranking que resulta da média dos
        // rankings de todos os músicos que vão tocar essa música.
        // Se não existirem músicos para tocar a música, o maestro irá ficar com um
        // ranking de 0 (usado excecionalmente para assinalar que não existem músicos
        // disponíveis).
        int sum = 0, total = 0;
        boolean hasMusicians = false;
        for (Musician musician : musicians.get(music.getInstrumentsFamily(0))) {
            if (musician.musicChecker(music)) {
                sum += musician.getPerformanceRanking();
                total++;
                hasMusicians = true;
            }
        }
        if (hasMusicians) {
            this.maestro.setRanking(sum / total);
        } else {
            this.maestro.setRanking(0);
        }
    }

    /**
     * 
     * Returns the maestro of the orchestra.
     * 
     * @return the maestro of the orchestra
     */
    public Maestro getMaestro() {
        return this.maestro;
    }
}