package com.mpl.androidapp.spacemanagment;

import java.util.Comparator;

/* renamed from: com.mpl.androidapp.spacemanagment.-$$Lambda$GamesViewModel$3$l7_w30btI4TvMtdjRXF2RMH64sw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$GamesViewModel$3$l7_w30btI4TvMtdjRXF2RMH64sw implements Comparator {
    public static final /* synthetic */ $$Lambda$GamesViewModel$3$l7_w30btI4TvMtdjRXF2RMH64sw INSTANCE = new $$Lambda$GamesViewModel$3$l7_w30btI4TvMtdjRXF2RMH64sw();

    private /* synthetic */ $$Lambda$GamesViewModel$3$l7_w30btI4TvMtdjRXF2RMH64sw() {
    }

    public final int compare(Object obj, Object obj2) {
        return Long.compare(((GamesModel) obj2).getSize().longValue(), ((GamesModel) obj).getSize().longValue());
    }
}
