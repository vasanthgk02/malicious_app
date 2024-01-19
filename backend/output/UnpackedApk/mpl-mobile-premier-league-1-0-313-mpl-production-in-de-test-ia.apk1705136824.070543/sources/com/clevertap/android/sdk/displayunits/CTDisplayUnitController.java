package com.clevertap.android.sdk.displayunits;

import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import java.util.HashMap;

public class CTDisplayUnitController {
    public final HashMap<String, CleverTapDisplayUnit> items = new HashMap<>();

    public synchronized void reset() {
        this.items.clear();
        Logger.d("DisplayUnit : ", "Cleared Display Units Cache");
    }
}
