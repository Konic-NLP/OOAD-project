import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.io.File;


//Apply Singleton Patter for Tracker
//Eager Instantiation
public class Tracker implements Observer {
    // two static methods that enables eager instantiation of the singleton pattern
    private static Tracker uniqueInstance=new Tracker();







    private int day;
    // using a nested dict to record the data, key of outsider dict is the name of staff, and the key inside the dict
    // is the items that required to record
    private HashMap<String, HashMap<String, Integer>> content;
    private Subject subject;
    //
    private Tracker()  {


        content = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.putIfAbsent("Items Sold",0);
        hashMap.putIfAbsent("Items Purchased",0);
        hashMap.putIfAbsent("Items Damaged",0);
//        System.out.println(hashMap.toString());
//        System.out.println(content.toString());
        content.putIfAbsent("Shaggy",hashMap);

        HashMap<String,Integer> hashMap1 = new HashMap<>();
        hashMap1.putIfAbsent("Items Sold",0);
        hashMap1.putIfAbsent("Items Purchased",0);
        hashMap1.putIfAbsent("Items Damaged",0);
//        System.out.println(hashMap.toString());
//        System.out.println(content.toString());
        content.putIfAbsent("Daphne",hashMap1);
        HashMap<String,Integer> hashMap2 = new HashMap<>();
        hashMap2.putIfAbsent("Items Sold",0);
        hashMap2.putIfAbsent("Items Purchased",0);
        hashMap2.putIfAbsent("Items Damaged",0);
        content.putIfAbsent("Velma",hashMap2);
        HashMap<String,Integer> hashMap3 = new HashMap<>();
        hashMap3.putIfAbsent("Items Sold",0);
        hashMap3.putIfAbsent("Items Purchased",0);
        hashMap3.putIfAbsent("Items Damaged",0);
        content.putIfAbsent("Tom",hashMap3);
        HashMap<String,Integer> hashMap4 = new HashMap<>();
        hashMap4.putIfAbsent("Items Sold",0);
        hashMap4.putIfAbsent("Items Purchased",0);
        hashMap4.putIfAbsent("Items Damaged",0);
        content.putIfAbsent("Jerry",hashMap4);
        day=0;
    }

    public static Tracker getInstance(Subject subject){
        subject.registerObserver(uniqueInstance);
        return uniqueInstance;

    }
    public void register(Subject subject){

        subject.registerObserver(Tracker.uniqueInstance);
    }
    // update the value in the insider dict based on the code
    @Override
    public void update(int caseNumber, int storenumber,String name, int number) {


        int newNumber;
        switch (caseNumber) {
            case 10:
            case 6:
//                System.out.println(content.get(name).get("Items Damaged"));
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
            case 12:
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
//    public void update(int caseNumber,int storeName, String name, int number){} ;


}
