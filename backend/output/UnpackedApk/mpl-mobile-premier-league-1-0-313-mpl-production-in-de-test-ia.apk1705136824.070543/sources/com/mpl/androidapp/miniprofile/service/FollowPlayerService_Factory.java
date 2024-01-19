package com.mpl.androidapp.miniprofile.service;

import dagger.internal.Factory;

public final class FollowPlayerService_Factory implements Factory<FollowPlayerService> {

    public static final class InstanceHolder {
        public static final FollowPlayerService_Factory INSTANCE = new FollowPlayerService_Factory();
    }

    public static FollowPlayerService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FollowPlayerService newInstance() {
        return new FollowPlayerService();
    }

    public FollowPlayerService get() {
        return newInstance();
    }
}
