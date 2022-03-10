public interface Covers extends Elements  {
    String type = null;
    int cost = 0;
    public String getType();
    public void setType(String type);
    public int getCost();
    public void setCost(int cost);
}

class CoversA implements Covers{
    private String type;
    private int cost;

    public CoversA(int cost){
        type = "CoversA";
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

class CoversB implements Covers{
    private String type;
    private int cost;

    public CoversB(int cost){
        type = "CoversB";
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

class CoversC implements Covers{
    private String type;
    private int cost;

    public CoversC(int cost){
        type = "CoversC";
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

