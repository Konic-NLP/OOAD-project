import java.util.Random;


//This class is made of mutiple methods with simple functions that are used to create random names, number,prices for items and other classes.
public class Helper {
    //The below method is to return a number(price) ranging from min to max inclusively
    public static int random_number(int max, int min) {
        Random rand = new Random();
        int randInt = rand.nextInt(max - min);
        return randInt + min;
    }
    //This method is to return a random letter chosen from the list
    private static String random_letter(){
        Random rand = new Random();
        String[] letterList = {"A","B","C","D","E","F","G","H","I","J"};
        int randInt = rand.nextInt(10);
        return letterList[randInt];
    }
    //This method is to make a random combination of number and letters to repsent the name of items.
    public static String random_name(String type){
        int number = Helper.random_number(1000,1);
        String letter = random_letter();
        return type+letter+number;
    }
    //This method is to call the random_number method.
    public static int random_purchasePrice(){
        int number  = Helper.random_number(50, 1);
        return number;
    }
    //This method is to random "new" or "used" from items.
    public static String random_newOrUsed(){
        Random rand = new Random();
        String[] newOrUsedList = {"new","used"};
        int rand_int = rand.nextInt(2);
        return newOrUsedList[rand_int];
    }
    //This method is to random a boolean.
    public static boolean random_boolean(){
        Random rand = new Random();
        int rand_int = rand.nextInt(2);
        if (rand_int==0){
            return true;
        }
        return false;
    }
    //This method is to random a daynumber 1 to 3 days after the given day.
    public static int random_arriveDay(int day){
        Random rand = new Random();
        int rand_int = random_number(3,1);
        return day+rand_int;
    }



}
