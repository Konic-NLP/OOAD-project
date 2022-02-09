public class Bank {

    private int sum;

    // put $1000 to register by calling the method
    public int withdraw(){

        int withdraw = 1000;
        this.sum += 1000;

        return withdraw;
    }

    // return the total money withdrawn from goToBank method
    public void getSum(){

        System.out.println("The current amount of money withdrawn from the bank is " + this.sum);

    }
}
