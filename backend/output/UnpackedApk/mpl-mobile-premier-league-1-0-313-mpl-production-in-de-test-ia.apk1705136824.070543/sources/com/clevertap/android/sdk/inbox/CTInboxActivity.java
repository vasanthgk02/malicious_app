package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inbox.CTInboxListViewFragment.InboxListener;
import com.google.android.material.tabs.TabLayout;
import com.inca.security.Proxy.iIiIiIiIii;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMapParser;

public class CTInboxActivity extends FragmentActivity implements InboxListener, CTInboxListener {
    public static int orientation;
    public CleverTapAPI cleverTapAPI;
    public CleverTapInstanceConfig config;
    public CTInboxListener inboxContentUpdatedListener = null;
    public CTInboxTabAdapter inboxTabAdapter;
    public WeakReference<InboxActivityListener> listenerWeakReference;
    public CTInboxStyleConfig styleConfig;
    public TabLayout tabLayout;
    public ViewPager viewPager;

    public interface InboxActivityListener {
        void messageDidClick(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z);

        void messageDidShow(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle);
    }

    public InboxActivityListener getListener() {
        InboxActivityListener inboxActivityListener;
        try {
            inboxActivityListener = (InboxActivityListener) this.listenerWeakReference.get();
        } catch (Throwable unused) {
            inboxActivityListener = null;
        }
        if (inboxActivityListener == null) {
            this.config.getLogger().verbose(this.config.accountId, (String) "InboxActivityListener is null for notification inbox ");
        }
        return inboxActivityListener;
    }

    public void inboxDidInitialize() {
        Logger.d("CTInboxActivity: called inboxDidInitialize");
        CTInboxListener cTInboxListener = this.inboxContentUpdatedListener;
        if (cTInboxListener != null) {
            cTInboxListener.inboxDidInitialize();
        }
    }

    public void inboxMessagesDidUpdate() {
        Logger.d("CTInboxActivity: called inboxMessagesDidUpdate");
        CTInboxListener cTInboxListener = this.inboxContentUpdatedListener;
        if (cTInboxListener != null) {
            cTInboxListener.inboxMessagesDidUpdate();
        }
        ((CTInboxListViewFragment) this.inboxTabAdapter.fragmentList[this.viewPager.getCurrentItem()]).updateAdapterContent();
    }

    public void messageDidClick(Context context, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z) {
        InboxActivityListener listener = getListener();
        if (listener != null) {
            listener.messageDidClick(this, cTInboxMessage, bundle, hashMap, z);
        }
    }

    public void messageDidShow(Context context, CTInboxMessage cTInboxMessage, Bundle bundle) {
        Logger.v("CTInboxActivity:messageDidShow() called with: data = [" + bundle + "], inboxMessage = [" + cTInboxMessage.messageId + CMapParser.MARK_END_OF_ARRAY);
        Logger.v("CTInboxActivity:didShow() called with: data = [" + bundle + "], inboxMessage = [" + cTInboxMessage.messageId + CMapParser.MARK_END_OF_ARRAY);
        InboxActivityListener listener = getListener();
        if (listener != null) {
            listener.messageDidShow(this, cTInboxMessage, bundle);
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 176632677, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, -1590515524, new Object[0]);
    }
}
