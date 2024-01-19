package com.cfg.mendikot;

import a.a.l.i;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.backends.android.DefaultAndroidInput;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Table.Debug;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Value.Fixed;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.cfg.mendikot.app.SDKEvent;
import com.cfg.mendikot.game.AndroidLauncher;
import com.cfg.utilities.Handle;
import com.mpl.androidapp.game.androidgames.cardGame.CardGameFeature;
import io.reactivex.Scheduler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.fontbox.cmap.CMap;

public class b extends ApplicationAdapter implements a.a.f.c, a.a.h.a, a.a.l.d {
    public static a.a.f.a s = a.a.f.a.RUN;

    /* renamed from: a  reason: collision with root package name */
    public Stage f2343a;

    /* renamed from: b  reason: collision with root package name */
    public ScalingViewport f2344b;

    /* renamed from: c  reason: collision with root package name */
    public Scheduler f2345c;

    /* renamed from: d  reason: collision with root package name */
    public Stack f2346d;

    /* renamed from: e  reason: collision with root package name */
    public Skin f2347e;

    /* renamed from: f  reason: collision with root package name */
    public Image f2348f;
    public HorizontalGroup g;
    public ScrollPane h;
    public ChangeListener i;
    public ButtonGroup j;
    public ConcurrentHashMap<String, a.a.l.e> k;
    public ConcurrentHashMap<String, TextButton> l;
    public int m;
    public List<String> n = new ArrayList();
    public Action o;
    public a.a.l.b p;
    public Handle q;

    public class a extends ActorGestureListener {
        public a(float f2, float f3, float f4, float f5) {
            super(f2, f3, f4, f5);
        }

        public void fling(InputEvent inputEvent, float f2, float f3, int i) {
            if (Math.abs(f2) <= Math.abs(f3)) {
                return;
            }
            if (f2 > 0.0f) {
                b bVar = b.this;
                bVar.m = bVar.j.getCheckedIndex();
                b bVar2 = b.this;
                Array<T> array = bVar2.j.buttons;
                int i2 = bVar2.m;
                if (i2 > 0) {
                    String str = ((TextButton) array.get(i2 - 1)).name;
                    b.this.j.setChecked(str);
                    ConcurrentHashMap<String, TextButton> concurrentHashMap = b.this.l;
                    if (concurrentHashMap != null) {
                        TextButton textButton = concurrentHashMap.get(str);
                        if (textButton != null) {
                            textButton.setChecked(true, textButton.programmaticChangeEvents);
                        }
                    }
                    b bVar3 = b.this;
                    bVar3.m--;
                    return;
                }
                return;
            }
            b bVar4 = b.this;
            bVar4.m = bVar4.j.getCheckedIndex();
            b bVar5 = b.this;
            Array<T> array2 = bVar5.j.buttons;
            int i3 = bVar5.m;
            if (i3 >= 0 && i3 < array2.size - 1) {
                String str2 = ((TextButton) array2.get(i3 + 1)).name;
                b.this.j.setChecked(str2);
                ConcurrentHashMap<String, TextButton> concurrentHashMap2 = b.this.l;
                if (concurrentHashMap2 != null) {
                    TextButton textButton2 = concurrentHashMap2.get(str2);
                    if (textButton2 != null) {
                        textButton2.setChecked(true, textButton2.programmaticChangeEvents);
                    }
                }
                b.this.m++;
            }
        }

        public void pan(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
        }

        public void panStop(InputEvent inputEvent, float f2, float f3, int i, int i2) {
        }

        public void touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            a.a.l.b bVar = b.this.p;
            if (bVar != null) {
                AndroidLauncher androidLauncher = (AndroidLauncher) bVar;
                androidLauncher.runOnUiThread(new com.cfg.mendikot.game.AndroidLauncher.c());
            }
        }
    }

    /* renamed from: com.cfg.mendikot.b$b  reason: collision with other inner class name */
    public class C0036b extends ChangeListener {
        public C0036b() {
        }
    }

    public class c extends InputListener {
        public c() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            a.a.l.b bVar = b.this.p;
            if (bVar != null) {
                AndroidLauncher androidLauncher = (AndroidLauncher) bVar;
                if (androidLauncher != null) {
                    try {
                        if (androidLauncher.f2366c.getSDKListener() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString(CardGameFeature.KEY_GAME_ID, "add_table");
                            androidLauncher.f2366c.getSDKListener().onEvent(SDKEvent.GAME_LEAVE, bundle);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw null;
                }
            }
            return false;
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2352a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f2353b;

        public d(String str, i iVar) {
            this.f2352a = str;
            this.f2353b = iVar;
        }

        public void run() {
            try {
                if (b.this.k != null && b.this.k.get(this.f2352a) == null) {
                    new a.a.l.g(this.f2353b, b.this);
                    TextButtonStyle textButtonStyle = new TextButtonStyle();
                    textButtonStyle.checked = b.this.f2347e.getDrawable("mtt_selected");
                    textButtonStyle.checkedOver = b.this.f2347e.getDrawable("mtt_unselected");
                    textButtonStyle.down = b.this.f2347e.getDrawable("mtt_selected");
                    textButtonStyle.up = b.this.f2347e.getDrawable("mtt_unselected");
                    textButtonStyle.checkedFontColor = Color.WHITE;
                    textButtonStyle.checkedOverFontColor = Color.valueOf("#808080");
                    textButtonStyle.font = b.this.f2347e.getFont("default-font");
                    String str = this.f2353b.f2680c;
                    if (str != null && !str.trim().isEmpty() && str.length() > 10) {
                        str = str.substring(0, 10) + "..";
                    }
                    TextButton textButton = new TextButton(CMap.SPACE + str + CMap.SPACE, textButtonStyle);
                    textButton.setChecked(true, textButton.programmaticChangeEvents);
                    float f2 = a.g;
                    float f3 = a.f2240f;
                    textButton.setSize(160.0f, 110.0f);
                    textButton.padTop = Fixed.valueOf(20.0f);
                    textButton.padLeft = Fixed.valueOf(15.0f);
                    textButton.padBottom = Fixed.valueOf(20.0f);
                    textButton.padRight = Fixed.valueOf(15.0f);
                    textButton.sizeInvalid = true;
                    textButton.addListener(b.this.i);
                    textButton.name = this.f2352a;
                    b.this.g.addActor(textButton);
                    b.this.j.add(textButton);
                    b.this.l.put(this.f2352a, textButton);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextButton f2355a;

        public e(TextButton textButton) {
            this.f2355a = textButton;
        }

        public void run() {
            TextButtonStyle textButtonStyle = this.f2355a.style;
            textButtonStyle.up = b.this.f2347e.getDrawable("mtt_blink");
            textButtonStyle.checkedOver = b.this.f2347e.getDrawable("mtt_blink");
            this.f2355a.setStyle(textButtonStyle);
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextButton f2357a;

        public f(TextButton textButton) {
            this.f2357a = textButton;
        }

        public void run() {
            TextButtonStyle textButtonStyle = this.f2357a.style;
            textButtonStyle.up = b.this.f2347e.getDrawable("mtt_unselected");
            textButtonStyle.checkedOver = b.this.f2347e.getDrawable("mtt_unselected");
            this.f2357a.setStyle(textButtonStyle);
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2359a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                a.a.f.a[] r0 = a.a.f.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2359a = r0
                a.a.f.a r1 = a.a.f.a.RUN     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f2359a     // Catch:{ NoSuchFieldError -> 0x0016 }
                a.a.f.a r2 = a.a.f.a.PAUSE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f2359a     // Catch:{ NoSuchFieldError -> 0x001d }
                a.a.f.a r2 = a.a.f.a.STOPPED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.b.g.<clinit>():void");
        }
    }

    public b(Scheduler scheduler, a.a.l.b bVar, Handle handle) {
        this.p = bVar;
        this.f2345c = scheduler;
        this.q = handle;
        this.k = new ConcurrentHashMap<>();
        this.l = new ConcurrentHashMap<>();
    }

    public void a(String str) {
        try {
            a.a.h.b bVar = new a.a.h.b();
            bVar.f2519a = str;
            if (a.a.a.a.d.b.b1 != null) {
                bVar.toString();
                a.a.a.a.d.b.b1.onNext(bVar);
                return;
            }
            throw new Exception("c is not initialized!!");
        } catch (Exception e2) {
            e2.printStackTrace();
            a.a.l.b bVar2 = this.p;
            if (bVar2 != null) {
                try {
                    ((AndroidLauncher) bVar2).g.f2243a.get(str).a();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.Class<com.badlogic.gdx.scenes.scene2d.actions.DelayAction> r0 = com.badlogic.gdx.scenes.scene2d.actions.DelayAction.class
            monitor-enter(r6)
            java.util.List<java.lang.String> r1 = r6.n     // Catch:{ all -> 0x0058 }
            boolean r1 = r1.contains(r7)     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r6)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.badlogic.gdx.scenes.scene2d.ui.TextButton> r1 = r6.l     // Catch:{ all -> 0x0058 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.ui.TextButton r1 = (com.badlogic.gdx.scenes.scene2d.ui.TextButton) r1     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0056
            com.cfg.mendikot.b$e r2 = new com.cfg.mendikot.b$e     // Catch:{ all -> 0x0058 }
            r2.<init>(r1)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.actions.RunnableAction r2 = co.hyperverge.hypersnapsdk.c.k.run(r2)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.Action r3 = co.hyperverge.hypersnapsdk.c.k.action(r0)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.actions.DelayAction r3 = (com.badlogic.gdx.scenes.scene2d.actions.DelayAction) r3     // Catch:{ all -> 0x0058 }
            r4 = 1048576000(0x3e800000, float:0.25)
            r3.duration = r4     // Catch:{ all -> 0x0058 }
            com.cfg.mendikot.b$f r5 = new com.cfg.mendikot.b$f     // Catch:{ all -> 0x0058 }
            r5.<init>(r1)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.actions.RunnableAction r5 = co.hyperverge.hypersnapsdk.c.k.run(r5)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.Action r0 = co.hyperverge.hypersnapsdk.c.k.action(r0)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.actions.DelayAction r0 = (com.badlogic.gdx.scenes.scene2d.actions.DelayAction) r0     // Catch:{ all -> 0x0058 }
            r0.duration = r4     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.actions.SequenceAction r0 = co.hyperverge.hypersnapsdk.c.k.sequence(r2, r3, r5, r0)     // Catch:{ all -> 0x0058 }
            java.lang.Class<com.badlogic.gdx.scenes.scene2d.actions.RepeatAction> r2 = com.badlogic.gdx.scenes.scene2d.actions.RepeatAction.class
            com.badlogic.gdx.scenes.scene2d.Action r2 = co.hyperverge.hypersnapsdk.c.k.action(r2)     // Catch:{ all -> 0x0058 }
            com.badlogic.gdx.scenes.scene2d.actions.RepeatAction r2 = (com.badlogic.gdx.scenes.scene2d.actions.RepeatAction) r2     // Catch:{ all -> 0x0058 }
            r3 = -1
            r2.repeatCount = r3     // Catch:{ all -> 0x0058 }
            r2.action = r0     // Catch:{ all -> 0x0058 }
            r6.o = r2     // Catch:{ all -> 0x0058 }
            r1.addAction(r2)     // Catch:{ all -> 0x0058 }
            java.util.List<java.lang.String> r0 = r6.n     // Catch:{ all -> 0x0058 }
            r0.add(r7)     // Catch:{ all -> 0x0058 }
        L_0x0056:
            monitor-exit(r6)
            return
        L_0x0058:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.b.c(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List<java.lang.String> r0 = r4.n     // Catch:{ all -> 0x0038 }
            boolean r0 = r0.contains(r5)     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r4)
            return
        L_0x000b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.badlogic.gdx.scenes.scene2d.ui.TextButton> r0 = r4.l     // Catch:{ all -> 0x0038 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0038 }
            com.badlogic.gdx.scenes.scene2d.ui.TextButton r0 = (com.badlogic.gdx.scenes.scene2d.ui.TextButton) r0     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0036
            r0.clearActions()     // Catch:{ all -> 0x0038 }
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r1 = r0.style     // Catch:{ all -> 0x0038 }
            com.badlogic.gdx.scenes.scene2d.ui.Skin r2 = r4.f2347e     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "mtt_unselected"
            com.badlogic.gdx.scenes.scene2d.utils.Drawable r2 = r2.getDrawable(r3)     // Catch:{ all -> 0x0038 }
            r1.up = r2     // Catch:{ all -> 0x0038 }
            com.badlogic.gdx.scenes.scene2d.ui.Skin r2 = r4.f2347e     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "mtt_unselected"
            com.badlogic.gdx.scenes.scene2d.utils.Drawable r2 = r2.getDrawable(r3)     // Catch:{ all -> 0x0038 }
            r1.checkedOver = r2     // Catch:{ all -> 0x0038 }
            r0.setStyle(r1)     // Catch:{ all -> 0x0038 }
            java.util.List<java.lang.String> r0 = r4.n     // Catch:{ all -> 0x0038 }
            r0.remove(r5)     // Catch:{ all -> 0x0038 }
        L_0x0036:
            monitor-exit(r4)
            return
        L_0x0038:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.b.d(java.lang.String):void");
    }

    public void e(String str) {
        try {
            if (this.k != null) {
                a.a.l.g gVar = (a.a.l.g) this.k.get(str);
                if (gVar != null) {
                    gVar.r[0].b();
                    gVar.r[1].b();
                    gVar.r[2].b();
                    gVar.r[3].b();
                }
                if (this.f2346d != null) {
                    this.f2346d.removeActor(gVar);
                }
                this.k.remove(str);
            }
            if (this.l != null) {
                if (!(this.l.get(str) == null || this.g == null)) {
                    this.g.removeActor(this.l.get(str));
                }
                if (!(this.l.get(str) == null || this.j == null)) {
                    ButtonGroup buttonGroup = this.j;
                    Button button = this.l.get(str);
                    if (buttonGroup == null) {
                        throw null;
                    } else if (button != null) {
                        button.buttonGroup = null;
                        buttonGroup.buttons.removeValue(button, true);
                        buttonGroup.checkedButtons.removeValue(button, true);
                        if (this.j.buttons.size > 0) {
                            this.j.setChecked(((TextButton) this.j.buttons.get(0)).label.text.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("button cannot be null.");
                    }
                }
                this.l.remove(str);
            }
        } catch (Exception e2) {
            e2.getMessage();
            e2.printStackTrace();
        }
    }

    public void render() {
        int i2;
        int i3;
        k.gl.glClear((((AndroidGraphics) k.graphics).bufferFormat.coverageSampling ? 32768 : 0) | 16640);
        Stage stage = this.f2343a;
        if (stage != null) {
            float min = Math.min(((AndroidGraphics) k.graphics).deltaTime, 0.033333335f);
            int length = stage.pointerOverActors.length;
            for (int i4 = 0; i4 < length; i4++) {
                Actor[] actorArr = stage.pointerOverActors;
                Actor actor = actorArr[i4];
                if (stage.pointerTouched[i4]) {
                    actorArr[i4] = stage.fireEnterAndExit(actor, stage.pointerScreenX[i4], stage.pointerScreenY[i4], i4);
                } else if (actor != null) {
                    actorArr[i4] = null;
                    Vector2 vector2 = stage.tempCoords;
                    vector2.x = (float) stage.pointerScreenX[i4];
                    vector2.y = (float) stage.pointerScreenY[i4];
                    stage.screenToStageCoordinates(vector2);
                    InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
                    inputEvent.type = Type.exit;
                    inputEvent.stage = stage;
                    Vector2 vector22 = stage.tempCoords;
                    inputEvent.stageX = vector22.x;
                    inputEvent.stageY = vector22.y;
                    inputEvent.relatedActor = actor;
                    inputEvent.pointer = i4;
                    actor.fire(inputEvent);
                    Pools.free(inputEvent);
                }
            }
            ApplicationType type = k.app.getType();
            if (type == ApplicationType.Desktop || type == ApplicationType.Applet || type == ApplicationType.WebGL) {
                stage.mouseOverActor = stage.fireEnterAndExit(stage.mouseOverActor, stage.mouseScreenX, stage.mouseScreenY, -1);
            }
            stage.root.act(min);
            Stage stage2 = this.f2343a;
            Camera camera = stage2.viewport.camera;
            camera.update();
            if (stage2.root.visible) {
                Batch batch = stage2.batch;
                batch.setProjectionMatrix(camera.combined);
                batch.begin();
                stage2.root.draw(batch, 1.0f);
                batch.end();
                if (Stage.debug) {
                    if (stage2.debugShapes == null) {
                        ShapeRenderer shapeRenderer = new ShapeRenderer();
                        stage2.debugShapes = shapeRenderer;
                        shapeRenderer.setAutoShapeType(true);
                    }
                    if (stage2.debugTableUnderMouse != Debug.none) {
                        Vector2 vector23 = stage2.tempCoords;
                        DefaultAndroidInput defaultAndroidInput = (DefaultAndroidInput) k.input;
                        synchronized (defaultAndroidInput) {
                            i2 = defaultAndroidInput.touchX[0];
                        }
                        float f2 = (float) i2;
                        DefaultAndroidInput defaultAndroidInput2 = (DefaultAndroidInput) k.input;
                        synchronized (defaultAndroidInput2) {
                            i3 = defaultAndroidInput2.touchY[0];
                        }
                        vector23.x = f2;
                        vector23.y = (float) i3;
                        stage2.screenToStageCoordinates(vector23);
                        Vector2 vector24 = stage2.tempCoords;
                        Actor hit = stage2.hit(vector24.x, vector24.y, true);
                        if (hit != null) {
                            if (stage2.debugTableUnderMouse == Debug.none) {
                                hit.setDebug(true);
                            } else {
                                while (hit != null && !(hit instanceof Table)) {
                                    hit = hit.parent;
                                }
                                if (hit != null) {
                                    ((Table) hit).debug(stage2.debugTableUnderMouse);
                                } else {
                                    return;
                                }
                            }
                            stage2.disableDebug(stage2.root, hit);
                        } else {
                            return;
                        }
                    }
                    k.gl.glEnable(GL20.GL_BLEND);
                    stage2.debugShapes.setProjectionMatrix(stage2.viewport.camera.combined);
                    stage2.debugShapes.begin();
                    stage2.root.drawDebug(stage2.debugShapes);
                    stage2.debugShapes.end();
                    k.gl.glDisable(GL20.GL_BLEND);
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }
}
