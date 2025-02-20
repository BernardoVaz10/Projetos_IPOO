import java.util.ArrayList;
import java.util.Random;

/**
 * This class Simulator represents a simulator.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt) 
 * @version 1
 */

public class Simulator {
    private ArrayList<Musician> musicians;
    private ArrayList<Instrument> instruments;
    private ArrayList<Maestro> maestros;
    private ArrayList<Music> musics;
    // STRING instrument family
    private InstrumentsFamily stringFamily;
    // METAL instrument family
    private InstrumentsFamily metalFamily;
    // PERCUSSION instrument family
    private InstrumentsFamily percussionFamily;
    // WIND instrument family
    private InstrumentsFamily windFamily;
    // KEYBOARD instrument family
    private InstrumentsFamily keyboardFamily;
    Concert concert;
    Orchestra orchestra;
    private int steps = 0;

    private Random random;

    public Simulator(int steps) {
        this.musicians = new ArrayList<>();
        this.instruments = new ArrayList<>();
        this.maestros = new ArrayList<>();
        this.musics = new ArrayList<>();
        this.steps = steps;

        this.stringFamily = new InstrumentsFamily(InstrumentsFamily.Families.STRING);
        this.metalFamily = new InstrumentsFamily(InstrumentsFamily.Families.METALS);
        this.percussionFamily = new InstrumentsFamily(InstrumentsFamily.Families.PERCUSSION);
        this.windFamily = new InstrumentsFamily(InstrumentsFamily.Families.WIND);
        this.keyboardFamily = new InstrumentsFamily(InstrumentsFamily.Families.KEYBOARD);

        createMusicians();
        createMaestros();
        createMusics();
        concertBarroque();
        startSimulator();
    }

    private void createMusicians() {
        // code to create and add 400 musiciansof strings family
        // Devem
        // ser atribuídos nomes diferentes a cada músico e um ranking aleatório entre
        // 1 e 5. A cada músico devem ainda ser atribuídos 3 instrumentos afinados da
        // família de instrumentos da qual é especialista. Os instrumentos devem
        // também possuir nomes diferentes. Os músicos e os instrumentos devem ser
        // guardados em listas que deverão estar como atributos da classe de
        // simulação.
        random = new Random();
        for (int i = 0; i < 400; i++) {
            Musician m = new Musician("Musician " + i, stringFamily, random.nextInt(5) + 1);
            createInstruments(m, stringFamily);
            musicians.add(m);
        }
        // code to create and add 250 musicians of metals family
        for (int i = 400; i < 650; i++) {
            Musician m = new Musician("Musician " + i, metalFamily, random.nextInt(5) + 1);
            createInstruments(m, metalFamily);
            musicians.add(m);
        }
        // code to create and add 150 musicians of percussion family
        for (int i = 650; i < 800; i++) {
            Musician m = new Musician("Musician " + i, percussionFamily, random.nextInt(5) + 1);
            createInstruments(m, percussionFamily);
            musicians.add(m);
        }

        // code to create and add 70 musicians of wind family
        for (int i = 800; i < 870; i++) {
            Musician m = new Musician("Musician " + i, windFamily, random.nextInt(5) + 1);
            createInstruments(m, windFamily);
            musicians.add(m);
        }
        // code to create and add 30 musicians of keyboard family
        for (int i = 870; i < 900; i++) {
            Musician m = new Musician("Musician " + i, keyboardFamily, random.nextInt(5) + 1);
            createInstruments(m, keyboardFamily);
            musicians.add(m);
        }
    }

    private void createInstruments(Musician m, InstrumentsFamily family) {
        // code to create and add instruments for each musician
        for (int j = 0; j < 3; j++) {
            Instrument instrument = new Instrument("Instrument " + j, family);
            instrument.tune();
            m.addInstrument(instrument);
            instruments.add(instrument);
        }
    }

    private void createMaestros() {
        // code to create and add 10 maestros
        random = new Random();
        for (int i = 0; i < 10; i++) {
            Maestro maestro = new Maestro("Maestro " + i, random.nextInt(5) + 1);
            if (random.nextInt(3) == 0) {
                MusicType musicType = new MusicType(MusicType.Types.BARROQUE);
                maestro.addMusicType(musicType);
                if (random.nextInt(3) == 0) {
                    musicType = new MusicType(MusicType.Types.CLASSICAL_ROMANTIC);
                    maestro.addMusicType(musicType);
                }
                if (random.nextInt(3) == 0) {
                    musicType = new MusicType(MusicType.Types.MEDIEVAL);
                    maestro.addMusicType(musicType);
                }
                if (random.nextInt(3) == 0) {
                    musicType = new MusicType(MusicType.Types.RENAISSANCE);
                    maestro.addMusicType(musicType);
                }
                if (random.nextInt(3) == 0) {
                    musicType = new MusicType(MusicType.Types.CENTURY2021);
                    maestro.addMusicType(musicType);
                }
            }

            maestros.add(maestro);
        }
    }

    private void createMusics() {
        // code to create and add 300 musics
        random = new Random();
        for (int i = 0; i < 300; i++) {
            // Cada música deve possuir uma duração entre 30 segundos e 15 minutos(900
            // segundos)
            // e um tipo aleatório de música (Barroca, Medieval, Renaissância,
            // Classicá-Romantica, Seculo XXI).
            MusicType musicType = new MusicType(MusicType.Types.values()[random.nextInt(5)]);
            // 870 porque 900 - 30 (duração minima) = 870 segundos que é o tempo maximo
            // que a musica pode ter.
            Music music = new Music(musicType, "Music" + i, random.nextDouble(870) + 30);
            // usar com uma probabilidade de 3/4 cada uma das familias de instrumentos
            // existentes.
            if (random.nextInt(4) != 0) {
                music.addInstrumentsFamily(stringFamily);
            }
            if (random.nextInt(4) != 0) {
                music.addInstrumentsFamily(metalFamily);
            }
            if (random.nextInt(4) != 0) {
                music.addInstrumentsFamily(percussionFamily);
            }
            if (random.nextInt(4) != 0) {
                music.addInstrumentsFamily(windFamily);
            }
            if (random.nextInt(4) != 0) {
                music.addInstrumentsFamily(keyboardFamily);
            }
            musics.add(music);
        }
    }

    // 1. Um concerto de música barroca.
    public void concertBarroque() {
        Maestro maestro = maestros.get(random.nextInt(maestros.size()));
        ArrayList<Musician> concertMusicians = new ArrayList<>();
        // get 10 random musicians of wind family
        for (int i = 0; i < 10; i++) {
            Musician musician = musicians.get(random.nextInt(musicians.size()));
            if (musician.getInstrumentsFamilies().contains(windFamily)) {
                concertMusicians.add(musician);
            } else {
                i--;
            }
        }
        // get 15 random musicians of string family
        for (int i = 0; i < 15; i++) {
            Musician musician = musicians.get(random.nextInt(musicians.size()));
            if (musician.getInstrumentsFamilies().contains(stringFamily)) {
                concertMusicians.add(musician);
            } else {
                i--;
            }
        }
        // get 2 random musicians of percussion family
        for (int i = 0; i < 2; i++) {
            Musician musician = musicians.get(random.nextInt(musicians.size()));
            if (musician.getInstrumentsFamilies().contains(percussionFamily)) {
                concertMusicians.add(musician);
            } else {
                i--;
            }
        }
        // get 6 random musicians of metal family
        for (int i = 0; i < 6; i++) {
            Musician musician = musicians.get(random.nextInt(musicians.size()));
            if (musician.getInstrumentsFamilies().contains(metalFamily)) {
                concertMusicians.add(musician);
            } else {
                i--;
            }
        }
        // get 2 random musicians of keyboard family
        for (int i = 0; i < 2; i++) {
            Musician musician = musicians.get(random.nextInt(musicians.size()));
            if (musician.getInstrumentsFamilies().contains(keyboardFamily)) {
                concertMusicians.add(musician);
            } else {
                i--;
            }
        }

        orchestra = new Orchestra(maestro);
        for (Musician musician : concertMusicians) {
            orchestra.addMusician(musician);
        }
        concert = new Concert("Barroque concert", new MusicType(MusicType.Types.BARROQUE));
        concert.setOrchestra(orchestra);
        for (Music music : musics) {
            if (music.getMusicType().getType() == MusicType.Types.BARROQUE) {
                System.out.println("Adding " + music.getTitle() + " to the concert.");
                concert.addMusic(music);
                if (concert.concertDuration() >= 7200) {
                    break;
                }
            }
        }
        System.out.println("Concert duration: " + concert.concertDuration());
    }

    public void playSong(Music music) {
        System.out.println("Playing " + music.getTitle());
        if (!this.orchestra.checkOrchestra(music)) {
            System.out.println("Não é possivel tocar essa musica.");
        } else {
            // deve ser executadoométodo act()
            // detodososmúsicosdasfamiliasdeinstrumentosdamúsicaeométodo act() da
            // orquestra.
            //
            for (InstrumentsFamily instrumentsFamily : music.getAllInstrumentsFamily()) {
                for (Musician musician : orchestra.getAllMusiciansByInstrumentFamily(instrumentsFamily)) {
                    musician.act();
                }
            }
            orchestra.act(music);
            // deve ser mostrado o nome do mestro e o seu ranking e ainda o número de
            // músicos que estão efetivamente a tocar a música.
            System.out.println("Maestro: " + orchestra.getMaestro().getName() + " Ranking: "
                    + orchestra.getMaestro().getRanking());
        }

    }

    // start simoulation
    public void startSimulator() {
        System.out.println("Starting simulator...");
        // get all concert musics
        ArrayList<Music> concertMusics = concert.getMusicList();
        System.out.println("Concert musics: " + concertMusics.size());
        // foreach step in steps, call playSong on the index, if index is bigger than
        // the size of the list, start again
        int count = 0;
        for (int i = 0; i < steps; i++) {
            if (count >= concertMusics.size()) {
                count = 0;
            }
            playSong(concertMusics.get(count));
            count++;
        }
    }
}
