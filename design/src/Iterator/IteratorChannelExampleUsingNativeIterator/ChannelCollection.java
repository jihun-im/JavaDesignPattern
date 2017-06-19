package Iterator.IteratorChannelExampleUsingNativeIterator;

import java.util.Iterator;

/**
 * Created by jihun.im on 2017-04-28.
 */
public interface ChannelCollection {
    public void addChannel(Channel c);
    public void removeChannel(Channel c);
    public Iterator iterator(ChannelTypeEnum type);
}
