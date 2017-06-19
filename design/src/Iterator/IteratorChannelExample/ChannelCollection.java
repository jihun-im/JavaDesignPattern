package Iterator.IteratorChannelExample;

/**
 * Created by jihun.im on 2017-04-28.
 */
public interface ChannelCollection {
    public void addChannel(Channel c);
    public void removeChannel(Channel c);
    public ChannelIterator iterator(ChannelTypeEnum type);
}
