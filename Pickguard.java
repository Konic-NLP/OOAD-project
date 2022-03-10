public interface Pickguard extends Elements{
    String type = null;
    int cost = 0;
    public String getType();
    public void setType(String type);
    public int getCost();
    public void setCost(int cost);
}

class PickguardA implements Pickguard{
    private String type;
    private int cost;

    public PickguardA(int cost){
        type = "PickguardA";
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

class PickguardB implements Pickguard{
    private String type;
    private int cost;

    public PickguardB(int cost){
        type = "PickguardB";
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

class PickguardC implements Pickguard{
    private String type;
    private int cost;

    public PickguardC(int cost){
        type = "PickguradC";
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
