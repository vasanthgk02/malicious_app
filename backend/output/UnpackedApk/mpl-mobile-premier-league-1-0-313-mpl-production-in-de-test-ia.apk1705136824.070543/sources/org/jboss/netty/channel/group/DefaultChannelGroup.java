package org.jboss.netty.channel.group;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.SocketAddress;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ServerChannel;
import org.jboss.netty.util.internal.ConcurrentHashMap;

public class DefaultChannelGroup extends AbstractSet<Channel> implements ChannelGroup {
    public static final AtomicInteger nextId = new AtomicInteger();
    public final String name;
    public final ConcurrentMap<Integer, Channel> nonServerChannels;
    public final ChannelFutureListener remover;
    public final ConcurrentMap<Integer, Channel> serverChannels;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DefaultChannelGroup() {
        // StringBuilder outline73 = GeneratedOutlineSupport.outline73("group-0x");
        // outline73.append(Integer.toHexString(nextId.incrementAndGet()));
        this(outline73.toString());
    }

    public void clear() {
        this.nonServerChannels.clear();
        this.serverChannels.clear();
    }

    public ChannelGroupFuture close() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            linkedHashMap.put(channel.getId(), channel.close().awaitUninterruptibly());
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            linkedHashMap.put(channel2.getId(), channel2.close());
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Integer, ChannelFuture>) linkedHashMap);
    }

    public boolean contains(Object obj) {
        boolean z = false;
        if (obj instanceof Integer) {
            if (this.nonServerChannels.containsKey(obj) || this.serverChannels.containsKey(obj)) {
                z = true;
            }
            return z;
        } else if (!(obj instanceof Channel)) {
            return false;
        } else {
            Channel channel = (Channel) obj;
            if (obj instanceof ServerChannel) {
                return this.serverChannels.containsKey(channel.getId());
            }
            return this.nonServerChannels.containsKey(channel.getId());
        }
    }

    public ChannelGroupFuture disconnect() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            linkedHashMap.put(channel.getId(), channel.disconnect().awaitUninterruptibly());
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            linkedHashMap.put(channel2.getId(), channel2.disconnect());
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Integer, ChannelFuture>) linkedHashMap);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public Channel find(Integer num) {
        Channel channel = (Channel) this.nonServerChannels.get(num);
        if (channel != null) {
            return channel;
        }
        return (Channel) this.serverChannels.get(num);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public boolean isEmpty() {
        return this.nonServerChannels.isEmpty() && this.serverChannels.isEmpty();
    }

    public Iterator<Channel> iterator() {
        return new CombinedIterator(this.serverChannels.values().iterator(), this.nonServerChannels.values().iterator());
    }

    public boolean remove(Object obj) {
        Channel channel;
        if (obj instanceof Integer) {
            channel = (Channel) this.nonServerChannels.remove(obj);
            if (channel == null) {
                channel = (Channel) this.serverChannels.remove(obj);
            }
        } else if (obj instanceof Channel) {
            Channel channel2 = (Channel) obj;
            channel = channel2 instanceof ServerChannel ? (Channel) this.serverChannels.remove(channel2.getId()) : (Channel) this.nonServerChannels.remove(channel2.getId());
        } else {
            channel = null;
        }
        if (channel == null) {
            return false;
        }
        channel.getCloseFuture().removeListener(this.remover);
        return true;
    }

    public ChannelGroupFuture setInterestOps(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            linkedHashMap.put(channel.getId(), channel.setInterestOps(i).awaitUninterruptibly());
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            linkedHashMap.put(channel2.getId(), channel2.setInterestOps(i));
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Integer, ChannelFuture>) linkedHashMap);
    }

    public ChannelGroupFuture setReadable(boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            linkedHashMap.put(channel.getId(), channel.setReadable(z).awaitUninterruptibly());
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            linkedHashMap.put(channel2.getId(), channel2.setReadable(z));
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Integer, ChannelFuture>) linkedHashMap);
    }

    public int size() {
        return this.serverChannels.size() + this.nonServerChannels.size();
    }

    public Object[] toArray() {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return arrayList.toArray();
    }

    public String toString() {
        return DefaultChannelGroup.class.getSimpleName() + "(name: " + getName() + ", size: " + size() + ')';
    }

    public ChannelGroupFuture unbind() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            linkedHashMap.put(channel.getId(), channel.unbind().awaitUninterruptibly());
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            linkedHashMap.put(channel2.getId(), channel2.unbind());
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Integer, ChannelFuture>) linkedHashMap);
    }

    public ChannelGroupFuture write(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        if (obj instanceof ChannelBuffer) {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            Iterator<Channel> it = iterator();
            while (it.hasNext()) {
                Channel next = it.next();
                linkedHashMap.put(next.getId(), next.write(channelBuffer.duplicate()));
            }
        } else {
            Iterator<Channel> it2 = iterator();
            while (it2.hasNext()) {
                Channel next2 = it2.next();
                linkedHashMap.put(next2.getId(), next2.write(obj));
            }
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Integer, ChannelFuture>) linkedHashMap);
    }

    public DefaultChannelGroup(String str) {
        this.serverChannels = new ConcurrentHashMap();
        this.nonServerChannels = new ConcurrentHashMap();
        this.remover = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                DefaultChannelGroup.this.remove(channelFuture.getChannel());
            }
        };
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException("name");
    }

    public boolean add(Channel channel) {
        boolean z = (channel instanceof ServerChannel ? this.serverChannels : this.nonServerChannels).putIfAbsent(channel.getId(), channel) == null;
        if (z) {
            channel.getCloseFuture().addListener(this.remover);
        }
        return z;
    }

    public int compareTo(ChannelGroup channelGroup) {
        int compareTo = getName().compareTo(channelGroup.getName());
        if (compareTo != 0) {
            return compareTo;
        }
        return System.identityHashCode(this) - System.identityHashCode(channelGroup);
    }

    public <T> T[] toArray(T[] tArr) {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return arrayList.toArray(tArr);
    }

    public ChannelGroupFuture write(Object obj, SocketAddress socketAddress) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        if (obj instanceof ChannelBuffer) {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            Iterator<Channel> it = iterator();
            while (it.hasNext()) {
                Channel next = it.next();
                linkedHashMap.put(next.getId(), next.write(channelBuffer.duplicate(), socketAddress));
            }
        } else {
            Iterator<Channel> it2 = iterator();
            while (it2.hasNext()) {
                Channel next2 = it2.next();
                linkedHashMap.put(next2.getId(), next2.write(obj, socketAddress));
            }
        }
        return new DefaultChannelGroupFuture((ChannelGroup) this, (Map<Integer, ChannelFuture>) linkedHashMap);
    }
}
