package builder;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class Computer2 {
    private String HDD;
    private String RAM;

    private String bluetooth;
    private String wifi;
    private String graphicCard;

    public Computer2(String HDD, String RAM) {
        this.HDD = HDD;
        this.RAM = RAM;
    }

    public Computer2 setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
        return this;
    }

    public Computer2 setWifi(String wifi) {
        this.wifi = wifi;
        return this;
    }
    public Computer2 setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " : " + bluetooth +  " : " +wifi +  " : " +graphicCard;
    }

}

