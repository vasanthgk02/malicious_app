package com.shield.android.c;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.shield.android.PortDetector;

public class j extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1524b;

    public j(Context context) {
        this.f1524b = context;
    }

    public String c() {
        Display[] displays = ((DisplayManager) this.f1524b.getSystemService("display")).getDisplays();
        StringBuilder sb = new StringBuilder();
        for (Display display : displays) {
            if (sb.length() == 0) {
                sb.append(display.getName());
            } else {
                sb.append(", ");
                sb.append(display.getName());
            }
        }
        if (PortDetector.isAirdroidConnected) {
            sb.append(", ");
            sb.append("airdroid");
        } else if (PortDetector.isAwerayConnected) {
            sb.append(", ");
            sb.append("aweray");
        } else if (PortDetector.isVysorConnected) {
            sb.append(", ");
            sb.append("vysor");
        }
        return sb.toString();
    }
}
