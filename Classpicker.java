import java.util.ArrayList;
import java.util.Random;

public class Classpicker {
    protected ArrayList<Class<?>> classes;

    Classpicker() {
        classes = new ArrayList<>();

        classes.add(PlayerCD.class);
        classes.add(MusicCD.class);
        classes.add(RecordPlayer.class);
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

        public static Items MakeRandomInstance(){
            Items a;
            int pick;
            Random r = new Random();
            pick =r.nextInt(15);
            switch (pick) {
                case 0 -> new PlayerCD();
                case 1 -> new MusicCD();
                case 3 -> new MP3();
                case 4 -> new Guitar();
                case 5 -> new Bass();
                case 6 -> new Mandolin();
                case 7 -> new Hats();
                case 8 -> new Shirts();
                case 9 -> new Bandanas();
                case 10 -> new PracticeAmps();
                case 11 -> new Cables();
                case 12 -> new Strings();
                default -> {
                    a = null;
                    System.out.println("whoops");
                }
            }
            return a;
            }
        }
    }

