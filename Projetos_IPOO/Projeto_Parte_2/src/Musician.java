
/**
 * This class Musician represents a musician. With this class we can create a
 * musician, buy an instrument, add an instrument, sell an instrument, check if
 * is possible to play a specific music.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */
public class Musician {
    // instance variables
    private String name;
    private InstrumentsFamily instrumentsFamily;
    private Instrument[] instruments;
    private int performanceRanking;

    /**
     * Constructor for objects of class Musician
     * 
     * @param name               the name of the musician
     * @param instrumentsFamily  the family of instruments the musician is
     *                           specialized in
     * @param performanceRanking the musician's performance ranking on a scale of 1
     *                           to 5
     */
    public Musician(String name, InstrumentsFamily instrumentsFamily, int performanceRanking) {
        // initialise instance variables
        this.name = name;
        this.instrumentsFamily = instrumentsFamily;
        this.instruments = new Instrument[100]; // random value
        if (performanceRanking > 0 && performanceRanking < 6) {
            this.performanceRanking = performanceRanking;
        }
    }

    /**
     * Buys an instrument with the given name.
     * 
     * @param name the name of the instrument to buy
     */
    public void buyInstrumentWithName(String name) {
        for (int i = 0; i < this.instruments.length; i++) {
            if (this.instruments[i] == null) {
                this.instruments[i] = new Instrument(name);
                break;
            }
        }
    }

    /**
     * Adds an existing instrument to the musician's collection.
     * 
     * @param instrument the instrument to add
     */
    public void addInstrument(Instrument instrument) {
        for (int i = 0; i < this.instruments.length; i++) {
            if (this.instruments[i] == null && instrument.getInstrumentsFamily() == this.instrumentsFamily) {
                this.instruments[i] = instrument;
                break;
            }
        }
    }

    /**
     * Sells an instrument with the given serial number.
     * 
     * @param serialNumber the serial number of the instrument to sell
     */
    public void sellInstrument(int serialNumber) {
        for (int i = 0; i < this.instruments.length; i++) {
            if (this.instruments[i].getSerialNumber() == serialNumber) {
                this.instruments[i] = null;
                break;
            }
        }
    }

    /**
     * Checks if it is possible for the musician to play a specific music.
     * 
     * @param music the music to check
     * @return true if the musician can play the music, false otherwise
     */
    public boolean musicChecker(Music music) {
        boolean checker = false;
        for (int i = 0; i < 4; i++) {
            if (music.getInstrumentsFamily(i) == instrumentsFamily
                    && instruments[i].getInstrumentsFamily() == instrumentsFamily
                    && instruments[i].isTuned().equals("Sim")) {
                checker = true;
                break;
            } else {
                checker = false;
            }
        }
        return checker;
    }

    /**
     * 
     * Shows a description of the musician, including the name, instrument family
     * they are specialized in, performance ranking, and instruments they possess.
     */
    public void showDescription() {
        System.out.println("Nome: " + this.name);
        System.out.println("Família de instrumentos em que é especialista: " + this.instrumentsFamily.getName());
        if (this.performanceRanking < 5) {
            System.out.println("Ranking: " + "\u2605".repeat(this.performanceRanking)
                    + "\u2606".repeat(5 - this.performanceRanking));
        } else {
            System.out.println("Ranking: " + "\u2605".repeat(this.performanceRanking));
        }
        System.out.printf("Instrumentos que possuem: ");
        getInstruments();
    }

    /**
     * 
     * Prints the names of all instruments in the musician's collection.
     */
    public void getInstruments() {
        for (int i = 0; i < this.instruments.length; i++) {
            if (this.instruments[i] != null) {
                System.out.printf(this.instruments[i].getName() + "; ");
            }
        }
    }

    /**
     * 
     * Checks if the musician has a tuned instrument in their collection.
     * 
     * @return true if the musician has a tuned instrument, false otherwise
     */
    public boolean haveTunedInstrument() {
        for (int i = 0; i < this.instruments.length; i++) {
            if (this.instruments[i] != null && this.instruments[i].isTuned().equals("Sim")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * Gets the name of the musician.
     * 
     * @return the name of the musician
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * Sets the name of the musician.
     * 
     * @param name the new name of the musician
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * Gets the performance ranking of the musician.
     * 
     * @return the performance ranking of the musician
     */
    public int getPerformanceRanking() {
        return this.performanceRanking;
    }

    /**
     * 
     * Sets the performance ranking of the musician.
     * 
     * @param performanceRanking the new performance ranking of the musician
     */
    public void setPerformanceRanking(int performanceRanking) {
        this.performanceRanking = performanceRanking;
    }

    /**
     * 
     * Gets the instrument family the musician is specialized in.
     * 
     * @return the instrument family the musician is specialized in
     */
    public InstrumentsFamily getInstrumentsFamily() {
        return this.instrumentsFamily;
    }

    /**
     * 
     * Sets the instrument family the musician is specialized in.
     * 
     * @param instrumentsFamily the new instrument family the musician is
     *                          specialized in
     */
    public void setInstrumentsFamily(InstrumentsFamily instrumentsFamily) {
        this.instrumentsFamily = instrumentsFamily;
    }

    /**
     * 
     * Gets the name of the instrument family the musician is specialized in.
     * 
     * @return the name of the instrument family the musician is specialized in
     */
    public String getInstrumentFamilyName() {
        return instrumentsFamily.getName();
    }

    /**
     * 
     * Sets the name of the instrument family the musician is specialized in.
     * 
     * @param name the new name of the instrument family the musician is specialized
     *             in
     */
    public void setInstrumentFamilyName(String name) {
        this.instrumentsFamily.setName(name);
    }
}
