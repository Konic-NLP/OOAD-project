

import java.util.*;

import org.apache.commons.math3.distribution.PoissonDistribution;
//This class is made of multiple methods with simple functions that are used to create random names, number,prices for items and other classes.
//This class's methods are examples of Cohesion.

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
    //update
    /* return  a random value sampled from poisson distribution
    // cite from official document for commons.math package
    https://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/PoissonDistribution.html
     */
    public static int getPossionDistribution() {
        // using commons.math package to generate the variate from the distribution
        PoissonDistribution possion=new PoissonDistribution(3);
       int rand =possion.sample();
        return rand;

    }
    public static String mergeString(ArrayList<Items> arrayList ){
        // using string joiner to output the multiple items type when using decorator
        String pre="";
        String infix=",";
        String post="";
        StringJoiner joiner=new StringJoiner(infix,pre,post);
        for(Items item: arrayList){
            joiner.add(item.getItemType());

        }

        return joiner.toString();
    }

    public static Staff[] assignStaff(ArrayList<Staff> staffs){

        Random random=new Random();
        // build an array to store the possible staff for work
        ArrayList<Staff> candidate = new ArrayList<>(staffs);
        // exclude who has worked for 3 days
        for (Staff staff : staffs) {
            if (staff.getCwd() == 2) {
                staff.cleanCwd();
                candidate.remove(staff);

            }
        }
        // get one to be sick from all staffs
        int sickindex=random.nextInt(staffs.size());
        Collections.shuffle(candidate);
        Staff [] todayStaff=new Staff[2];
        todayStaff[0]=candidate.get(0);
        todayStaff[1]=candidate.get(1);

        // first select two as the staff for each of the stores
        int sickprob=random.nextInt(101);// set the probability for sick
        /* if the oen who get sick is the one that had assigned to work for that day
        this one get rest and the other one is assigned
         */

        if (sickprob<10&staffs.get(sickindex)==todayStaff[0]){
            System.out.format("today should be %s but %s get sick",staffs.get(sickindex),staffs.get(sickindex));

            todayStaff[0]=candidate.get(2);
        }if(sickprob<10&staffs.get(sickindex)==todayStaff[1]){
            System.out.format("today should be %s but %s get sick",staffs.get(sickindex),staffs.get(sickindex));

            todayStaff[1]=candidate.get(2);}

            // if the sick staff not the one of two staffs should work for that day....
            // anyone can work for that day but not work that day can take a rest
            todayStaff[0].addCwd();
            todayStaff[1].addCwd();
            for(Staff rest:candidate){
                if(!Arrays.asList(todayStaff).contains(rest)){
                    rest.cleanCwd();
                }
            }
//        for(Staff member:staffs){
//            System.out.println(member.getName()+" "+member.getCwd());
//        }
            return todayStaff;

        }}

