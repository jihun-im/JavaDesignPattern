package Iterator.IteratorChannelExampleUsingNativeIterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jihun.im on 2017-04-28.
 */
public class ChannelIteratorImpleOptimized implements Iterator<Channel> {
    private ChannelTypeEnum allowedType;
    private List<Channel> channelList;
    private int position;
    private boolean optimized = false;

    public ChannelIteratorImpleOptimized(ChannelTypeEnum allowedType,
                                         List<Channel> channelsList) {
        this.allowedType = allowedType;
        this.channelList = channelsList;
        this.optimized = false;
    }

    @Override
    public boolean hasNext() {
        if (this.optimized) {
            return hasNextOriginal();
        } else {
            return hasNextAndOptimize();
        }
    }

    private boolean hasNextOriginal() {
        if (position < channelList.size()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasNextAndOptimize() {
        while (position < channelList.size()) {
            Channel channel = channelList.get(position);
            if (channel.getTYPE().equals(allowedType) || allowedType.equals(ChannelTypeEnum.ALL)) {
                return true;
            } else {
                channelList.remove(position);
                position++;
            }
        }
        this.optimized = true;
        return false;
    }

    @Override
    public Channel next() {
        Channel c = channelList.get(position);
        position++;
        return c;
    }

}