public interface KnobSet extends Elements{
    String type = null;
    int cost = 0;
    public String getType();
    public void setType(String type);
    public int getCost();
    public void setCost(int cost);
}

class KnobSetA implements KnobSet{
    private String type;
    private int cost;

    public KnobSetA(int cost){
        type = "KnobSetA";
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

class KnobSetB implements KnobSet{
    private String type;
    private int cost;

    public KnobSetB(int cost){
        type = "KnobSetB";
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

class KnobSetC implements KnobSet{
    private String type;
    private int cost;

    public KnobSetC(int cost){
        type = "KnobSetC";
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
