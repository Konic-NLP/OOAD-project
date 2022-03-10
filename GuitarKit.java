import java.util.ArrayList;

interface Elements{
    String type = null;
    int cost = 0;
    public String getType();
    public void setType(String type);
    public int getCost();
    public void setCost(int cost);
}

public class GuitarKit extends Items {

    private ArrayList<Elements> elementList;

    public GuitarKit(Bridge bridge,KnobSet knobSet,Covers covers,Neck neck,Pickguard pickguard,Pickups pickups){
        this.elementList=new ArrayList<Elements>();
        this.elementList.add(bridge);
        this.elementList.add(knobSet);
        this.elementList.add(covers);
        this.elementList.add(neck);
        this.elementList.add(pickguard);
        this.elementList.add(pickups);
        this.salePrice = getSumPrice();
        this.itemType="GuitarKit";
        this.name = Helper.random_name(this.itemType);
    }
    public int getSumPrice(){
        int sum = 0;
        for (int i = 0; i<elementList.size(); i++){
            sum +=elementList.get(i).getCost();
        }
        return sum;

    }
    public int getSaleOrice(){

        return salePrice;
    }

    public ArrayList<Elements> getElementList() {
        return elementList;
    }

    public void setElementList(ArrayList<Elements> elementList) {
        this.elementList = elementList;
    }
}
