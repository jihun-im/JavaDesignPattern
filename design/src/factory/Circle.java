package factory;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
