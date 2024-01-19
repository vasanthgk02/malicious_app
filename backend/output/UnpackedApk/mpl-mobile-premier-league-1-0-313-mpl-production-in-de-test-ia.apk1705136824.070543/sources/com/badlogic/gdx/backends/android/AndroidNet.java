package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.NetJavaImpl;

public class AndroidNet implements Net {
    public NetJavaImpl netJavaImpl;

    public AndroidNet(AndroidApplicationBase androidApplicationBase, AndroidApplicationConfiguration androidApplicationConfiguration) {
        this.netJavaImpl = new NetJavaImpl(androidApplicationConfiguration.maxNetThreads);
    }
}
