public class items {


        public String name;
        public int purchasePrice;
        public int listPrice;
        public int salePrice;
        public String newOrUsed;
        public String condition;
        public int daySold;
        public int dayArrived;

        public inialize_items{
        }
    }


    //First subclass and its subclasses of items:music
//1
    public class music extends items{
        public String band;
        public String album;
    }
//1.1
    public paperSocre extends music{

    }
//1.2
    public cd extends music{

    }
//1/3
    public vinyi extends music{

    }


    //Second subclass and its subclasses of items:players
//2
    public class players extends items{

    }
    //2.1
    public class cd extends players{

    }
    //2.2
    public class recordPlayer extends players{

    }
    //2.3
    public class mp3 extends players{

    }

    //Third
//3
    public class instruments extends items{

    }
    //3.1
    public class stringed extends instruments{
        public boolean electric;
    }
    //3.1.1
    public class mandolin extends stringed{

    }
    //3.1.2
    public class bass extends stringed{

    }
    //3.1.3
    public class guitar extends stringed{

    }
    //3.2
    public class wind extends instruments{

    }
    //3.2.1
    public class flute extends wind{
        public String type;
    }
    //3.2.2
    public class harmonica extends wind{

    }
    //3.3
    public class bandanas extends instruments{
    }

//Forth
//4
    public Accessories extends items{

    }
//4.1
    public practiceAmps extends Accessories{
        public int wattage;
    }
//4.2
    public cables extends Accessories{
        public int length;
    }
//4.3
    public strings extends Accessories{
    }
        }




