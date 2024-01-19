package com.rudderstack.android.sdk.core;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.rudderstack.android.sdk.core.util.Utils;
import com.rudderstack.android.sdk.core.util.Utils.NetworkResponses;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.cmap.CMapParser;

public class FlushUtils {
    public static final Object DB_LOCK = new Object();
    public static final Object FLUSH_LOCK = new Object();

    public static boolean flush(boolean z, Map<String, RudderIntegration<?>> map, List<Integer> list, List<String> list2, int i, String str, DBPersistentManager dBPersistentManager, String str2, String str3) {
        int i2;
        boolean z2;
        List<Integer> list3 = list;
        List<String> list4 = list2;
        int i3 = i;
        DBPersistentManager dBPersistentManager2 = dBPersistentManager;
        if (z && map != null) {
            flushNativeSdks(map);
        }
        list.clear();
        list2.clear();
        RudderLogger.logDebug("EventRepository: flush: Fetching events to flush to server");
        synchronized (DB_LOCK) {
            dBPersistentManager2.fetchAllEventsFromDB(list3, list4);
        }
        int numberOfBatches = Utils.getNumberOfBatches(list2.size(), i3);
        RudderLogger.logDebug(String.format(Locale.US, "EventRepository: flush: %d batches of events to be flushed", new Object[]{Integer.valueOf(numberOfBatches)}));
        int i4 = 1;
        while (i4 <= numberOfBatches) {
            int i5 = 3;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    String str4 = str2;
                    String str5 = str3;
                    i2 = 2;
                    z2 = true;
                    break;
                }
                List<T> batch = Utils.getBatch(list3, i3);
                List<T> batch2 = Utils.getBatch(list2, i);
                String payloadFromMessages = getPayloadFromMessages(batch, batch2);
                RudderLogger.logDebug(String.format(Locale.US, "EventRepository: flush: payload: %s", new Object[]{payloadFromMessages}));
                RudderLogger.logInfo(String.format(Locale.US, "EventRepository: flush: EventCount: %d", new Object[]{Integer.valueOf(batch2.size())}));
                if (payloadFromMessages != null) {
                    NetworkResponses flushEventsToServer = flushEventsToServer(payloadFromMessages, str, str2, str3);
                    RudderLogger.logInfo(String.format(Locale.US, "EventRepository: flush: ServerResponse: %s", new Object[]{flushEventsToServer}));
                    if (flushEventsToServer == NetworkResponses.SUCCESS) {
                        RudderLogger.logDebug(String.format("EventRepository: flush: Successfully sent batch %d/%d ", new Object[]{Integer.valueOf(i4), Integer.valueOf(numberOfBatches)}));
                        RudderLogger.logInfo(String.format(Locale.US, "EventRepository: flush: clearingEvents of batch %d from DB: %s", new Object[]{Integer.valueOf(i4), flushEventsToServer}));
                        dBPersistentManager2.clearEventsFromDB(batch);
                        list3.removeAll(batch);
                        list4.removeAll(batch2);
                        z2 = false;
                        i2 = 2;
                        break;
                    }
                } else {
                    String str6 = str2;
                    String str7 = str3;
                }
                RudderLogger.logWarn(String.format("EventRepository: flush: Failed to send batch %d/%d retrying again, %d retries left", new Object[]{Integer.valueOf(i4), Integer.valueOf(numberOfBatches), Integer.valueOf(i6)}));
                i3 = i;
                i5 = i6;
            }
            if (z2) {
                Object[] objArr = new Object[i2];
                objArr[0] = Integer.valueOf(i4);
                objArr[1] = Integer.valueOf(numberOfBatches);
                RudderLogger.logWarn(String.format("EventRepository: flush: Failed to send batch %d/%d after 3 retries , dropping the remaining batches as well", objArr));
                return false;
            }
            i4++;
            i3 = i;
        }
        return true;
    }

    public static NetworkResponses flushEventsToServer(String str, String str2, String str3, String str4) {
        String byteArrayOutputStream;
        try {
            if (TextUtils.isEmpty(str3)) {
                RudderLogger.logError((String) "EventRepository: flushEventsToServer: WriteKey was not correct. Aborting flush to server");
                return null;
            }
            RudderLogger.logDebug("EventRepository: flushEventsToServer: dataPlaneEndPoint: " + r6);
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str2 + "v1/batch").openConnection()));
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            httpURLConnection.setRequestProperty("Authorization", String.format(Locale.US, "Basic %s", new Object[]{str3}));
            httpURLConnection.setRequestProperty("AnonymousId", str4);
            httpURLConnection.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            synchronized (FLUSH_LOCK) {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
                outputStreamWriter.close();
                outputStream.close();
                httpURLConnection.connect();
            }
            if (httpURLConnection.getResponseCode() == 200) {
                return NetworkResponses.SUCCESS;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getErrorStream());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            for (int read = bufferedInputStream.read(); read != -1; read = bufferedInputStream.read()) {
                byteArrayOutputStream2.write((byte) read);
            }
            RudderLogger.logError("EventRepository: flushEventsToServer: ServerError: " + byteArrayOutputStream);
            if (byteArrayOutputStream.toLowerCase().contains("invalid write key")) {
                return NetworkResponses.WRITE_KEY_ERROR;
            }
            return NetworkResponses.ERROR;
        } catch (Exception e2) {
            RudderLogger.logError(e2);
        }
    }

    public static void flushNativeSdks(Map<String, RudderIntegration<?>> map) {
        RudderLogger.logDebug("EventRepository: flush native SDKs");
        for (Entry next : map.entrySet()) {
            RudderLogger.logDebug(String.format(Locale.US, "EventRepository: flush for %s", new Object[]{next.getKey()}));
            RudderIntegration rudderIntegration = (RudderIntegration) next.getValue();
            if (rudderIntegration != null) {
                rudderIntegration.flush();
            }
        }
    }

    public static String getPayloadFromMessages(List<Integer> list, List<String> list2) {
        try {
            RudderLogger.logDebug("EventRepository: getPayloadFromMessages: recordCount: " + list2.size());
            String timeStamp = Utils.getTimeStamp();
            RudderLogger.logDebug("EventRepository: getPayloadFromMessages: sentAtTimestamp: " + timeStamp);
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"sentAt\":\"");
            sb.append(timeStamp);
            sb.append("\",");
            sb.append("\"batch\": [");
            int uTF8Length = Utils.getUTF8Length(sb) + 2;
            int i = 0;
            while (true) {
                if (i >= list2.size()) {
                    break;
                }
                String str = list2.get(i);
                String format = String.format("%s,\"sentAt\":\"%s\"},", new Object[]{str.substring(0, str.length() - 1), timeStamp});
                uTF8Length += Utils.getUTF8Length(format);
                if (uTF8Length >= 512000) {
                    RudderLogger.logDebug(String.format(Locale.US, "EventRepository: getPayloadFromMessages: MAX_BATCH_SIZE reached at index: %d | Total: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(uTF8Length)}));
                    break;
                }
                sb.append(format);
                arrayList.add(list.get(i));
                i++;
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            sb.append("}");
            list.retainAll(arrayList);
            return sb.toString();
        } catch (Exception e2) {
            RudderLogger.logError(e2);
            return null;
        }
    }
}
