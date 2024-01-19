package com.mpl.androidapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.network.modules.listeners.IResponseListener;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadActivity extends AppCompatActivity {
    public static final String TAG = "DownloadActivity";
    public Button mDownloadApk;
    public ProgressBar mProgressBar;

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1179371322, bundle);
    }

    /* access modifiers changed from: 0000 */
    public void startDownload(String str) {
        try {
            NetworkUtils.downloadMPLProApp(this, new JSONObject(str), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    DownloadActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            DownloadActivity.this.mProgressBar.setVisibility(8);
                            DownloadActivity.this.mDownloadApk.setVisibility(0);
                        }
                    });
                }

                public void progressResponse(long j, long j2, boolean z) {
                    final int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                    MLogger.d(IResponseListener.TAG, "progressResponse: ", Integer.valueOf(i));
                    DownloadActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            if (DownloadActivity.this.mProgressBar != null && DownloadActivity.this.mProgressBar.isShown()) {
                                DownloadActivity.this.mProgressBar.setProgress(i);
                            }
                        }
                    });
                }

                public void onResponseSuccess(String str) {
                    DownloadActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            DownloadActivity.this.mProgressBar.setVisibility(8);
                        }
                    });
                    FileUtils.installApk(DownloadActivity.this, new File(str));
                }
            });
        } catch (JSONException e2) {
            MLogger.printStackTrace(e2);
        }
    }
}
