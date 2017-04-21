package objectadapter;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class GunAdapter implements Soldier{
    Gun gun;

    public GunAdapter(Gun gun) {
        this.gun = gun;
    }


    @Override
    public void attack() {
        gun.fire();
    }
}
