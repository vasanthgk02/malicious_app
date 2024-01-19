package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.payment.routing.RoutingConstants;
import com.netcore.android.SMTEventParamKeys;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONArray;
import org.json.JSONObject;
import sfs2x.client.requests.game.CreateSFSGameRequest;

public abstract class UPIUtils {
    public boolean isBindStarted;
    public int smsSendingTryCount;

    public class SendSmsThread extends Thread {
        public String callback;
        public Integer counter = Integer.valueOf(0);
        public Integer length;
        public String mobileNumber;
        public String simSlot;
        public String token;
        public Integer tries;

        public abstract class SMSBroadcastReceiver extends BroadcastReceiver {
            public WeakReference<Activity> activityRef = new WeakReference<>(null);
            public boolean isRegistered = false;

            public SMSBroadcastReceiver() {
            }

            public synchronized void registerWithFlag() {
                Activity activity = (Activity) this.activityRef.get();
                if (activity != null) {
                    activity.registerReceiver(this, new IntentFilter("SMS_SENT" + SendSmsThread.this.mobileNumber));
                    this.isRegistered = true;
                }
            }

            public synchronized void setActivityRef(Activity activity) {
                this.activityRef = new WeakReference<>(activity);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void unregisterWithFlag() {
                /*
                    r2 = this;
                    monitor-enter(r2)
                    boolean r0 = r2.isRegistered     // Catch:{ all -> 0x0019 }
                    if (r0 != 0) goto L_0x0007
                    monitor-exit(r2)
                    return
                L_0x0007:
                    java.lang.ref.WeakReference<android.app.Activity> r0 = r2.activityRef     // Catch:{ all -> 0x0019 }
                    java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0019 }
                    android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ all -> 0x0019 }
                    if (r0 == 0) goto L_0x0017
                    r1 = 0
                    r2.isRegistered = r1     // Catch:{ all -> 0x0019 }
                    r0.unregisterReceiver(r2)     // Catch:{ all -> 0x0019 }
                L_0x0017:
                    monitor-exit(r2)
                    return
                L_0x0019:
                    r0 = move-exception
                    monitor-exit(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.UPIUtils.SendSmsThread.SMSBroadcastReceiver.unregisterWithFlag():void");
            }
        }

        public SendSmsThread(String str, String str2, String str3, String str4, Integer num, Integer num2) {
            this.simSlot = str;
            this.mobileNumber = str2;
            this.token = str3;
            this.callback = str4;
            this.tries = num;
            this.length = num2;
        }

        public void run() {
            int i = VERSION.SDK_INT >= 23 ? PDChoice.FLAG_COMMIT_ON_SEL_CHANGE : 0;
            Activity activity = UPIUtils.this.getActivity();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SMS_SENT");
            outline73.append(this.mobileNumber);
            final PendingIntent broadcast = PendingIntent.getBroadcast(activity, 0, new Intent(outline73.toString()), i);
            AnonymousClass1 r1 = new SMSBroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    int resultCode = getResultCode();
                    int i = (intent == null || intent.getExtras() == null) ? 0 : intent.getExtras().getInt("errorCode");
                    if (resultCode == -1) {
                        SendSmsThread sendSmsThread = SendSmsThread.this;
                        UPIUtils uPIUtils = UPIUtils.this;
                        if (!uPIUtils.isBindStarted) {
                            uPIUtils.isBindStarted = true;
                            sendSmsThread.sendCallback(this, Integer.valueOf(resultCode), Integer.valueOf(i));
                            return;
                        }
                    }
                    if (resultCode == -1 || SendSmsThread.this.counter.intValue() >= SendSmsThread.this.tries.intValue()) {
                        SendSmsThread sendSmsThread2 = SendSmsThread.this;
                        UPIUtils uPIUtils2 = UPIUtils.this;
                        if (uPIUtils2.isBindStarted || uPIUtils2.smsSendingTryCount != sendSmsThread2.length.intValue()) {
                            synchronized (this) {
                                UPIUtils.this.smsSendingTryCount++;
                            }
                            unregisterWithFlag();
                            return;
                        }
                        SendSmsThread.this.sendCallback(this, Integer.valueOf(resultCode), Integer.valueOf(i));
                        return;
                    }
                    SendSmsThread.this.sendSMS(broadcast);
                }
            };
            r1.setActivityRef(UPIUtils.this.getActivity());
            r1.registerWithFlag();
            sendSMS(broadcast);
        }

        public void sendCallback(SMSBroadcastReceiver sMSBroadcastReceiver, Integer num, Integer num2) {
            String str;
            DynamicUI dynamicUI;
            StringBuilder sb;
            String str2;
            String str3;
            if (num.intValue() == -1) {
                dynamicUI = UPIUtils.this.getDynamicUI();
                sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                sb.append(this.callback);
                str2 = "\", \"SUCCESS\")";
            } else if (num.intValue() == 1) {
                dynamicUI = UPIUtils.this.getDynamicUI();
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                outline73.append(this.callback);
                outline73.append("\", \"GENERIC_FAILURE");
                if (num2.intValue() == 0) {
                    str3 = "";
                } else {
                    str3 = "_" + num2;
                }
                str = GeneratedOutlineSupport.outline62(outline73, str3, "\", \"837\")");
                dynamicUI.addJsToWebView(str);
                sMSBroadcastReceiver.unregisterWithFlag();
            } else if (num.intValue() == 4) {
                dynamicUI = UPIUtils.this.getDynamicUI();
                sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                sb.append(this.callback);
                str2 = "\", \"NO_SERVICE\", \"838\")";
            } else if (num.intValue() == 3) {
                dynamicUI = UPIUtils.this.getDynamicUI();
                sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                sb.append(this.callback);
                str2 = "\", \"NULL_PDU\", \"839\")";
            } else if (num.intValue() == 2) {
                dynamicUI = UPIUtils.this.getDynamicUI();
                sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                sb.append(this.callback);
                str2 = "\", \"RADIO_OFF\", \"840\")";
            } else {
                dynamicUI = UPIUtils.this.getDynamicUI();
                sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                sb.append(this.callback);
                str2 = "\", \"EXCEPTION\", \"837\")";
            }
            sb.append(str2);
            str = sb.toString();
            dynamicUI.addJsToWebView(str);
            sMSBroadcastReceiver.unregisterWithFlag();
        }

        public void sendSMS(PendingIntent pendingIntent) {
            this.counter = Integer.valueOf(this.counter.intValue() + 1);
            new PaymentUtils();
            Context context = UPIUtils.this.getContext();
            HyperFragment hyperFragment = UPIUtils.this.getHyperFragment();
            int parseInt = Integer.parseInt(this.simSlot);
            String str = this.mobileNumber;
            PaymentUtils.sendSMS(context, hyperFragment, parseInt, str, null, this.token + CMap.SPACE + this.mobileNumber, pendingIntent, null);
        }
    }

    public abstract Activity getActivity();

    public abstract Context getContext();

    public String getDeviceDetails() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("androidId", Secure.getString(getContext().getContentResolver(), "android_id"));
            jSONObject.put("os", "ANDROID");
            jSONObject.put("androidAPILevel", VERSION.SDK_INT + "");
            jSONObject.put("version", VERSION.RELEASE);
            jSONObject.put(SMTEventParamKeys.SMT_APP_VERSION, getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("geocode", "");
            jSONObject.put("location", "");
            jSONObject.put("capability", "");
            jSONObject.put(CreateSFSGameRequest.KEY_INVITATION_PARAMS, "");
            jSONObject.put("packageName", getContext().getPackageName());
            jSONObject.put(Constant.HEADER_ANDROID_DEVICE_ID, Secure.getString(getContext().getContentResolver(), "android_id"));
            jSONObject.put("subscriberId", getSubscriberId());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public abstract DynamicUI getDynamicUI();

    public abstract HyperFragment getHyperFragment();

    @SuppressLint({"MissingPermission"})
    public String getSIMOperators() {
        try {
            JSONArray jSONArray = new JSONArray();
            List<SubscriptionInfo> activeSubscriptionInfoList = (VERSION.SDK_INT >= 23 ? (SubscriptionManager) getContext().getSystemService(SubscriptionManager.class) : SubscriptionManager.from(getContext())).getActiveSubscriptionInfoList();
            int i = 0;
            if (activeSubscriptionInfoList == null) {
                return "SIM_CARD_NOT_AVAILABLE";
            }
            for (SubscriptionInfo next : activeSubscriptionInfoList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    StringBuilder sb = new StringBuilder();
                    int i2 = i + 1;
                    try {
                        sb.append(i);
                        sb.append("");
                        jSONObject.put("id", sb.toString());
                        jSONObject.put("simSerialNo", next.getSubscriptionId() + "");
                        jSONObject.put("provider", next.getCarrierName());
                        if (next.getNumber() != null && next.getNumber().length() > 9) {
                            jSONObject.put(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, next.getNumber());
                        }
                        jSONArray.put(jSONObject);
                    } catch (Exception unused) {
                    }
                    i = i2;
                } catch (Exception unused2) {
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("simDetails", jSONArray);
            return jSONObject2.toString();
        } catch (Exception unused3) {
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public String getSubscriberId() {
        try {
            JSONArray jSONArray = new JSONArray();
            List<SubscriptionInfo> activeSubscriptionInfoList = (VERSION.SDK_INT >= 23 ? (SubscriptionManager) getContext().getSystemService(SubscriptionManager.class) : SubscriptionManager.from(getContext())).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList == null) {
                return "SIM_CARD_NOT_AVAILABLE";
            }
            Iterator<SubscriptionInfo> it = activeSubscriptionInfoList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().getSubscriptionId() + "");
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return "error while fetching SubscriberId";
        }
    }

    public boolean isAirplaneModeOn() {
        return Global.getInt(getContext().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    @SuppressLint({"MissingPermission"})
    public boolean isSimActive(int i) {
        int i2 = VERSION.SDK_INT;
        boolean z = true;
        if (i2 >= 26) {
            int simSlotIndex = ((SubscriptionManager) getContext().getSystemService(SubscriptionManager.class)).getActiveSubscriptionInfoList().get(i).getSimSlotIndex();
            TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            if (telephonyManager.getSimState(simSlotIndex) != 5) {
                z = false;
            }
            return z;
        } else if (i2 < 24) {
            return true;
        } else {
            TelephonyManager createForSubscriptionId = ((TelephonyManager) getContext().getSystemService("phone")).createForSubscriptionId(((SubscriptionManager) getContext().getSystemService(SubscriptionManager.class)).getActiveSubscriptionInfoList().get(i).getSubscriptionId());
            if (createForSubscriptionId == null) {
                return false;
            }
            if (createForSubscriptionId.getSimState() != 5) {
                z = false;
            }
            return z;
        }
    }

    public void sendSms(String str, String[] strArr, String str2, String str3, String str4) {
        this.isBindStarted = false;
        this.smsSendingTryCount = 1;
        for (String sendSmsThread : strArr) {
            SendSmsThread sendSmsThread2 = new SendSmsThread(str, sendSmsThread, str2, str4, Integer.valueOf(Integer.parseInt(str3)), Integer.valueOf(r10));
            sendSmsThread2.start();
        }
    }
}
