package singleton;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class NetworkController {

    static NetworkController networkController;

    private NetworkController() {

    }

    static public NetworkController getInstance() {
        if (networkController == null) {
            networkController = new NetworkController();
        }
        return networkController;
    }

    public String getNetworkStatus() {
        return "controller instance id : " + this;
    }

}
