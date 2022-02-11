import java.util.ArrayList;

 public class Items {

     //General attributes of all the items
     protected String name; // unique for each object
     protected String itemType; //unique for each (sub)class
     protected int purchasePrice; // the price for the store to restock
     protected int listPrice;  // the price for the buyer first time to consult
     protected int salePrice; // the terminal price for buyer to buy
     protected String newOrUsed;
     protected int condition;
     protected int daySold;  //when it sold, this attribute should be updated
     protected int dayArrived; // when it ordered, this attribute should be random set and updated

     // Constructor for items
     // The dayArrived is default to 0 since three objects of each subclass will be created at the first day of the store.
     public Items() {
         this.name = Helper.random_name(this.itemType);
         this.purchasePrice = Helper.random_purchasePrice();
         this.listPrice = 2 * this.purchasePrice;
         this.newOrUsed = Helper.random_newOrUsed();
         this.condition = Helper.random_number(5, 1);
         this.dayArrived = 0;
     }

     //Below is a bunch of getter functions to get the attributes of the items
     public String getName() {
         return this.name;
     }

     public String getItemType() {return this.itemType;}

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

     public String getConditionList(){
         return String[] {"Poor","Fair","Good","Very Good","Excellent"};
     }

     // Below is a bunch of setter functions to set the attributes of the items
     public void setName(String name) {
         this.name = name;
     }

     public void setItemType(String type) {
         this.itemType = itemType;
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

     public void setSalePrice(int price) {this.salePrice = price;}
 }

    //First subclass and its subclasses of items:music
    //1
    class Music extends Items{

        //Additional attributes for the music
        protected String band="";
        protected String album="";
        public Music(){
            super();
            this.band = Helper.random_name("band");
            this.album = Helper.random_name("album");
            this.itemType="Music";
            this.name = Helper.random_name(this.itemType);

        }

        //Addtional getter and setter for additional attributes.
        public String getBand(){return this.band;}
        public String getAlbum(){return this.album;}

        public void setBand(String band){this.band = band;}
        public void setAlbum(String album){this.album = album;}

     }
        //subclasses of music
        //1.1
        class PaperScore extends Music{
            public PaperScore(){
                super();
                this.itemType="PaperScore";
                this.name = Helper.random_name(this.itemType);
            }
            @Override
            public String getItemType(){return this.itemType;}

        }
        //1.2
       class MusicCD extends Music{
            public MusicCD(){
                super();
                this.itemType="MusicCD";
                this.name = Helper.random_name(this.itemType);

            }
            @Override
            public String getItemType(){return this.itemType;}
        }
        //1/3
        class Vinyl extends Music{
            public Vinyl(){
                super();
                this.itemType="Vinyl";
                this.name = Helper.random_name(this.itemType);

            }
            @Override
            public String getItemType(){return this.itemType;}
        }

    //Second subclass
    //2
    class Players extends Items {
        public Players(){
            super();
            this.itemType="Players";
            this.name = Helper.random_name(this.itemType);

        }
        @Override
        public String getItemType(){return this.itemType;}
    }

        //2.1
        class PlayerCD extends Players {
            public PlayerCD(){
                super();
                this.itemType="PlayerCD";
                this.name = Helper.random_name(this.itemType);

            }
            @Override
            public String getItemType(){return this.itemType;}
        }
        //2.2
        class RecordPlayer extends Players{
            public RecordPlayer(){
                super();
                this.itemType="RecordPlayer";
                this.name = Helper.random_name(this.itemType);

            }
            @Override
            public String getItemType(){return this.itemType;}
        }
        //2.3
        class MP3 extends Players{
            public MP3(){
                super();
                this.itemType="MP3";
                this.name = Helper.random_name(this.itemType);

            }
            @Override
            public String getItemType(){return this.itemType;}
        }

    //Third subclass
    //3
    class Instruments extends Items{
        public Instruments(){
            super();
            this.itemType="Instruments";
            this.name = Helper.random_name(this.itemType);

        }
        @Override
        public String getItemType(){return this.itemType;}
    }
        //3.1
        class Stringed extends Instruments{
         protected boolean electric;

         public Stringed(){
                super();
                this.electric = Helper.random_boolean();
                this.itemType="Stringed";
                this.name = Helper.random_name(this.itemType);

         }
            @Override
            public String getItemType(){return this.itemType;}

            // Additional getter and setter
            public boolean getElectric() {
                return electric;
            }
            public void setElectric(boolean electric){
                this.electric = electric;
            }
        }
            //3.1.1
            class Mandolin extends Stringed{
                public Mandolin(){
                    super();
                    this.itemType="Mandolin";
                    this.name = Helper.random_name(this.itemType);
                }
                @Override
                public String getItemType(){return this.itemType;}
            }
            //3.1.2
             class Bass extends Stringed{
                public Bass(){
                    super();
                    this.itemType="Bass";
                    this.name = Helper.random_name(this.itemType);
                }
                @Override
                public String getItemType(){return this.itemType;}
            }
            //3.1.3
            class Guitar extends Stringed{
                public Guitar(){
                    super();
                    this.itemType="Guitar";
                    this.name = Helper.random_name(this.itemType);
                }
                @Override
                public String getItemType(){return this.itemType;}
            }
        //3.2
        class Wind extends Instruments{
            public Wind(){
                super();
                this.itemType="Wind";
                this.name = Helper.random_name(this.itemType);
            }
            @Override
            public String getItemType(){return this.itemType;}
        }
            //3.2.1
            class Flute extends Wind{
                protected String type;
                public Flute(){
                    super();
                    this.type = Helper.random_name("type");
                    this.itemType="Flute";
                    this.name = Helper.random_name(this.itemType);
                }
                @Override
                public String getItemType(){return this.itemType;}
                public void setType(String itemType) {
                    this.itemType = itemType;
                }
                public String getType() {
                    return itemType;
                }
            }


            //3.2.2
            class Harmonica extends Wind{
                private String key;
                public Harmonica(){
                    super();
                    this.key = Helper.random_name("key");
                    this.itemType="Harmonica";
                    this.name = Helper.random_name(this.itemType);
                }
                @Override
                public String getItemType(){return this.itemType;}
                public void setKey(String key) {
                    this.key = key;
                }
                public String getKey() {
                    return this.key;
                }
            }


    //Fourth subclass
    //4
    class Clothing extends Items{
        public Clothing(){
            super();
            this.itemType="Clothing";
            this.name = Helper.random_name(this.itemType);
        }
        @Override
        public String getItemType(){return this.itemType;}
    }
        //4.1
      class Hats extends Clothing{
            private int hatSize;
            public Hats(){
                super();
                this.hatSize = Helper.random_number(5,1);
                this.itemType="Hats";
                this.name = Helper.random_name(this.itemType);
            }
            @Override
            public String getItemType(){return this.itemType;}

            public void setHatSize(int size) {
                this.hatSize = size;
            }
            public int getHatSize() {
                return hatSize;
            }
        }

        //4.2
       class Shirts extends Clothing {
            private int shirtSize;

            public Shirts() {
                super();
                this.shirtSize = Helper.random_number(5, 1);
                this.itemType = "Shirts";
                this.name = Helper.random_name(this.itemType);
            }

            @Override
            public String getItemType() {return this.itemType;}

            public void setShirtSize(int size) {
                this.shirtSize = size;
            }
            public int getHatSize() {
                return shirtSize;
            }
        }

        //4.3
         class Bandanas extends Clothing{
            public Bandanas() {
                super();
                this.itemType = "Bandanas";
                this.name = Helper.random_name(this.itemType);
            }
            @Override
            public String getItemType(){return this.itemType;}
        }


    //Fifth subclass
    //5
    class Accessories extends Items{
        public Accessories() {
            super();
            this.itemType = "Accessories";
            this.name = Helper.random_name(this.itemType);
        }
        @Override
        public String getItemType(){return this.itemType;}
    }
        //5.1
        class PracticeAmps extends Accessories {
            private int wattage;

            public PracticeAmps() {
                super();
                this.wattage = Helper.random_number(10, 1);
                this.itemType = "PracticeAmps";
                this.name = Helper.random_name(this.itemType);
            }

            @Override
            public String getItemType() {return this.itemType;}

            public void setWattage(int wattage) {
                this.wattage = wattage;
            }
            public int getWattage() {
                return wattage;
            }
        }
        //5.2
       class Cables extends Accessories {
            private int length;
            public Cables() {
                super();
                this.length = Helper.random_number(10,1);
                this.itemType = "PracticeAmps";
                this.name = Helper.random_name(this.itemType);
            }
            @Override
            public String getItemType(){return this.itemType;}

            public void setLength(int length) {
                this.length = length;
            }
            public int getLength() {
                return length;
            }
        }

       //5.3
      class Strings extends Accessories {
           private String type;
           public Strings() {
               super();
               this.type = Helper.random_name(type);
               this.itemType = "Strings";
               this.name = Helper.random_name(this.itemType);
           }
           @Override
           public String getItemType () {return this.itemType;}

           public void setType (String itemType){this.itemType = itemType;}
           public String getType() {return itemType;}
       }









