package io.hansel.ujmtracker;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f5317a;

    public e(Context context) {
        this.f5317a = context;
    }

    public abstract Pair<ArrayList<String>, Set<String>> a(String str, String str2, Map<String, Object> map);

    public abstract ArrayList<String> a();
}
