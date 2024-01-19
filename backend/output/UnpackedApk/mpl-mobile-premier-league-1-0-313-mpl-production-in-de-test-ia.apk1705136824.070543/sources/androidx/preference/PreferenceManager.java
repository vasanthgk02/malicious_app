package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
    }
}
