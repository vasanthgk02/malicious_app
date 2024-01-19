package com.badlogic.gdx.backends.android;

import a.a.c.c;
import a.a.c.d;
import a.a.f.a;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.AbstractGraphics;
import com.badlogic.gdx.Graphics.BufferFormat;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.cfg.mendikot.app.SDKEvent;
import com.cfg.mendikot.b;
import com.cfg.mendikot.b.C0036b;
import com.cfg.mendikot.game.AndroidLauncher;
import com.squareup.picasso.Utils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class AndroidGraphics extends AbstractGraphics implements Renderer {
    public static volatile boolean enforceContinuousRendering;
    public AndroidApplicationBase app;
    public BufferFormat bufferFormat;
    public final AndroidApplicationConfiguration config;
    public volatile boolean created;
    public float deltaTime = 0.0f;
    public volatile boolean destroy;
    public String extensions;
    public int fps;
    public long frameId = -1;
    public long frameStart = System.nanoTime();
    public int frames;
    public GL20 gl20;
    public GL30 gl30;
    public GLVersion glVersion;
    public int height;
    public boolean isContinuous;
    public long lastFrameTime = System.nanoTime();
    public volatile boolean pause;
    public volatile boolean resume;
    public volatile boolean running;
    public Object synch;
    public int[] value;
    public final GLSurfaceView20 view;
    public int width;

    public AndroidGraphics(AndroidApplicationBase androidApplicationBase, AndroidApplicationConfiguration androidApplicationConfiguration, ResolutionStrategy resolutionStrategy) {
        AndroidApplicationBase androidApplicationBase2 = androidApplicationBase;
        boolean z = false;
        this.frames = 0;
        this.created = false;
        this.running = false;
        this.pause = false;
        this.resume = false;
        this.destroy = false;
        BufferFormat bufferFormat2 = new BufferFormat(8, 8, 8, 0, 16, 0, 0, false);
        this.bufferFormat = bufferFormat2;
        this.isContinuous = true;
        this.value = new int[1];
        this.synch = new Object();
        this.config = androidApplicationConfiguration;
        this.app = androidApplicationBase2;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        int i = 2;
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, new EGLConfig[10], 10, iArr);
        egl10.eglTerminate(eglGetDisplay);
        if (iArr[0] > 0 ? true : z) {
            AndroidApplicationConfiguration androidApplicationConfiguration2 = this.config;
            GdxEglConfigChooser gdxEglConfigChooser = new GdxEglConfigChooser(androidApplicationConfiguration2.r, androidApplicationConfiguration2.g, androidApplicationConfiguration2.f3305b, androidApplicationConfiguration2.f3304a, androidApplicationConfiguration2.depth, androidApplicationConfiguration2.stencil, androidApplicationConfiguration2.numSamples);
            GLSurfaceView20 gLSurfaceView20 = new GLSurfaceView20((AndroidApplication) androidApplicationBase2, resolutionStrategy, this.config.useGL30 ? 3 : i);
            gLSurfaceView20.setEGLConfigChooser(gdxEglConfigChooser);
            gLSurfaceView20.setRenderer(this);
            this.view = gLSurfaceView20;
            gLSurfaceView20.setPreserveEGLContextOnPause(true);
            this.view.setFocusable(true);
            this.view.setFocusableInTouchMode(true);
            return;
        }
        throw new GdxRuntimeException((String) "Libgdx requires OpenGL ES 2.0");
    }

    public void clearManagedCaches() {
        Mesh.clearAllMeshes(this.app);
        Texture.clearAllTextures(this.app);
        Cubemap.clearAllCubemaps(this.app);
        TextureArray.clearAllTextureArrays(this.app);
        ShaderProgram.clearAllShaderPrograms(this.app);
        GLFrameBuffer.clearAllFrameBuffers(this.app);
        logManagedCachesStatus();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0009, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void destroy() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.synch
            monitor-enter(r0)
            r1 = 0
            r4.running = r1     // Catch:{ all -> 0x001f }
            r1 = 1
            r4.destroy = r1     // Catch:{ all -> 0x001f }
        L_0x0009:
            boolean r1 = r4.destroy     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r4.synch     // Catch:{ InterruptedException -> 0x0013 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0013 }
            goto L_0x0009
        L_0x0013:
            com.badlogic.gdx.Application r1 = co.hyperverge.hypersnapsdk.c.k.app     // Catch:{ all -> 0x001f }
            java.lang.String r2 = "AndroidGraphics"
            java.lang.String r3 = "waiting for destroy synchronization failed!"
            r1.log(r2, r3)     // Catch:{ all -> 0x001f }
            goto L_0x0009
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidGraphics.destroy():void");
    }

    public final int getAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.value) ? this.value[0] : i2;
    }

    public void logManagedCachesStatus() {
        k.app.log("AndroidGraphics", Mesh.getManagedStatus());
        k.app.log("AndroidGraphics", Texture.getManagedStatus());
        k.app.log("AndroidGraphics", Cubemap.getManagedStatus());
        k.app.log("AndroidGraphics", ShaderProgram.getManagedStatus());
        k.app.log("AndroidGraphics", GLFrameBuffer.getManagedStatus());
    }

    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long nanoTime = System.nanoTime();
        if (!this.resume) {
            this.deltaTime = ((float) (nanoTime - this.lastFrameTime)) / 1.0E9f;
        } else {
            this.deltaTime = 0.0f;
        }
        this.lastFrameTime = nanoTime;
        synchronized (this.synch) {
            z = this.running;
            z2 = this.pause;
            z3 = this.destroy;
            z4 = this.resume;
            if (this.resume) {
                this.resume = false;
            }
            if (this.pause) {
                this.pause = false;
                this.synch.notifyAll();
            }
            if (this.destroy) {
                this.destroy = false;
                this.synch.notifyAll();
            }
        }
        if (z4) {
            SnapshotArray<LifecycleListener> lifecycleListeners = this.app.getLifecycleListeners();
            synchronized (lifecycleListeners) {
                LifecycleListener[] lifecycleListenerArr = (LifecycleListener[]) lifecycleListeners.begin();
                int i = lifecycleListeners.size;
                for (int i2 = 0; i2 < i; i2++) {
                    lifecycleListenerArr[i2].resume();
                }
                lifecycleListeners.end();
            }
            b bVar = (b) this.app.getApplicationListener();
            if (bVar != null) {
                a aVar = a.RUN;
                b.s = aVar;
                try {
                    if (a.a.a.a.d.b.f7b != null) {
                        aVar.toString();
                        a.a.a.a.d.b.f7b.onNext(aVar);
                        k.app.log("AndroidGraphics", Utils.VERB_RESUMED);
                    } else {
                        throw new Exception("b is not initialized!!");
                    }
                } catch (Exception e2) {
                    b.s = a.RUN;
                    e2.printStackTrace();
                    a.a.l.b bVar2 = bVar.p;
                    if (bVar2 != null) {
                        ((AndroidLauncher) bVar2).a();
                    }
                }
            } else {
                throw null;
            }
        }
        if (z) {
            synchronized (this.app.getRunnables()) {
                this.app.getExecutedRunnables().clear();
                this.app.getExecutedRunnables().addAll(this.app.getRunnables());
                this.app.getRunnables().clear();
            }
            for (int i3 = 0; i3 < this.app.getExecutedRunnables().size; i3++) {
                try {
                    ((Runnable) this.app.getExecutedRunnables().get(i3)).run();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ((DefaultAndroidInput) this.app.getInput()).processEvents();
            this.frameId++;
            this.app.getApplicationListener().render();
        }
        if (z2) {
            SnapshotArray<LifecycleListener> lifecycleListeners2 = this.app.getLifecycleListeners();
            synchronized (lifecycleListeners2) {
                LifecycleListener[] lifecycleListenerArr2 = (LifecycleListener[]) lifecycleListeners2.begin();
                int i4 = lifecycleListeners2.size;
                for (int i5 = 0; i5 < i4; i5++) {
                    lifecycleListenerArr2[i5].pause();
                }
            }
            b bVar3 = (b) this.app.getApplicationListener();
            if (bVar3 != null) {
                a aVar2 = a.PAUSE;
                b.s = aVar2;
                try {
                    if (a.a.a.a.d.b.f7b != null) {
                        aVar2.toString();
                        a.a.a.a.d.b.f7b.onNext(aVar2);
                        k.app.log("AndroidGraphics", "paused");
                    } else {
                        throw new Exception("b is not initialized!!");
                    }
                } catch (Exception e3) {
                    b.s = a.PAUSE;
                    a.a.l.b bVar4 = bVar3.p;
                    if (bVar4 != null) {
                        ((AndroidLauncher) bVar4).f();
                    }
                    e3.printStackTrace();
                }
            } else {
                throw null;
            }
        }
        if (z3) {
            SnapshotArray<LifecycleListener> lifecycleListeners3 = this.app.getLifecycleListeners();
            synchronized (lifecycleListeners3) {
                LifecycleListener[] lifecycleListenerArr3 = (LifecycleListener[]) lifecycleListeners3.begin();
                int i6 = lifecycleListeners3.size;
                for (int i7 = 0; i7 < i6; i7++) {
                    lifecycleListenerArr3[i7].dispose();
                }
            }
            b bVar5 = (b) this.app.getApplicationListener();
            if (bVar5 != null) {
                b.s = a.STOPPED;
                bVar5.f2343a.dispose();
                d<String, Texture> dVar = a.a.a.a.d.b.f2412b;
                if (dVar != null) {
                    try {
                        dVar.f2454b.clear();
                        dVar.f2453a.clear();
                    } catch (Exception unused) {
                    }
                    a.a.c.b<String, BitmapFont> bVar6 = a.a.a.a.d.b.f2414d;
                    if (bVar6 != null) {
                        try {
                            bVar6.f2442b.clear();
                            bVar6.f2441a.clear();
                        } catch (Exception unused2) {
                        }
                        c<String, Sound> cVar = a.a.a.a.d.b.f2413c;
                        if (cVar != null) {
                            try {
                                cVar.f2448b.clear();
                                cVar.f2447a.clear();
                            } catch (Exception unused3) {
                            }
                            a.a.l.b bVar7 = bVar5.p;
                            if (bVar7 != null) {
                                ((AndroidLauncher) bVar7).b();
                            }
                            k.app.log("AndroidGraphics", "destroyed");
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }
        if (nanoTime - this.frameStart > 1000000000) {
            this.fps = this.frames;
            this.frames = 0;
            this.frameStart = nanoTime;
        }
        this.frames++;
    }

    public void onPauseGLSurfaceView() {
        GLSurfaceView20 gLSurfaceView20 = this.view;
        if (gLSurfaceView20 != null) {
            gLSurfaceView20.onPause();
        }
    }

    public void onResumeGLSurfaceView() {
        GLSurfaceView20 gLSurfaceView20 = this.view;
        if (gLSurfaceView20 != null) {
            gLSurfaceView20.onResume();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.width = i3;
        this.height = i4;
        this.app.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        updateSafeAreaInsets();
        gl10.glViewport(0, 0, this.width, this.height);
        if (!this.created) {
            b bVar = (b) this.app.getApplicationListener();
            if (bVar != null) {
                try {
                    a.a.a.a.d.b.a(bVar.q);
                    if (bVar.p != null) {
                        AndroidLauncher androidLauncher = (AndroidLauncher) bVar.p;
                        if (androidLauncher != null) {
                            try {
                                if (androidLauncher.f2366c.getSDKListener() != null) {
                                    androidLauncher.f2366c.getSDKListener().onEvent(SDKEvent.ASSETS_LOADED, null);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            throw null;
                        }
                    }
                    a.a.a.a.d.b.a(bVar.f2345c, (a.a.f.c) bVar);
                    a.a.a.a.d.b.a(bVar.f2345c, (a.a.h.a) bVar);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                com.cfg.mendikot.a.f2235a = (float) ((AndroidGraphics) k.graphics).width;
                com.cfg.mendikot.a.f2236b = (float) ((AndroidGraphics) k.graphics).height;
                ScalingViewport scalingViewport = new ScalingViewport(Scaling.fit, 2160.0f, 1080.0f);
                bVar.f2344b = scalingViewport;
                bVar.f2343a = new Stage(scalingViewport);
                Image image = new Image(a.a.a.a.d.b.f2412b.a("table_bar"));
                bVar.f2348f = image;
                image.setSize(2200.0f, 110.0f);
                Image image2 = bVar.f2348f;
                float f2 = com.cfg.mendikot.a.f2238d;
                image2.setPosition(-20.0f, 980.0f);
                Table table = new Table();
                table.fillParent = true;
                bVar.f2347e = new Skin();
                Texture a2 = a.a.a.a.d.b.f2412b.a("mtt_selected");
                TextureFilter textureFilter = TextureFilter.Linear;
                a2.setFilter(textureFilter, textureFilter);
                bVar.f2347e.add("mtt_selected", a2);
                Texture a3 = a.a.a.a.d.b.f2412b.a("mtt_unselected");
                TextureFilter textureFilter2 = TextureFilter.Linear;
                a3.setFilter(textureFilter2, textureFilter2);
                bVar.f2347e.add("mtt_unselected", a3);
                bVar.f2347e.add("default-font", a.a.a.a.d.b.f2414d.a("Rajdhani-Bold"));
                bVar.f2347e.add("mtt_blink", a.a.a.a.d.b.f2412b.a("mtt_blink"));
                bVar.f2347e.add("mtt_add", a.a.a.a.d.b.f2412b.a("mtt_add_table"));
                HorizontalGroup horizontalGroup = new HorizontalGroup();
                bVar.g = horizontalGroup;
                horizontalGroup.align = 10;
                horizontalGroup.fill = 1.0f;
                horizontalGroup.setHeight(120.0f);
                HorizontalGroup horizontalGroup2 = bVar.g;
                horizontalGroup2.space = 20.0f;
                ScrollPane scrollPane = new ScrollPane(horizontalGroup2);
                bVar.h = scrollPane;
                float f3 = com.cfg.mendikot.a.f2237c;
                float f4 = com.cfg.mendikot.a.f2238d;
                scrollPane.setPosition(15.0f, 955.0f);
                ScrollPane scrollPane2 = bVar.h;
                float f5 = com.cfg.mendikot.a.f2239e;
                float f6 = com.cfg.mendikot.a.f2240f;
                scrollPane2.setSize(1895.0f, 120.0f);
                ScrollPane scrollPane3 = bVar.h;
                scrollPane3.disableX = false;
                scrollPane3.disableY = true;
                scrollPane3.needsLayout = true;
                ButtonGroup buttonGroup = new ButtonGroup();
                bVar.j = buttonGroup;
                buttonGroup.maxCheckCount = 1;
                Stack stack = new Stack();
                bVar.f2346d = stack;
                Cell add = table.add(stack);
                Integer num = Cell.onei;
                add.expandX = num;
                add.expandY = num;
                Float f7 = Cell.onef;
                add.fillX = f7;
                add.fillY = f7;
                b.a aVar = r6;
                String str = "mtt_add";
                b.a aVar2 = new b.a(40.0f, 0.4f, 1.1f, 0.3f);
                bVar.f2346d.addListener(aVar);
                bVar.i = new C0036b();
                TextButtonStyle textButtonStyle = new TextButtonStyle();
                textButtonStyle.checked = bVar.f2347e.getDrawable(str);
                textButtonStyle.checkedOver = bVar.f2347e.getDrawable(str);
                textButtonStyle.down = bVar.f2347e.getDrawable(str);
                textButtonStyle.up = bVar.f2347e.getDrawable(str);
                textButtonStyle.checkedFontColor = Color.WHITE;
                textButtonStyle.checkedOverFontColor = Color.valueOf("#808080");
                textButtonStyle.font = bVar.f2347e.getFont("default-font");
                TextButton textButton = new TextButton("", textButtonStyle);
                textButton.setChecked(true, textButton.programmaticChangeEvents);
                float f8 = com.cfg.mendikot.a.g;
                float f9 = com.cfg.mendikot.a.f2240f;
                textButton.setSize(160.0f, 110.0f);
                textButton.touchable = Touchable.enabled;
                textButton.addListener(new b.c());
                textButton.name = "add_table_1312810534325429";
                bVar.g.addActor(textButton);
                bVar.f2343a.root.addActor(table);
                Input input = k.input;
                Stage stage = bVar.f2343a;
                DefaultAndroidInput defaultAndroidInput = (DefaultAndroidInput) input;
                synchronized (defaultAndroidInput) {
                    defaultAndroidInput.processor = stage;
                }
                b.s = a.RUN;
                a.a.l.b bVar2 = bVar.p;
                if (bVar2 != null) {
                    AndroidLauncher androidLauncher2 = (AndroidLauncher) bVar2;
                    try {
                        androidLauncher2.g();
                        if (androidLauncher2.f2366c.getSDKListener() != null) {
                            androidLauncher2.f2366c.getSDKListener().onEvent(SDKEvent.GAME_CREATED, null);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                this.created = true;
                synchronized (this) {
                    this.running = true;
                }
            } else {
                throw null;
            }
        }
        ((b) this.app.getApplicationListener()).f2343a.viewport.update(i3, i4, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 r23, javax.microedition.khronos.egl.EGLConfig r24) {
        /*
            r22 = this;
            r6 = r22
            r7 = r23
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r0.eglGetCurrentContext()
            r0 = 7938(0x1f02, float:1.1124E-41)
            java.lang.String r1 = r7.glGetString(r0)
            r2 = 7936(0x1f00, float:1.1121E-41)
            java.lang.String r3 = r7.glGetString(r2)
            r4 = 7937(0x1f01, float:1.1122E-41)
            java.lang.String r5 = r7.glGetString(r4)
            com.badlogic.gdx.graphics.glutils.GLVersion r8 = new com.badlogic.gdx.graphics.glutils.GLVersion
            com.badlogic.gdx.Application$ApplicationType r9 = com.badlogic.gdx.Application.ApplicationType.Android
            r8.<init>(r9, r1, r3, r5)
            r6.glVersion = r8
            com.badlogic.gdx.backends.android.AndroidApplicationConfiguration r1 = r6.config
            boolean r1 = r1.useGL30
            java.lang.String r9 = "AndroidGraphics"
            if (r1 == 0) goto L_0x004d
            int r1 = r8.getMajorVersion()
            r3 = 2
            if (r1 <= r3) goto L_0x004d
            com.badlogic.gdx.graphics.GL30 r1 = r6.gl30
            if (r1 == 0) goto L_0x003d
            goto L_0x00b7
        L_0x003d:
            com.badlogic.gdx.backends.android.AndroidGL30 r1 = new com.badlogic.gdx.backends.android.AndroidGL30
            r1.<init>()
            r6.gl30 = r1
            r6.gl20 = r1
            co.hyperverge.hypersnapsdk.c.k.gl = r1
            co.hyperverge.hypersnapsdk.c.k.gl20 = r1
            co.hyperverge.hypersnapsdk.c.k.gl30 = r1
            goto L_0x005d
        L_0x004d:
            com.badlogic.gdx.graphics.GL20 r1 = r6.gl20
            if (r1 == 0) goto L_0x0052
            goto L_0x00b7
        L_0x0052:
            com.badlogic.gdx.backends.android.AndroidGL20 r1 = new com.badlogic.gdx.backends.android.AndroidGL20
            r1.<init>()
            r6.gl20 = r1
            co.hyperverge.hypersnapsdk.c.k.gl = r1
            co.hyperverge.hypersnapsdk.c.k.gl20 = r1
        L_0x005d:
            com.badlogic.gdx.Application r1 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.String r3 = "OGL renderer: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r4 = r7.glGetString(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.log(r9, r3)
            com.badlogic.gdx.Application r1 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.String r3 = "OGL vendor: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r2 = r7.glGetString(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.log(r9, r2)
            com.badlogic.gdx.Application r1 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.String r2 = "OGL version: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r0 = r7.glGetString(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.log(r9, r0)
            com.badlogic.gdx.Application r0 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.String r1 = "OGL extensions: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            r2 = 7939(0x1f03, float:1.1125E-41)
            java.lang.String r2 = r7.glGetString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.log(r9, r1)
        L_0x00b7:
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            r8 = r0
            javax.microedition.khronos.egl.EGL10 r8 = (javax.microedition.khronos.egl.EGL10) r8
            java.lang.Object r0 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r10 = r8.eglGetDisplay(r0)
            r4 = 12324(0x3024, float:1.727E-41)
            r11 = 0
            r12 = 0
            r0 = r22
            r1 = r8
            r2 = r10
            r3 = r24
            r5 = r12
            int r14 = r0.getAttrib(r1, r2, r3, r4, r5)
            r4 = 12323(0x3023, float:1.7268E-41)
            int r15 = r0.getAttrib(r1, r2, r3, r4, r5)
            r4 = 12322(0x3022, float:1.7267E-41)
            int r13 = r0.getAttrib(r1, r2, r3, r4, r5)
            r4 = 12321(0x3021, float:1.7265E-41)
            int r12 = r0.getAttrib(r1, r2, r3, r4, r5)
            r4 = 12325(0x3025, float:1.7271E-41)
            r5 = r11
            int r11 = r0.getAttrib(r1, r2, r3, r4, r5)
            r4 = 12326(0x3026, float:1.7272E-41)
            r16 = 0
            r5 = 0
            int r5 = r0.getAttrib(r1, r2, r3, r4, r5)
            r4 = 12337(0x3031, float:1.7288E-41)
            r7 = r5
            r5 = r16
            int r5 = r0.getAttrib(r1, r2, r3, r4, r5)
            r16 = 12513(0x30e1, float:1.7534E-41)
            r4 = 12513(0x30e1, float:1.7534E-41)
            r17 = 0
            r6 = r5
            r5 = r17
            int r0 = r0.getAttrib(r1, r2, r3, r4, r5)
            int r6 = java.lang.Math.max(r6, r0)
            r5 = 0
            r0 = r22
            r4 = r16
            int r0 = r0.getAttrib(r1, r2, r3, r4, r5)
            r1 = 0
            if (r0 == 0) goto L_0x011d
            r0 = 1
            goto L_0x011e
        L_0x011d:
            r0 = 0
        L_0x011e:
            com.badlogic.gdx.Application r2 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.String r3 = "framebuffer: ("
            java.lang.String r4 = ", "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline75(r3, r14, r4, r15, r4)
            r3.append(r13)
            r3.append(r4)
            r3.append(r12)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r9, r3)
            com.badlogic.gdx.Application r2 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "depthbuffer: ("
            r3.append(r5)
            r3.append(r11)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r9, r3)
            com.badlogic.gdx.Application r2 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "stencilbuffer: ("
            r3.append(r5)
            r3.append(r7)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r9, r3)
            com.badlogic.gdx.Application r2 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "samples: ("
            r3.append(r5)
            r3.append(r6)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r9, r3)
            com.badlogic.gdx.Application r2 = co.hyperverge.hypersnapsdk.c.k.app
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "coverage sampling: ("
            r3.append(r5)
            r3.append(r0)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.log(r9, r3)
            com.badlogic.gdx.Graphics$BufferFormat r2 = new com.badlogic.gdx.Graphics$BufferFormat
            r3 = r13
            r13 = r2
            r16 = r3
            r17 = r12
            r18 = r11
            r19 = r7
            r20 = r6
            r21 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = r22
            r0.bufferFormat = r2
            android.util.DisplayMetrics r2 = new android.util.DisplayMetrics
            r2.<init>()
            com.badlogic.gdx.backends.android.AndroidApplicationBase r3 = r0.app
            android.view.WindowManager r3 = r3.getWindowManager()
            android.view.Display r3 = r3.getDefaultDisplay()
            r3.getMetrics(r2)
            r22.updateSafeAreaInsets()
            com.badlogic.gdx.backends.android.AndroidApplicationBase r2 = r0.app
            com.badlogic.gdx.graphics.Mesh.invalidateAllMeshes(r2)
            com.badlogic.gdx.backends.android.AndroidApplicationBase r2 = r0.app
            com.badlogic.gdx.graphics.Texture.invalidateAllTextures(r2)
            com.badlogic.gdx.backends.android.AndroidApplicationBase r2 = r0.app
            com.badlogic.gdx.graphics.Cubemap.invalidateAllCubemaps(r2)
            com.badlogic.gdx.backends.android.AndroidApplicationBase r2 = r0.app
            com.badlogic.gdx.graphics.TextureArray.invalidateAllTextureArrays(r2)
            com.badlogic.gdx.backends.android.AndroidApplicationBase r2 = r0.app
            com.badlogic.gdx.graphics.glutils.ShaderProgram.invalidateAllShaderPrograms(r2)
            com.badlogic.gdx.backends.android.AndroidApplicationBase r2 = r0.app
            com.badlogic.gdx.graphics.glutils.GLFrameBuffer.invalidateAllFrameBuffers(r2)
            r22.logManagedCachesStatus()
            com.badlogic.gdx.backends.android.AndroidApplicationBase r2 = r0.app
            android.view.WindowManager r2 = r2.getWindowManager()
            android.view.Display r2 = r2.getDefaultDisplay()
            int r3 = r2.getWidth()
            r0.width = r3
            int r2 = r2.getHeight()
            r0.height = r2
            long r2 = java.lang.System.nanoTime()
            r0.lastFrameTime = r2
            int r2 = r0.width
            int r3 = r0.height
            r4 = r23
            r4.glViewport(r1, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidGraphics.onSurfaceCreated(javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        co.hyperverge.hypersnapsdk.c.k.app.log("AndroidGraphics", "waiting for pause synchronization failed!");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pause() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.synch
            monitor-enter(r0)
            boolean r1 = r4.running     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0009:
            r1 = 0
            r4.running = r1     // Catch:{ all -> 0x0045 }
            r1 = 1
            r4.pause = r1     // Catch:{ all -> 0x0045 }
            com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20 r1 = r4.view     // Catch:{ all -> 0x0045 }
            com.badlogic.gdx.backends.android.AndroidGraphics$1 r2 = new com.badlogic.gdx.backends.android.AndroidGraphics$1     // Catch:{ all -> 0x0045 }
            r2.<init>()     // Catch:{ all -> 0x0045 }
            r1.queueEvent(r2)     // Catch:{ all -> 0x0045 }
        L_0x0019:
            boolean r1 = r4.pause     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0043
            java.lang.Object r1 = r4.synch     // Catch:{ InterruptedException -> 0x0039 }
            r2 = 4000(0xfa0, double:1.9763E-320)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x0039 }
            boolean r1 = r4.pause     // Catch:{ InterruptedException -> 0x0039 }
            if (r1 == 0) goto L_0x0019
            com.badlogic.gdx.Application r1 = co.hyperverge.hypersnapsdk.c.k.app     // Catch:{ InterruptedException -> 0x0039 }
            java.lang.String r2 = "AndroidGraphics"
            java.lang.String r3 = "waiting for pause synchronization took too long; assuming deadlock and killing"
            r1.error(r2, r3)     // Catch:{ InterruptedException -> 0x0039 }
            int r1 = android.os.Process.myPid()     // Catch:{ InterruptedException -> 0x0039 }
            android.os.Process.killProcess(r1)     // Catch:{ InterruptedException -> 0x0039 }
            goto L_0x0019
        L_0x0039:
            com.badlogic.gdx.Application r1 = co.hyperverge.hypersnapsdk.c.k.app     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "AndroidGraphics"
            java.lang.String r3 = "waiting for pause synchronization failed!"
            r1.log(r2, r3)     // Catch:{ all -> 0x0045 }
            goto L_0x0019
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidGraphics.pause():void");
    }

    public void requestRendering() {
        GLSurfaceView20 gLSurfaceView20 = this.view;
        if (gLSurfaceView20 != null) {
            gLSurfaceView20.requestRender();
        }
    }

    public void resume() {
        synchronized (this.synch) {
            this.running = true;
            this.resume = true;
        }
    }

    public void setContinuousRendering(boolean z) {
        if (this.view != null) {
            boolean z2 = enforceContinuousRendering || z;
            this.isContinuous = z2;
            this.view.setRenderMode(z2 ? 1 : 0);
        }
    }

    public boolean supportsExtension(String str) {
        if (this.extensions == null) {
            this.extensions = k.gl.glGetString(GL20.GL_EXTENSIONS);
        }
        return this.extensions.contains(str);
    }

    public void updateSafeAreaInsets() {
        if (VERSION.SDK_INT >= 28) {
            try {
                DisplayCutout displayCutout = this.app.getApplicationWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
                if (displayCutout != null) {
                    displayCutout.getSafeInsetRight();
                    displayCutout.getSafeInsetBottom();
                    displayCutout.getSafeInsetTop();
                    displayCutout.getSafeInsetLeft();
                }
            } catch (UnsupportedOperationException unused) {
                k.app.log("AndroidGraphics", "Unable to get safe area insets");
            }
        }
    }
}
