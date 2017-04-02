package com.pryhoda.order;
import java.util.LinkedList;

/**
 * Created by pryho on 14-Nov-16.
 */
public class PostDeliveryStrategy implements IDelivery{

    @Override
    public String deliver(LinkedList items) {
        return "Post delivery";
    }
}
