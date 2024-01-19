package com.freshchat.consumer.sdk.j;

import com.mpl.androidapp.utils.Constant;

public class ba {
    public static void fX() {
        if (!af.fW()) {
            Class ay = ao.ay("com.squareup.picasso.Picasso");
            if (ay != null && ao.c(ay, Constant.GET) == null) {
                throw new IllegalArgumentException("Unsupported version of Picasso found. Please create and set custom Image loader using Freshchat.setImageLoader().");
            }
        }
    }

    public static boolean fY() {
        return ao.ay("com.squareup.picasso.Picasso") != null;
    }

    public static boolean fZ() {
        return !fY();
    }
}
