package com.facebook.appevents.cloudbridge;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;

/* renamed from: com.facebook.appevents.cloudbridge.-$$Lambda$m16G8HSqb-E1bMmir1EfQXv1qNY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY implements Callback {
    public static final /* synthetic */ $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY INSTANCE = new $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY();

    private /* synthetic */ $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY() {
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AppEventsCAPIManager.m157enable$lambda0(graphResponse);
    }
}
