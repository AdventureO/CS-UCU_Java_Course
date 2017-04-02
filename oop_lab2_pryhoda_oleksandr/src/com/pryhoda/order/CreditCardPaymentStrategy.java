package com.pryhoda.order;

/**
 * Created by pryho on 14-Nov-16.
 */
public class CreditCardPaymentStrategy implements IPayment{
    public String pay(double cost){
        return "Payed by Credit Card:" + cost + "$";
    }
}
