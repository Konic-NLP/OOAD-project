import java.util.ArrayList;

 public class Items {

    //General attributes of all the items
    protected String name; // unique for each object
    protected String itemType ; //unique for each class
    protected int purchasePrice; // the price for the store to restock
    protected int listPrice;  // the price for the buyer first time to consult
    protected int salePrice; // the terminal price for buyer to buy
    protected String newOrUsed; // temporally not used
    protected int condition; // just for seller to sell item
    protected int daySold;  //when it sold, this attribute should be updated
    protected int dayArrived; // when it ordered, this attribute should be updated

     public Items(){
         this.purchasePrice = Helper.random_purchasePrice();
         this.listPrice=2*this.purchasePrice;
         this.name = Helper.random_name(this.itemType);
         this.newOrUsed = Helper.random_newOrUsed();
         this.condition = Helper.random_number(5,1);
         this.dayArrived = Helper.random_number(3,1);
     }

    //Below is a bunch of getter functions to get the attributes of the items
    public String getName() {
        return this.name;
    }
    public int getPurchasePrice() {
        return purchasePrice;
    }
    public int getListPrice() {
        return listPrice;
    }
    public int getSalePrice() {
        return salePrice;
    }
    public int getCondition() {
        return condition;
    }
    public String getNewOrUsed() {
        return newOrUsed;
    }
    public int getDaySold() {
        return daySold;
    }
    public int getDayArrived() {
        return dayArrived;
    }
    public String getItemType(){return this.itemType;}


    // Below is a bunch of setter functions to set the attributes of the items
    public void setName(String name) {
        this.name = name;
    }
    public void setPurchasePrice(int price) {
        this.purchasePrice = price;
    }
    public void setListPrice(int price) {
        this.listPrice = price;
    }
    public void setNewOrUsed(String newOrUsed) {
        this.newOrUsed = newOrUsed;
    }
    public void setCondition(int condition) {
        this.condition = condition;
    }
    public void setDaySold(int day) {
        this.daySold = day;
    }
    public void setDayArrived(int day) {
        this.dayArrived = day;
    }
    public void setSalePrice(int price){this.salePrice = price;}

    //



    


//    public void initialize_forSelller(int condition) {
//        int price = condition * Helper.random_number(10, 1);
//        this.purchasePrice = price;
//    }



//    public void do_stock(){
////        initialize_main(0);
////        initialize_price();
//    }
//}




    //First subclass and its subclasses of items:music
    //1
    class Music extends Items{

        //Attributes for the music
//        protected String itemType = "Music";
        protected String band="";
        protected String album="";
       Music(){
            super();
            this.itemType="Music";

        }}

//        Getter methods for Music
//        public String getBand() {
//            return this.band;
//        }
//        public String getAlbum() {
//            return album;
//        }
//
//
////        Setter methods for music
//        public void setBand(String band) {
//            this.band = band;
//        }
//        public void setAlbum(String album) {
//            this.album = album;
//        }

        // Constructor for Music
//        public void initialize_main(int day){
//            this.name = Helper.random_name(this.itemType);
//            this.newOrUsed = Helper.random_newOrUsed();
//            this.condition = Helper.random_number(5,1);
//            this.dayArrived = day;
//            this.band = Helper.random_name("band");
//            this.album = Helper.random_name("album");
//        }
//    }

        //subclasses of music
        //1.1
        class PaperScore extends Music{

//            protected String itemType;
            public PaperScore(){
                super();
                this.itemType="PaperScore";
            }
            @Override
            public String getItemType(){return this.itemType;}

        }
        //1.2
       class MusicCD extends Music{
            protected String itemType = "MusicCD";
            @Override
            public String getItemType(){return this.itemType;}
        }
        //1/3
        class Vinyl extends Music{
            protected String itemType = "Vinyl";
            @Override
            public String getItemType(){return this.itemType;}
        }

    //Second subclass
    //2
    class Players extends Items {
        protected String itemType = "Player";
        @Override
        public String getItemType(){return this.itemType;}
    }

        //2.1
        class PlayerCD extends Players {
            protected String itemType = "PlayerCD";
            @Override
            public String getItemType(){return this.itemType;}
        }
        //2.2
        class RecordPlayer extends Players{
            protected String itemType = "RecordPlayer";
            @Override
            public String getItemType(){return this.itemType;}
        }
        //2.3
        class MP3 extends Players{
            protected String itemType = "MP3";
            @Override
            public String getItemType(){return this.itemType;}
        }

    //Third subclass
    //3
    class Instruments extends Items{
        protected String itemType = "Instruments";
        @Override
        public String getItemType(){return this.itemType;}
    }
        //3.1
        class Stringed extends Instruments{
            protected String itemType = "Stringed";
            @Override
            public String getItemType(){return this.itemType;}
            private boolean electric;

            public boolean getElectric() {
                return electric;
            }
            public void setElectric(boolean electric){
                this.electric = electric;
            }

            public void initialize_main(int day) {
                this.name = Helper.random_name(this.itemType);
                this.newOrUsed = Helper.random_newOrUsed();
                this.condition = Helper.random_number(5,1);
                this.dayArrived = day;
                this.electric = Helper.random_boolean();
            }

        }
            //3.1.1
            class Mandolin extends Stringed{
                protected String itemType = "Mandolin";
                @Override
                public String getItemType(){return this.itemType;}
            }
            //3.1.2
             class Bass extends Stringed{
                protected String itemType = "Bass";
                @Override
                public String getItemType(){return this.itemType;}
            }
            //3.1.3
            class Guitar extends Stringed{
                protected String itemType = "Guitar";
                @Override
                public String getItemType(){return this.itemType;}
            }
        //3.2
        class Wind extends Instruments{
            protected String itemType = "Wind";
            @Override
            public String getItemType(){return this.itemType;}
        }
            //3.2.1
            class Flute extends Wind{
                protected String itemType = "Flute";
                @Override
                public String getItemType(){return this.itemType;}
                private String type;

                public void setType(String itemType) {
                    this.itemType = itemType;
                }

                public String getType() {
                    return itemType;
                }

                public void initialize_main(int day) {
                    this.name = Helper.random_name(this.itemType);
                    this.newOrUsed = Helper.random_newOrUsed();
                    this.condition = Helper.random_number(5,1);
                    this.dayArrived = day;
                    this.type = Helper.random_name("type");
                }
            }

            //3.2.2
            class Harmonica extends Wind{
                private String key;
                protected String itemType = "Harmonica";
                @Override
                public String getItemType(){return this.itemType;}

                public void setKey(String key) {
                    this.key = key;
                }

                public String getKey() {
                    return key;
                }

                public void initialize_main(int day) {
                    this.name = Helper.random_name(this.itemType);
                    this.newOrUsed = Helper.random_newOrUsed();
                    this.condition = Helper.random_number(5,1);
                    this.dayArrived = day;
                    this.key  = Helper.random_name("key");
                }
            }


    //Fourth subclass
    //4
    class Clothing extends Items{
        protected String itemType = "Clothing";
    }
        //4.1
      class Hats extends Clothing{
            protected String itemType = "Hats";
            @Override
            public String getItemType(){return this.itemType;}
            private int hatSize;

            public void setHatSize(int size) {
                this.hatSize = size;
            }

            public int getHatSize() {
                return hatSize;
            }

            public void initialize_main(int day) {
                this.name = Helper.random_name(this.itemType);
                this.newOrUsed = Helper.random_newOrUsed();
                this.condition = Helper.random_number(5,1);
                this.dayArrived = day;
                this.hatSize = Helper.random_number(5,1);
            }
        }

        //4.2
       class Shirts extends Clothing{
            protected String itemType = "Shirts";
            @Override
            public String getItemType(){return this.itemType;}
            private int shirtSize;

            public void setShirtSize(int size) {
                this.shirtSize = size;
            }

            public int getHatSize() {
                return shirtSize;
            }
            public String getName(){return this.name;}
            public void initialize_main(int day) {
                this.name = Helper.random_name(this.itemType);
                this.newOrUsed = Helper.random_newOrUsed();
                this.condition = Helper.random_number(5,1);
                this.dayArrived = day;
                this.shirtSize = Helper.random_number(5,1);
            }
        }

        //4.3
         class Bandanas extends Clothing{
            protected String itemType = "Bandanas";
            @Override
            public String getItemType(){return this.itemType;}
        }


    //Fifth subclass
    //5
    class Accessories extends Items{
        protected String itemType = "Accessories";

    }
        //5.1
        class PracticeAmps extends Accessories {
            protected String itemType = "PracticeAmps";
            @Override
            public String getItemType(){return this.itemType;}
            private int wattage;

            public void setWattage(int wattage) {
                this.wattage = wattage;
            }

            public int getWattage() {
                return wattage;
            }

            public void initialize_main(int day) {
                this.name = Helper.random_name(this.itemType);
                this.newOrUsed = Helper.random_newOrUsed();
                this.condition = Helper.random_number(5, 1);
                this.dayArrived = day;
                this.wattage = Helper.random_number(10, 1);
            }
        }
        //5.2
       class Cables extends Accessories {
            protected String itemType = "Cables";
            @Override
            public String getItemType(){return this.itemType;}
            private int length;

            public void setLength(int length) {
                this.length = length;
            }

            public int getLength() {
                return length;
            }

            public void initialize_main(int day) {
                this.name = Helper.random_name(this.itemType);
                this.newOrUsed = Helper.random_newOrUsed();
                this.condition = Helper.random_number(5, 1);
                this.dayArrived = day;
                this.length = Helper.random_number(10, 1);
            }
        }
       //5.3
      class Strings extends Accessories {
           protected String itemType = "Strings";
           @Override
           public String getItemType(){return this.itemType;}
           private String type;

           public void setType(String itemType) {
               this.itemType = itemType;
           }

           public String getType() {
               return itemType;
           }

           public void initialize_main(int day) {
               this.name = Helper.random_name(this.itemType);
               this.newOrUsed = Helper.random_newOrUsed();
               this.condition = Helper.random_number(5, 1);
               this.dayArrived = day;
               this.type = Helper.random_name("type");
           }
       }}







