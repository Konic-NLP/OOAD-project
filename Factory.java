public interface Factory {
    public Bridge createBridge(int num);
    public KnobSet createKnobSet(int num);
    public Covers createCovers(int num);
    public Neck createNeck(int num);
    public Pickguard createPickGuard(int num);
    public Pickups createPickups(int num);
    public GuitarKit generate(int num1,int num2, int num3, int num4, int num5, int num6);
}
class FactoryNorth implements Factory{
    public GuitarKit generate(int num1,int num2, int num3, int num4, int num5, int num6){
        Bridge bridge = createBridge(num1);
        KnobSet knobSet = createKnobSet(num2);
        Covers covers =createCovers(num3);
        Neck neck = createNeck(num4);
        Pickguard pg = createPickGuard(num5);
        Pickups pu = createPickups(num6);

        GuitarKit guitarKit = new GuitarKit(bridge,knobSet,covers,neck,pg,pu);
        return guitarKit;
    }
    @Override
    public Bridge createBridge(int num1) {
        Bridge a;
        switch (num1){
            case(0): a = new BridgeA(3); break;
            case(1): a = new BridgeB(4); break;
            case(2): a = new BridgeC(5); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num1);
        }
        return a;
    }

    @Override
    public KnobSet createKnobSet(int num2) {
        KnobSet a;
        switch (num2){
            case(0): a = new KnobSetA(3); break;
            case(1): a = new KnobSetB(4); break;
            case(2): a = new KnobSetC(5); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num2);
        }
        return a;
    }

    @Override
    public Covers createCovers(int num3) {
        Covers a;
        switch (num3){
            case(0): a = new CoversA(3); break;
            case(1): a = new CoversB(4); break;
            case(2): a = new CoversC(5); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num3);
        }
        return a;
    }

    @Override
    public Neck createNeck(int num4) {
        Neck a;
        switch (num4){
            case(0): a = new NeckA(3); break;
            case(1): a = new NeckB(4); break;
            case(2): a = new NeckC(5); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num4);
        }
        return a;
    }

    @Override
    public Pickguard createPickGuard(int num5) {
        Pickguard a;
        switch (num5){
            case(0): a = new PickguardA(3); break;
            case(1): a = new PickguardB(4); break;
            case(2): a = new PickguardC(5); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num5);
        }
        return a;
    }

    @Override
    public Pickups createPickups(int num6) {
        Pickups a;
        switch (num6){
            case(0): a = new PickupsA(3); break;
            case(1): a = new PickupsB(4); break;
            case(2): a = new PickupsC(5); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num6);
        }
        return a;
    }

}

class FactorySouth implements Factory{
    public GuitarKit generate(int num1,int num2, int num3, int num4, int num5, int num6){
        Bridge bridge = createBridge(num1);
        KnobSet knobSet = createKnobSet(num2);
        Covers covers =createCovers(num3);
        Neck neck = createNeck(num4);
        Pickguard pg = createPickGuard(num5);
        Pickups pu = createPickups(num6);

        GuitarKit guitarKit = new GuitarKit(bridge,knobSet,covers,neck,pg,pu);
        return guitarKit;
    }
    @Override
    public Bridge createBridge(int num1) {
        Bridge a;
        switch (num1){
            case(0): a = new BridgeA(6); break;
            case(1): a = new BridgeB(8); break;
            case(2): a = new BridgeC(10); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num1);
        }
        return a;
    }

    @Override
    public KnobSet createKnobSet(int num2) {
        KnobSet a;
        switch (num2){
            case(0): a = new KnobSetA(6); break;
            case(1): a = new KnobSetB(8); break;
            case(2): a = new KnobSetC(10); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num2);
        }
        return a;
    }

    @Override
    public Covers createCovers(int num3) {
        Covers a;
        switch (num3){
            case(0): a = new CoversA(6); break;
            case(1): a = new CoversB(8); break;
            case(2): a = new CoversC(10); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num3);
        }
        return a;
    }

    @Override
    public Neck createNeck(int num4) {
        Neck a;
        switch (num4){
            case(0): a = new NeckA(6); break;
            case(1): a = new NeckB(8); break;
            case(2): a = new NeckC(10); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num4);
        }
        return a;
    }

    @Override
    public Pickguard createPickGuard(int num5) {
        Pickguard a;
        switch (num5){
            case(0): a = new PickguardA(6); break;
            case(1): a = new PickguardB(8); break;
            case(2): a = new PickguardC(10); break;
            default:
                    throw new IllegalStateException("Unexpected value: " + num5);
        }
        return a;
    }

    @Override
    public Pickups createPickups(int num6) {
        Pickups a;
        switch (num6){
            case(0): a = new PickupsA(6); break;
            case(1): a = new PickupsB(8); break;
            case(2): a = new PickupsC(10); break;
            default:
                throw new IllegalStateException("Unexpected value: " + num6);
        }
        return a;
    }
}