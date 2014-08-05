package com.funkyganesha.visitor;

import java.util.List;

/**
 * Created by barga009 on 8/2/14 at 10:44 PM. Comment {"$EXPR$"}
 */
public class ShoppingCart {
    private List<Visitable> visitableList;

    public double calculatePostage() {
        PostageVisitor postageVisitor = new PostageVisitor();
        ProhibitedItemVisitor prohibitedItemVisitor = new ProhibitedItemVisitor();
        for (Visitable visitable : visitableList) {
            visitable.accept(postageVisitor);
        }
        double totalPostage = postageVisitor.getTotalPostage();
        return totalPostage;
    }

    public void setVisitableList(List<Visitable> visitableList) {
        this.visitableList = visitableList;
    }
}
