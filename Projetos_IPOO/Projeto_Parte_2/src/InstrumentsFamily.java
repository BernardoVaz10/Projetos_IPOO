
/**
 * This class represents the family of the instrument, like wind, keyboard,
 * string, percussion.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */
public class InstrumentsFamily {
    // instance variables
    private String name;

    /**
     * Enum with the possible families of instruments.
     */
    public enum Families {
        WIND,
        KEYBOARD,
        STRING,
        PERCUSSION
    }

    private Families family;

    /**
     * Constructor for objects of class InstrumentsFamily.
     * 
     * @param family the family of the instrument
     */
    public InstrumentsFamily(Families family) {
        // initialise instance variables
        switch (family) {
            case WIND:
                this.name = "Wind";
                this.family = family;
                break;
            case KEYBOARD:
                this.name = "Keyboard";
                this.family = family;
                break;
            case STRING:
                this.family = family;
                this.name = "String";
                break;
            case PERCUSSION:
                this.family = family;
                this.name = "Percussion";
                break;
            default:
                this.family = null;
                break;
        }
    }

    /**
     * Get the name of the family.
     * 
     * @return the name of the family
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the family.
     * 
     * @param name the new name for the family
     */
    public void setName(String name) {
        name = this.name;
    }

    /**
     * Get the family of instruments.
     * 
     * @return the family of instruments
     */
    public Families getFamily() {
        return this.family;
    }

    /**
     * Set the family of instruments.
     * 
     * @param family the new family of instruments
     */
    public void setFamily(Families family) {
        family = this.family;
    }
}
