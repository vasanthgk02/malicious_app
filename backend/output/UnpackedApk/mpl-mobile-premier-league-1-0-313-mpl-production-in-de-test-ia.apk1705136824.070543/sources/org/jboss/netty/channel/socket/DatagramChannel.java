package org.jboss.netty.channel.socket;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import org.jboss.netty.channel.Channel;

public interface DatagramChannel extends Channel {
    DatagramChannelConfig getConfig();

    InetSocketAddress getLocalAddress();

    InetSocketAddress getRemoteAddress();

    void joinGroup(InetAddress inetAddress);

    void joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface);

    void leaveGroup(InetAddress inetAddress);

    void leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface);
}
