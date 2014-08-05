package com.funkyganesha.visitor;

/**
 * Created by barga009 on 8/2/14 at 10:35 PM. Comment {"$EXPR$"}
 */
public interface Visitor {
    void visit(Book book);

    void visit(CD cd);
}
