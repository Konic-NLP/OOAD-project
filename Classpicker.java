import java.util.ArrayList;
import java.util.Random;

public class Classpicker {
    protected ArrayList<Class<?>> classes;

    Classpicker() {
        classes = new ArrayList<>();

        classes.add(PaperScore.class);
        classes.add(Vinyl.class);
        classes.add(MusicCD.class);
        classes.add(RecordPlayer.class);
        classes.add(PlayerCD.class);
        classes.add(MP3.class);
        classes.add(Guitar.class);
        classes.add(Bass.class);
        classes.add(Mandolin.class);
        classes.add(Flute.class);
        classes.add(Harmonica.class);
        classes.add(Hats.class);
        classes.add(Shirts.class);
        classes.add(Bandanas.class);
        classes.add(PracticeAmps.class);
        classes.add(Cables.class);
        classes.add(Strings.class);
    }

    public static Items MakeRandomInstance() {
        Items a;
        int pick;
        Random r = new Random();
        pick = r.nextInt(13);
        System.out.println(pick);
        switch (pick) {
            case 0 ->  a  = new PaperScore();
            case 1 -> a  = new MusicCD();
            case 2 -> a = new Vinyl();
            case 3 -> a = new PlayerCD();
            case 4 -> a =  new RecordPlayer();
            case 5 -> a =  new MP3();
            case 6 -> a = new Bass();
            case 7 -> a = new Mandolin();
            case 8 -> a = new Flute();
            case 9 -> a = new Harmonica();
            case 10 -> a = new Hats();
            case 11 -> a = new Shirts();
            case 12 -> a = new Bandanas();
            case 13 -> a = new PracticeAmps();
            case 14 -> a = new Cables();
            case 15 -> a = new Strings();
            case 16 -> a = new Guitar();
            default -> {
                a = null;
                System.out.println("whoops");
            }
        }
        return a;

    }
}

