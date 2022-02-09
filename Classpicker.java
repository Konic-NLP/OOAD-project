import java.util.ArrayList;
import java.util.Random;

public class Classpicker {
    protected ArrayList<Class<?>> classes;

    Classpicker(){
        classes = new ArrayList <>();

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

       public Items MakeRandomInstance(){
           Items a;
           int pick;
           Random r = new Random();
           Class<?> c = classes.get(pick);
           Class<?> [] parameterType = null;
           Object [] initargs = null;
           try{
               a = (Items) c.getDeclaredConstructor(parameterType).newInstance(initargs);
           }
           catch (Exception e ){
               System.out.println("whoops"+e.toString());
               a = null;
           }
           return a;
        }





    }
}
