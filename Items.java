class Items {

    //General attributes of all the items
    public String name;
    public int purchasePrice;
    public int listPrice;
    public int salePrice;
    public String newOrUsed;
    public String condition;
    public int daySold;
    public int dayArrived;


    //Below is a bunch of getter functions to get the attributes of the items
    public String getName() {
        return name;
    }
    public int purchasePrice() {
        return purchasePrice;
    }
    public int listPrice() {
        return listPrice;
    }
    public int salePrice() {
        return salePrice;
    }
    public String getCondition() {
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
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setDaySold(int day) {
        this.daySold = day;
    }
    public void setDayArrived(int day) {
        this.dayArrived = day;
    }
}



    //First subclass and its subclasses of items:music
    //1
    class Music extends Items{

        //Attributes for the music
        private String band;
        private String album;


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
    }

        //subclasses of music
        //1.1
        class PaperScore extends Music{
        }
        //1.2
        class MusicCD extends Music{
        }
        //1/3
        class Vinyl extends Music{
        }

    //Second subclass
    //2
    class Players extends Items {
    }

        //2.1
        class PlayerCD extends Players {
        }
        //2.2
        class RecordPlayer extends Players{
        }
        //2.3
        class MP3 extends Players{
        }

    //Third subclass
    //3
    class Instruments extends Items{
    }
        //3.1
        class Stringed extends Instruments{
            private boolean electric;

            public boolean getElectric() {
                return electric;
            }
            public void setElectric(boolean electric){
                this.electric = electric;
                }
        }
            //3.1.1
            class Mandolin extends Stringed{
            }
            //3.1.2
            class Bass extends Stringed{
            }
            //3.1.3
            class Guitar extends Stringed{
            }
        //3.2
        class Wind extends Instruments{
        }
            //3.2.1
            class Flute extends Wind{
                private String type;

                public void setType(String type) {
                    this.type = type;
                }

                public String getType() {
                    return type;
                }
            }

            //3.2.2
            class Harmonica extends Wind{
                private String key;

                public void setKey(String key) {
                    this.key = key;
                }

                public String getKey() {
                    return key;
                }
            }


    //Fourth subclass
    //4
    class Clothing extends Items{
    }
        //4.1
        class Hats extends Clothing{
            private int hatSize;

            public void setHatSize(int size) {
                this.hatSize = size;
            }

            public int getHatSize() {
                return hatSize;
            }
        }

        //4.2
        class Shirts extends Clothing{
            private int shirtSize;

            public void setShirtSize(int size) {
                this.shirtSize = size;
            }

            public int getHatSize() {
                return shirtSize;
            }
        }

        //4.3
        class Bandanas extends Clothing{
        }


    //Fifth subclass
    //5
    class Accessories extends Items{
    }
        //5.1
        class PracticeAmps extends Accessories{
            private int wattage;

            public void setWattage(int wattage) {
                this.wattage = wattage;
            }

            public int getWattage() {
                return wattage;
            }
    }
        //5.2
        class Cables extends Accessories{
            private int length;

            public void setLength(int length) {
                this.length = length;
            }

            public int getLength() {
                return length;
            }
        }
       //5.3
        class Strings extends Accessories{
           private String type;

           public void setType(String type) {
               this.type = type;
           }

           public String getType() {
               return type;
           }
        }







