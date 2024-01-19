package com.shield.android.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.inca.security.Proxy.iIiIiIiIii;
import com.shield.android.CaptchaType;
import com.shield.android.internal.f;
import com.shield.android.internal.j;
import java.util.Random;

public class CaptchaDialog extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public CaptchaType f1686a = CaptchaType.TEXT_CAPTCHA;

    /* renamed from: b  reason: collision with root package name */
    public LocalBroadcastManager f1687b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f1688c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f1689d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f1690e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f1691f;
    public TextView g;
    public String h = "";
    public int i = -1;
    public int j = 0;

    public static Intent a(Context context, CaptchaType captchaType, boolean z) {
        Intent intent = new Intent(context, CaptchaDialog.class);
        intent.putExtra("captcha_type", captchaType);
        intent.putExtra("quittable", z);
        return intent;
    }

    /* access modifiers changed from: 0000 */
    public /* synthetic */ void b() {
        Intent intent = new Intent("captcha_broadcast");
        intent.putExtra("RESULT_OK", true);
        this.f1687b.sendBroadcast(intent);
        finish();
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1467285744, bundle);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 == 6) {
            if (this.f1686a != CaptchaType.TEXT_CAPTCHA) {
                try {
                    if (Integer.parseInt(this.f1689d.getText().toString()) != this.i) {
                        int i3 = this.j + 1;
                        this.j = i3;
                        if (i3 > 3) {
                            Intent intent = new Intent("captcha_broadcast");
                            intent.putExtra("RESULT_OK", false);
                            this.f1687b.sendBroadcast(intent);
                            finish();
                        }
                        this.g.setVisibility(0);
                        int nextInt = new Random().nextInt(10);
                        int nextInt2 = new Random().nextInt(10);
                        this.i = nextInt + nextInt2;
                        this.f1688c.setImageBitmap(j.a(nextInt, nextInt2));
                    } else {
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                CaptchaDialog.this.b();
                            }
                        }, 200);
                    }
                } catch (Exception e2) {
                    if (f.a().f1677b && e2.getMessage() != null) {
                        e2.getLocalizedMessage();
                    }
                }
            } else if (!this.f1689d.getText().toString().equals(this.h)) {
                int i4 = this.j + 1;
                this.j = i4;
                if (i4 > 3) {
                    Intent intent2 = new Intent("captcha_broadcast");
                    intent2.putExtra("RESULT_OK", false);
                    this.f1687b.sendBroadcast(intent2);
                    finish();
                }
                this.g.setVisibility(0);
                String e3 = j.e();
                this.h = e3;
                this.f1688c.setImageBitmap(j.a(e3));
            } else {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        CaptchaDialog.this.a();
                    }
                }, 200);
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public /* synthetic */ void a() {
        Intent intent = new Intent("captcha_broadcast");
        intent.putExtra("RESULT_OK", true);
        this.f1687b.sendBroadcast(intent);
        finish();
    }
}
