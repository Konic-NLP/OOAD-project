public interface Pickups extends Elements{
    String type = null;
    int cost = 0;
    public String getType();
    public void setType(String type);
    public int getCost();
    public void setCost(int cost);
}

class PickupsA implements Pickups{
    private String type;
    private int cost;

    public PickupsA(int cost){
        type = "PickupA";
        this.cost = cost;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
}

class PickupsB implements Pickups{
    private String type;
    private int cost;

    public PickupsB(int cost){
        type = "PickupB";
        this.cost = cost;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
}

class PickupsC implements Pickups{
    private String type;
    private int cost;

    public PickupsC(int cost){
        type = "PickupC";
        this.cost = cost;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
}

