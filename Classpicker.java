import java.util.ArrayList;
import java.util.Random;

//The belowing code is adapted and inspried from Professor Bruce's code post in the Piazza.
//weblink https://canvas.colorado.edu/courses/79638/external_tools/1711

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
    //The belowing method is return and create an object of random subclass introduced in the Items.java.
    public static Items MakeRandomInstance() {
        Items a;
        int pick;
        Random r = new Random();
        pick = r.nextInt(17);
        switch (pick) {
            case 0 :  a  = new PaperScore(); break;
            case 1 : a  = new MusicCD();break;
            case 2 : a = new Vinyl();break;
            case 3 : a = new PlayerCD();break;
            case 4 : a =  new RecordPlayer();break;
            case 5 : a =  new MP3();break;
            case 6 : a = new Bass();break;
            case 7 : a = new Mandolin();break;
            case 8 : a = new Flute();break;
            case 9 : a = new Harmonica();break;
            case 10 : a = new Hats();break;
            case 11 : a = new Shirts();break;
            case 12 : a = new Bandanas();break;
            case 13 : a = new PracticeAmps();break;
            case 14 : a = new Cables();break;
            case 15 : a = new Strings();break;
            case 16 : a = new Guitar();break;
            default  :{
                a = null;
                System.out.println("whoops");
            }
        }
        return a;

    }
}

