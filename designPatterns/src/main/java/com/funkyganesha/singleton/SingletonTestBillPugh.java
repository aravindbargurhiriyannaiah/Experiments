public class SingletonTestBillPugh {

    private SingletonTestBillPugh() {
    }

    private static class InnerClass {
        public static final SingletonTestBillPugh SINGLETON_TEST_BILL_PUGH = new SingletonTestBillPugh();
    }

    public SingletonTestBillPugh getInstance() {
        return InnerClass.SINGLETON_TEST_BILL_PUGH;
    }
}
