package singleton;

/**
 * Created by Jihun on 2017-06-24.
 */
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class SingletoneHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletoneHelper.INSTANCE;
    }
}
