package com.badlogic.gdx.backends.android;

import android.app.WallpaperColors;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.service.wallpaper.WallpaperService.Engine;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.WindowManager;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxNativesLoader;
import org.apache.fontbox.cmap.CMap;

public abstract class AndroidLiveWallpaperService extends WallpaperService {
    public static boolean DEBUG = false;
    public volatile AndroidLiveWallpaper app = null;
    public int engines = 0;
    public volatile boolean isPreviewNotified = false;
    public volatile AndroidWallpaperEngine linkedEngine = null;
    public volatile boolean notifiedPreviewState = false;
    public volatile int[] sync = new int[0];
    public Callback view = null;
    public int viewFormat;
    public int viewHeight;
    public int viewWidth;
    public int visibleEngines = 0;

    public class AndroidWallpaperEngine extends Engine {
        public int engineFormat;
        public int engineHeight;
        public boolean engineIsVisible = false;
        public int engineWidth;
        public boolean iconDropConsumed = true;
        public boolean offsetsConsumed = true;
        public int xIconDrop;
        public float xOffset = 0.0f;
        public float xOffsetStep = 0.0f;
        public int xPixelOffset = 0;
        public int yIconDrop;
        public float yOffset = 0.0f;
        public float yOffsetStep = 0.0f;
        public int yPixelOffset = 0;

        public AndroidWallpaperEngine() {
            super(AndroidLiveWallpaperService.this);
            if (AndroidLiveWallpaperService.DEBUG) {
                hashCode();
            }
        }

        public void notifyOffsetsChanged() {
            if (AndroidLiveWallpaperService.this.linkedEngine == this && (AndroidLiveWallpaperService.this.app.listener instanceof AndroidWallpaperListener) && !this.offsetsConsumed) {
                this.offsetsConsumed = true;
                AndroidLiveWallpaperService.this.app.postRunnable(new Runnable() {
                    public void run() {
                        boolean z;
                        synchronized (AndroidLiveWallpaperService.this.sync) {
                            z = AndroidLiveWallpaperService.this.linkedEngine == AndroidWallpaperEngine.this;
                        }
                        if (z) {
                            AndroidWallpaperEngine androidWallpaperEngine = AndroidWallpaperEngine.this;
                            ((AndroidWallpaperListener) AndroidLiveWallpaperService.this.app.listener).offsetChange(androidWallpaperEngine.xOffset, androidWallpaperEngine.yOffset, androidWallpaperEngine.xOffsetStep, androidWallpaperEngine.yOffsetStep, androidWallpaperEngine.xPixelOffset, androidWallpaperEngine.yPixelOffset);
                        }
                    }
                });
            }
        }

        public void notifyPreviewState() {
            if (AndroidLiveWallpaperService.this.linkedEngine == this && (AndroidLiveWallpaperService.this.app.listener instanceof AndroidWallpaperListener)) {
                final boolean isPreview = AndroidLiveWallpaperService.this.linkedEngine.isPreview();
                AndroidLiveWallpaperService.this.app.postRunnable(new Runnable() {
                    public void run() {
                        boolean z;
                        synchronized (AndroidLiveWallpaperService.this.sync) {
                            z = true;
                            if (AndroidLiveWallpaperService.this.isPreviewNotified) {
                                if (AndroidLiveWallpaperService.this.notifiedPreviewState == isPreview) {
                                    z = false;
                                }
                            }
                            AndroidLiveWallpaperService.this.notifiedPreviewState = isPreview;
                            AndroidLiveWallpaperService.this.isPreviewNotified = true;
                        }
                        if (z) {
                            AndroidLiveWallpaper androidLiveWallpaper = AndroidLiveWallpaperService.this.app;
                            if (androidLiveWallpaper != null) {
                                ((AndroidWallpaperListener) androidLiveWallpaper.listener).previewStateChange(isPreview);
                            }
                        }
                    }
                });
            }
        }

        public final void notifySurfaceChanged(int i, int i2, int i3, boolean z) {
            if (!z) {
                AndroidLiveWallpaperService androidLiveWallpaperService = AndroidLiveWallpaperService.this;
                if (i == androidLiveWallpaperService.viewFormat && i2 == androidLiveWallpaperService.viewWidth && i3 == androidLiveWallpaperService.viewHeight) {
                    boolean z2 = AndroidLiveWallpaperService.DEBUG;
                    return;
                }
            }
            this.engineFormat = i;
            this.engineWidth = i2;
            this.engineHeight = i3;
            if (AndroidLiveWallpaperService.this.linkedEngine == this) {
                AndroidLiveWallpaperService androidLiveWallpaperService2 = AndroidLiveWallpaperService.this;
                androidLiveWallpaperService2.viewFormat = this.engineFormat;
                androidLiveWallpaperService2.viewWidth = this.engineWidth;
                androidLiveWallpaperService2.viewHeight = this.engineHeight;
                Callback callback = androidLiveWallpaperService2.view;
                SurfaceHolder surfaceHolder = getSurfaceHolder();
                AndroidLiveWallpaperService androidLiveWallpaperService3 = AndroidLiveWallpaperService.this;
                callback.surfaceChanged(surfaceHolder, androidLiveWallpaperService3.viewFormat, androidLiveWallpaperService3.viewWidth, androidLiveWallpaperService3.viewHeight);
                return;
            }
            boolean z3 = AndroidLiveWallpaperService.DEBUG;
        }

        public Bundle onCommand(String str, int i, int i2, int i3, Bundle bundle, boolean z) {
            if (AndroidLiveWallpaperService.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append(" > AndroidWallpaperEngine - onCommand(");
                sb.append(str);
                sb.append(CMap.SPACE);
                sb.append(i);
                sb.append(CMap.SPACE);
                sb.append(i2);
                sb.append(CMap.SPACE);
                sb.append(i3);
                sb.append(CMap.SPACE);
                sb.append(bundle);
                sb.append(CMap.SPACE);
                sb.append(z);
                sb.append("), linked: ");
                sb.append(AndroidLiveWallpaperService.this.linkedEngine == this);
                sb.toString();
            }
            if (str.equals("android.home.drop")) {
                this.iconDropConsumed = false;
                this.xIconDrop = i;
                this.yIconDrop = i2;
                if (AndroidLiveWallpaperService.this.linkedEngine == this && (AndroidLiveWallpaperService.this.app.listener instanceof AndroidWallpaperListener) && !this.iconDropConsumed) {
                    this.iconDropConsumed = true;
                    AndroidLiveWallpaperService.this.app.postRunnable(new Runnable() {
                        public void run() {
                            boolean z;
                            synchronized (AndroidLiveWallpaperService.this.sync) {
                                z = AndroidLiveWallpaperService.this.linkedEngine == AndroidWallpaperEngine.this;
                            }
                            if (z) {
                                AndroidWallpaperEngine androidWallpaperEngine = AndroidWallpaperEngine.this;
                                ((AndroidWallpaperListener) AndroidLiveWallpaperService.this.app.listener).iconDropped(androidWallpaperEngine.xIconDrop, androidWallpaperEngine.yIconDrop);
                            }
                        }
                    });
                }
            }
            return super.onCommand(str, i, i2, i3, bundle, z);
        }

        public WallpaperColors onComputeColors() {
            Application application = k.app;
            if (VERSION.SDK_INT >= 27 && (application instanceof AndroidLiveWallpaper)) {
                Color[] colorArr = ((AndroidLiveWallpaper) application).wallpaperColors;
                if (colorArr != null) {
                    return new WallpaperColors(android.graphics.Color.valueOf(colorArr[0].r, colorArr[0].g, colorArr[0].f3307b, colorArr[0].f3306a), android.graphics.Color.valueOf(colorArr[1].r, colorArr[1].g, colorArr[1].f3307b, colorArr[1].f3306a), android.graphics.Color.valueOf(colorArr[2].r, colorArr[2].g, colorArr[2].f3307b, colorArr[2].f3306a));
                }
            }
            return super.onComputeColors();
        }

        public void onCreate(SurfaceHolder surfaceHolder) {
            if (AndroidLiveWallpaperService.DEBUG) {
                hashCode();
                AndroidLiveWallpaperService androidLiveWallpaperService = AndroidLiveWallpaperService.this;
                int i = androidLiveWallpaperService.engines;
                AndroidWallpaperEngine androidWallpaperEngine = androidLiveWallpaperService.linkedEngine;
                Thread.currentThread().toString();
            }
            super.onCreate(surfaceHolder);
        }

        public void onDestroy() {
            super.onDestroy();
        }

        public void onOffsetsChanged(float f2, float f3, float f4, float f5, int i, int i2) {
            this.offsetsConsumed = false;
            this.xOffset = f2;
            this.yOffset = f3;
            this.xOffsetStep = f4;
            this.yOffsetStep = f5;
            this.xPixelOffset = i;
            this.yPixelOffset = i2;
            notifyOffsetsChanged();
            Graphics graphics = k.graphics;
            if (!((AndroidGraphics) graphics).isContinuous) {
                ((AndroidGraphics) graphics).requestRendering();
            }
            super.onOffsetsChanged(f2, f3, f4, f5, i, i2);
        }

        public void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (AndroidLiveWallpaperService.DEBUG) {
                isPreview();
                hashCode();
                AndroidLiveWallpaperService androidLiveWallpaperService = AndroidLiveWallpaperService.this;
                int i4 = androidLiveWallpaperService.engines;
                AndroidWallpaperEngine androidWallpaperEngine = androidLiveWallpaperService.linkedEngine;
                getSurfaceHolder().getSurface().isValid();
            }
            super.onSurfaceChanged(surfaceHolder, i, i2, i3);
            notifySurfaceChanged(i, i2, i3, true);
        }

        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
            AndroidLiveWallpaperService androidLiveWallpaperService = AndroidLiveWallpaperService.this;
            androidLiveWallpaperService.engines++;
            androidLiveWallpaperService.setLinkedEngine(this);
            if (AndroidLiveWallpaperService.DEBUG) {
                hashCode();
                AndroidLiveWallpaperService androidLiveWallpaperService2 = AndroidLiveWallpaperService.this;
                int i = androidLiveWallpaperService2.engines;
                AndroidWallpaperEngine androidWallpaperEngine = androidLiveWallpaperService2.linkedEngine;
            }
            super.onSurfaceCreated(surfaceHolder);
            AndroidLiveWallpaperService androidLiveWallpaperService3 = AndroidLiveWallpaperService.this;
            if (androidLiveWallpaperService3.engines == 1) {
                androidLiveWallpaperService3.visibleEngines = 0;
            }
            AndroidLiveWallpaperService androidLiveWallpaperService4 = AndroidLiveWallpaperService.this;
            if (androidLiveWallpaperService4.engines == 1 && androidLiveWallpaperService4.app == null) {
                AndroidLiveWallpaperService androidLiveWallpaperService5 = AndroidLiveWallpaperService.this;
                androidLiveWallpaperService5.viewFormat = 0;
                androidLiveWallpaperService5.viewWidth = 0;
                androidLiveWallpaperService5.viewHeight = 0;
                androidLiveWallpaperService5.app = new AndroidLiveWallpaper(AndroidLiveWallpaperService.this);
                AndroidLiveWallpaperService.this.onCreateApplication();
                AndroidLiveWallpaper androidLiveWallpaper = AndroidLiveWallpaperService.this.app;
                throw new Error("You must override 'AndroidLiveWallpaperService.onCreateApplication' method and call 'initialize' from its body.");
            }
            AndroidLiveWallpaper androidLiveWallpaper2 = AndroidLiveWallpaperService.this.app;
            throw null;
        }

        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            AndroidLiveWallpaperService androidLiveWallpaperService = AndroidLiveWallpaperService.this;
            androidLiveWallpaperService.engines--;
            if (AndroidLiveWallpaperService.DEBUG) {
                hashCode();
                AndroidLiveWallpaperService androidLiveWallpaperService2 = AndroidLiveWallpaperService.this;
                int i = androidLiveWallpaperService2.engines;
                AndroidWallpaperEngine androidWallpaperEngine = androidLiveWallpaperService2.linkedEngine;
            }
            AndroidLiveWallpaperService androidLiveWallpaperService3 = AndroidLiveWallpaperService.this;
            if (androidLiveWallpaperService3.engines == 0) {
                androidLiveWallpaperService3.onDeepPauseApplication();
            }
            if (AndroidLiveWallpaperService.this.linkedEngine == this) {
                Callback callback = AndroidLiveWallpaperService.this.view;
                if (callback != null) {
                    callback.surfaceDestroyed(surfaceHolder);
                }
            }
            this.engineFormat = 0;
            this.engineWidth = 0;
            this.engineHeight = 0;
            AndroidLiveWallpaperService androidLiveWallpaperService4 = AndroidLiveWallpaperService.this;
            if (androidLiveWallpaperService4.engines == 0) {
                androidLiveWallpaperService4.linkedEngine = null;
            }
            super.onSurfaceDestroyed(surfaceHolder);
        }

        public void onTouchEvent(MotionEvent motionEvent) {
            if (AndroidLiveWallpaperService.this.linkedEngine == this) {
                AndroidLiveWallpaperService.this.app.input.onTouch(null, motionEvent);
            }
        }

        public void onVisibilityChanged(boolean z) {
            boolean isVisible = isVisible();
            if (AndroidLiveWallpaperService.DEBUG) {
                hashCode();
                getSurfaceHolder().getSurface().isValid();
            }
            super.onVisibilityChanged(z);
            if (isVisible || !z) {
                if (this.engineIsVisible != z) {
                    this.engineIsVisible = z;
                    if (z) {
                        AndroidLiveWallpaperService.this.visibleEngines++;
                        if (AndroidLiveWallpaperService.DEBUG) {
                            hashCode();
                            AndroidLiveWallpaperService androidLiveWallpaperService = AndroidLiveWallpaperService.this;
                            int i = androidLiveWallpaperService.engines;
                            int i2 = androidLiveWallpaperService.visibleEngines;
                        }
                        if (AndroidLiveWallpaperService.this.linkedEngine != null) {
                            if (AndroidLiveWallpaperService.this.linkedEngine != this) {
                                AndroidLiveWallpaperService.this.setLinkedEngine(this);
                                AndroidLiveWallpaperService.this.view.surfaceDestroyed(getSurfaceHolder());
                                notifySurfaceChanged(this.engineFormat, this.engineWidth, this.engineHeight, false);
                                AndroidLiveWallpaperService.this.view.surfaceCreated(getSurfaceHolder());
                            } else {
                                notifySurfaceChanged(this.engineFormat, this.engineWidth, this.engineHeight, false);
                            }
                            AndroidLiveWallpaperService androidLiveWallpaperService2 = AndroidLiveWallpaperService.this;
                            if (androidLiveWallpaperService2.visibleEngines == 1) {
                                AndroidLiveWallpaper androidLiveWallpaper = androidLiveWallpaperService2.app;
                                if (androidLiveWallpaper != null) {
                                    k.app = androidLiveWallpaper;
                                    k.input = null;
                                    k.audio = null;
                                    k.files = null;
                                    k.graphics = null;
                                    k.f3111net = null;
                                    throw null;
                                }
                                throw null;
                            }
                            notifyPreviewState();
                            notifyOffsetsChanged();
                            AndroidGraphics androidGraphics = (AndroidGraphics) k.graphics;
                            if (!androidGraphics.isContinuous) {
                                androidGraphics.requestRendering();
                            }
                        }
                    } else {
                        AndroidLiveWallpaperService androidLiveWallpaperService3 = AndroidLiveWallpaperService.this;
                        androidLiveWallpaperService3.visibleEngines--;
                        if (AndroidLiveWallpaperService.DEBUG) {
                            hashCode();
                            AndroidLiveWallpaperService androidLiveWallpaperService4 = AndroidLiveWallpaperService.this;
                            int i3 = androidLiveWallpaperService4.engines;
                            int i4 = androidLiveWallpaperService4.visibleEngines;
                        }
                        AndroidLiveWallpaperService androidLiveWallpaperService5 = AndroidLiveWallpaperService.this;
                        if (androidLiveWallpaperService5.visibleEngines >= androidLiveWallpaperService5.engines) {
                            androidLiveWallpaperService5.visibleEngines = Math.max(r3 - 1, 0);
                        }
                        if (AndroidLiveWallpaperService.this.linkedEngine != null) {
                            AndroidLiveWallpaperService androidLiveWallpaperService6 = AndroidLiveWallpaperService.this;
                            if (androidLiveWallpaperService6.visibleEngines == 0) {
                                if (androidLiveWallpaperService6.app != null) {
                                    boolean z2 = AndroidLiveWallpaperService.DEBUG;
                                    throw null;
                                }
                                throw null;
                            }
                        }
                        boolean z3 = AndroidLiveWallpaperService.DEBUG;
                    }
                } else {
                    boolean z4 = AndroidLiveWallpaperService.DEBUG;
                }
                return;
            }
            boolean z5 = AndroidLiveWallpaperService.DEBUG;
        }
    }

    static {
        GdxNativesLoader.load();
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public WindowManager getWindowManager() {
        return (WindowManager) getSystemService("window");
    }

    public void onCreate() {
        if (DEBUG) {
            hashCode();
        }
        super.onCreate();
    }

    public void onCreateApplication() {
        boolean z = DEBUG;
    }

    public Engine onCreateEngine() {
        boolean z = DEBUG;
        return new AndroidWallpaperEngine();
    }

    public void onDeepPauseApplication() {
        boolean z = DEBUG;
        if (this.app != null) {
            throw null;
        }
    }

    public void onDestroy() {
        if (DEBUG) {
            hashCode();
        }
        super.onDestroy();
        if (this.app == null) {
            return;
        }
        if (this.app != null) {
            this.app = null;
            this.view = null;
            return;
        }
        throw null;
    }

    public void setLinkedEngine(AndroidWallpaperEngine androidWallpaperEngine) {
        synchronized (this.sync) {
            this.linkedEngine = androidWallpaperEngine;
        }
    }
}
