package com.inca.security.DexProtect;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.util.Locale;

public class SupportActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        Builder builder = new Builder(this);
        builder.setCancelable(false);
        if (VERSION.SDK_INT < 24) {
            str = getResources().getConfiguration().locale.getCountry();
        } else {
            str = getResources().getConfiguration().getLocales().get(0).getCountry();
        }
        if (str.length() == 0) {
            str = Locale.getDefault().getCountry();
        }
        String str3 = "AppGuard RunTime 兼容性";
        if (str.compareTo("KR") == 0) {
            str3 = "앱가드 런타임 호환성";
            str2 = "실행을 위해서는 Dalvik 런타임으로의 변경이 필요합니다.";
        } else if (str.compareTo("CN") == 0) {
            str2 = "为执行需要变更到Dalvik Runtime。";
        } else if (str.compareTo("TW") == 0) {
            str2 = "為執行需要變更到 Dalvik Runtime。";
        } else if (str.compareTo("JP") == 0) {
            str3 = "GameGuard for Mobileのランタイムとの互換性";
            str2 = "実行するためにはDalvikランタイムへの変更が必要となります。";
        } else {
            str3 = "AppGuard Runtime Compatibility";
            str2 = "A change to the Dalvik runtime is required for execution.";
        }
        builder.setTitle(str3);
        builder.setMessage(str2);
        builder.setNeutralButton(LiveVideoBroadcaster.OK, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (VERSION.SDK_INT >= 16) {
                        SupportActivity.this.finishAffinity();
                    }
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                } catch (Exception unused) {
                }
            }
        });
        builder.create().show();
    }
}
