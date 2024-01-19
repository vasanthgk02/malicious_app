package com.badlogic.gdx.backends.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.audio.Music;

public class AndroidMusic implements Music, OnCompletionListener {
    public boolean isPrepared;
    public Music.OnCompletionListener onCompletionListener;
    public MediaPlayer player;
    public boolean wasPlaying;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r4.player = null;
        r4.onCompletionListener = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        co.hyperverge.hypersnapsdk.c.k.app.log("AndroidMusic", "error while disposing AndroidMusic instance, non-fatal");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r4 = this;
            android.media.MediaPlayer r0 = r4.player
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r1 = 0
            r0.release()     // Catch:{ all -> 0x000e }
            r4.player = r1
            r4.onCompletionListener = r1
            throw r1
        L_0x000e:
            com.badlogic.gdx.Application r0 = co.hyperverge.hypersnapsdk.c.k.app     // Catch:{ all -> 0x001c }
            java.lang.String r2 = "AndroidMusic"
            java.lang.String r3 = "error while disposing AndroidMusic instance, non-fatal"
            r0.log(r2, r3)     // Catch:{ all -> 0x001c }
            r4.player = r1
            r4.onCompletionListener = r1
            throw r1
        L_0x001c:
            r4.player = r1
            r4.onCompletionListener = r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidMusic.dispose():void");
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.onCompletionListener != null) {
            k.app.postRunnable(new Runnable() {
                public void run() {
                    AndroidMusic androidMusic = AndroidMusic.this;
                    androidMusic.onCompletionListener.onCompletion(androidMusic);
                }
            });
        }
    }
}
