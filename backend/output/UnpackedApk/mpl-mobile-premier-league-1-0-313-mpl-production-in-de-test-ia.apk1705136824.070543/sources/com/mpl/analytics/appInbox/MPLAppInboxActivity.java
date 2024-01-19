package com.mpl.analytics.appInbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;

public class MPLAppInboxActivity extends AppCompatActivity implements CTInboxListener {
    public static final String TAG = "MPLAppInboxActivity";
    public CleverTapAPI cleverTapDefaultInstance;
    public Button yourInboxButton;

    public static Intent createIntent(Context context) {
        return new Intent(context, MPLAppInboxActivity.class);
    }

    public void inboxDidInitialize() {
        this.yourInboxButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("Promotions");
                arrayList.add("Offers");
                arrayList.add("Others");
                CTInboxStyleConfig cTInboxStyleConfig = new CTInboxStyleConfig();
                cTInboxStyleConfig.setTabs(arrayList);
                cTInboxStyleConfig.setTabBackgroundColor("#FF0000");
                cTInboxStyleConfig.setSelectedTabIndicatorColor("#0000FF");
                cTInboxStyleConfig.setSelectedTabColor("#000000");
                cTInboxStyleConfig.setUnselectedTabColor("#FFFFFF");
                cTInboxStyleConfig.setBackButtonColor("#FF0000");
                cTInboxStyleConfig.setNavBarTitleColor("#FF0000");
                cTInboxStyleConfig.setNavBarTitle("MY INBOX");
                cTInboxStyleConfig.setNavBarColor("#FFFFFF");
                cTInboxStyleConfig.setInboxBackgroundColor("#00FF00");
                MPLAppInboxActivity.this.cleverTapDefaultInstance.showAppInbox(cTInboxStyleConfig);
            }
        });
    }

    public void inboxMessagesDidUpdate() {
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1754284264, bundle);
    }
}
