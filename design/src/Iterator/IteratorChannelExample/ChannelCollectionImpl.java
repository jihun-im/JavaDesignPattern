package Iterator.IteratorChannelExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class ChannelCollectionImpl implements ChannelCollection {


    private List<Channel> channelList;

    public ChannelCollectionImpl() {
        channelList = new ArrayList<Channel>();
    }

    @Override
    public void addChannel(Channel c) {
        channelList.add(c);
    }

    @Override
    public void removeChannel(Channel c) {
        channelList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type, this.channelList);
    }
}
