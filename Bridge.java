public interface Bridge extends Elements {
    String type = null;
    int cost = 0;
    public String getType();
    public void setType(String type);
    public int getCost();
    public void setCost(int cost);
}

class BridgeA implements Bridge {
    private String type;
    private int cost;

    public BridgeA(int cost) {
        type = "BridgeA";
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

class BridgeB implements Bridge {
    private String type;
    private int cost;

    public BridgeB(int cost) {
        type = "BridgeB";
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

class BridgeC implements Bridge {
    private String type;
    private int cost;

    public BridgeC(int cost) {
        type = "BridgeC";
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