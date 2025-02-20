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
public class Orchestra {
    // instance variables
    private Maestro maestro;
    private Musician[] musicians;

    /**
     * Constructor for objects of class Orchestra
     * 
     * @param maestro the maestro of the orchestra
     */
    public Orchestra(Maestro maestro) {
        // initialise instance variables
        this.maestro = maestro;
        musicians = new Musician[32];
    }

    /**
     * Adds a musician to the orchestra
     * 
     * @param musician the musician to be added
     */
    public void addMusician(Musician musician) {
        for (int i = 0; i < musicians.length; i++) {
            if (musicians[i] == null) {
                musicians[i] = musician;
                break;
            } else if (musicians[i] == musician || musicians[i].getName() == musician.getName()) {
                System.out.println("The musician has already been added.");
                break;
            } else {
                System.out.println("The group of musicians is complete.");
            }
        }
    }

    /**
     * Removes a musician from the orchestra by name
     * 
     * @param name the name of the musician to be removed
     */
    public void removeMusician(String name) {
        for (int i = 0; i < musicians.length; i++) {
            if (musicians[i].getName().equals(name)) {
                musicians[i] = null;
                break;
            } else {
                System.out.println("The musician does not exist.");
            }
        }
    }

    /**
     * Gets a list of musicians who are experts in a specific instrument family
     * 
     * @param instrumentsFamily the instrument family to filter by
     */
    public void getMusiciansByInstrumentFamily(InstrumentsFamily instrumentsFamily) {
        for (int i = 0; i < musicians.length; i++) {
            if (musicians[i].getInstrumentsFamily() == instrumentsFamily) {
                System.out.println(musicians[i]);
            } else {
                System.out.println("There are no musicians with that instrument.");
            }
        }
    }

    /**
     * Removes a musician from the orchestra by position
     * 
     * @param position the position of the musician to be removed
     */
    public void removeMusician(int position) {
        musicians[position] = null;
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
        int count = 0;
        for (int i = 0; i < this.musicians.length; i++) {
            if (this.musicians[i].getInstrumentsFamily() == instrumentsFamily) {
                count++;
            }
        }
        return count;
    }

    /**
     * 
     * Prints the names of all musicians in the orchestra.
     */
    public void getAllMusiciansNames() {
        for (int i = 0; i < this.musicians.length; i++) {
            System.out.printf("%d: " + this.musicians[i].getName() + "\n", i + 1);
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
        String[] instrumentF = new String[4];
        int count = 0;
        for (int i = 0; i < musicians.length; i++) {
            if (musicians[i].getInstrumentFamilyName() != instrumentF[i]) {
                instrumentF[i] = musicians[i].getInstrumentFamilyName();
                if (instrumentF != null) {
                    count++;
                }
            }
        }
        System.out.printf("The orchestra is composed of %d instrument families.\n", count);
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
        boolean isTrue = false;
        for (int i = 0; i < music.getInstrumentsFamilyLength(); i++) {
            for (int j = 0; j < musicians.length; j++) {
                if (musicians[j].getInstrumentsFamily() == music.getInstrumentsFamily(i)) {
                    if (musicians[j].haveTunedInstrument()) {
                        isTrue = true;
                    }
                }
            }
        }
        return isTrue;
    }

    /**
     * 
     * Shows the information of the maestro and all musicians in the orchestra.
     */
    public void showMaestroAndMusicians() {
        System.out.println("Maestro: " + this.maestro);
        for (int i = 0; i < musicians.length; i++) {
            if (musicians[i] != null) {
                System.out.println(musicians[i]);
            }
        }
    }

    /**
    
    Returns the maestro of the orchestra.
    @return the maestro of the orchestra
    */
    public Maestro getMaestro() {
    return this.maestro;
    }
}