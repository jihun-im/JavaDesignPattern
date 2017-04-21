package adapter.gunexample;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class ObjectAdapterMain {
    public static void main(String[] args) {
        Soldier soldier1 = new GunAdapter(new Gun());
        soldier1.attack();
        Soldier soldier2 = new GunAdapter(new Rifle());
        soldier2.attack();
        Soldier soldier3 = new GunAdapter(new Pistol());
        soldier3.attack();

    }
}
