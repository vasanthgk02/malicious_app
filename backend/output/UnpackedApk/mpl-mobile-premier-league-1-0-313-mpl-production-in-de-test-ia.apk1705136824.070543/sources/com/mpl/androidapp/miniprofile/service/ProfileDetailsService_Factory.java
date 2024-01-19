package com.mpl.androidapp.miniprofile.service;

import dagger.internal.Factory;

public final class ProfileDetailsService_Factory implements Factory<ProfileDetailsService> {

    public static final class InstanceHolder {
        public static final ProfileDetailsService_Factory INSTANCE = new ProfileDetailsService_Factory();
    }

    public static ProfileDetailsService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProfileDetailsService newInstance() {
        return new ProfileDetailsService();
    }

    public ProfileDetailsService get() {
        return newInstance();
    }
}
