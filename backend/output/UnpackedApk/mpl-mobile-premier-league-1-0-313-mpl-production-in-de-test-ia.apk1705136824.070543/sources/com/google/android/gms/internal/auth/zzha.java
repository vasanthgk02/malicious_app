package com.google.android.gms.internal.auth;

import okio.Utf8;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzha {
    public static /* synthetic */ void zza(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzew {
        if (!zze(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !zze(b4) && !zze(b5)) {
                byte b6 = ((b2 & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((b4 & Utf8.REPLACEMENT_BYTE) << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
                cArr[i] = (char) ((b6 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                cArr[i + 1] = (char) ((b6 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                return;
            }
        }
        throw zzew.zzb();
    }

    public static /* synthetic */ void zzb(byte b2, byte b3, char[] cArr, int i) throws zzew {
        if (b2 < -62 || zze(b3)) {
            throw zzew.zzb();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }

    public static /* synthetic */ void zzc(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzew {
        if (!zze(b3)) {
            if (b2 == -32) {
                if (b3 >= -96) {
                    b2 = -32;
                }
            }
            if (b2 == -19) {
                if (b3 < -96) {
                    b2 = -19;
                }
            }
            if (!zze(b4)) {
                cArr[i] = (char) (((b2 & 15) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzew.zzb();
    }

    public static /* synthetic */ boolean zzd(byte b2) {
        return b2 >= 0;
    }

    public static boolean zze(byte b2) {
        return b2 > -65;
    }
}
