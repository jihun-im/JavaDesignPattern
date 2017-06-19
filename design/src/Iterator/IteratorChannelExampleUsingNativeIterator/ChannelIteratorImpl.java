package Iterator.IteratorChannelExampleUsingNativeIterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class ChannelIteratorImpl implements Iterator<Channel> {
    private ChannelTypeEnum allowedType;
    private List<Channel> channelList;
    private int position;

    public ChannelIteratorImpl(ChannelTypeEnum allowedType,
                               List<Channel> channelsList) {
        this.allowedType = allowedType;
        this.channelList = channelsList;
    }

    @Override
    public boolean hasNext() {
        while (position < channelList.size()) {
            Channel channel = channelList.get(position);
            if (channel.getTYPE().equals(allowedType) || allowedType.equals(ChannelTypeEnum.ALL)) {
                return true;
            } else
                position++;
        }
        return false;
    }

    @Override
    public Channel next() {
        Channel c = channelList.get(position);
        position++;
        return c;
    }

}