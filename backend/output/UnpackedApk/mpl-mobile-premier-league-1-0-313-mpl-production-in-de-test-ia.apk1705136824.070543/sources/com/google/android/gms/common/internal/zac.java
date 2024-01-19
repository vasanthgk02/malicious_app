package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListPlatformWrapper;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zac {
    public static final SimpleArrayMap zaa = new SimpleArrayMap();
    public static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(context);
            return packageManager.zza.getPackageManager().getApplicationLabel(packageManager.zza.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String zad(Context context, int i) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, new Object[]{zaa2});
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{zaa2});
            } else if (i == 5) {
                return zah(context, "common_google_play_services_invalid_account_text", zaa2);
            } else {
                if (i == 7) {
                    return zah(context, "common_google_play_services_network_error_text", zaa2);
                }
                if (i == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{zaa2});
                } else if (i == 20) {
                    return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
                } else {
                    switch (i) {
                        case 16:
                            return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
                        case 17:
                            return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{zaa2});
                        default:
                            return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, new Object[]{zaa2});
                    }
                }
            }
        } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, new Object[]{zaa2});
        }
    }

    public static String zag(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_title);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_title);
        }
        if (i == 3) {
            return resources.getString(R.string.common_google_play_services_enable_title);
        }
        if (i == 5) {
            return zai(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return zai(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return zai(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return zai(context, "common_google_play_services_restricted_profile_title");
    }

    public static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, new Object[]{str2});
    }

    public static String zai(Context context, String str) {
        LocaleListCompat localeListCompat;
        synchronized (zaa) {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                if (VERSION.SDK_INT >= 24) {
                    localeListCompat = new LocaleListCompat(new LocaleListPlatformWrapper(configuration.getLocales()));
                } else {
                    localeListCompat = LocaleListCompat.create(configuration.locale);
                }
                Locale locale = localeListCompat.mImpl.get(0);
                if (!locale.equals(zab)) {
                    zaa.clear();
                    zab = locale;
                }
                String str2 = (String) zaa.getOrDefault(str, null);
                if (str2 != null) {
                    return str2;
                }
                Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
                if (remoteResource == null) {
                    return null;
                }
                int identifier = remoteResource.getIdentifier(str, NetworkingModule.REQUEST_BODY_KEY_STRING, "com.google.android.gms");
                if (identifier == 0) {
                    return null;
                }
                String string = remoteResource.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                zaa.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
