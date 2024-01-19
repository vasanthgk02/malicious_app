package org.jboss.netty.channel.local;

import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.util.internal.ConcurrentHashMap;

public final class LocalChannelRegistry {
    public static final ConcurrentMap<LocalAddress, Channel> map = new ConcurrentHashMap();

    public static Channel getChannel(LocalAddress localAddress) {
        return (Channel) map.get(localAddress);
    }

    public static boolean isRegistered(LocalAddress localAddress) {
        return map.containsKey(localAddress);
    }

    public static boolean register(LocalAddress localAddress, Channel channel) {
        return map.putIfAbsent(localAddress, channel) == null;
    }

    public static boolean unregister(LocalAddress localAddress) {
        return map.remove(localAddress) != null;
    }
}
