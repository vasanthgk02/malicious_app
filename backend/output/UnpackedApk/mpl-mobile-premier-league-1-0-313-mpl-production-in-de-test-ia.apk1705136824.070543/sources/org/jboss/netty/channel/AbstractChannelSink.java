package org.jboss.netty.channel;

public abstract class AbstractChannelSink implements ChannelSink {
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void exceptionCaught(org.jboss.netty.channel.ChannelPipeline r1, org.jboss.netty.channel.ChannelEvent r2, org.jboss.netty.channel.ChannelPipelineException r3) throws java.lang.Exception {
        /*
            r0 = this;
            java.lang.Throwable r1 = r3.getCause()
            if (r1 != 0) goto L_0x0007
            goto L_0x0008
        L_0x0007:
            r3 = r1
        L_0x0008:
            org.jboss.netty.channel.Channel r1 = r2.getChannel()
            org.jboss.netty.channel.Channels.fireExceptionCaught(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.AbstractChannelSink.exceptionCaught(org.jboss.netty.channel.ChannelPipeline, org.jboss.netty.channel.ChannelEvent, org.jboss.netty.channel.ChannelPipelineException):void");
    }
}
