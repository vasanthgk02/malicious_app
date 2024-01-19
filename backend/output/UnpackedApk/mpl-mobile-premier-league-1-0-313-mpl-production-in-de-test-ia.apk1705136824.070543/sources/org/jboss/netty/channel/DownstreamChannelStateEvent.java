package org.jboss.netty.channel;

public class DownstreamChannelStateEvent implements ChannelStateEvent {
    public final Channel channel;
    public final ChannelFuture future;
    public final ChannelState state;
    public final Object value;

    /* renamed from: org.jboss.netty.channel.DownstreamChannelStateEvent$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$channel$ChannelState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                org.jboss.netty.channel.ChannelState[] r0 = org.jboss.netty.channel.ChannelState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$channel$ChannelState = r0
                r1 = 1
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.OPEN     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.channel.ChannelState r3 = org.jboss.netty.channel.ChannelState.BOUND     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jboss.netty.channel.ChannelState r3 = org.jboss.netty.channel.ChannelState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0024 }
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.INTEREST_OPS     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.DownstreamChannelStateEvent.AnonymousClass1.<clinit>():void");
        }
    }

    public DownstreamChannelStateEvent(Channel channel2, ChannelFuture channelFuture, ChannelState channelState, Object obj) {
        if (channel2 == null) {
            throw new NullPointerException("channel");
        } else if (channelFuture == null) {
            throw new NullPointerException("future");
        } else if (channelState != null) {
            this.channel = channel2;
            this.future = channelFuture;
            this.state = channelState;
            this.value = obj;
        } else {
            throw new NullPointerException("state");
        }
    }

    public Channel getChannel() {
        return this.channel;
    }

    public ChannelFuture getFuture() {
        return this.future;
    }

    public ChannelState getState() {
        return this.state;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        String obj = getChannel().toString();
        StringBuilder sb = new StringBuilder(obj.length() + 64);
        sb.append(obj);
        int ordinal = getState().ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        sb.append(' ');
                        sb.append(getState().name());
                        sb.append(": ");
                        sb.append(getValue());
                    } else {
                        sb.append(" CHANGE_INTEREST: ");
                        sb.append(getValue());
                    }
                } else if (getValue() != null) {
                    sb.append(" CONNECT: ");
                    sb.append(getValue());
                } else {
                    sb.append(" DISCONNECT");
                }
            } else if (getValue() != null) {
                sb.append(" BIND: ");
                sb.append(getValue());
            } else {
                sb.append(" UNBIND");
            }
        } else if (Boolean.TRUE.equals(getValue())) {
            sb.append(" OPEN");
        } else {
            sb.append(" CLOSE");
        }
        return sb.toString();
    }
}
