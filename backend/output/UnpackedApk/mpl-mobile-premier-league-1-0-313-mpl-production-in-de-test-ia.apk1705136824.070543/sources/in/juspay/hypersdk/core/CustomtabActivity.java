package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.browser.customtabs.CustomTabColorSchemeParams$Builder;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomtabActivity extends Activity {
    public static final String CUSTOMTAB_RESULT = "customtab-result";
    public static final String LOG_TAG = "CustomtabActivity";
    public Boolean isFirstResume = Boolean.TRUE;

    public static ArrayList<ResolveInfo> getCustomTabsPackages(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        List<ResolveInfo> queryIntentActivities = VERSION.SDK_INT >= 23 ? packageManager.queryIntentActivities(intent, 131072) : packageManager.queryIntentActivities(intent, 0);
        ArrayList<ResolveInfo> arrayList = new ArrayList<>();
        for (ResolveInfo next : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(next.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean isChromeInstalled(ArrayList<ResolveInfo> arrayList) {
        Iterator<ResolveInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().activityInfo.packageName.equals("com.android.chrome")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void launchInBrowser(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void launchIntentChooser(ArrayList<ResolveInfo> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<ResolveInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setPackage(it.next().activityInfo.packageName);
            arrayList2.add(intent);
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList2.remove(0), "Select app");
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList2.toArray(new Parcelable[arrayList2.size()]));
        startActivity(createChooser);
    }

    public void loadUrl(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        CustomTabColorSchemeParams$Builder customTabColorSchemeParams$Builder = new CustomTabColorSchemeParams$Builder();
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
        Integer num = customTabColorSchemeParams$Builder.mToolbarColor;
        Bundle bundle2 = new Bundle();
        if (num != null) {
            bundle2.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        intent.putExtras(bundle2);
        CustomTabsIntent customTabsIntent = new CustomTabsIntent(intent, null);
        customTabsIntent.intent.setData(Uri.parse(str));
        try {
            ArrayList<ResolveInfo> customTabsPackages = getCustomTabsPackages(getBaseContext(), str);
            if (customTabsPackages.size() <= 0) {
                launchInBrowser(str);
            } else if (isChromeInstalled(customTabsPackages)) {
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setData(Uri.parse(str));
                ContextCompat.startActivity(this, customTabsIntent.intent, customTabsIntent.startAnimationBundle);
            } else {
                launchIntentChooser(customTabsPackages, str);
            }
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "Exception in customtab activity", e2);
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1115316500, bundle);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 887952220, new Object[0]);
    }
}
