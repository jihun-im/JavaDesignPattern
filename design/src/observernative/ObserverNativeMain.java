package observernative;

/**
 * Created by jihun.im on 2017-04-24.
 */
public class ObserverNativeMain {
    public static void main(String[] args) {
        Bank bank = new Bank(0);
        Client client1 = new Client();
        Client client2 = new Client();

        bank.addObserver(client1);
        bank.addObserver(client2);

        bank.notifyObservers();
        bank.setBalance(4);
        bank.notifyObservers();
        bank.notifyObservers();

    }
}
