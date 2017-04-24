package observer;

/**
 * Created by jihun.im on 2017-04-24.
 */
public class ObserverMain {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();

        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");

        topic.register(obj1);
        topic.register(obj2);

        obj1.setSubject(topic);
        obj2.setSubject(topic);

        topic.notifyObservers();

        //check if any update is available
        obj1.update();

        //now send message to subject
        topic.postMessage("New Message");
    }
}
