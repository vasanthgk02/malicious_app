package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.customviews.CloseImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CTInAppBaseFragment extends Fragment {
    public CloseImageView closeImageView = null;
    public CleverTapInstanceConfig config;
    public Context context;
    public int currentOrientation;
    public CTInAppNotification inAppNotification;
    public AtomicBoolean isCleanedUp = new AtomicBoolean();
    public WeakReference<InAppListener> listenerWeakReference;

    public class CTInAppNativeButtonClickListener implements OnClickListener {
        public CTInAppNativeButtonClickListener() {
        }

        public void onClick(View view) {
            CTInAppBaseFragment cTInAppBaseFragment = CTInAppBaseFragment.this;
            int intValue = ((Integer) view.getTag()).intValue();
            if (cTInAppBaseFragment != null) {
                try {
                    CTInAppNotificationButton cTInAppNotificationButton = cTInAppBaseFragment.inAppNotification.buttons.get(intValue);
                    Bundle bundle = new Bundle();
                    bundle.putString("wzrk_id", cTInAppBaseFragment.inAppNotification.campaignId);
                    bundle.putString("wzrk_c2a", cTInAppNotificationButton.text);
                    HashMap<String, String> hashMap = cTInAppNotificationButton.keyValues;
                    InAppListener listener = cTInAppBaseFragment.getListener();
                    if (listener != null) {
                        listener.inAppNotificationDidClick(cTInAppBaseFragment.inAppNotification, bundle, hashMap);
                    }
                    String str = cTInAppNotificationButton.actionUrl;
                    if (str != null) {
                        cTInAppBaseFragment.fireUrlThroughIntent(str, bundle);
                    } else {
                        cTInAppBaseFragment.didDismiss(bundle);
                    }
                } catch (Throwable th) {
                    Logger logger = cTInAppBaseFragment.config.getLogger();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error handling notification button click: ");
                    outline73.append(th.getCause());
                    logger.debug(outline73.toString());
                    cTInAppBaseFragment.didDismiss(null);
                }
            } else {
                throw null;
            }
        }
    }

    public abstract void cleanup();

    public void didDismiss(Bundle bundle) {
        cleanup();
        InAppListener listener = getListener();
        if (listener != null && getActivity() != null && getActivity().getBaseContext() != null) {
            listener.inAppNotificationDidDismiss(getActivity().getBaseContext(), this.inAppNotification, bundle);
        }
    }

    public void fireUrlThroughIntent(String str, Bundle bundle) {
        try {
            Uri parse = Uri.parse(str.replace("\n", "").replace("\r", ""));
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Bundle bundle2 = new Bundle();
            if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                for (String next : queryParameterNames) {
                    bundle2.putString(next, parse.getQueryParameter(next));
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            if (!bundle2.isEmpty()) {
                intent.putExtras(bundle2);
            }
            Utils.setPackageNameFromResolveInfoList(getActivity(), intent);
            startActivity(intent);
        } catch (Throwable unused) {
        }
        didDismiss(bundle);
    }

    public abstract void generateListener();

    public InAppListener getListener() {
        InAppListener inAppListener;
        try {
            inAppListener = (InAppListener) this.listenerWeakReference.get();
        } catch (Throwable unused) {
            inAppListener = null;
        }
        if (inAppListener == null) {
            Logger logger = this.config.getLogger();
            String str = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("InAppListener is null for notification: ");
            outline73.append(this.inAppNotification.jsonDescription);
            logger.verbose(str, outline73.toString());
        }
        return inAppListener;
    }

    public int getScaledPixels(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public void onAttach(Context context2) {
        super.onAttach(context2);
        this.context = context2;
        Bundle arguments = getArguments();
        this.inAppNotification = (CTInAppNotification) arguments.getParcelable("inApp");
        this.config = (CleverTapInstanceConfig) arguments.getParcelable("config");
        this.currentOrientation = getResources().getConfiguration().orientation;
        generateListener();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        InAppListener listener = getListener();
        if (listener != null) {
            listener.inAppNotificationDidShow(this.inAppNotification, null);
        }
    }
}
