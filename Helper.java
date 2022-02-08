import java.util.Random;

public class Helper {
    private static int random_number(int max, int min) {
        Random rand = new Random();
        int rand_int = rand.nextInt(max - min);
        return rand_int + min;
    }
    private static String random_letter(){
        Random rand = new Random();
        String[] letter_list = {"A","B","C","D","E","F","G","H","I","J"};
        int rand_int = rand.nextInt(10);
        return letter_list[rand_int];
    }

    public static String random_name(String type){
        int number = Helper.random_number(0,1000);
        String letter = random_letter();
        return type+letter+number;
    }
}
