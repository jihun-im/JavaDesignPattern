package observer;

/**
 * Created by jihun.im on 2017-04-24.
 */
public interface Observer {
    public void update();
    public void setSubject(Subject sub);
}
