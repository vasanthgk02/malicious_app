package c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import timber.log.Timber;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f2811a;

    public c(SharedPreferences sharedPreferences) {
        this.f2811a = sharedPreferences;
    }

    public synchronized String a(String str) {
        try {
        }
        return this.f2811a.getString(str, "");
    }

    public synchronized void a() {
        Editor edit = this.f2811a.edit();
        edit.clear();
        edit.apply();
    }

    public synchronized void a(String str, String str2) {
        Timber.TREE_OF_SOULS.d("Writing key: %s and value %s", str, str2);
        Editor edit = this.f2811a.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
