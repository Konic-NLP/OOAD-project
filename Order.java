import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.Map;

public class Order {
    /*
    the order class record the all orders that haven't arrived at store yet
     */
    private ArrayList<Items> orderlist;

    public Order() { // create a arraylist attribute use constructor
        this.orderlist = new ArrayList<Items>();

    }

    // add new item into the orderlist
    public void orderItems(Items item) {

        this.orderlist.add(item);


    }

    //when the item arrive at the store, remove it from the orderlist
    public void remove(Items item) {
        if (this.orderlist.size() != 0) {
            this.orderlist.remove(item);
//        System.out.println('');
        }
    }


    /*

    below just for testing
     */
//    public static class Items {
//
//        int price = 100;
//
//        public int getPurchaseprce() {
//
//            return this.price;
//        }
//    }


}



///*
//
// // test for order object
// public static void main(String[] args){
//        Items item=new Items();
//        Items item1=new Items();
//        Order order= new Order();
//        order.orderItems(item);
//        order.orderItems(item1);
//        order.remove(item);
//        System.out.println(order.orderlist);
///*

