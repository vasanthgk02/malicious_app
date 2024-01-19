package com.mpl.androidapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public class ShareMPLActivity extends AppCompatActivity {
    public static final String TAG = "ShareMPL:";
    public SimpleDraweeView mShareImage;
    public Intent mShareIntent;
    public JSONObject mShareJsonObject;
    public TextView mShareText;

    public void createDirectoriesIfUnAvailable(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public String getSavedFile(byte[] bArr, int i, File file, String str, boolean z) {
        return getSavedFile(bArr, i, file, str, z, true);
    }

    public String getSavedFileFromUri(Context context, Uri uri, File file, String str) {
        byte[] bArr;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[1024];
                while (openInputStream.read(bArr2) != -1) {
                    byteArrayOutputStream.write(bArr2);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (FileNotFoundException | IOException unused) {
                bArr = null;
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (bArr == null) {
                return null;
            }
            return getSavedFile(bArr, bArr.length, file, str, true);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            throw null;
        }
    }

    public void handleSendImage(Intent intent, String str) {
        String str2;
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            try {
                this.mShareText.setVisibility(8);
                this.mShareImage.setVisibility(0);
                if (str == null || !str.equals("image/gif")) {
                    this.mShareImage.setImageURI(uri);
                    File appExternalSendingImageStoragePath = FileUtils.getAppExternalSendingImageStoragePath(this);
                    str2 = getSavedFileFromUri(this, uri, appExternalSendingImageStoragePath, System.currentTimeMillis() + ".png");
                } else {
                    PipelineDraweeControllerBuilder uri2 = Fresco.newDraweeControllerBuilder().setUri(uri);
                    uri2.mAutoPlayAnimations = true;
                    this.mShareImage.setController(uri2.build());
                    File appExternalSendingImageStoragePath2 = FileUtils.getAppExternalSendingImageStoragePath(this);
                    str2 = getSavedFileFromUri(this, uri, appExternalSendingImageStoragePath2, System.currentTimeMillis() + ".gif");
                }
                MLogger.d(TAG, "handleSendImage: ", str2);
                JSONObject jSONObject = new JSONObject();
                this.mShareJsonObject = jSONObject;
                jSONObject.put("isFile", true);
                this.mShareJsonObject.put("isText", false);
                this.mShareJsonObject.put("text", "");
                this.mShareJsonObject.put("file", str2);
                prepareNotificationData(this.mShareJsonObject);
            } catch (Exception e2) {
                MLogger.e(TAG, "handleSendImage: ", e2.getMessage());
            }
        }
    }

    public void handleSendMultipleImages(Intent intent) {
        intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    }

    public void handleSendText(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        if (stringExtra != null) {
            this.mShareImage.setVisibility(8);
            this.mShareText.setText(stringExtra);
            try {
                JSONObject jSONObject = new JSONObject();
                this.mShareJsonObject = jSONObject;
                jSONObject.put("isFile", false);
                this.mShareJsonObject.put("isText", true);
                this.mShareJsonObject.put("text", stringExtra);
                this.mShareJsonObject.put("file", "");
                prepareNotificationData(this.mShareJsonObject);
            } catch (Exception unused) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        setContentView((int) R.layout.activity_share_mpl);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (type != null && type.equals("image/gif")) {
            toolbar.setTitle((CharSequence) "Send GIF");
        } else if (type == null || (!type.equals("image/png") && !type.equals("image/jpg"))) {
            toolbar.setTitle((CharSequence) "Send");
        } else {
            toolbar.setTitle((CharSequence) "Send Image");
        }
        setSupportActionBar(toolbar);
        this.mShareText = (TextView) findViewById(R.id.share_text);
        this.mShareImage = (SimpleDraweeView) findViewById(R.id.share_image);
        findViewById(R.id.send).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ShareMPLActivity shareMPLActivity = ShareMPLActivity.this;
                EventPublishHelper.publishMqttMessageReceiveEvent(shareMPLActivity, shareMPLActivity.mShareJsonObject.toString());
                ShareMPLActivity.this.finish();
            }
        });
        if (!"android.intent.action.SEND".equals(action) || type == null) {
            if ("android.intent.action.SEND_MULTIPLE".equals(action) && type != null && type.startsWith("image/")) {
                handleSendMultipleImages(intent);
            }
        } else if ("text/plain".equals(type)) {
            handleSendText(intent);
        } else if (type.startsWith("image/")) {
            handleSendImage(intent, type);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void prepareNotificationData(JSONObject jSONObject) {
        this.mShareIntent = new Intent(this, MPLReactContainerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("sharable", true);
        bundle.putString("sharableData", jSONObject.toString());
        bundle.putString("action", "OPEN_DEEP_LINK");
        bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Messages\",\"param\":{\"shareContent\":" + jSONObject + "}}}");
        this.mShareIntent.putExtras(bundle);
    }

    public String getSavedFile(byte[] bArr, int i, File file, String str, boolean z, boolean z2) {
        String str2 = null;
        if (bArr != null && i > 0) {
            createDirectoriesIfUnAvailable(file.getAbsolutePath());
            File file2 = new File(file, str);
            if (file2.exists()) {
                file2.delete();
                try {
                    file2.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (z2) {
                file2.setReadable(true, false);
                file2.setWritable(true, false);
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    str2 = file2.getAbsolutePath();
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
            }
            if (str2 != null && z) {
                return GeneratedOutlineSupport.outline50("file://", str2);
            }
        }
        return str2;
    }
}
