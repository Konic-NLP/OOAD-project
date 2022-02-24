import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.File;

public class Tracker implements Observer {
    private int day;
    private HashMap<String, HashMap<String, Integer>> content;
    private Subject subject;

    public Tracker(Subject subject) throws FileNotFoundException {
        this.subject = subject;
        this.subject.registerObserver(this);
        this.content = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.putIfAbsent("Items Sold",0);
        hashMap.putIfAbsent("Items Purchased",0);
        hashMap.putIfAbsent("Items Damaged",0);
//        System.out.println(hashMap.toString());
//        System.out.println(content.toString());
        content.putIfAbsent("Shaggy",hashMap);

//        System.out.println(hashMap.toString());
//        System.out.println(content.toString());
        content.putIfAbsent("Daphne",hashMap);
        content.putIfAbsent("Velma",hashMap);
        this.day=0;
    }

    @Override
    public void update(int caseNumber, String name, int number) {


        int newNumber;
        switch (caseNumber) {
            case 10:
            case 6:
                newNumber = content.get(name).get("Items Damaged") + number;
                content.get(name).replace("Items Damaged", newNumber);
                break;
            case 8:
                newNumber = content.get(name).get("Items Sold") + number;
                content.get(name).replace("Items Sold", newNumber);
                break;
            case 9:
                newNumber = content.get(name).get("Items Purchased") + number;
                content.get(name).replace("Items Purchased", newNumber);
                break;
            case 11:
                this.day+=1;
                write();
                break;
        }
    }
    public void write(){
        System.out.println("++++++++++++++++++");
        System.out.println("Day: "+day);
        System.out.println(content.toString());
        System.out.println("++++++++++++++++++");
    }

}
