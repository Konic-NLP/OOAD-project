class Items {

    //General attributes of all the items
    protected String name;
    protected String itemType = "Item";
    protected int purchasePrice;
    protected int listPrice;
    protected int salePrice;
    protected String newOrUsed;
    protected int condition;
    protected int daySold;
    protected int dayArrived;



    //Below is a bunch of getter functions to get the attributes of the items
    public String getName() {
        return name;
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
    public String getItemType(){return getItemType();}


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
    protected int generate_Listprice(){
        int number =  2*this.purchasePrice;
        return number;
    }

    // Constructor for items
    public void initialize_main(int day){
        this.name = Helper.random_name(this.itemType);
        this.newOrUsed = Helper.random_newOrUsed();
        this.condition = Helper.random_number(5,1);
        this.dayArrived = day;

    }
    
    public void initialize_price(){
        this.purchasePrice = Helper.random_purchasePrice();
        this.listPrice = this.generate_Listprice();
    }

    public void initalize_arriveDay(int day){
        this.dayArrived = Helper.randome_arriveDay(day);
    }
}





    //First subclass and its subclasses of items:music
    //1
    class Music extends Items{

        //Attributes for the music
        protected String itemType = "Music";
        protected String band;
        protected String album;


        //Getter methods for Music
        public String getBand() {
            return band;
        }
        public String getAlbum() {
            return album;
        }


        //Setter methods for music
        public void setBand(String band) {
            this.band = band;
        }
        public void setAlbum(String album) {
            this.album = album;
        }

        // Constructor for Music
        public void initialize_main(int day){
            this.name = Helper.random_name(this.itemType);
            this.newOrUsed = Helper.random_newOrUsed();
            this.condition = Helper.random_number(5,1);
            this.dayArrived = day;
            this.band = Helper.random_name("band");
            this.album = Helper.random_name("album");
        }
    }

        //subclasses of music
        //1.1
        class PaperScore extends Music{
            protected String itemType = "PaperScore";
        }
        //1.2
        class MusicCD extends Music{
            protected String itemType = "MusicCD";
        }
        //1/3
        class Vinyl extends Music{
            protected String itemType = "Vinyl";   
        }

    //Second subclass
    //2
    class Players extends Items {
        protected String itemType = "Player";
    }

        //2.1
        class PlayerCD extends Players {
            protected String itemType = "PlayerCD";
        }
        //2.2
        class RecordPlayer extends Players{
            protected String itemType = "RecordPlayer";
        }
        //2.3
        class MP3 extends Players{
            protected String itemType = "MP3";
        }

    //Third subclass
    //3
    class Instruments extends Items{
        protected String itemType = "Instruments";
    }
        //3.1
        class Stringed extends Instruments{
            protected String itemType = "Stringed";
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
            }
            //3.1.2
            class Bass extends Stringed{
                protected String itemType = "Bass";
            }
            //3.1.3
            class Guitar extends Stringed{
                protected String itemType = "Guitar";
            }
        //3.2
        class Wind extends Instruments{
            protected String itemType = "Wind";
        }
            //3.2.1
            class Flute extends Wind{
                protected String itemType = "Flute";
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
            private int shirtSize;

            public void setShirtSize(int size) {
                this.shirtSize = size;
            }

            public int getHatSize() {
                return shirtSize;
            }

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
        }


    //Fifth subclass
    //5
    class Accessories extends Items{
        protected String itemType = "Accessories";
    }
        //5.1
        class PracticeAmps extends Accessories {
            protected String itemType = "PracticeAmps";
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
       }







