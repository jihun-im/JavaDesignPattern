package builder;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class BuilderMain {
    public static void main(String[] args) {
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        Computer2 comp2 = new Computer2("2TB","16GB")
                .setWifi("wifi")
                .setBluetooth("QSENN BT Module")
                .setGraphicCard("GTX1170");
        System.out.println(comp);
        System.out.println(comp2);

    }
}
