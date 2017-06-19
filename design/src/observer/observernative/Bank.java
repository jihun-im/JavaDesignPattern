package observer.observernative;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by jihun.im on 2017-04-24.
 */
public class Bank extends Observable {

    private int balance = 0;

    public Bank(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        setChanged();
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        super.addObserver(observer);
    }

    @Override
    public synchronized void deleteObserver(Observer observer) {
        super.deleteObserver(observer);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

}
