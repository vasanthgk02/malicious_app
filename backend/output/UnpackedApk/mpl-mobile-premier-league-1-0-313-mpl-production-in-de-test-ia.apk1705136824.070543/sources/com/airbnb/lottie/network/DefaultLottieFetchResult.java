package com.airbnb.lottie.network;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class DefaultLottieFetchResult implements Closeable {
    public final HttpURLConnection connection;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    public void close() {
        this.connection.disconnect();
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012 A[SYNTHETIC, Splitter:B:9:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String error() {
        /*
            r2 = this;
            java.net.HttpURLConnection r0 = r2.connection     // Catch:{ IOException -> 0x000d }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x000d }
            int r0 = r0 / 100
            r1 = 2
            if (r0 != r1) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0012
            r0 = 0
            goto L_0x0045
        L_0x0012:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0046 }
            r0.<init>()     // Catch:{ IOException -> 0x0046 }
            java.lang.String r1 = "Unable to fetch "
            r0.append(r1)     // Catch:{ IOException -> 0x0046 }
            java.net.HttpURLConnection r1 = r2.connection     // Catch:{ IOException -> 0x0046 }
            java.net.URL r1 = r1.getURL()     // Catch:{ IOException -> 0x0046 }
            r0.append(r1)     // Catch:{ IOException -> 0x0046 }
            java.lang.String r1 = ". Failed with "
            r0.append(r1)     // Catch:{ IOException -> 0x0046 }
            java.net.HttpURLConnection r1 = r2.connection     // Catch:{ IOException -> 0x0046 }
            int r1 = r1.getResponseCode()     // Catch:{ IOException -> 0x0046 }
            r0.append(r1)     // Catch:{ IOException -> 0x0046 }
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch:{ IOException -> 0x0046 }
            java.net.HttpURLConnection r1 = r2.connection     // Catch:{ IOException -> 0x0046 }
            java.lang.String r1 = r2.getErrorFromConnection(r1)     // Catch:{ IOException -> 0x0046 }
            r0.append(r1)     // Catch:{ IOException -> 0x0046 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0046 }
        L_0x0045:
            return r0
        L_0x0046:
            r0 = move-exception
            java.lang.String r1 = "get error failed "
            com.airbnb.lottie.utils.Logger.warning(r1, r0)
            java.lang.String r0 = r0.getMessage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.network.DefaultLottieFetchResult.error():java.lang.String");
    }

    public final String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e2) {
                throw e2;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
