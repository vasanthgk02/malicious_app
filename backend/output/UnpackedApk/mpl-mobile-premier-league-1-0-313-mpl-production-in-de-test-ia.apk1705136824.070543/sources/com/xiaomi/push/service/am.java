package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.di;
import com.xiaomi.push.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;

public class am {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4853a = Log.isLoggable("NCHelper", 3);

    public static int a(NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((Integer) z.b((Object) notificationChannel, (String) "getUserLockedFields", new Object[0])).intValue();
            if (f4853a) {
                a("isUserLockedChannel:" + i + CMap.SPACE + notificationChannel);
            }
        } catch (Exception e2) {
            b.a((String) "NCHelper", "is user locked error" + e2);
        }
        return i;
    }

    @TargetApi(26)
    public static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(aq aqVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String a2 = aqVar.a(str);
        if (f4853a) {
            StringBuilder outline82 = GeneratedOutlineSupport.outline82("createChannel: appChannelId:", a2, " serverChannelId:", str, " serverChannelName:");
            outline82.append(charSequence);
            outline82.append(" serverChannelDesc:");
            outline82.append(str2);
            outline82.append(" serverChannelNotifyType:");
            outline82.append(i);
            outline82.append(" serverChannelName:");
            outline82.append(charSequence);
            outline82.append(" serverChannelImportance:");
            outline82.append(i2);
            outline82.append(" channelSoundStr:");
            outline82.append(str3);
            outline82.append(" channelPermissions:");
            outline82.append(str4);
            a(outline82.toString());
        }
        NotificationChannel notificationChannel = new NotificationChannel(a2, charSequence, i2);
        notificationChannel.setDescription(str2);
        boolean z = false;
        notificationChannel.enableVibration((i & 2) != 0);
        if ((i & 4) != 0) {
            z = true;
        }
        notificationChannel.enableLights(z);
        if ((i & 1) == 0) {
            notificationChannel.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("android.resource://");
            outline73.append(aqVar.a());
            if (str3.startsWith(outline73.toString())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (f4853a) {
            a("create channel:" + notificationChannel);
        }
        a(aqVar, notificationChannel, str4);
        return a2;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public static void a(Context context, aq aqVar, NotificationChannel notificationChannel, int i, String str) {
        if (i > 0) {
            int a2 = a.a(context) >= 2 ? e.a(context.getPackageName(), str) : 0;
            NotificationChannel a3 = a(notificationChannel.getId(), notificationChannel);
            if ((i & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    a3.setSound(null, null);
                } else {
                    a3.setSound(System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    a3.enableVibration(false);
                } else {
                    a3.enableVibration(true);
                }
            }
            if ((i & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    a3.enableLights(false);
                } else {
                    a3.enableLights(true);
                }
            }
            if ((i & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                a3.setImportance(importance);
            }
            if ((i & 2) != 0) {
                a3.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            aqVar.a(a3);
            aqVar.a(notificationChannel, true);
            e.a(aqVar.a(), notificationChannel.getId(), a2, 0);
            return;
        }
        aqVar.a(notificationChannel);
    }

    public static void a(Context context, String str) {
        if (f.a(context) && !TextUtils.isEmpty(str)) {
            c(context, str);
            e.a(context, str);
        }
    }

    public static void a(Context context, List<String> list) {
        if (f4853a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (!list.isEmpty()) {
            Editor edit = a(context).edit();
            for (String remove : list) {
                edit.remove(remove);
            }
            edit.apply();
        }
    }

    public static void a(di diVar) {
        if (diVar != null) {
            Map<String, String> map = diVar.f493a;
            if (map != null && map.containsKey("REMOVE_CHANNEL_MARK")) {
                diVar.f489a = 0;
                diVar.f493a.remove(Constants.CHANNEL_ID);
                diVar.f493a.remove("channel_importance");
                diVar.f493a.remove("channel_name");
                diVar.f493a.remove("channel_description");
                diVar.f493a.remove("channel_perm");
                b.a("delete channel info by:" + diVar.f493a.get("REMOVE_CHANNEL_MARK"));
                diVar.f493a.remove("REMOVE_CHANNEL_MARK");
            }
        }
    }

    @TargetApi(26)
    public static void a(aq aqVar, NotificationChannel notificationChannel, String str) {
        char c2;
        int i;
        Context a2 = aqVar.a();
        String id = notificationChannel.getId();
        String a3 = aq.a(id, aqVar.a());
        if (f4853a) {
            a("appChannelId:" + id + " oldChannelId:" + a3);
        }
        boolean z = true;
        if (!f.a(a2) || TextUtils.equals(id, a3)) {
            NotificationChannel a4 = aqVar.a(id);
            if (f4853a) {
                a("elseLogic getNotificationChannel:" + a4);
            }
            if (a4 == null) {
                aqVar.a(notificationChannel);
            }
        } else {
            NotificationManager notificationManager = (NotificationManager) a2.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a3);
            NotificationChannel a5 = aqVar.a(id);
            if (f4853a) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + a5);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a6 = a(id, notificationChannel2);
                if (f4853a) {
                    a("copyXmsf copyXmsfChannel:" + a6);
                }
                if (a5 != null) {
                    i = a(a5);
                    aqVar.a(a6, i == 0);
                    c2 = 3;
                } else {
                    int a7 = a(notificationChannel2);
                    a(a2, aqVar, a6, a7, notificationChannel2.getId());
                    i = a7;
                    c2 = 4;
                }
                b(a2, id);
                notificationManager.deleteNotificationChannel(a3);
            } else if (a5 == null) {
                if (f4853a) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                aqVar.a(notificationChannel);
                i = 0;
                c2 = 1;
            } else if (!a(a2, id) && a(notificationChannel, a5)) {
                if (f4853a) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                i = a(a5);
                aqVar.a(notificationChannel, i == 0);
                c2 = 2;
            }
            if (!(c2 == 1 || c2 == 4 || c2 == 3)) {
                z = false;
            }
            e.a(aqVar.a(), aqVar.a(), id, notificationChannel.getImportance(), str, z, i);
        }
        i = 0;
        c2 = 0;
        z = false;
        e.a(aqVar.a(), aqVar.a(), id, notificationChannel.getImportance(), str, z, i);
    }

    public static void a(String str) {
        b.a((String) "NCHelper", str);
    }

    @TargetApi(26)
    public static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        boolean z2 = false;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z3 = true;
        if (!TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            if (f4853a) {
                a((String) "appHack channelConfigLowerCompare:getName");
            }
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f4853a) {
                a((String) "appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f4853a) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("appHack channelConfigLowerCompare:getImportance  ");
                outline73.append(notificationChannel.getImportance());
                outline73.append(CMap.SPACE);
                outline73.append(notificationChannel2.getImportance());
                a(outline73.toString());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f4853a) {
                a((String) "appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f4853a) {
                a((String) "appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        boolean z4 = notificationChannel.getSound() != null;
        if (notificationChannel2.getSound() != null) {
            z2 = true;
        }
        if (z4 != z2) {
            notificationChannel.setSound(null, null);
            if (f4853a) {
                a((String) "appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z3 = z;
        }
        if (f4853a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z3);
        }
        return z3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m803a(Context context, String str) {
        if (f4853a) {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("checkCopeidChannel:newFullChannelId:", str, "  ");
            outline80.append(a(context).getBoolean(str, false));
            a(outline80.toString());
        }
        return a(context).getBoolean(str, false);
    }

    public static void b(Context context, String str) {
        if (f4853a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    public static void c(Context context, String str) {
        try {
            aq a2 = aq.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String next : keySet) {
                if (a2.a(next)) {
                    arrayList.add(next);
                    if (f4853a) {
                        a("delete channel copy record:" + next);
                    }
                }
            }
            a(context, (List<String>) arrayList);
        } catch (Exception unused) {
        }
    }
}
