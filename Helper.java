import java.util.Random;

public class Helper {
    public static int random_number(int max, int min) {
        Random rand = new Random();
        int randInt = rand.nextInt(max - min);
        return randInt + min;
    }
    private static String random_letter(){
        Random rand = new Random();
        String[] letterList = {"A","B","C","D","E","F","G","H","I","J"};
        int randInt = rand.nextInt(10);
        return letterList[randInt];
    }

    public static String random_name(String type){
        int number = Helper.random_number(1000,0);
        String letter = random_letter();
        return type+letter+number;
    }

    public static int random_purchasePrice(){
        int number  = Helper.random_number(50, 0);
        return number;
    }

//    public static String random_condition(){
//        Random rand = new Random();
//        String[] conditionList = {"poor","fair","good","very good","excellent"};
//        int rand_int = rand.nextInt(5);
//        return conditionList[rand_int];
//    }

    public static String random_newOrUsed(){
        Random rand = new Random();
        String[] newOrUsedList = {"new","used"};
        int rand_int = rand.nextInt(2);
        return newOrUsedList[rand_int];
    }
    public static boolean random_boolean(){
        Random rand = new Random();
        int rand_int = rand.nextInt(2);
        if (rand_int==0){
            return true;
        }
        return false;
    }

    public static int random_arriveDay(int day){
        Random rand = new Random();
        int rand_int = random_number(3,1);
        return day+rand_int;
    }



}
