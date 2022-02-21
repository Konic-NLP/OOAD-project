public class Property {
    private String type;
    private boolean value=false;
    private int chance=0;
    public Property(int chance,String name){
        this.chance=chance;
        this.type=name;
    }
    public boolean getValue(){return this.value;}
    public void setValue(boolean value){ this.value=value;};
    public int getChance(){return this.chance;}
    public String getName(){return this.type;}

}
