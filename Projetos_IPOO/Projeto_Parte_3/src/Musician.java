
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

// imports
import java.util.HashSet;
import java.util.Iterator;

public class Musician {
    // instance variables
    private String name;
    private HashSet<InstrumentsFamily> instrumentsFamilies;
    // private InstrumentsFamily instrumentsFamily; -- OLD VAR
    private HashSet<Instrument> instruments;
    // private Instrument[] instruments; -- OLD VAR
    private int performanceRanking;
    // pontos de desempenho
    private int points;

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
        this.instrumentsFamilies = new HashSet<InstrumentsFamily>();
        this.instrumentsFamilies.add(instrumentsFamily);
        this.instruments = new HashSet<Instrument>();
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
        instruments.add(new Instrument(name));
    }

    /**
     * Adds an existing instrument to the musician's collection.
     * 
     * @param instrument the instrument to add
     */
    public void addInstrument(Instrument instrument) {
        if (instrumentsFamilies.contains(instrument.getInstrumentsFamily())) {
            instruments.add(instrument);
        }
    }

    /**
     * Sells an instrument with the given serial number.
     * 
     * @param serialNumber the serial number of the instrument to sell
     */
    public void sellInstrument(int serialNumber) {
        Iterator<Instrument> iterator = instruments.iterator();
        while (iterator.hasNext()) {
            Instrument instrument = iterator.next();
            if (instrument.getSerialNumber() == serialNumber) {
                iterator.remove();
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
        for (InstrumentsFamily family : instrumentsFamilies) {
            if (checkFamily(family)) {
                for (Instrument instrument : instruments) {
                    if (checkFamily(instrument.getInstrumentsFamily()) || instrument.isTuned().equals("Sim")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // check if family is in the musician's collection
    public boolean checkFamily(InstrumentsFamily family) {
        for (InstrumentsFamily fam : instrumentsFamilies) {
            if (fam == family) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * Shows a description of the musician, including the name, instrument family
     * they are specialized in, performance ranking, and instruments they possess.
     */
    public void showDescription() {
        System.out.println("Nome: " + this.name);
        System.out.println("Famílias de instrumentos em que é especialista: ");
        // show all the families names in the musician's collection
        for (InstrumentsFamily family : instrumentsFamilies) {
            System.out.println(family.getName());
        }
        if (this.performanceRanking < 5) {
            System.out.println("Ranking: " + "\u2605".repeat(this.performanceRanking)
                    + "\u2606".repeat(5 - this.performanceRanking));
        } else {
            System.out.println("Ranking: " + "\u2605".repeat(this.performanceRanking));
        }
        for (Instrument instrument : instruments) {
            System.out.print(instrument.getName() + " ");
        }
        System.out.println();
    }

    
    public void act() {
        // acadamúsicadasimulaçãodeveráescolheruminstrumentoentreos instrumentos
        // afinados que possui
        if (haveTunedInstrument()) {
            for (Instrument instrument : instruments) {
                // se o instrumento for afinado, o músico ganha 1 ponto de desempenho
                if (instrument.isTuned().equals("Sim")) {
                    this.points++;
                    instrument.act();
                    break;
                }
            }
        } else {
            // se o músico não tiver nenhum instrumento afinado, perde 1 ponto de
            // desempenho
            this.points--;
        }
        // se tiver 10 pontos de desempenho sube um nível do ranking de desempenho
        if (this.points == 10) {
            this.performanceRanking++;
            this.points = 0;
        } else if (this.points == -10) {
            this.performanceRanking--;
            this.points = 0;
        }
    }

    /**
     * 
     * Checks if the musician has a tuned instrument in their collection.
     * 
     * @return true if the musician has a tuned instrument, false otherwise
     */
    public boolean haveTunedInstrument() {
        for (Instrument instrument : instruments) {
            if (instrument.isTuned().equals("Sim")) {
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
     * Gets the instruments families the musician is specialized in.
     * 
     * @return the instruments families the musician is specialized in
     */
    public HashSet<InstrumentsFamily> getInstrumentsFamilies() {
        return this.instrumentsFamilies;
    }

    /**
     * 
     * Sets the instrument family the musician is specialized in.
     * 
     * @param instrumentsFamily the new instrument family the musician is
     *                          specialized in
     */
    public void setInstrumentsFamily(InstrumentsFamily instrumentsFamily) {
        instrumentsFamilies.add(instrumentsFamily);
    }

    /**
     * 
     * Gets the name of the instrument family the musician is specialized in.
     * 
     * @return the name of the instrument family the musician is specialized in
     */
    public String getInstrumentFamilyName() {
        StringBuilder sb = new StringBuilder();
        for (InstrumentsFamily family : instrumentsFamilies) {
            sb.append(family.getName() + " ");
        }
        return sb.toString().trim();
    }

    /**
     * 
     * Sets the name of the instrument family the musician is specialized in.
     * 
     * @param name the new name of the instrument family the musician is specialized
     *             in
     */
    public void setInstrumentFamilyName(String name) {
        for (InstrumentsFamily family : instrumentsFamilies) {
            family.setName(name);
        }
    }
}
