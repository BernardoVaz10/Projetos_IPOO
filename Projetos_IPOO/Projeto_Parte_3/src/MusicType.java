
/**
 * This class represents the music type, like medieval, renaissance, baroque,
 * classical romantic, century 20 & 21.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */
public class MusicType {
    // instance variables
    private String name;

    /**
     * An enum representing the different types of music.
     */
    public enum Types {
        MEDIEVAL,
        RENAISSANCE,
        BARROQUE,
        CLASSICAL_ROMANTIC,
        CENTURY2021
    }

    Types type;

    /**
     * Constructor for objects of class MusicType.
     * 
     * @param type the type of music represented by this object
     */
    public MusicType(Types type) {
        // initialise instance variables
        this.type = type;
        switch (type) {
            case MEDIEVAL:
                this.name = "Medieval";
                break;
            case RENAISSANCE:
                this.name = "Renaissance";
                break;
            case BARROQUE:
                this.name = "Barroque";
                break;
            case CLASSICAL_ROMANTIC:
                this.name = "Classical Romantic";
                break;
            case CENTURY2021:
                this.name = "Century 20 & 21";
                break;

            default:
                break;
        }
    }

    /**
     * 
     * Gets the name of the music type.
     * 
     * @return the name of the music type
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * Sets the name of the music type.
     * 
     * @param name the new name of the music type
     */
    public void setName(String name) {
        name = this.name;
    }

    /**
     * 
     * Gets the type of the music type.
     * 
     * @return the type of the music type
     */
    public Types getType() {
        return this.type;
    }
}
