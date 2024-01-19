package com.mpl.androidapp.spacemanagment;

import android.content.Context;
import java.util.Map;

public interface GamesRepository {
    Map getInstalledApps(Context context, boolean z);
}
