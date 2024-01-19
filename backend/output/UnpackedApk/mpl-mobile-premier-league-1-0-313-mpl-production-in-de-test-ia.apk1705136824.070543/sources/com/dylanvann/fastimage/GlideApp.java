package com.dylanvann.fastimage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import java.io.File;

public final class GlideApp {
    public static Glide get(Context context) {
        return Glide.get(context);
    }

    public static File getPhotoCacheDir(Context context) {
        return Glide.getPhotoCacheDir(context);
    }

    @SuppressLint({"VisibleForTests"})
    @Deprecated
    public static void init(Glide glide) {
        Glide.init(glide);
    }

    @SuppressLint({"VisibleForTests"})
    public static void tearDown() {
        Glide.tearDown();
    }

    public static GlideRequests with(Context context) {
        return (GlideRequests) Glide.with(context);
    }

    public static File getPhotoCacheDir(Context context, String str) {
        return Glide.getPhotoCacheDir(context, str);
    }

    @SuppressLint({"VisibleForTests"})
    public static void init(Context context, GlideBuilder glideBuilder) {
        Glide.init(context, glideBuilder);
    }

    public static GlideRequests with(Activity activity) {
        return (GlideRequests) Glide.with(activity);
    }

    public static GlideRequests with(FragmentActivity fragmentActivity) {
        return (GlideRequests) Glide.with(fragmentActivity);
    }

    public static GlideRequests with(Fragment fragment) {
        return (GlideRequests) Glide.with(fragment);
    }

    @Deprecated
    public static GlideRequests with(android.app.Fragment fragment) {
        return (GlideRequests) Glide.with(fragment);
    }

    public static GlideRequests with(View view) {
        return (GlideRequests) Glide.with(view);
    }
}
