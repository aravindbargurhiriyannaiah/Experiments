package com.funkyganesha.observer;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by barga009 on 8/2/14 at 12:22 AM. Comment {"$EXPR$"}
 */
public class ObserverTest {
    @Test
    public void testUpdate() throws Exception {
        Internet observer = new Internet();
        Loan loan = new Loan();
        loan.registerObserver(observer);
        double beforeInterest = 4.5d;
        loan.setInterest(beforeInterest);
        double before = observer.getInterest();
        assertEquals("Observer has not been notified of the update", beforeInterest, before);
        double newInterest = 5.4d;
        loan.setInterest(newInterest);
        double after = observer.getInterest();
        assertEquals("Observer has not been notified of the update", newInterest, after);
    }
}
