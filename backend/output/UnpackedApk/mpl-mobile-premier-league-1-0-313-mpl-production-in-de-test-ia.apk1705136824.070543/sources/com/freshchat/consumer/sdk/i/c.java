package com.freshchat.consumer.sdk.i;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.x;
import com.freshchat.consumer.sdk.ui.MediaSeekBar;
import java.io.File;

public class c implements Runnable {
    public static final String TAG = c.class.getName();
    public static volatile MediaPlayer gY;
    public final e cL;
    public final Context context;
    public final TelephonyManager gZ;
    public final Message gz;
    public final Activity ha;
    public final View hb;
    public final MediaSeekBar hc;
    public OnSeekBarChangeListener hd;

    public static final boolean dU() {
        try {
            if (gY != null) {
                return gY.isPlaying();
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return false;
    }

    private void dV() {
        if (gY == null) {
            synchronized (c.class) {
                if (gY == null) {
                    gY = new MediaPlayer();
                }
            }
            return;
        }
        try {
            synchronized (c.class) {
                if (gY.isPlaying()) {
                    gY.stop();
                }
                gY.reset();
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static synchronized void dW() {
        synchronized (c.class) {
            if (gY != null && gY.isPlaying()) {
                try {
                    gY.stop();
                    try {
                        gY.reset();
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    try {
                        q.a(e3);
                    } finally {
                        try {
                            gY.reset();
                        } catch (Exception e4) {
                            q.a(e4);
                        }
                    }
                }
            }
        }
    }

    private void dX() {
        this.ha.runOnUiThread(new Runnable() {
            public void run() {
                c.this.hc.setVisibility(4);
            }
        });
    }

    private void dY() {
        this.ha.runOnUiThread(new Runnable() {
            public void run() {
                c.this.hc.setVisibility(0);
            }
        });
    }

    private void r(int i) {
        if (i == 0) {
            while (b.aq(this.gz.getAlias()) == 0) {
                try {
                    dX();
                    Thread.sleep(1000);
                } catch (Exception e2) {
                    q.a(e2);
                    return;
                }
            }
        }
    }

    public void a(Integer... numArr) {
        try {
            if (this.gZ != null && this.gZ.getCallState() == 1) {
                gY.stop();
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public void run() {
        String str;
        File b2;
        try {
            synchronized (c.class) {
                long currentTimeMillis = System.currentTimeMillis();
                dV();
                long currentTimeMillis2 = System.currentTimeMillis();
                String str2 = TAG;
                ai.d(str2, "Media init " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            try {
                this.hc.setOnSeekBarChangeListener(this.hd);
                int progress = this.hc.getProgress();
                gY.setOnErrorListener(new OnErrorListener() {
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        q.a(new RuntimeException(GeneratedOutlineSupport.outline43("Media player error w: ", i, " e: ", i2)));
                        return false;
                    }
                });
                b2 = x.b(this.context, this.gz);
                boolean exists = b2.exists();
                String str3 = TAG;
                ai.d(str3, "Audio file received for playing " + b2.getAbsolutePath());
                String str4 = TAG;
                ai.d(str4, "Does the media player's file exist ? " + exists);
                long currentTimeMillis4 = System.currentTimeMillis();
                String str5 = TAG;
                ai.d(str5, "Pre-file check " + (currentTimeMillis4 - currentTimeMillis3) + " ms");
                int aq = b.aq(this.gz.getAlias());
                if (!exists) {
                    dX();
                } else {
                    r(aq);
                }
                long currentTimeMillis5 = System.currentTimeMillis();
                String str6 = TAG;
                ai.d(str6, "Post-file check " + (currentTimeMillis5 - currentTimeMillis4) + " ms");
                dY();
                synchronized (c.class) {
                    int i = this.cL.bo() ? 3 : 0;
                    gY.reset();
                    gY.setAudioStreamType(i);
                    gY.setDataSource(b2.getAbsolutePath());
                    gY.prepare();
                    this.hc.setMax(gY.getDuration());
                    this.ha.runOnUiThread(new Runnable() {
                        public void run() {
                            c.this.hc.setThumbOffset(1);
                        }
                    });
                    ((AudioManager) this.context.getSystemService("audio")).requestAudioFocus(null, 3, 2);
                    gY.start();
                    gY.seekTo(progress);
                    long currentTimeMillis6 = System.currentTimeMillis();
                    String str7 = TAG;
                    ai.d(str7, "File-play " + (currentTimeMillis6 - currentTimeMillis5) + " ms");
                }
                try {
                    if (gY.isPlaying()) {
                        com.freshchat.consumer.sdk.j.b.c.kq = this.gz.getAlias();
                        this.hc.a(this.hb, gY);
                    }
                    while (gY.isPlaying()) {
                        a(Integer.valueOf(gY.getCurrentPosition()));
                    }
                } catch (Exception e2) {
                    q.a(e2);
                }
                a(Integer.valueOf(0));
                this.hb.setTag(Boolean.FALSE);
                this.hc.dZ();
                com.freshchat.consumer.sdk.j.b.c.kq = null;
                this.ha.runOnUiThread(new Runnable() {
                    public void run() {
                        ((ImageView) c.this.hb).setImageResource(aq.j(c.this.context, R.attr.freshchatPlayIcon));
                        c.this.hc.setThumbOffset(9999);
                    }
                });
                try {
                    ((AudioManager) this.ha.getSystemService("audio")).abandonAudioFocus(null);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                boolean delete = b2.delete();
                String str8 = TAG;
                ai.d(str8, "Was audio file deleted ? " + delete);
                q.a(e4);
                throw e4;
            } catch (Exception e5) {
                q.a(e5);
                this.hb.setTag(Boolean.FALSE);
                this.hc.dZ();
                com.freshchat.consumer.sdk.j.b.c.kq = null;
                this.ha.runOnUiThread(new Runnable() {
                    public void run() {
                        ((ImageView) c.this.hb).setImageResource(aq.j(c.this.context, R.attr.freshchatPlayIcon));
                        c.this.hc.setThumbOffset(9999);
                    }
                });
                try {
                    ((AudioManager) this.ha.getSystemService("audio")).abandonAudioFocus(null);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        } catch (Exception e7) {
            try {
                q.a(e7);
            } finally {
                try {
                    str = "audio";
                    ((AudioManager) this.ha.getSystemService(str)).abandonAudioFocus(null);
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
        } catch (Throwable th) {
            this.hb.setTag(Boolean.FALSE);
            this.hc.dZ();
            com.freshchat.consumer.sdk.j.b.c.kq = null;
            this.ha.runOnUiThread(new Runnable() {
                public void run() {
                    ((ImageView) c.this.hb).setImageResource(aq.j(c.this.context, R.attr.freshchatPlayIcon));
                    c.this.hc.setThumbOffset(9999);
                }
            });
            throw th;
        }
    }
}
