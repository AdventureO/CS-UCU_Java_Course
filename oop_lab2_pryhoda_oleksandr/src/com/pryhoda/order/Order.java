package com.pryhoda.order;

import com.pryhoda.suppliers.CactusSuplier;
import com.pryhoda.suppliers.ChamomileSupllier;
import com.pryhoda.suppliers.RoseSuplier;
import com.pryhoda.suppliers.TulipSuplier;

import java.util.LinkedList;
import java.util.Observable;

/**
 * Created by pryho on 08-Nov-16.
 */
public class Order extends Observable {

    LinkedList<Item> items = new LinkedList<Item>();
    private IPayment payment;
    private IDelivery delivery;


    public Order(){
        items = new LinkedList<>();
    }

    public void SetPaymentStrategy(IPayment payment){
        this.payment = payment;
    }

    public void SetDeliveryStrategy(IDelivery delivery){
        this.delivery = delivery;
    }

    public IDelivery getDeliveryStrategy() {
        return this.delivery;
    }

    public IPayment getPaymentStrategy() {
        return this.payment;
    }

    public double CalculateTotalPrice(){
        double price = 0;
        for (Item item : items){
            price += item.price();
        }
        return price;
    }

    public void ProcessOrder(){
        if (payment != null){
            payment.pay(CalculateTotalPrice());
        }
        delivery.deliver(items);

        new CactusSuplier().update(this, items);
        new ChamomileSupllier().update(this, items);
        new RoseSuplier().update(this, items);
        new TulipSuplier().update(this, items);
    }

    public void AddItem(Item item){
        items.add(item);
    }

    public void RemoveItem(Item item){
        items.remove(item);
    }

    public static void main(String[] args) {

    }

}
