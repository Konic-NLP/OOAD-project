public class Register {

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
     public void deductmoney(int price){


        //the price is determined by the
        this.moneysum-=price;

     }
/*
below just for test

 */

//    public static class Items{
//
//        int price=100;
//        public int getPurchasePrice() {
//
//            return this.price;
//        }
//    }



//public static void main(String[] args){
//        Register reg= new Register();
//       Items items = new Items();
//        reg.deductmoney(items);
//        System.out.println(reg.getMoneysum());
//
//
//
//
//
//
//
//}

}
