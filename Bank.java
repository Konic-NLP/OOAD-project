public class Bank {

    private int sum;

    // put $1000 to register by calling the method
    public int withdraw(){
        System.out.println("the staff withdraw 100$ from the bank");
        int withdraw = 1000;
        this.sum += 1000;

        return withdraw;
    }

    // return the total money withdrawn from goToBank method
    public void getSum(){

        System.out.println("The amount of money withdrawn from the bank is " + this.sum);

    }
}
