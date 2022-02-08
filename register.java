public class register {

    private int moneysum;// sum of money in the register


    /*

    add the money to the register
     */

    public void addmoney(int amount){

        this.moneysum+=amount;


    }

    // get to know the  money
    public int getMoneysum() {

        return this.moneysum;


    }
    // if a seller customer sells the item to the store, we need to deduct the money from the register
     public void deductmoney(Items items){


        //the price is determined by the
        this.moneysum-=items.getPurchasePrice;

     }







}
