package com.inca.security.Proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.inca.security.AppGuard.BuildConfig;
import com.inca.security.IIIiiiiIii;
import com.inca.security.IIIiiiiiiI;
import com.inca.security.iiIIiiiiIi;
import java.io.File;
import java.io.FileInputStream;
import okio.Utf8;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

/* compiled from: eb */
public class JNISoxProxy {
    private static /* synthetic */ Context IiIIiiIIii;
    private static /* synthetic */ Context iiIIIiiIiI;
    private static /* synthetic */ IIIiiiiiiI iiiiIiiiii;

    public static Context getContext() {
        return IiIIiiIIii;
    }

    public static void setApplicationContext(Context context) {
        iiIIIiiIiI = context;
    }

    public static Context getApplicationContext() {
        return iiIIIiiIiI;
    }

    public static String getLocaleString() {
        return VERSION.SDK_INT < 24 ? IiIIiiIIii.getResources().getConfiguration().locale.getCountry() : IiIIiiIIii.getResources().getConfiguration().getLocales().get(0).getCountry();
    }

    public static IIIiiiiiiI getDeviceInfo() {
        return iiiiIiiiii;
    }

    public static void setContext(Context context) {
        IiIIiiIIii = context;
        if (IiIIiiIIii != null && iiiiIiiiii == null) {
            iiiiIiiiii = new IIIiiiiiiI(context);
        }
    }

    public static void loadSecureLibrary(String str) {
        Context context;
        while (true) {
            context = IiIIiiIIii;
            if (context != null) {
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException unused) {
            }
        }
        if (context.getFilesDir() == null) {
            iiiiIiiiii.iIiiIiiiIi(true);
        } else {
            String str2 = IiIIiiIIii.getApplicationInfo().nativeLibraryDir;
            String absolutePath = IiIIiiIIii.getFilesDir().getAbsolutePath();
            String format = String.format(IIIiiiiIii.iIiiIiiiIi("3\u001e9\u0001\u000f3\u001e8\u001ey"), new Object[]{str2, str});
            String format2 = String.format(BuildConfig.iIiiIiiiIi("Wr]m\u001bcWr\\r\u001d"), new Object[]{absolutePath, str});
            if (!new File(format).exists()) {
                System.loadLibrary(str);
                return;
            }
            try {
                byte[] bArr = new byte[3];
                FileInputStream fileInputStream = new FileInputStream(format);
                fileInputStream.read(bArr);
                fileInputStream.close();
                if (bArr[0] == 83 && bArr[1] == 79 && bArr[2] == 88) {
                    iiIIiiiiIi iiiiiiiiii = new iiIIiiiiIi(IiIIiiIIii);
                    iiiiiiiiii.iIiiIiiiIi(new byte[]{61, 85, -74, 101, -82, 109, -32, 122, -40, 68, 102, -55, 82, 108, -64, MqttWireMessage.MESSAGE_TYPE_DISCONNECT}, new byte[]{0, 0, 0, GlyfDescript.X_DUAL, 9, -72, 5, 83, -91, 38, 35, 67, -114, 18, 29, -33, 36, -67, -1, 110}, new byte[]{0, 0, 1, 38, -6, 47, -30, 85, 49, 46, -118, -62, 36, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -113, -77, -117, 71, -86, -2, -1, 52, 35, 22, 91, HttpCodecUtil.COLON, 42, -36, 101, 45, 93, 76, -28, 72, 22, -120, 13, -116, -23, 118, -117, 51, 79, -4, 39, 93, -56, 68, -44, 114, -15, 43, Byte.MIN_VALUE, -94, -86, 10, 43, 77, 18, -56, -99, -99, -50, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, -2, 91, -16, 39, -82, -56, 107, 51, 80, 35, GlyfDescript.X_DUAL, -16, GlyfDescript.X_DUAL, 25, -28, -100, -67, 104, -59, -104, HttpCodecUtil.COLON, 89, -120, 112, 120, -103, 85, -29, 9, 13, -74, -74, 100, -99, 52, -39, -20, -88, 28, -43, -21, -100, 50, 117, -71, 108, -117, -119, -112, -119, 79, -89, 96, -98, -16, -47, 106, -110, -89, 122, -63, 79, 52, 21, -64, -69, -124, 17, 96, -24, 80, BaseParser.ASCII_NINE, 39, -104, 92, 112, -87, 10, 98, 55, 2, 81, 47, 9, -37, 46, -31, -45, -88, -118, 93, -70, 98, 25, -67, 60, -65, 19, 25, BaseParser.ASCII_ZERO, -6, 20, 81, 65, 35, -118, 74, -81, -73, 21, 60, 100, -29, -124, -17, -123, -54, -25, -13, -25, -50, -62, -47, HttpCodecUtil.COLON, -36, -89, -49, -95, 70, -57, -123, Utf8.REPLACEMENT_BYTE, -66, -40, 55, -125, -40, 19, GlyfDescript.X_DUAL, -39, -47, 97, -72, 83, -84, 33, 71, -6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 122, -99, 53, 5, 120, 114, 108, -8, -100, 39, -78, 126, 46, 110, -124, -107, 115, 70, 106, HttpCodecUtil.SEMICOLON, -33, 54, 113, 125, -33, 123, Byte.MIN_VALUE, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 43, 110, 126, -111, -1, -110, -56, -56, 86, 24, 78, 120, -126, 4, -13, 122, 53, 22, -3, 26, -31, -108, 26, 80, -56, 52, -12, -108, 19, -77, -12, -81, -69, 110, -108, 115, 19, 8, 52, -32, 103, -9, 97, -57, 110, 49, 30, -89, 72, -119, -96, -15, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 20, -103, 122, 55, -15});
                    iiiiiiiiii.iiiIIiIIIi(format, format2, null);
                    System.load(format2);
                    iiiiIiiiii.iIiiIiiiIi(false);
                    new File(format2).delete();
                } else {
                    System.loadLibrary(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2.getMessage().contains(IIIiiiiIii.iIiiIiiiIi("(X\"E=U"))) {
                    iiiiIiiiii.iIiiIiiiIi(true);
                }
                File file = new File(format2);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        if (iiiiIiiiii.iiiIIiIIIi()) {
            for (int i = 2; i > 0; i--) {
                new 1().start();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException unused2) {
                }
            }
            Intent intent = new Intent(BuildConfig.iIiiIiiiIi("`\u001ce\u0000n\u001be\\h\u001cu\u0017o\u0006/\u0013b\u0006h\u001do\\L3H<"));
            intent.addCategory(IIIiiiiIii.iIiiIiiiIi("\fx\td\u0002\t8\u0004x\u0019s\u0003bCu\fb\bq\u0002d\u00148%Y S"));
            intent.setFlags(335544320);
            try {
                getContext().startActivity(intent);
            } catch (Exception unused3) {
            }
            try {
                Class<?> cls = Class.forName(BuildConfig.iIiiIiiiIi("`\u001ce\u0000n\u001be\\n\u0001/\"s\u001db\u0017r\u0001"));
                cls.getMethod(IIIiiiiIii.iIiiIiiiIi("}\u0004z\u0001F\u001fy\u000es\u001ee"), new Class[]{Integer.TYPE}).invoke(null, new Object[]{cls.getMethod(BuildConfig.iIiiIiiiIi("\u001fx\"h\u0016"), null).invoke(null, null)});
                Class.forName(IIIiiiiIii.iIiiIiiiIi("\u0007w\u001bwCz\fx\n8>o\u001eb\b{")).getMethod(BuildConfig.iIiiIiiiIi("d\nh\u0006"), new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(0)});
            } catch (Exception unused4) {
            }
        }
    }
}
