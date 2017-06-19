package Iterator.IteratorChannelExample;

import java.util.List;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class ChannelIteratorImpl implements ChannelIterator {
    private ChannelTypeEnum type;
    private List<Channel> channels;
    private int position;

    public ChannelIteratorImpl(ChannelTypeEnum ty,
                               List<Channel> channelsList) {
        this.type = ty;
        this.channels = channelsList;
    }

    @Override
    public boolean hasNext() {
        while (position < channels.size()) {
            Channel c = channels.get(position);
            if (c.getTYPE().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
                return true;
            } else
                position++;
        }
        return false;
    }

    @Override
    public Channel next() {
        Channel c = channels.get(position);
        position++;
        return c;
    }

}