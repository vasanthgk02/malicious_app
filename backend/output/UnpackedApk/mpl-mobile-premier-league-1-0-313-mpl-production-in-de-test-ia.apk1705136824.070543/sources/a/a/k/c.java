package a.a.k;

import a.a.e.b.j;
import a.a.l.g;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.android.DefaultAndroidInput;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.cfg.mendikot.game.AndroidLauncher;
import java.util.Map.Entry;

public class c extends Group {

    /* renamed from: a  reason: collision with root package name */
    public d f2550a;

    /* renamed from: b  reason: collision with root package name */
    public a f2551b;

    /* renamed from: c  reason: collision with root package name */
    public Image f2552c;

    /* renamed from: d  reason: collision with root package name */
    public Image f2553d;

    /* renamed from: e  reason: collision with root package name */
    public Image f2554e;

    /* renamed from: f  reason: collision with root package name */
    public Label f2555f;
    public Label g;
    public Label h;
    public Label i;
    public Label j;
    public Image k;
    public a.a.a l;
    public a.a.e.b m;
    public Image n;
    public a.a.e.a o;
    public Image p;
    public Image q;
    public Image r;
    public Image s;
    public Sound t;
    public Texture u;
    public Texture v;
    public int w = 15;

    public class a extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2556a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2557b;

        public a(Texture texture, Texture texture2) {
            this.f2556a = texture;
            this.f2557b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            c.this.n.setDrawable(new TextureRegionDrawable(this.f2556a));
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            c.this.n.setDrawable(new TextureRegionDrawable(this.f2557b));
            c.this.m.visible = true;
        }
    }

    public class b implements j {
        public b() {
        }

        public void a(int i) {
            c cVar = c.this;
            cVar.m.visible = false;
            a aVar = cVar.f2551b;
            if (aVar != null) {
                int i2 = cVar.f2550a.f2568c;
                g gVar = (g) aVar;
                if (gVar.f2594a != null) {
                    String str = "";
                    String str2 = str;
                    for (Entry next : gVar.f2597d.entrySet()) {
                        if (((Integer) next.getValue()).intValue() == i2) {
                            str2 = (String) next.getKey();
                        }
                        if (((Integer) next.getValue()).intValue() == 3) {
                            str = (String) next.getKey();
                        }
                    }
                    a.a.l.d dVar = gVar.f2594a;
                    String str3 = gVar.f2595b.f2678a;
                    a.a.l.b bVar = ((com.cfg.mendikot.b) dVar).p;
                    if (bVar != null) {
                        ((AndroidLauncher) bVar).g.f2243a.get(str3).a(str3, str, str2, i);
                    }
                }
            }
        }
    }

    /* renamed from: a.a.k.c$c  reason: collision with other inner class name */
    public class C0041c extends InputListener {
        public C0041c() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            c.this.m.visible = false;
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            c cVar = c.this;
            cVar.addActorBefore(cVar.h, cVar.l);
            c cVar2 = c.this;
            a aVar = cVar2.f2551b;
            if (aVar != null) {
                ((g) aVar).a(cVar2.f2550a.f2568c == 3);
            }
            if (c.this.f2550a.f2568c == 3) {
                if (com.cfg.mendikot.a.y) {
                    c.this.t.play();
                }
                if (com.cfg.mendikot.a.x) {
                    DefaultAndroidInput defaultAndroidInput = (DefaultAndroidInput) k.input;
                    if (VERSION.SDK_INT >= 26) {
                        defaultAndroidInput.vibrator.vibrate(VibrationEffect.createOneShot((long) 500, -1));
                    } else {
                        defaultAndroidInput.vibrator.vibrate((long) 500);
                    }
                }
            }
            c cVar3 = c.this;
            cVar3.f2553d.visible = true;
            cVar3.f2554e.visible = false;
            Label label = cVar3.h;
            label.visible = true;
            label.style.fontColor = Color.valueOf("ff3232");
            c.this.h.color.set(255.0f, 255.0f, 255.0f, 1.0f);
            c.this.h.setSize(100.0f, 100.0f);
            c cVar4 = c.this;
            Label label2 = cVar4.h;
            d dVar = cVar4.f2550a;
            label2.setPosition(dVar.h + 50.0f, dVar.i + 50.0f);
            c.this.h.setFontScale(2.5f);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2562a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2563b;

        public e(int i, int i2) {
            this.f2562a = i;
            this.f2563b = i2;
        }

        public void run() {
            int i;
            c cVar = c.this;
            int i2 = cVar.w;
            if (i2 % 10 == 0) {
                Label label = cVar.h;
                label.setText((CharSequence) i + "");
                c cVar2 = c.this;
                int i3 = cVar2.w;
                if (i == 5) {
                    int i4 = cVar2.f2550a.f2568c;
                }
            }
            c cVar3 = c.this;
            int i5 = cVar3.w - 1;
            cVar3.w = i5;
            a.a.a aVar = cVar3.l;
            float f2 = (((float) i5) * 0.1f) / ((float) this.f2562a);
            if (aVar != null) {
                try {
                    aVar.f2380a.begin();
                    aVar.f2380a.setUniformf((String) "g", f2);
                    aVar.f2380a.end();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                throw null;
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            c.this.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(a.a.k.d r18, a.a.k.a r19) {
        /*
            r17 = this;
            r0 = r17
            r17.<init>()
            r1 = 15
            r0.w = r1
            r1 = r18
            r0.f2550a = r1
            r1 = r19
            r0.f2551b = r1
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r2 = "glow8"
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r2)
            r0.v = r1
            com.badlogic.gdx.graphics.Texture$TextureFilter r2 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            r1.setFilter(r2, r2)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = new com.badlogic.gdx.scenes.scene2d.ui.Image
            com.badlogic.gdx.graphics.Texture r2 = r0.v
            r1.<init>(r2)
            r0.f2554e = r1
            r2 = 1133903872(0x43960000, float:300.0)
            r1.setSize(r2, r2)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.f2554e
            a.a.k.d r2 = r0.f2550a
            float r3 = r2.h
            r4 = 1113849856(0x42640000, float:57.0)
            float r3 = r3 - r4
            float r2 = r2.i
            r4 = 1112014848(0x42480000, float:50.0)
            float r2 = r2 - r4
            r1.setPosition(r3, r2)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.f2554e
            r2 = 0
            r1.visible = r2
            r0.addActor(r1)
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r3 = "glow7"
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r3)
            r0.u = r1
            com.badlogic.gdx.graphics.Texture$TextureFilter r3 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            r1.setFilter(r3, r3)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = new com.badlogic.gdx.scenes.scene2d.ui.Image
            com.badlogic.gdx.graphics.Texture r3 = r0.u
            r1.<init>(r3)
            r0.f2553d = r1
            r3 = 1136852992(0x43c30000, float:390.0)
            r1.setSize(r3, r3)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.f2553d
            a.a.k.d r3 = r0.f2550a
            float r5 = r3.h
            r6 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 - r6
            float r3 = r3.i
            r7 = 1120272384(0x42c60000, float:99.0)
            float r3 = r3 - r7
            r1.setPosition(r5, r3)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.f2553d
            r1.visible = r2
            r0.addActor(r1)
            a.a.k.d r1 = r0.f2550a
            int r1 = r1.f2568c
            r3 = 1
            r5 = 3
            if (r1 != r5) goto L_0x0086
            r1 = 1
            goto L_0x0087
        L_0x0086:
            r1 = 0
        L_0x0087:
            if (r1 == 0) goto L_0x008e
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r7 = "pp4"
            goto L_0x00a4
        L_0x008e:
            a.a.k.d r1 = r0.f2550a
            int r1 = r1.f2568c
            if (r1 != 0) goto L_0x0099
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r7 = "pp1"
            goto L_0x00a4
        L_0x0099:
            if (r1 != r3) goto L_0x00a0
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r7 = "pp2"
            goto L_0x00a4
        L_0x00a0:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r7 = "pp3"
        L_0x00a4:
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r7)
            com.badlogic.gdx.graphics.Texture$TextureFilter r7 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = com.android.tools.r8.GeneratedOutlineSupport.outline22(r1, r7, r7, r1)
            r0.f2552c = r1
            r7 = 1128792064(0x43480000, float:200.0)
            r1.setSize(r7, r7)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.f2552c
            a.a.k.d r8 = r0.f2550a
            float r9 = r8.h
            float r8 = r8.i
            r1.setPosition(r9, r8)
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r8 = "open_card_background"
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r8)
            com.badlogic.gdx.graphics.Texture$TextureFilter r8 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            r1.setFilter(r8, r8)
            a.a.a r8 = new a.a.a
            r8.<init>(r1)
            r0.l = r8
            a.a.k.d r1 = r0.f2550a
            float r9 = r1.h
            r10 = 1106247680(0x41f00000, float:30.0)
            float r9 = r9 - r10
            float r1 = r1.i
            float r1 = r1 - r10
            r8.setPosition(r9, r1)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.f2552c
            r0.addActor(r1)
            a.a.k.d r1 = r0.f2550a
            int r1 = r1.f2568c
            r8 = 2
            if (r1 != 0) goto L_0x00ee
            goto L_0x00f3
        L_0x00ee:
            if (r1 != r3) goto L_0x00f1
            goto L_0x00f8
        L_0x00f1:
            if (r1 != r8) goto L_0x00f8
        L_0x00f3:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r9 = "rounds_container_green"
            goto L_0x00fc
        L_0x00f8:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r9 = "rounds_container_red"
        L_0x00fc:
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r9)
            com.badlogic.gdx.graphics.Texture$TextureFilter r9 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            r1.setFilter(r9, r9)
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r9 = new com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle
            r9.<init>()
            a.a.c.b<java.lang.String, com.badlogic.gdx.graphics.g2d.BitmapFont> r11 = a.a.a.a.d.b.f2414d
            java.lang.String r12 = "Rajdhani-Bold"
            com.badlogic.gdx.graphics.g2d.BitmapFont r11 = r11.a(r12)
            r9.font = r11
            com.badlogic.gdx.graphics.g2d.TextureRegion r11 = new com.badlogic.gdx.graphics.g2d.TextureRegion
            r11.<init>(r1)
            com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable r1 = new com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
            r1.<init>(r11)
            r9.background = r1
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = new com.badlogic.gdx.scenes.scene2d.ui.Label
            java.lang.String r11 = "0/3"
            r1.<init>(r11, r9)
            r0.j = r1
            r1.setAlignment(r3)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.j
            r1.wrap = r3
            r1.invalidateHierarchy()
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.j
            r9 = 1117151293(0x4296603d, float:75.187965)
            r1.setSize(r9, r9)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.j
            a.a.k.d r9 = r0.f2550a
            float r11 = r9.h
            r13 = 1124422997(0x43055555, float:133.33333)
            float r11 = r11 + r13
            r14 = 1110704128(0x42340000, float:45.0)
            float r11 = r11 + r14
            float r9 = r9.i
            float r9 = r9 + r13
            r14 = 1117782016(0x42a00000, float:80.0)
            float r9 = r9 - r14
            r1.setPosition(r11, r9)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.j
            r0.addActor(r1)
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r9 = "label_bidding"
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r9)
            com.badlogic.gdx.graphics.Texture$TextureFilter r9 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            r1.setFilter(r9, r9)
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r9 = new com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle
            r9.<init>()
            a.a.c.b<java.lang.String, com.badlogic.gdx.graphics.g2d.BitmapFont> r11 = a.a.a.a.d.b.f2414d
            com.badlogic.gdx.graphics.g2d.BitmapFont r11 = r11.a(r12)
            r9.font = r11
            com.badlogic.gdx.graphics.Color r11 = com.badlogic.gdx.graphics.Color.BLACK
            r9.fontColor = r11
            com.badlogic.gdx.graphics.g2d.TextureRegion r11 = new com.badlogic.gdx.graphics.g2d.TextureRegion
            r11.<init>(r1)
            com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable r1 = new com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
            r1.<init>(r11)
            r9.background = r1
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = new com.badlogic.gdx.scenes.scene2d.ui.Label
            java.lang.String r11 = "Bid\n..."
            r1.<init>(r11, r9)
            r0.h = r1
            r1.setAlignment(r3)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.h
            r1.wrap = r3
            r1.invalidateHierarchy()
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.h
            r9 = 1069547520(0x3fc00000, float:1.5)
            r1.setFontScale(r9)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.h
            r9 = 1124204544(0x43020000, float:130.0)
            r11 = 1124859904(0x430c0000, float:140.0)
            r1.setSize(r9, r11)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.h
            a.a.k.d r9 = r0.f2550a
            float r15 = r9.h
            r16 = 1108082688(0x420c0000, float:35.0)
            float r15 = r15 + r16
            float r9 = r9.i
            float r9 = r9 + r10
            r1.setPosition(r15, r9)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.h
            r9 = 1061997773(0x3f4ccccd, float:0.8)
            com.badlogic.gdx.graphics.Color r1 = r1.color
            r10 = 1132396544(0x437f0000, float:255.0)
            r1.set(r10, r10, r10, r9)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.h
            r1.visible = r2
            r0.addActor(r1)
            a.a.k.d r1 = r0.f2550a
            int r1 = r1.f2568c
            int r1 = r1 % r8
            if (r1 != 0) goto L_0x01d2
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r9 = "label_name1"
            goto L_0x01d6
        L_0x01d2:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r9 = "label_name2"
        L_0x01d6:
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r9)
            com.badlogic.gdx.graphics.Texture$TextureFilter r9 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = com.android.tools.r8.GeneratedOutlineSupport.outline22(r1, r9, r9, r1)
            r0.k = r1
            r9 = 1131413504(0x43700000, float:240.0)
            r1.setSize(r9, r11)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.k
            a.a.k.d r9 = r0.f2550a
            float r10 = r9.h
            r11 = 1101004800(0x41a00000, float:20.0)
            float r10 = r10 - r11
            float r9 = r9.i
            float r9 = r9 - r6
            r1.setPosition(r10, r9)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.k
            r0.addActor(r1)
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r1 = new com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle
            r1.<init>()
            a.a.c.b<java.lang.String, com.badlogic.gdx.graphics.g2d.BitmapFont> r6 = a.a.a.a.d.b.f2414d
            com.badlogic.gdx.graphics.g2d.BitmapFont r6 = r6.a(r12)
            r1.font = r6
            com.badlogic.gdx.scenes.scene2d.ui.Label r6 = new com.badlogic.gdx.scenes.scene2d.ui.Label
            java.lang.String r9 = " Player "
            r6.<init>(r9, r1)
            r0.f2555f = r6
            r6.setAlignment(r8)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2555f
            r1.wrap = r3
            r1.invalidateHierarchy()
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2555f
            r1.setSize(r7, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2555f
            a.a.k.d r6 = r0.f2550a
            float r9 = r6.h
            r10 = 0
            float r9 = r9 - r10
            float r6 = r6.i
            r11 = 1095761920(0x41500000, float:13.0)
            float r6 = r6 - r11
            r1.setPosition(r9, r6)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2555f
            r6 = 1066192077(0x3f8ccccd, float:1.1)
            r1.setFontScale(r6)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2555f
            r0.addActor(r1)
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r1 = new com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle
            r1.<init>()
            a.a.c.b<java.lang.String, com.badlogic.gdx.graphics.g2d.BitmapFont> r9 = a.a.a.a.d.b.f2414d
            com.badlogic.gdx.graphics.g2d.BitmapFont r9 = r9.a(r12)
            r1.font = r9
            com.badlogic.gdx.scenes.scene2d.ui.Label r9 = new com.badlogic.gdx.scenes.scene2d.ui.Label
            java.lang.String r11 = " Team - "
            r9.<init>(r11, r1)
            r0.i = r9
            r1 = 4
            r9.setAlignment(r1)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.i
            r1.wrap = r3
            r1.invalidateHierarchy()
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.i
            r1.setSize(r7, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.i
            a.a.k.d r4 = r0.f2550a
            float r7 = r4.h
            float r7 = r7 - r10
            float r4 = r4.i
            r9 = 1119748096(0x42be0000, float:95.0)
            float r4 = r4 - r9
            r1.setPosition(r7, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.i
            r1.setFontScale(r6)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.i
            r0.addActor(r1)
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r4 = "bid_value"
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r4)
            com.badlogic.gdx.graphics.Texture$TextureFilter r4 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
            r1.setFilter(r4, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r4 = new com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle
            r4.<init>()
            a.a.c.b<java.lang.String, com.badlogic.gdx.graphics.g2d.BitmapFont> r6 = a.a.a.a.d.b.f2414d
            com.badlogic.gdx.graphics.g2d.BitmapFont r6 = r6.a(r12)
            r4.font = r6
            com.badlogic.gdx.graphics.g2d.TextureRegion r6 = new com.badlogic.gdx.graphics.g2d.TextureRegion
            r6.<init>(r1)
            com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable r1 = new com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
            r1.<init>(r6)
            r4.background = r1
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = new com.badlogic.gdx.scenes.scene2d.ui.Label
            java.lang.String r6 = "0"
            r1.<init>(r6, r4)
            r0.g = r1
            r1.setAlignment(r3)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.g
            r1.wrap = r3
            r1.invalidateHierarchy()
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.g
            r4 = 1114636288(0x42700000, float:60.0)
            r1.setSize(r4, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.g
            a.a.k.d r4 = r0.f2550a
            float r6 = r4.h
            float r4 = r4.i
            r7 = 1109131264(0x421c0000, float:39.0)
            float r4 = r4 + r7
            r1.setPosition(r6, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.g
            r0.addActor(r1)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = new com.badlogic.gdx.scenes.scene2d.ui.Image
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r4 = a.a.a.a.d.b.f2412b
            java.lang.String r6 = "spade_disable"
            com.badlogic.gdx.graphics.Texture r4 = r4.a(r6)
            r1.<init>(r4)
            r0.r = r1
            r4 = 1109393408(0x42200000, float:40.0)
            r1.setSize(r4, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.r
            a.a.k.d r6 = r0.f2550a
            float r7 = r6.h
            r9 = 1090519040(0x41000000, float:8.0)
            float r7 = r7 + r9
            float r6 = r6.i
            r9 = 52
            float r9 = (float) r9
            float r6 = r6 - r9
            r1.setPosition(r7, r6)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = new com.badlogic.gdx.scenes.scene2d.ui.Image
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r6 = a.a.a.a.d.b.f2412b
            java.lang.String r7 = "heart_disable"
            com.badlogic.gdx.graphics.Texture r6 = r6.a(r7)
            r1.<init>(r6)
            r0.p = r1
            r1.setSize(r4, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.p
            a.a.k.d r6 = r0.f2550a
            float r7 = r6.h
            r10 = 1098907648(0x41800000, float:16.0)
            float r7 = r7 + r10
            float r7 = r7 + r4
            float r6 = r6.i
            float r6 = r6 - r9
            r1.setPosition(r7, r6)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = new com.badlogic.gdx.scenes.scene2d.ui.Image
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r6 = a.a.a.a.d.b.f2412b
            java.lang.String r7 = "diamond_disable"
            com.badlogic.gdx.graphics.Texture r6 = r6.a(r7)
            r1.<init>(r6)
            r0.q = r1
            r1.setSize(r4, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.q
            a.a.k.d r6 = r0.f2550a
            float r7 = r6.h
            r10 = 1103101952(0x41c00000, float:24.0)
            float r7 = r7 + r10
            float r7 = r7 + r14
            float r6 = r6.i
            float r6 = r6 - r9
            r1.setPosition(r7, r6)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = new com.badlogic.gdx.scenes.scene2d.ui.Image
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r6 = a.a.a.a.d.b.f2412b
            java.lang.String r7 = "club_disable"
            com.badlogic.gdx.graphics.Texture r6 = r6.a(r7)
            r1.<init>(r6)
            r0.s = r1
            r1.setSize(r4, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.s
            a.a.k.d r4 = r0.f2550a
            float r6 = r4.h
            r7 = 1107296256(0x42000000, float:32.0)
            float r6 = r6 + r7
            r7 = 1123024896(0x42f00000, float:120.0)
            float r6 = r6 + r7
            float r4 = r4.i
            float r4 = r4 - r9
            r1.setPosition(r6, r4)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.r
            r0.addActor(r1)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.p
            r0.addActor(r1)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.q
            r0.addActor(r1)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.s
            r0.addActor(r1)
            a.a.c.c<java.lang.String, com.badlogic.gdx.audio.Sound> r1 = a.a.a.a.d.b.f2413c
            java.lang.String r4 = "sound_myturn"
            com.badlogic.gdx.audio.Sound r1 = r1.a(r4)
            r0.t = r1
            a.a.c.c<java.lang.String, com.badlogic.gdx.audio.Sound> r1 = a.a.a.a.d.b.f2413c
            java.lang.String r4 = "alarm"
            r1.a(r4)
            a.a.k.d r1 = r0.f2550a
            boolean r4 = r1.g
            if (r4 == 0) goto L_0x0438
            int r1 = r1.f2568c
            if (r1 >= r5) goto L_0x03c5
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r1 = a.a.a.a.d.b.f2412b
            java.lang.String r4 = "emoji_icon_up"
            com.badlogic.gdx.graphics.Texture r1 = r1.a(r4)
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r4 = a.a.a.a.d.b.f2412b
            java.lang.String r6 = "emoji_icon_down"
            com.badlogic.gdx.graphics.Texture r4 = r4.a(r6)
            com.badlogic.gdx.scenes.scene2d.ui.Image r6 = new com.badlogic.gdx.scenes.scene2d.ui.Image
            r6.<init>(r1)
            r0.n = r6
            a.a.k.d r7 = r0.f2550a
            float r9 = r7.h
            float r9 = r9 + r13
            float r7 = r7.i
            float r7 = r7 + r13
            r6.setPosition(r9, r7)
            com.badlogic.gdx.scenes.scene2d.ui.Image r6 = r0.n
            r7 = 1117151293(0x4296603d, float:75.187965)
            r6.setSize(r7, r7)
            com.badlogic.gdx.scenes.scene2d.ui.Image r6 = r0.n
            a.a.k.c$a r7 = new a.a.k.c$a
            r7.<init>(r4, r1)
            r6.addListener(r7)
            com.badlogic.gdx.scenes.scene2d.ui.Image r1 = r0.n
            r0.addActor(r1)
        L_0x03c5:
            a.a.e.a r1 = new a.a.e.a
            r1.<init>()
            r0.o = r1
            a.a.k.d r4 = r0.f2550a
            int r4 = r4.f2568c
            r6 = 1143773199(0x442c980f, float:690.3759)
            if (r4 == 0) goto L_0x03ec
            if (r4 == r3) goto L_0x03e6
            if (r4 == r8) goto L_0x03e3
            if (r4 == r5) goto L_0x03dc
            goto L_0x03f1
        L_0x03dc:
            r3 = 1155022848(0x44d84000, float:1730.0)
            r6 = 1132702378(0x4383aaaa, float:263.3333)
            goto L_0x03ee
        L_0x03e3:
            r3 = 1153630208(0x44c30000, float:1560.0)
            goto L_0x03ee
        L_0x03e6:
            r3 = 1150599168(0x4494c000, float:1190.0)
            r6 = 1146552320(0x44570000, float:860.0)
            goto L_0x03ee
        L_0x03ec:
            r3 = 1137836032(0x43d20000, float:420.0)
        L_0x03ee:
            r1.setPosition(r3, r6)
        L_0x03f1:
            a.a.e.a r1 = r0.o
            r3 = 1126170624(0x43200000, float:160.0)
            r1.setSize(r3, r3)
            a.a.e.a r1 = r0.o
            r1.visible = r2
            r0.addActor(r1)
            a.a.k.d r1 = r0.f2550a
            int r1 = r1.f2568c
            if (r1 >= r5) goto L_0x0438
            a.a.e.b r1 = new a.a.e.b
            a.a.k.c$b r3 = new a.a.k.c$b
            r3.<init>()
            r1.<init>(r3)
            r0.m = r1
            r3 = 1134231552(0x439b0000, float:310.0)
            r1.setSize(r3, r3)
            a.a.e.b r1 = r0.m
            a.a.k.d r3 = r0.f2550a
            float r4 = r3.h
            r5 = 1113325568(0x425c0000, float:55.0)
            float r4 = r4 - r5
            float r3 = r3.i
            r5 = 1119092736(0x42b40000, float:90.0)
            float r3 = r3 - r5
            r1.setPosition(r4, r3)
            a.a.e.b r1 = r0.m
            r1.visible = r2
            a.a.k.c$c r2 = new a.a.k.c$c
            r2.<init>()
            r1.addListener(r2)
            a.a.e.b r1 = r0.m
            r0.addActor(r1)
        L_0x0438:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.k.c.<init>(a.a.k.d, a.a.k.a):void");
    }

    public void a() {
        a aVar = this.f2551b;
        if (aVar != null) {
            ((g) aVar).a(false);
        }
        this.w = 15;
        this.h.clearActions();
        this.h.setText((CharSequence) "");
        this.h.visible = false;
        this.f2553d.visible = false;
        this.f2554e.visible = false;
        removeActor(this.l);
    }

    public void a(int i2, int i3) {
        Label label = this.j;
        label.setText((CharSequence) i3 + "/" + i2);
    }

    public void b() {
        a.a.e.a aVar = this.o;
        if (aVar != null) {
            aVar.j.dispose();
            aVar.k.dispose();
            aVar.l.dispose();
            aVar.m.dispose();
            aVar.n.dispose();
            aVar.o.dispose();
            aVar.p.dispose();
            aVar.q.dispose();
            aVar.r.dispose();
            removeActor(this.o);
        }
    }

    public void b(char[] cArr) {
        TextureRegionDrawable textureRegionDrawable;
        Image image;
        this.r.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("spade_disable")));
        this.p.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("heart_disable")));
        this.q.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("diamond_disable")));
        this.s.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("club_disable")));
        for (char c2 : cArr) {
            if (c2 == 'C') {
                image = this.s;
                textureRegionDrawable = new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("club_enable"));
            } else if (c2 == 'D') {
                image = this.q;
                textureRegionDrawable = new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("diamond_enable"));
            } else if (c2 == 'H') {
                image = this.p;
                textureRegionDrawable = new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("heart_enable"));
            } else if (c2 != 'S') {
            } else {
                image = this.r;
                textureRegionDrawable = new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("spade_enable"));
            }
            image.setDrawable(textureRegionDrawable);
        }
    }

    public void b(String str, String str2) {
        d dVar = this.f2550a;
        dVar.f2566a = str2;
        if (dVar == null) {
            throw null;
        } else if (k.a3(str)) {
            if (str != null && !str.trim().isEmpty() && str.length() > 10) {
                str = str.substring(0, 10) + ".";
            }
            this.i.setText((CharSequence) "Team " + str);
        }
    }

    public void b(int i2, int i3) {
        a.a.e.b bVar = this.m;
        if (bVar != null) {
            bVar.visible = false;
        }
        if (i2 < 0) {
            a();
            return;
        }
        int i4 = i2 * 10;
        this.w = i4;
        this.h.clearActions();
        Label label = this.h;
        float f2 = (float) i3;
        RunnableAction run = k.run(new d());
        RepeatAction repeat = k.repeat(i4, k.delay(0.09f, k.run(new e(i2, i3))));
        RunnableAction run2 = k.run(new f());
        SequenceAction sequenceAction = (SequenceAction) k.action(SequenceAction.class);
        sequenceAction.actions.add(run);
        Actor actor = sequenceAction.actor;
        if (actor != null) {
            run.setActor(actor);
        }
        sequenceAction.actions.add(repeat);
        Actor actor2 = sequenceAction.actor;
        if (actor2 != null) {
            repeat.setActor(actor2);
        }
        sequenceAction.actions.add(run2);
        Actor actor3 = sequenceAction.actor;
        if (actor3 != null) {
            run2.setActor(actor3);
        }
        label.addAction(k.delay(f2, sequenceAction));
    }

    public void a(String str, String str2) {
        d dVar = this.f2550a;
        dVar.f2566a = str2;
        dVar.f2567b = str;
        if (str != null && !str.trim().isEmpty() && str.length() > 10) {
            str = str.substring(0, 10) + ".";
        }
        this.f2555f.setText((CharSequence) str);
    }
}
