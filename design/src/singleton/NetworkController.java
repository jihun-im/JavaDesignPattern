package singleton;

import sun.nio.ch.Net;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class NetworkController {

    static NetworkController networkController;

    private NetworkController() {

    }


    // multi thread application
    static public NetworkController getInstanceForMultiThreadApplication() {
        if (networkController == null) {
            synchronized (NetworkController.class) {
                if (networkController == null) {
                    networkController = new NetworkController();
                }
            }
        }
        return networkController;
    }

    public String getNetworkStatus() {
        return "controller instance id : " + this;
    }

    // single thread application
    static public NetworkController getInstance() {

        if (networkController == null) {
            networkController = new NetworkController();
        }
        return networkController;
    }


}
