package com.shield.android;

import com.shield.android.d.e;
import com.shield.android.internal.f;
import java.net.ConnectException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PortDetector {
    public static boolean isAirdroidConnected;
    public static boolean isAwerayConnected;
    public static boolean isVysorConnected;

    public static void a(e eVar) {
        boolean z;
        boolean z2 = false;
        try {
            new DatagramSocket(5647).close();
        } catch (Exception e2) {
            String exc = e2.toString();
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
            if (exc.contains("EADDRINUSE")) {
                Object[] objArr = new Object[0];
                if (f.a().f1677b) {
                    String.format("aweray port detected ", objArr);
                }
                z = true;
            }
        }
        z = false;
        isAwerayConnected = z;
        if (z) {
            eVar.c();
        }
        int i = 8888;
        int i2 = 0;
        while (i <= 8892) {
            if (i == 8892) {
                i = 8765;
            }
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), i));
                i2++;
                socket.close();
            } catch (ConnectException e3) {
                if (f.a().f1677b && e3.getMessage() != null) {
                    e3.getLocalizedMessage();
                }
            } catch (Exception e4) {
                if (f.a().f1677b && e4.getMessage() != null) {
                    e4.getLocalizedMessage();
                }
            }
            if (i == 8765) {
                break;
            }
            i++;
        }
        boolean z3 = i2 == 5;
        isAirdroidConnected = z3;
        if (z3) {
            eVar.b();
        }
        int i3 = 0;
        for (int i4 = 53516; i4 <= 53519; i4++) {
            try {
                Socket socket2 = new Socket();
                socket2.connect(new InetSocketAddress(InetAddress.getLocalHost(), i4));
                i3++;
                socket2.close();
            } catch (ConnectException e5) {
                if (f.a().f1677b && e5.getMessage() != null) {
                    e5.getLocalizedMessage();
                }
            } catch (Exception e6) {
                if (f.a().f1677b && e6.getMessage() != null) {
                    e6.getLocalizedMessage();
                }
            }
        }
        if (i3 >= 3) {
            z2 = true;
        }
        isVysorConnected = z2;
        if (z2) {
            eVar.a();
        }
    }
}
