package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;

public final class HardwareConfigState {
    public static final File FD_SIZE_LIST = new File("/proc/self/fd");
    public static volatile HardwareConfigState instance;
    public int decodesSinceLastFdCheck;
    public final int fdCountLimit;
    public boolean isFdSizeBelowHardwareLimit = true;
    public final boolean isHardwareConfigAllowedByDeviceModel;
    public final int minHardwareDimension;

    public HardwareConfigState() {
        boolean z = true;
        String str = Build.MODEL;
        if (str != null && str.length() >= 7) {
            String substring = Build.MODEL.substring(0, 7);
            char c2 = 65535;
            switch (substring.hashCode()) {
                case -1398613787:
                    if (substring.equals("SM-A520")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1398431166:
                    if (substring.equals("SM-G930")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1398431161:
                    if (substring.equals("SM-G935")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1398431073:
                    if (substring.equals("SM-G960")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1398431068:
                    if (substring.equals("SM-G965")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1398343746:
                    if (substring.equals("SM-J720")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1398222624:
                    if (substring.equals("SM-N935")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (VERSION.SDK_INT == 26) {
                        z = false;
                        break;
                    }
                    break;
            }
        }
        this.isHardwareConfigAllowedByDeviceModel = z;
        if (VERSION.SDK_INT >= 28) {
            this.fdCountLimit = 20000;
            this.minHardwareDimension = 0;
            return;
        }
        this.fdCountLimit = OS2WindowsMetricsTable.WEIGHT_CLASS_BOLD;
        this.minHardwareDimension = 128;
    }

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (instance == null) {
                        instance = new HardwareConfigState();
                    }
                }
            }
        }
        return instance;
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        if (!z || !this.isHardwareConfigAllowedByDeviceModel || VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        int i3 = this.minHardwareDimension;
        if (i < i3 || i2 < i3) {
            return false;
        }
        synchronized (this) {
            try {
                int i4 = this.decodesSinceLastFdCheck + 1;
                this.decodesSinceLastFdCheck = i4;
                if (i4 >= 50) {
                    this.decodesSinceLastFdCheck = 0;
                    boolean z4 = FD_SIZE_LIST.list().length < this.fdCountLimit;
                    this.isFdSizeBelowHardwareLimit = z4;
                    if (!z4) {
                        Log.isLoggable("Downsampler", 5);
                    }
                }
                z3 = this.isFdSizeBelowHardwareLimit;
            }
        }
        if (z3) {
            return true;
        }
        return false;
    }
}
