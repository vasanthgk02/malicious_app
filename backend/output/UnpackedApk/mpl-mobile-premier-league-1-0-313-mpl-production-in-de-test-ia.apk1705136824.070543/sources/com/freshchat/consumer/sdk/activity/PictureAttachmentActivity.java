package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.a.h;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.p;
import com.inca.security.Proxy.iIiIiIiIii;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

public class PictureAttachmentActivity extends b {
    public View aD;
    public View aE;
    public TextWatcher aV = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
            if (editable != null && p.aD(PictureAttachmentActivity.this.getContext())) {
                i.a(PictureAttachmentActivity.this.getContext(), PictureAttachmentActivity.this.bV);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public h bQ;
    public boolean bR = false;
    public View bS;
    public View bT;
    public ImageView bU;
    public EditText bV;
    public a bW;
    public ProgressBar bX;
    public OnClickListener bY = new OnClickListener() {
        public void onClick(View view) {
            PictureAttachmentActivity.this.bW.m(PictureAttachmentActivity.this.bV.getText().toString());
            PictureAttachmentActivity.this.setResult(-1, PictureAttachmentActivity.this.bW.aM());
            PictureAttachmentActivity.this.finish();
        }
    };
    public com.freshchat.consumer.sdk.f.a bZ = new com.freshchat.consumer.sdk.f.a() {
        public void aG() {
            i.a(PictureAttachmentActivity.this.getContext(), (View) PictureAttachmentActivity.this.bU, (View) PictureAttachmentActivity.this.bX);
        }

        public void aH() {
            PictureAttachmentActivity.this.aE.setAlpha(1.0f);
            i.a(PictureAttachmentActivity.this.getContext(), (View) PictureAttachmentActivity.this.bX, (View) PictureAttachmentActivity.this.bU);
            PictureAttachmentActivity.this.aE.setEnabled(true);
        }

        public void aI() {
            i.a(PictureAttachmentActivity.this.getContext(), c.PICTURE_ATTACHMENT_PREVIEW_ERROR);
            PictureAttachmentActivity.this.finish();
        }
    };

    public static class a {
        public String cb;
        public String cc;
        public String cd;
        public int height;
        public int width;

        public String aK() {
            return this.cc;
        }

        public String aL() {
            return this.cd;
        }

        public Intent aM() {
            Intent intent = new Intent();
            intent.putExtra("PIC_URL", this.cc);
            intent.putExtra("PIC_THUMB_URL", this.cb);
            intent.putExtra("PICTURE_WIDTH", this.width);
            intent.putExtra("PICTURE_HEIGHT", this.height);
            intent.putExtra("IMAGE_CAPTION", this.cd);
            return intent;
        }

        public a d(Intent intent) {
            this.cc = intent.getStringExtra("PIC_URL");
            this.cb = intent.getStringExtra("PIC_THUMB_URL");
            this.width = intent.getIntExtra("PICTURE_WIDTH", 100);
            this.height = intent.getIntExtra("PICTURE_HEIGHT", 100);
            this.cd = intent.getStringExtra("IMAGE_CAPTION");
            return this;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public void k(String str) {
            this.cb = str;
        }

        public void l(String str) {
            this.cc = str;
        }

        public void m(String str) {
            this.cd = str;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public void setWidth(int i) {
            this.width = i;
        }
    }

    public static Intent a(Context context, Uri uri, int i, String str) {
        Intent intent = new Intent(context, PictureAttachmentActivity.class);
        intent.putExtra("PICTURE_URL", uri);
        intent.putExtra("REQUEST_CODE", i);
        intent.putExtra("ATTACHMENT_CREATION_MODE", true);
        intent.putExtra("IMAGE_CAPTION", str);
        return intent;
    }

    public static Intent a(Context context, String str) {
        Intent intent = new Intent(context, PictureAttachmentActivity.class);
        intent.addFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
        intent.putExtra("PICTURE_URL", str);
        return intent;
    }

    public void a(Context context, Intent intent) {
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout"};
    }

    /* access modifiers changed from: 0000 */
    public void b(Uri uri, int i) {
        com.freshchat.consumer.sdk.i.a aVar = new com.freshchat.consumer.sdk.i.a(getApplicationContext(), this.bU, i, this.bW, this.bZ);
        aVar.execute(new Uri[]{uri});
    }

    /* access modifiers changed from: 0000 */
    public void j(String str) {
        String aF = ad.aF(str);
        Context applicationContext = getApplicationContext();
        com.freshchat.consumer.sdk.j.a.d.a aVar = new com.freshchat.consumer.sdk.j.a.d.a(applicationContext, "cache");
        aVar.a(applicationContext, 0.05f);
        h hVar = new h(applicationContext, Math.min(1080, p.ar(getContext())));
        this.bQ = hVar;
        hVar.c(aVar);
        this.bQ.a((Object) aF, this.bU, this.bZ);
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1091790256, bundle);
    }
}
