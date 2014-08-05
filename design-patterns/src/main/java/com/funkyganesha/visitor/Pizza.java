package com.funkyganesha.visitor;

/**
 * Created by barga009 on 8/3/14 at 12:31 PM. Comment {"$EXPR$"}
 */
public class Pizza implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
