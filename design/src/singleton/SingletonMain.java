package singleton;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class SingletonMain {

    public static void main(String[] args) {
        System.out.println("network status : " + NetworkController.getInstance().getNetworkStatus());
        System.out.println("network status : " + NetworkController.getInstance().getNetworkStatus()); //same instance!
    }

}
