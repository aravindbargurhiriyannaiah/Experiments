package com.funkyganesha.visitor;

/**
 * Created by barga009 on 8/2/14 at 10:38 PM. Comment {"$EXPR$"}
 */
public class PostageVisitor implements Visitor {
    private double totalPostage = 0.0d;

    @Override
    public void visit(CD cd) {
        //CD price * 0.6 if price is available, CD weight * 1 otherwise
        double cdPostage;
        if (cd.getPrice() != 0.0d) {
            cdPostage = cd.getPrice() * 0.6;
        }   else {
            cdPostage = cd.getWeight() * 1;
        }
        System.out.println("Postage of [" + cd + "] = [" + cdPostage + "]");
        totalPostage += cdPostage;
    }

    @Override
    public void visit(Book book) {

        // $0.5 per pound
        double bookPostage = book.getWeight() * 0.5;
        System.out.println("Postage of [" + book + "] = [" + bookPostage + "].");

        totalPostage += bookPostage;
    }

    public double getTotalPostage() {
        return totalPostage;
    }
}
