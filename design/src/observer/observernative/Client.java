package observer.observernative;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by jihun.im on 2017-04-24.
 */
public class Client implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("update");
    }

}
