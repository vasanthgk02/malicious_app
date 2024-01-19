package com.clevertap.android.pushsdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.Style;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.pushnotification.INotificationRenderer;
import com.clevertap.android.sdk.pushnotification.INotificationRenderer.CC;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.squareup.picasso.NetworkRequestHandler;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONArray;

public class FallbackNotificationRenderer implements INotificationRenderer {
    public String notifMessage;
    public String notifTitle;
    public int smallIcon;

    public String getActionButtonIconKey() {
        return "ico";
    }

    public Object getCollapseKey(Bundle bundle) {
        return bundle.get("wzrk_ck");
    }

    public String getMessage(Bundle bundle) {
        String string = bundle.getString("nm");
        this.notifMessage = string;
        return string;
    }

    public String getTitle(Bundle bundle, Context context) {
        String string = bundle.getString("nt", "");
        if (string.isEmpty()) {
            string = context.getApplicationInfo().name;
        }
        this.notifTitle = string;
        return string;
    }

    public Builder renderNotification(Bundle bundle, Context context, Builder builder, CleverTapInstanceConfig cleverTapInstanceConfig, int i) {
        Style style;
        JSONArray jSONArray;
        String string = bundle.getString("ico");
        String string2 = bundle.getString("wzrk_bp");
        if (string2 == null || !string2.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
            style = new BigTextStyle().bigText(this.notifMessage);
        } else {
            try {
                Bitmap notificationBitmapWithTimeoutAndSize = Utils.getNotificationBitmapWithTimeoutAndSize(string2, false, context, cleverTapInstanceConfig, TQConstants.COUNTDOWN_DURATION, PDChoice.FLAG_MULTI_SELECT);
                if (notificationBitmapWithTimeoutAndSize != null) {
                    style = new BigPictureStyle().bigPicture(notificationBitmapWithTimeoutAndSize);
                } else {
                    throw new Exception("Failed to fetch big picture!");
                }
            } catch (Throwable th) {
                Style bigText = new BigTextStyle().bigText(this.notifMessage);
                cleverTapInstanceConfig.getLogger().verbose(cleverTapInstanceConfig.accountId, "FallbackNotificationRenderer :: Falling back to big text notification, couldn't fetch big picture", th);
                style = bigText;
            }
        }
        if (bundle.containsKey("wzrk_clr")) {
            builder.setColor(Color.parseColor(bundle.getString("wzrk_clr")));
            builder.setColorized(true);
        }
        builder.setContentTitle(this.notifTitle).setContentText(this.notifMessage).setContentIntent(k.getLaunchPendingIntent(bundle, context)).setAutoCancel(true).setStyle(style).setSmallIcon(this.smallIcon);
        builder.setLargeIcon(Utils.getNotificationBitmap(string, true, context));
        String string3 = bundle.getString("wzrk_acts");
        if (string3 != null) {
            try {
                jSONArray = new JSONArray(string3);
            } catch (Throwable th2) {
                Logger logger = cleverTapInstanceConfig.getLogger();
                String str = cleverTapInstanceConfig.accountId;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("error parsing notification actions: ");
                outline73.append(th2.getLocalizedMessage());
                logger.debug(str, outline73.toString());
            }
            setActionButtons(context, bundle, i, builder, jSONArray);
            return builder;
        }
        jSONArray = null;
        setActionButtons(context, bundle, i, builder, jSONArray);
        return builder;
    }

    public /* synthetic */ Builder setActionButtons(Context context, Bundle bundle, int i, Builder builder, JSONArray jSONArray) {
        return CC.$default$setActionButtons(this, context, bundle, i, builder, jSONArray);
    }

    public void setSmallIcon(int i, Context context) {
        this.smallIcon = i;
    }
}
