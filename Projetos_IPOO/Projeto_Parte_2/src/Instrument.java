
/**
 * This class represents the instrument. It has a name, a serial number, a
 * boolean to check if is tuned and a family.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */
public class Instrument {
    // instance variables
    private static int SERIAL_NUMBER = 0;
    private String name;
    private int serialNumber;
    private boolean isTuned;
    private InstrumentsFamily family;

    /**
     * Constructor for objects of class Instrument with only the name of the
     * instrument.
     * 
     * @param name the name of the instrument
     */
    public Instrument(String name) {
        this.name = name;
        this.isTuned = false;
        SERIAL_NUMBER++;
        this.serialNumber = SERIAL_NUMBER;
    }

    /**
     * Constructor for objects of class Instrument with the name and family of the
     * instrument.
     * 
     * @param name   the name of the instrument
     * @param family the family of the instrument
     */
    public Instrument(String name, InstrumentsFamily family) {
        this.name = name;
        this.family = family;
        this.isTuned = false;
        SERIAL_NUMBER++;
        this.serialNumber = SERIAL_NUMBER;
    }

    /**
     * Tune the instrument.
     */
    public void tune() {
        this.isTuned = true;
    }

    /**
     * Untune the instrument.
     */
    public void untune() {
        this.isTuned = false;
    }

    /**
     * Show the description of the instrument.
     */
    public void showDescription() {
        System.out.println("Número de série: " + this.serialNumber);
        System.out.println("Nome: " + name);
        try {
            System.out.println("Família: " + this.family.getName());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Família: Não informada");
        }
        System.out.println("Está afinado: " + isTuned());
    }

    /**
     * Check if the instrument is tuned.
     * 
     * @return "Sim" if the instrument is tuned, "Não" otherwise
     */
    public String isTuned() {
        if (this.isTuned) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    /**
     * Return the number of instruments created.
     * 
     * @return the number of instruments
     */
    public int numberOfInstruments() {
        return SERIAL_NUMBER;
    }

    /**
     * 
     * Returns the name of the Instrument.
     * 
     * @return the name of the Instrument.
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * Returns the serial number of the Instrument.
     * 
     * @return the serial number of the Instrument.
     */
    public int getSerialNumber() {
        return this.serialNumber;
    }

    /**
     * 
     * Returns the InstrumentsFamily of the Instrument.
     * 
     * @return the InstrumentsFamily of the Instrument.
     */
    public InstrumentsFamily getInstrumentsFamily() {
        return this.family;
    }

}
