package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.google.firebase.perf.config.RemoteConfigManager;
import org.apache.fontbox.cmap.CMap;
import sfs2x.client.entities.invitation.InvitationReply;

public final class o extends FrameLayout implements OnBufferingUpdateListener, OnCompletionListener, OnPreparedListener, OnVideoSizeChangedListener, Callback, MediaPlayerControl {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3537a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3538b;

    /* renamed from: c  reason: collision with root package name */
    public final SurfaceView f3539c;

    /* renamed from: d  reason: collision with root package name */
    public final SurfaceHolder f3540d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3541e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3542f;
    public final int g;
    public final boolean h;
    public final long i;
    public final long j;
    public final FrameLayout k;
    public final Display l;
    public int m;
    public int n;
    public int o;
    public int p;
    public MediaPlayer q;
    public MediaController r;
    public boolean s = false;
    public boolean t = false;
    public int u = 0;
    public boolean v = false;
    public boolean w = false;
    public a x;
    public b y;
    public volatile int z = 0;

    public interface a {
        void a(int i);
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public o f3544b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3545c = false;

        public b(o oVar) {
            this.f3544b = oVar;
        }

        public final void a() {
            this.f3545c = true;
        }

        public final void run() {
            try {
                Thread.sleep(RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (!this.f3545c) {
                if (o.f3537a) {
                    o.b("Stopping the video player due to timeout.");
                }
                this.f3544b.CancelOnPrepare();
            }
        }
    }

    public o(Context context, String str, int i2, int i3, int i4, boolean z2, long j2, long j3, a aVar) {
        super(context);
        this.x = aVar;
        this.f3538b = context;
        this.k = this;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f3539c = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.f3540d = holder;
        holder.addCallback(this);
        this.k.setBackgroundColor(i2);
        this.k.addView(this.f3539c);
        this.l = ((WindowManager) this.f3538b.getSystemService("window")).getDefaultDisplay();
        this.f3541e = str;
        this.f3542f = i3;
        this.g = i4;
        this.h = z2;
        this.i = j2;
        this.j = j3;
        if (f3537a) {
            b("fileName: " + this.f3541e);
        }
        if (f3537a) {
            b("backgroundColor: " + i2);
        }
        if (f3537a) {
            b("controlMode: " + this.f3542f);
        }
        if (f3537a) {
            b("scalingMode: " + this.g);
        }
        if (f3537a) {
            b("isURL: " + this.h);
        }
        if (f3537a) {
            b("videoOffset: " + this.i);
        }
        if (f3537a) {
            b("videoLength: " + this.j);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void a(int i2) {
        this.z = i2;
        a aVar = this.x;
        if (aVar != null) {
            aVar.a(this.z);
        }
    }

    public static void b(String str) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r8 = this;
            android.media.MediaPlayer r0 = r8.q
            if (r0 == 0) goto L_0x001c
            android.view.SurfaceHolder r1 = r8.f3540d
            r0.setDisplay(r1)
            boolean r0 = r8.v
            if (r0 != 0) goto L_0x001b
            boolean r0 = f3537a
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "Resuming playback"
            b(r0)
        L_0x0016:
            android.media.MediaPlayer r0 = r8.q
            r0.start()
        L_0x001b:
            return
        L_0x001c:
            r0 = 0
            r8.a(r0)
            r8.doCleanUp()
            android.media.MediaPlayer r0 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x00cc }
            r0.<init>()     // Catch:{ Exception -> 0x00cc }
            r8.q = r0     // Catch:{ Exception -> 0x00cc }
            boolean r1 = r8.h     // Catch:{ Exception -> 0x00cc }
            if (r1 == 0) goto L_0x003a
            android.content.Context r1 = r8.f3538b     // Catch:{ Exception -> 0x00cc }
            java.lang.String r2 = r8.f3541e     // Catch:{ Exception -> 0x00cc }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00cc }
            r0.setDataSource(r1, r2)     // Catch:{ Exception -> 0x00cc }
            goto L_0x008e
        L_0x003a:
            long r0 = r8.j     // Catch:{ Exception -> 0x00cc }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x005a
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00cc }
            java.lang.String r1 = r8.f3541e     // Catch:{ Exception -> 0x00cc }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r2 = r8.q     // Catch:{ Exception -> 0x00cc }
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ Exception -> 0x00cc }
            long r4 = r8.i     // Catch:{ Exception -> 0x00cc }
            long r6 = r8.j     // Catch:{ Exception -> 0x00cc }
            r2.setDataSource(r3, r4, r6)     // Catch:{ Exception -> 0x00cc }
        L_0x0056:
            r0.close()     // Catch:{ Exception -> 0x00cc }
            goto L_0x008e
        L_0x005a:
            android.content.res.Resources r0 = r8.getResources()     // Catch:{ Exception -> 0x00cc }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x00cc }
            java.lang.String r1 = r8.f3541e     // Catch:{ IOException -> 0x007d }
            android.content.res.AssetFileDescriptor r0 = r0.openFd(r1)     // Catch:{ IOException -> 0x007d }
            android.media.MediaPlayer r1 = r8.q     // Catch:{ IOException -> 0x007d }
            java.io.FileDescriptor r2 = r0.getFileDescriptor()     // Catch:{ IOException -> 0x007d }
            long r3 = r0.getStartOffset()     // Catch:{ IOException -> 0x007d }
            long r5 = r0.getLength()     // Catch:{ IOException -> 0x007d }
            r1.setDataSource(r2, r3, r5)     // Catch:{ IOException -> 0x007d }
            r0.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x008e
        L_0x007d:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00cc }
            java.lang.String r1 = r8.f3541e     // Catch:{ Exception -> 0x00cc }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r1 = r8.q     // Catch:{ Exception -> 0x00cc }
            java.io.FileDescriptor r2 = r0.getFD()     // Catch:{ Exception -> 0x00cc }
            r1.setDataSource(r2)     // Catch:{ Exception -> 0x00cc }
            goto L_0x0056
        L_0x008e:
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            android.view.SurfaceHolder r1 = r8.f3540d     // Catch:{ Exception -> 0x00cc }
            r0.setDisplay(r1)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            r1 = 1
            r0.setScreenOnWhilePlaying(r1)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            r0.setOnBufferingUpdateListener(r8)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            r0.setOnCompletionListener(r8)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            r0.setOnPreparedListener(r8)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            r0.setOnVideoSizeChangedListener(r8)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            r1 = 3
            r0.setAudioStreamType(r1)     // Catch:{ Exception -> 0x00cc }
            android.media.MediaPlayer r0 = r8.q     // Catch:{ Exception -> 0x00cc }
            r0.prepareAsync()     // Catch:{ Exception -> 0x00cc }
            com.unity3d.player.o$b r0 = new com.unity3d.player.o$b     // Catch:{ Exception -> 0x00cc }
            r0.<init>(r8)     // Catch:{ Exception -> 0x00cc }
            r8.y = r0     // Catch:{ Exception -> 0x00cc }
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ Exception -> 0x00cc }
            com.unity3d.player.o$b r1 = r8.y     // Catch:{ Exception -> 0x00cc }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00cc }
            r0.start()     // Catch:{ Exception -> 0x00cc }
            return
        L_0x00cc:
            r0 = move-exception
            boolean r1 = f3537a
            if (r1 == 0) goto L_0x00e9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            b(r0)
        L_0x00e9:
            r0 = 2
            r8.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.o.c():void");
    }

    private void d() {
        if (!isPlaying()) {
            a(1);
            if (f3537a) {
                b("startVideoPlayback");
            }
            updateVideoLayout();
            if (!this.v) {
                start();
            }
        }
    }

    public final void CancelOnPrepare() {
        a(2);
    }

    public final boolean a() {
        return this.v;
    }

    public final boolean canPause() {
        return true;
    }

    public final boolean canSeekBackward() {
        return true;
    }

    public final boolean canSeekForward() {
        return true;
    }

    public final void destroyPlayer() {
        if (f3537a) {
            b("destroyPlayer");
        }
        if (!this.v) {
            pause();
        }
        doCleanUp();
    }

    public final void doCleanUp() {
        b bVar = this.y;
        if (bVar != null) {
            bVar.a();
            this.y = null;
        }
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.q = null;
        }
        this.o = 0;
        this.p = 0;
        this.t = false;
        this.s = false;
    }

    public final int getBufferPercentage() {
        if (this.h) {
            return this.u;
        }
        return 100;
    }

    public final int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public final int getDuration() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    public final boolean isPlaying() {
        boolean z2 = this.t && this.s;
        MediaPlayer mediaPlayer = this.q;
        return mediaPlayer == null ? !z2 : mediaPlayer.isPlaying() || !z2;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        if (f3537a) {
            b("onBufferingUpdate percent:" + i2);
        }
        this.u = i2;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f3537a) {
            b("onCompletion called");
        }
        destroyPlayer();
        a(3);
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || (this.f3542f == 2 && i2 != 0 && !keyEvent.isSystem())) {
            destroyPlayer();
            a(3);
            return true;
        }
        MediaController mediaController = this.r;
        return mediaController != null ? mediaController.onKeyDown(i2, keyEvent) : super.onKeyDown(i2, keyEvent);
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f3537a) {
            b("onPrepared called");
        }
        b bVar = this.y;
        if (bVar != null) {
            bVar.a();
            this.y = null;
        }
        int i2 = this.f3542f;
        if (i2 == 0 || i2 == 1) {
            MediaController mediaController = new MediaController(this.f3538b);
            this.r = mediaController;
            mediaController.setMediaPlayer(this);
            this.r.setAnchorView(this);
            this.r.setEnabled(true);
            Context context = this.f3538b;
            if (context instanceof Activity) {
                this.r.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.r.show();
        }
        this.t = true;
        if (1 != 0 && this.s) {
            d();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & InvitationReply.EXPIRED;
        if (this.f3542f == 2 && action == 0) {
            destroyPlayer();
            a(3);
            return true;
        }
        MediaController mediaController = this.r;
        return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        if (f3537a) {
            b("onVideoSizeChanged called " + i2 + "x" + i3);
        }
        if (i2 == 0 || i3 == 0) {
            if (f3537a) {
                b("invalid video width(" + i2 + ") or height(" + i3 + ")");
            }
            return;
        }
        this.s = true;
        this.o = i2;
        this.p = i3;
        if (this.t && 1 != 0) {
            d();
        }
    }

    public final void pause() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            if (this.w) {
                mediaPlayer.pause();
            }
            this.v = true;
        }
    }

    public final void seekTo(int i2) {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i2);
        }
    }

    public final void start() {
        if (f3537a) {
            b("Start");
        }
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            if (this.w) {
                mediaPlayer.start();
            }
            this.v = false;
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (f3537a) {
            b("surfaceChanged called " + i2 + CMap.SPACE + i3 + "x" + i4);
        }
        if (this.m != i3 || this.n != i4) {
            this.m = i3;
            this.n = i4;
            if (this.w) {
                updateVideoLayout();
            }
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f3537a) {
            b("surfaceCreated called");
        }
        this.w = true;
        c();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f3537a) {
            b("surfaceDestroyed called");
        }
        this.w = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r5 <= r3) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        r0 = (int) (((float) r1) * r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        if (r5 >= r3) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateVideoLayout() {
        /*
            r8 = this;
            boolean r0 = f3537a
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = "updateVideoLayout"
            b(r0)
        L_0x000a:
            android.media.MediaPlayer r0 = r8.q
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            int r0 = r8.m
            if (r0 == 0) goto L_0x0017
            int r0 = r8.n
            if (r0 != 0) goto L_0x0036
        L_0x0017:
            android.content.Context r0 = r8.f3538b
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r1)
            int r0 = r1.widthPixels
            r8.m = r0
            int r0 = r1.heightPixels
            r8.n = r0
        L_0x0036:
            int r0 = r8.m
            int r1 = r8.n
            boolean r2 = r8.s
            if (r2 == 0) goto L_0x0067
            int r2 = r8.o
            float r3 = (float) r2
            int r4 = r8.p
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r5 = r5 / r6
            int r6 = r8.g
            r7 = 1
            if (r6 != r7) goto L_0x005a
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0055
        L_0x0051:
            float r1 = (float) r0
            float r1 = r1 / r3
            int r1 = (int) r1
            goto L_0x0071
        L_0x0055:
            float r0 = (float) r1
            float r0 = r0 * r3
            int r0 = (int) r0
            goto L_0x0071
        L_0x005a:
            r7 = 2
            if (r6 != r7) goto L_0x0062
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0055
            goto L_0x0051
        L_0x0062:
            if (r6 != 0) goto L_0x0071
            r0 = r2
            r1 = r4
            goto L_0x0071
        L_0x0067:
            boolean r2 = f3537a
            if (r2 == 0) goto L_0x0071
            java.lang.String r2 = "updateVideoLayout: Video size is not known yet"
            b(r2)
        L_0x0071:
            int r2 = r8.m
            if (r2 != r0) goto L_0x0079
            int r2 = r8.n
            if (r2 == r1) goto L_0x00a4
        L_0x0079:
            boolean r2 = f3537a
            if (r2 == 0) goto L_0x0096
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "frameWidth = "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r3 = "; frameHeight = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            b(r2)
        L_0x0096:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r0, r1, r3)
            android.widget.FrameLayout r0 = r8.k
            android.view.SurfaceView r1 = r8.f3539c
            r0.updateViewLayout(r1, r2)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.o.updateVideoLayout():void");
    }
}
