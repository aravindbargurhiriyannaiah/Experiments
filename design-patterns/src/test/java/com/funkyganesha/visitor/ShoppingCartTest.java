package com.funkyganesha.visitor;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by barga009 on 8/2/14 at 11:02 PM. Comment {"$EXPR$"}
 */
public class ShoppingCartTest {
    @Test
    public void testCalculatePostage() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Visitable> list = Lists.newArrayList();

        list.add(createBook("Design Patterns: Elements of Reusable Object-Oriented Software - GOF", 44.04d, 2));
        list.add(createBook("Domain Driven Design - Eric Evans", 29.99d, 3.4));

        list.add(createCD("Call of the Valley", 19.99, 0));
        list.add(createCD("Visions of India - L Subramaniam", 0, 0.4));

        shoppingCart.setVisitableList(list);
        double totalPostage = shoppingCart.calculatePostage();
        assertEquals("Incorrect postage calculated", 15.094, totalPostage, 0);
    }

    private Book createBook(String name, double price, double weight) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setWeight(weight);
        return book;
    }

    private CD createCD(String name, double price, double weight) {
        CD cd = new CD();
        cd.setName(name);
        cd.setWeight(weight);
        cd.setPrice(price);
        return cd;
    }

}
