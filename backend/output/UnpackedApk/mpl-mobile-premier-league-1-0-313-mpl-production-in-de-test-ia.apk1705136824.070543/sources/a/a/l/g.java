package a.a.l;

import a.a.d.b.C0038b;
import a.a.e.a.C0039a;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Interpolation.PowOut;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.cfg.mendikot.api.SocketManager;
import com.cfg.mendikot.game.AndroidLauncher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class g extends Group implements e, a.a.k.a, a.a.d.e, c {
    public f A;
    public h B;
    public a C;
    public Sound D;
    public boolean E;

    /* renamed from: a  reason: collision with root package name */
    public d f2594a;

    /* renamed from: b  reason: collision with root package name */
    public i f2595b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f2596c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f2597d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, a.a.k.d> f2598e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, String> f2599f = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, a.a.j.f> g = new ConcurrentHashMap<>();
    public int h = 0;
    public Image i;
    public Image j;
    public Image k;
    public Image l;
    public Image m;
    public Image n;
    public Image o;
    public Image p;
    public a.a.i.a q;
    public a.a.k.c[] r = new a.a.k.c[4];
    public a.a.d.c s;
    public a.a.d.b t;
    public a.a.j.a u;
    public a.a.j.a v;
    public a.a.j.a w;
    public j z;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2600a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2601b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2602c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashSet f2603d;

        public a(String str, int i, int i2, HashSet hashSet) {
            this.f2600a = str;
            this.f2601b = i;
            this.f2602c = i2;
            this.f2603d = hashSet;
        }

        public void run() {
            g.this.q.a(1);
            int intValue = g.this.f2597d.get(this.f2600a).intValue();
            g.this.r[intValue].b(this.f2601b / 1000, this.f2602c / 1000);
            if (intValue == 3) {
                g.this.s.a(this.f2603d, true);
            } else {
                g.this.s.a(this.f2603d, false);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2605a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2606b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a.a.d.a f2607c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f2608d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f2610f;
        public final /* synthetic */ HashSet g;

        public b(String str, String str2, a.a.d.a aVar, int i, int i2, boolean z, HashSet hashSet) {
            this.f2605a = str;
            this.f2606b = str2;
            this.f2607c = aVar;
            this.f2608d = i;
            this.f2609e = i2;
            this.f2610f = z;
            this.g = hashSet;
        }

        public void run() {
            a.a.d.a aVar;
            a.a.d.h hVar;
            int intValue = g.this.f2597d.get(this.f2605a).intValue();
            int intValue2 = g.this.f2597d.get(this.f2606b).intValue();
            if (intValue == 0) {
                g.this.t.a(this.f2607c, 0.2f);
            } else if (intValue == 1) {
                g.this.t.b(this.f2607c, 0.2f);
            } else if (intValue == 2) {
                g.this.t.c(this.f2607c, 0.2f);
            } else if (intValue == 3) {
                a.a.d.c cVar = g.this.s;
                a.a.d.a aVar2 = this.f2607c;
                char c2 = aVar2.f2459a;
                char c3 = aVar2.f2460b;
                int i = 0;
                while (true) {
                    aVar = null;
                    if (i >= cVar.f2472a.size()) {
                        hVar = null;
                        i = -1;
                        break;
                    }
                    a.a.d.h hVar2 = cVar.f2472a.get(i);
                    a.a.d.a aVar3 = hVar2.q;
                    if (aVar3.f2460b == c3 && aVar3.f2459a == c2) {
                        hVar = hVar2;
                        aVar = aVar3;
                        break;
                    }
                    i++;
                }
                if (!(i == -1 || aVar == null || hVar == null)) {
                    try {
                        cVar.b(aVar, hVar, false);
                    } catch (Exception unused) {
                    }
                }
            }
            g.this.r[intValue].a();
            int i2 = this.f2608d;
            int i3 = this.f2609e;
            if (!this.f2610f) {
                g.this.r[intValue2].b(i2 / 1000, i3 / 1000);
            }
            a.a.d.c cVar2 = g.this.s;
            if (intValue2 == 3) {
                cVar2.a(this.g, true);
            } else {
                cVar2.a(this.g, false);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ char f2611a;

        public c(char c2) {
            this.f2611a = c2;
        }

        public void run() {
            g.this.q.a(this.f2611a);
            g.this.B.a("Trump revealed.", 2);
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2613a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ char[] f2614b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2615c;

        public d(String str, char[] cArr, int i) {
            this.f2613a = str;
            this.f2614b = cArr;
            this.f2615c = i;
        }

        public void run() {
            float f2;
            int intValue = g.this.f2597d.get(this.f2613a).intValue();
            a.a.d.b bVar = g.this.t;
            bVar.i = 0.13333334f;
            float f3 = 1280.0f;
            float f4 = 0.0f;
            if (intValue != 0) {
                if (intValue == 1) {
                    bVar.i = 0.2f;
                    f2 = 540.0f;
                } else if (intValue != 2) {
                    if (intValue != 3) {
                        f2 = 0.0f;
                    } else {
                        f4 = -540.0f;
                    }
                }
                bVar.addAction(co.hyperverge.hypersnapsdk.c.k.sequence(co.hyperverge.hypersnapsdk.c.k.parallel(co.hyperverge.hypersnapsdk.c.k.moveBy(f4, f2, 0.4f, Interpolation.circle), co.hyperverge.hypersnapsdk.c.k.run(new a.a.d.b.a())), co.hyperverge.hypersnapsdk.c.k.run(new C0038b())));
                if (bVar.f2464a.visible && com.cfg.mendikot.a.y) {
                    bVar.g.play();
                }
                a.a.k.c cVar = g.this.r[intValue];
                char[] cArr = this.f2614b;
                a.a.k.d dVar = cVar.f2550a;
                int i = dVar.f2569d + 1;
                dVar.f2569d = i;
                cVar.g.setText(i);
                cVar.b(cArr);
                g.this.q.a(this.f2615c + 2);
            }
            f3 = -1280.0f;
            bVar.i = 0.26666668f;
            float f5 = f4;
            f4 = f3;
            f2 = f5;
            bVar.addAction(co.hyperverge.hypersnapsdk.c.k.sequence(co.hyperverge.hypersnapsdk.c.k.parallel(co.hyperverge.hypersnapsdk.c.k.moveBy(f4, f2, 0.4f, Interpolation.circle), co.hyperverge.hypersnapsdk.c.k.run(new a.a.d.b.a())), co.hyperverge.hypersnapsdk.c.k.run(new C0038b())));
            bVar.g.play();
            a.a.k.c cVar2 = g.this.r[intValue];
            char[] cArr2 = this.f2614b;
            a.a.k.d dVar2 = cVar2.f2550a;
            int i2 = dVar2.f2569d + 1;
            dVar2.f2569d = i2;
            cVar2.g.setText(i2);
            cVar2.b(cArr2);
            g.this.q.a(this.f2615c + 2);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HashMap[] f2617a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap f2618b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f2619c;

        public e(HashMap[] hashMapArr, ConcurrentHashMap concurrentHashMap, boolean z) {
            this.f2617a = hashMapArr;
            this.f2618b = concurrentHashMap;
            this.f2619c = z;
        }

        public void run() {
            boolean z = g.this.f2595b.g == 1;
            g gVar = g.this;
            int i = gVar.f2595b.g;
            if (i == 1 || gVar.h < i) {
                g gVar2 = g.this;
                gVar2.u.a(z, gVar2.f2597d, this.f2617a, this.f2618b, this.f2619c);
            } else if (i == 3) {
                gVar.v.a(z, gVar.f2597d, this.f2617a, this.f2618b, this.f2619c);
            } else if (i == 5) {
                gVar.w.a(z, gVar.f2597d, this.f2617a, this.f2618b, this.f2619c);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            int i = 0;
            g.this.q.a(0);
            while (i < 4) {
                g.this.r[i].a();
                a.a.k.c cVar = g.this.r[i];
                if (cVar != null) {
                    try {
                        cVar.r.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("spade_disable")));
                        cVar.p.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("heart_disable")));
                        cVar.q.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("diamond_disable")));
                        cVar.s.setDrawable(new TextureRegionDrawable(a.a.a.a.d.b.f2412b.a("club_disable")));
                        cVar.g.setText((CharSequence) "0");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    i++;
                } else {
                    throw null;
                }
            }
        }
    }

    /* renamed from: a.a.l.g$g  reason: collision with other inner class name */
    public class C0043g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HashMap f2622a;

        public C0043g(HashMap hashMap) {
            this.f2622a = hashMap;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0036  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                a.a.l.g r0 = a.a.l.g.this
                a.a.j.a r1 = r0.u
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = r0.f2597d
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r3 = r0.f2598e
                java.util.HashMap r4 = r6.f2622a
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.j.f> r0 = r0.g
                r1.a(r2, r3, r4, r0)
                a.a.l.g r0 = a.a.l.g.this
                a.a.l.i r1 = r0.f2595b
                int r1 = r1.g
                r2 = 3
                if (r1 == r2) goto L_0x001f
                r2 = 5
                if (r1 == r2) goto L_0x001c
                goto L_0x002c
            L_0x001c:
                a.a.j.a r1 = r0.w
                goto L_0x0021
            L_0x001f:
                a.a.j.a r1 = r0.v
            L_0x0021:
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = r0.f2597d
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r3 = r0.f2598e
                java.util.HashMap r4 = r6.f2622a
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.j.f> r0 = r0.g
                r1.a(r2, r3, r4, r0)
            L_0x002c:
                a.a.l.g r0 = a.a.l.g.this
                boolean r1 = r0.visible
                r2 = 1065353216(0x3f800000, float:1.0)
                com.badlogic.gdx.audio.Sound r0 = r0.D
                if (r1 == 0) goto L_0x003a
                r0.play(r2)
                goto L_0x0040
            L_0x003a:
                r1 = 1060320051(0x3f333333, float:0.7)
                r0.play(r1)
            L_0x0040:
                a.a.l.g r0 = a.a.l.g.this
                a.a.l.a r0 = r0.C
                com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2572a
                r1.clearActions()
                com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2572a
                r3 = 1
                r1.visible = r3
                r3 = 10
                r0.f2575d = r3
                java.lang.String r4 = "Game has ended. Table will close in "
                java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
                int r5 = r0.f2575d
                r4.append(r5)
                java.lang.String r5 = " seconds."
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                r1.setText(r4)
                com.badlogic.gdx.scenes.scene2d.ui.Label r1 = r0.f2572a
                a.a.l.a$e r4 = new a.a.l.a$e
                r4.<init>()
                com.badlogic.gdx.scenes.scene2d.actions.RunnableAction r4 = co.hyperverge.hypersnapsdk.c.k.run(r4)
                com.badlogic.gdx.scenes.scene2d.actions.DelayAction r2 = co.hyperverge.hypersnapsdk.c.k.delay(r2, r4)
                com.badlogic.gdx.scenes.scene2d.actions.RepeatAction r2 = co.hyperverge.hypersnapsdk.c.k.repeat(r3, r2)
                a.a.l.a$f r3 = new a.a.l.a$f
                r3.<init>()
                com.badlogic.gdx.scenes.scene2d.actions.RunnableAction r0 = co.hyperverge.hypersnapsdk.c.k.run(r3)
                com.badlogic.gdx.scenes.scene2d.actions.SequenceAction r0 = co.hyperverge.hypersnapsdk.c.k.sequence(r2, r0)
                r1.addAction(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.l.g.C0043g.run():void");
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            a aVar = g.this.C;
            aVar.f2574c = 0;
            aVar.f2572a.clearActions();
            Label label = aVar.f2572a;
            label.visible = true;
            label.setText((CharSequence) "Connecting Players");
            Label label2 = aVar.f2572a;
            DelayAction delay = co.hyperverge.hypersnapsdk.c.k.delay(0.5f, co.hyperverge.hypersnapsdk.c.k.run(new a.a.l.a.c()));
            RepeatAction repeatAction = (RepeatAction) co.hyperverge.hypersnapsdk.c.k.action(RepeatAction.class);
            repeatAction.repeatCount = -1;
            repeatAction.action = delay;
            label2.addAction(co.hyperverge.hypersnapsdk.c.k.sequence(repeatAction, co.hyperverge.hypersnapsdk.c.k.run(new a.a.l.a.d())));
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2625a;

        public i(String str) {
            this.f2625a = str;
        }

        public void run() {
            h hVar = g.this.B;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("An error occurred! Go back to lobby to start the game again!\n");
            outline73.append(this.f2625a);
            hVar.a(outline73.toString(), 1000);
        }
    }

    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2627a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashSet f2628b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap f2629c;

        public j(ArrayList arrayList, HashSet hashSet, ConcurrentHashMap concurrentHashMap) {
            this.f2627a = arrayList;
            this.f2628b = hashSet;
            this.f2629c = concurrentHashMap;
        }

        public void run() {
            g.a(g.this, this.f2627a, this.f2628b);
            g.a(g.this, this.f2629c);
        }
    }

    public class k extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2631a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2632b;

        public k(Texture texture, Texture texture2) {
            this.f2631a = texture;
            this.f2632b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            g.this.k.setDrawable(new TextureRegionDrawable(this.f2631a));
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            g.this.k.setDrawable(new TextureRegionDrawable(this.f2632b));
            g.this.A.visible = true;
        }
    }

    public class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2634a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2635b;

        public l(String str, int i) {
            this.f2634a = str;
            this.f2635b = i;
        }

        public void run() {
            g.this.B.a(this.f2634a, this.f2635b);
        }
    }

    public class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2637a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2638b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2639c;

        public m(String str, String str2, int i) {
            this.f2637a = str;
            this.f2638b = str2;
            this.f2639c = i;
        }

        public void run() {
            String str;
            float f2;
            float f3;
            g gVar = g.this;
            String str2 = this.f2637a;
            String str3 = this.f2638b;
            int i = this.f2639c;
            int intValue = gVar.f2597d.get(str2).intValue();
            int intValue2 = gVar.f2597d.get(str3).intValue();
            a.a.c.d<String, Texture> dVar = a.a.a.a.d.b.f2412b;
            switch (i) {
                case 1:
                    str = "emoji2";
                    break;
                case 2:
                    str = "emoji3";
                    break;
                case 3:
                    str = "emoji4";
                    break;
                case 4:
                    str = "emoji5";
                    break;
                case 5:
                    str = "emoji6";
                    break;
                case 6:
                    str = "emoji7";
                    break;
                case 7:
                    str = "emoji8";
                    break;
                case 8:
                    str = "emoji9";
                    break;
                default:
                    str = "emoji1";
                    break;
            }
            Texture a2 = dVar.a(str);
            float f4 = 263.3333f;
            float f5 = 1730.0f;
            if (intValue != 1) {
                if (intValue == 2) {
                    f3 = 1560.0f;
                } else if (intValue != 3) {
                    f3 = 420.0f;
                } else {
                    f3 = 1730.0f;
                    f2 = 263.3333f;
                }
                f2 = 690.3759f;
            } else {
                f3 = 1190.0f;
                f2 = 860.0f;
            }
            if (intValue2 == 1) {
                f4 = 860.0f;
                f5 = 1190.0f;
            } else if (intValue2 == 2) {
                f4 = 690.3759f;
                f5 = 1560.0f;
            } else if (intValue2 != 3) {
                f4 = 690.3759f;
                f5 = 420.0f;
            }
            Image image = new Image(a2);
            image.setPosition(f3, f2);
            image.setSize(160.0f, 160.0f);
            image.visible = true;
            gVar.addActorBefore(gVar.u.c(), image);
            PowOut powOut = Interpolation.fastSlow;
            MoveToAction moveToAction = (MoveToAction) co.hyperverge.hypersnapsdk.c.k.action(MoveToAction.class);
            moveToAction.endX = f5;
            moveToAction.endY = f4;
            moveToAction.duration = 0.5f;
            moveToAction.interpolation = powOut;
            image.addAction(co.hyperverge.hypersnapsdk.c.k.delay(0.1f, co.hyperverge.hypersnapsdk.c.k.sequence(moveToAction, co.hyperverge.hypersnapsdk.c.k.run(new y(intValue2, i, image)))));
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            g.this.B.a("Failed to refresh data! Please refresh manually by bottom refresh button in the sidebar", 2);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        public void run() {
            g.this.B.f2676a.visible = false;
        }
    }

    public class p implements Runnable {
        public p() {
        }

        public void run() {
            g.this.B.a("Connection lost! Trying to reconnect...", 5);
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public void run() {
            g.this.B.a("You have been disconnected for too long! Go back to lobby to start the game again!", 1000);
        }
    }

    public class r extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2646b;

        public r(Texture texture, Texture texture2) {
            this.f2645a = texture;
            this.f2646b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            g.this.n.setDrawable(new TextureRegionDrawable(this.f2645a));
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            g.this.n.setDrawable(new TextureRegionDrawable(this.f2646b));
            j jVar = g.this.z;
            jVar.f2684a.toString();
            jVar.visible = true;
        }
    }

    public class s extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2648a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2649b;

        public s(Texture texture, Texture texture2) {
            this.f2648a = texture;
            this.f2649b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            g.this.m.setDrawable(new TextureRegionDrawable(this.f2648a));
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            g.this.m.setDrawable(new TextureRegionDrawable(this.f2649b));
            g.this.u.a();
        }
    }

    public class t extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2651a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2652b;

        public t(Texture texture, Texture texture2) {
            this.f2651a = texture;
            this.f2652b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            g.this.l.setDrawable(new TextureRegionDrawable(this.f2651a));
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            try {
                g.this.l.setDrawable(new TextureRegionDrawable(this.f2652b));
                if (g.this.f2594a != null) {
                    ((com.cfg.mendikot.b) g.this.f2594a).a(g.this.f2595b.f2678a);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class u extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2654a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2655b;

        public u(Texture texture, Texture texture2) {
            this.f2654a = texture;
            this.f2655b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            h hVar;
            String str;
            try {
                if (com.cfg.mendikot.a.y) {
                    com.cfg.mendikot.a.y = false;
                    g.this.o.setDrawable(new TextureRegionDrawable(this.f2654a));
                    hVar = g.this.B;
                    str = "Sound OFF.";
                } else {
                    com.cfg.mendikot.a.y = true;
                    g.this.o.setDrawable(new TextureRegionDrawable(this.f2655b));
                    hVar = g.this.B;
                    str = "Sound ON.";
                }
                hVar.a(str, 2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class v extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2658b;

        public v(Texture texture, Texture texture2) {
            this.f2657a = texture;
            this.f2658b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            h hVar;
            String str;
            try {
                if (com.cfg.mendikot.a.x) {
                    com.cfg.mendikot.a.x = false;
                    g.this.p.setDrawable(new TextureRegionDrawable(this.f2657a));
                    hVar = g.this.B;
                    str = "Vibration OFF.";
                } else {
                    com.cfg.mendikot.a.x = true;
                    g.this.p.setDrawable(new TextureRegionDrawable(this.f2658b));
                    hVar = g.this.B;
                    str = "Vibration ON.";
                }
                hVar.a(str, 2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f2660a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2661b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f2662c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2663d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f2665f;
        public final /* synthetic */ char g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ HashSet i;
        public final /* synthetic */ ConcurrentHashMap j;
        public final /* synthetic */ String[] k;
        public final /* synthetic */ ConcurrentHashMap l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;
        public final /* synthetic */ int o;
        public final /* synthetic */ int p;
        public final /* synthetic */ ConcurrentHashMap q;
        public final /* synthetic */ ConcurrentHashMap r;
        public final /* synthetic */ g s;

        public w(g gVar, boolean z, String str, i iVar, String str2, int i2, int i3, char c2, ArrayList arrayList, HashSet hashSet, ConcurrentHashMap concurrentHashMap, String[] strArr, ConcurrentHashMap concurrentHashMap2, String str3, String str4, int i4, int i5, ConcurrentHashMap concurrentHashMap3, ConcurrentHashMap concurrentHashMap4) {
            this.s = gVar;
            this.f2660a = z;
            this.f2661b = str;
            this.f2662c = iVar;
            this.f2663d = str2;
            this.f2664e = i2;
            this.f2665f = i3;
            this.g = c2;
            this.h = arrayList;
            this.i = hashSet;
            this.j = concurrentHashMap;
            this.k = strArr;
            this.l = concurrentHashMap2;
            this.m = str3;
            this.n = str4;
            this.o = i4;
            this.p = i5;
            this.q = concurrentHashMap3;
            this.r = concurrentHashMap4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x00ed A[SYNTHETIC, Splitter:B:23:0x00ed] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01b9 A[Catch:{ Exception -> 0x026f }, LOOP:1: B:39:0x01b3->B:41:0x01b9, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x01f7 A[Catch:{ Exception -> 0x026f }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0235 A[Catch:{ Exception -> 0x026f }] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x024a A[Catch:{ Exception -> 0x026f }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x025c A[Catch:{ Exception -> 0x026f }] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01a9 A[EDGE_INSN: B:72:0x01a9->B:38:0x01a9 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r13 = this;
                boolean r0 = r13.f2660a     // Catch:{ Exception -> 0x026f }
                if (r0 != 0) goto L_0x001c
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                if (r0 == 0) goto L_0x001a
                a.a.f.a r1 = com.cfg.mendikot.b.s     // Catch:{ Exception -> 0x026f }
                a.a.f.a r2 = a.a.f.a.RUN     // Catch:{ Exception -> 0x026f }
                if (r1 == r2) goto L_0x000f
                goto L_0x001c
            L_0x000f:
                com.badlogic.gdx.Application r1 = co.hyperverge.hypersnapsdk.c.k.app     // Catch:{ Exception -> 0x026f }
                a.a.l.g$h r2 = new a.a.l.g$h     // Catch:{ Exception -> 0x026f }
                r2.<init>()     // Catch:{ Exception -> 0x026f }
                r1.postRunnable(r2)     // Catch:{ Exception -> 0x026f }
                goto L_0x001c
            L_0x001a:
                r0 = 0
                throw r0     // Catch:{ Exception -> 0x026f }
            L_0x001c:
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.i r1 = r13.f2662c     // Catch:{ Exception -> 0x026f }
                a.a.l.g.a(r0, r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.j r0 = r0.z     // Catch:{ Exception -> 0x026f }
                a.a.l.i r1 = r13.f2662c     // Catch:{ Exception -> 0x026f }
                r0.a(r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.i r0 = r0.f2595b     // Catch:{ Exception -> 0x026f }
                java.lang.String r1 = r13.f2663d     // Catch:{ Exception -> 0x026f }
                r0.f2679b = r1     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                int r1 = r13.f2664e     // Catch:{ Exception -> 0x026f }
                r2 = 1
                int r1 = r1 + r2
                r0.h = r1     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.i.a r0 = r0.q     // Catch:{ Exception -> 0x026f }
                int r1 = r13.f2664e     // Catch:{ Exception -> 0x026f }
                int r1 = r1 + r2
                r0.b(r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.i.a r0 = r0.q     // Catch:{ Exception -> 0x026f }
                int r1 = r13.f2665f     // Catch:{ Exception -> 0x026f }
                int r1 = r1 + r2
                r0.a(r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.i.a r0 = r0.q     // Catch:{ Exception -> 0x026f }
                char r1 = r13.g     // Catch:{ Exception -> 0x026f }
                r0.a(r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.ArrayList r1 = r13.h     // Catch:{ Exception -> 0x026f }
                java.util.HashSet r3 = r13.i     // Catch:{ Exception -> 0x026f }
                a.a.l.g.a(r0, r1, r3)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap r1 = r13.j     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r3 = r0.f2598e     // Catch:{ Exception -> 0x026f }
                r3.clear()     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r0 = r0.f2598e     // Catch:{ Exception -> 0x026f }
                r0.putAll(r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                java.lang.String[] r1 = r13.k     // Catch:{ Exception -> 0x026f }
                a.a.l.g.a(r0, r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                java.lang.String[] r1 = r13.k     // Catch:{ Exception -> 0x026f }
                a.a.l.g.b(r0, r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap r1 = r13.l     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r3 = r0.f2599f     // Catch:{ Exception -> 0x026f }
                r3.clear()     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r0 = r0.f2599f     // Catch:{ Exception -> 0x026f }
                r0.putAll(r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap r1 = r13.l     // Catch:{ Exception -> 0x026f }
                a.a.l.g.d(r0, r1)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.u     // Catch:{ Exception -> 0x026f }
                a.a.l.g r1 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r1 = r1.f2597d     // Catch:{ Exception -> 0x026f }
                a.a.l.g r3 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r3 = r3.f2598e     // Catch:{ Exception -> 0x026f }
                a.a.l.g r4 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r4 = r4.f2599f     // Catch:{ Exception -> 0x026f }
                a.a.l.g r5 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.j.f> r5 = r5.g     // Catch:{ Exception -> 0x026f }
                r0.a(r1, r3, r4, r5)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.i r0 = r0.f2595b     // Catch:{ Exception -> 0x026f }
                int r0 = r0.g     // Catch:{ Exception -> 0x026f }
                r1 = 5
                r3 = 3
                if (r0 == r3) goto L_0x00ca
                if (r0 == r1) goto L_0x00b7
                goto L_0x00e0
            L_0x00b7:
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.w     // Catch:{ Exception -> 0x026f }
                a.a.l.g r4 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r4 = r4.f2597d     // Catch:{ Exception -> 0x026f }
                a.a.l.g r5 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r5 = r5.f2598e     // Catch:{ Exception -> 0x026f }
                a.a.l.g r6 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r6 = r6.f2599f     // Catch:{ Exception -> 0x026f }
            L_0x00c7:
                a.a.l.g r7 = r13.s     // Catch:{ Exception -> 0x026f }
                goto L_0x00db
            L_0x00ca:
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.v     // Catch:{ Exception -> 0x026f }
                a.a.l.g r4 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r4 = r4.f2597d     // Catch:{ Exception -> 0x026f }
                a.a.l.g r5 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r5 = r5.f2598e     // Catch:{ Exception -> 0x026f }
                a.a.l.g r6 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r6 = r6.f2599f     // Catch:{ Exception -> 0x026f }
                goto L_0x00c7
            L_0x00db:
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.j.f> r7 = r7.g     // Catch:{ Exception -> 0x026f }
                r0.a(r4, r5, r6, r7)     // Catch:{ Exception -> 0x026f }
            L_0x00e0:
                r0 = 0
                r4 = 0
            L_0x00e2:
                java.lang.String[] r5 = r13.k     // Catch:{ Exception -> 0x026f }
                int r5 = r5.length     // Catch:{ Exception -> 0x026f }
                java.lang.String r6 = "moveStart"
                r7 = 1057379089(0x3f065311, float:0.524705)
                r8 = -1
                if (r4 >= r5) goto L_0x01a9
                a.a.l.g r5 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r5 = r5.f2597d     // Catch:{ Exception -> 0x026f }
                java.lang.String[] r9 = r13.k     // Catch:{ Exception -> 0x026f }
                r9 = r9[r4]     // Catch:{ Exception -> 0x026f }
                java.lang.Object r5 = r5.get(r9)     // Catch:{ Exception -> 0x026f }
                java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x026f }
                int r5 = r5.intValue()     // Catch:{ Exception -> 0x026f }
                a.a.l.g r9 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r9 = r9.f2598e     // Catch:{ Exception -> 0x026f }
                java.lang.String[] r10 = r13.k     // Catch:{ Exception -> 0x026f }
                r10 = r10[r4]     // Catch:{ Exception -> 0x026f }
                java.lang.Object r9 = r9.get(r10)     // Catch:{ Exception -> 0x026f }
                a.a.k.d r9 = (a.a.k.d) r9     // Catch:{ Exception -> 0x026f }
                java.lang.String r9 = r9.f2567b     // Catch:{ Exception -> 0x026f }
                a.a.l.g r10 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r10 = r10.f2598e     // Catch:{ Exception -> 0x026f }
                java.lang.String[] r11 = r13.k     // Catch:{ Exception -> 0x026f }
                r11 = r11[r4]     // Catch:{ Exception -> 0x026f }
                java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x026f }
                a.a.k.d r10 = (a.a.k.d) r10     // Catch:{ Exception -> 0x026f }
                java.lang.String r10 = r10.f2566a     // Catch:{ Exception -> 0x026f }
                a.a.l.g r11 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.k.c[] r11 = r11.r     // Catch:{ Exception -> 0x026f }
                r11 = r11[r5]     // Catch:{ Exception -> 0x026f }
                r11.a(r9, r10)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r9 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r9 = r9.f2599f     // Catch:{ Exception -> 0x026f }
                java.lang.String[] r11 = r13.k     // Catch:{ Exception -> 0x026f }
                r11 = r11[r4]     // Catch:{ Exception -> 0x026f }
                java.lang.Object r9 = r9.get(r11)     // Catch:{ Exception -> 0x026f }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x026f }
                a.a.l.g r11 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.k.c[] r11 = r11.r     // Catch:{ Exception -> 0x026f }
                r11 = r11[r5]     // Catch:{ Exception -> 0x026f }
                r11.b(r9, r10)     // Catch:{ Exception -> 0x026f }
                a.a.l.g r9 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.k.c[] r9 = r9.r     // Catch:{ Exception -> 0x026f }
                r9 = r9[r5]     // Catch:{ Exception -> 0x026f }
                a.a.l.g r10 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.i r10 = r10.f2595b     // Catch:{ Exception -> 0x026f }
                int r10 = r10.g     // Catch:{ Exception -> 0x026f }
                a.a.l.g r11 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r11 = r11.f2598e     // Catch:{ Exception -> 0x026f }
                java.lang.String[] r12 = r13.k     // Catch:{ Exception -> 0x026f }
                r12 = r12[r4]     // Catch:{ Exception -> 0x026f }
                java.lang.Object r11 = r11.get(r12)     // Catch:{ Exception -> 0x026f }
                a.a.k.d r11 = (a.a.k.d) r11     // Catch:{ Exception -> 0x026f }
                int r11 = r11.f2570e     // Catch:{ Exception -> 0x026f }
                r9.a(r10, r11)     // Catch:{ Exception -> 0x026f }
                java.lang.String r9 = r13.m     // Catch:{ Exception -> 0x026f }
                int r10 = r9.hashCode()     // Catch:{ Exception -> 0x026f }
                if (r10 == r7) goto L_0x0167
                goto L_0x016e
            L_0x0167:
                boolean r6 = r9.equals(r6)     // Catch:{ Exception -> 0x026f }
                if (r6 == 0) goto L_0x016e
                r8 = 0
            L_0x016e:
                if (r8 == 0) goto L_0x0171
                goto L_0x01a5
            L_0x0171:
                java.lang.String[] r6 = r13.k     // Catch:{ Exception -> 0x026f }
                r6 = r6[r4]     // Catch:{ Exception -> 0x026f }
                java.lang.String r7 = r13.n     // Catch:{ Exception -> 0x026f }
                boolean r6 = r6.contentEquals(r7)     // Catch:{ Exception -> 0x026f }
                if (r6 == 0) goto L_0x018f
                a.a.l.g r6 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.k.c[] r6 = r6.r     // Catch:{ Exception -> 0x026f }
                r5 = r6[r5]     // Catch:{ Exception -> 0x026f }
                int r6 = r13.o     // Catch:{ Exception -> 0x026f }
                int r6 = r6 / 1000
                int r7 = r13.p     // Catch:{ Exception -> 0x026f }
                int r7 = r7 / 1000
                r5.b(r6, r7)     // Catch:{ Exception -> 0x026f }
                goto L_0x0198
            L_0x018f:
                a.a.l.g r6 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.k.c[] r6 = r6.r     // Catch:{ Exception -> 0x026f }
                r5 = r6[r5]     // Catch:{ Exception -> 0x026f }
                r5.a()     // Catch:{ Exception -> 0x026f }
            L_0x0198:
                a.a.l.g r5 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.a r5 = r5.C     // Catch:{ Exception -> 0x026f }
                com.badlogic.gdx.scenes.scene2d.ui.Label r6 = r5.f2572a     // Catch:{ Exception -> 0x026f }
                r6.clearActions()     // Catch:{ Exception -> 0x026f }
                com.badlogic.gdx.scenes.scene2d.ui.Label r5 = r5.f2572a     // Catch:{ Exception -> 0x026f }
                r5.visible = r0     // Catch:{ Exception -> 0x026f }
            L_0x01a5:
                int r4 = r4 + 1
                goto L_0x00e2
            L_0x01a9:
                java.util.concurrent.ConcurrentHashMap r4 = r13.q     // Catch:{ Exception -> 0x026f }
                java.util.Collection r4 = r4.values()     // Catch:{ Exception -> 0x026f }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x026f }
            L_0x01b3:
                boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x026f }
                if (r5 == 0) goto L_0x01e8
                java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x026f }
                a.a.k.d r5 = (a.a.k.d) r5     // Catch:{ Exception -> 0x026f }
                a.a.l.g r9 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r9 = r9.f2597d     // Catch:{ Exception -> 0x026f }
                java.lang.String r10 = r5.f2566a     // Catch:{ Exception -> 0x026f }
                java.lang.Object r9 = r9.get(r10)     // Catch:{ Exception -> 0x026f }
                java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x026f }
                int r9 = r9.intValue()     // Catch:{ Exception -> 0x026f }
                a.a.l.g r10 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.k.c[] r10 = r10.r     // Catch:{ Exception -> 0x026f }
                r9 = r10[r9]     // Catch:{ Exception -> 0x026f }
                char[] r10 = r5.f2571f     // Catch:{ Exception -> 0x026f }
                int r5 = r5.f2569d     // Catch:{ Exception -> 0x026f }
                a.a.k.d r11 = r9.f2550a     // Catch:{ Exception -> 0x026f }
                r11.f2569d = r5     // Catch:{ Exception -> 0x026f }
                r11.f2571f = r10     // Catch:{ Exception -> 0x026f }
                com.badlogic.gdx.scenes.scene2d.ui.Label r11 = r9.g     // Catch:{ Exception -> 0x026f }
                r11.setText(r5)     // Catch:{ Exception -> 0x026f }
                r9.b(r10)     // Catch:{ Exception -> 0x026f }
                goto L_0x01b3
            L_0x01e8:
                a.a.l.g r4 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap r5 = r13.r     // Catch:{ Exception -> 0x026f }
                a.a.l.g.a(r4, r5)     // Catch:{ Exception -> 0x026f }
                java.lang.String r4 = r13.n     // Catch:{ Exception -> 0x026f }
                boolean r4 = co.hyperverge.hypersnapsdk.c.k.a3(r4)     // Catch:{ Exception -> 0x026f }
                if (r4 == 0) goto L_0x022f
                a.a.l.g r4 = r13.s     // Catch:{ Exception -> 0x026f }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r4 = r4.f2597d     // Catch:{ Exception -> 0x026f }
                java.lang.String r5 = r13.n     // Catch:{ Exception -> 0x026f }
                java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x026f }
                java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x026f }
                int r4 = r4.intValue()     // Catch:{ Exception -> 0x026f }
                java.lang.String r5 = r13.m     // Catch:{ Exception -> 0x026f }
                int r9 = r5.hashCode()     // Catch:{ Exception -> 0x026f }
                if (r9 == r7) goto L_0x0210
                goto L_0x0217
            L_0x0210:
                boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x026f }
                if (r5 == 0) goto L_0x0217
                r8 = 0
            L_0x0217:
                if (r8 == 0) goto L_0x021a
                goto L_0x022f
            L_0x021a:
                if (r4 != r3) goto L_0x0226
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.d.c r0 = r0.s     // Catch:{ Exception -> 0x026f }
                java.util.HashSet r4 = r13.i     // Catch:{ Exception -> 0x026f }
                r0.a(r4, r2)     // Catch:{ Exception -> 0x026f }
                goto L_0x022f
            L_0x0226:
                a.a.l.g r2 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.d.c r2 = r2.s     // Catch:{ Exception -> 0x026f }
                java.util.HashSet r4 = r13.i     // Catch:{ Exception -> 0x026f }
                r2.a(r4, r0)     // Catch:{ Exception -> 0x026f }
            L_0x022f:
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.u     // Catch:{ Exception -> 0x026f }
                if (r0 == 0) goto L_0x0242
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.u     // Catch:{ Exception -> 0x026f }
                a.a.l.g r2 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.i r2 = r2.f2595b     // Catch:{ Exception -> 0x026f }
                java.lang.String r2 = r2.f2679b     // Catch:{ Exception -> 0x026f }
                r0.a(r2)     // Catch:{ Exception -> 0x026f }
            L_0x0242:
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.l.i r0 = r0.f2595b     // Catch:{ Exception -> 0x026f }
                int r0 = r0.g     // Catch:{ Exception -> 0x026f }
                if (r0 == r3) goto L_0x025c
                if (r0 == r1) goto L_0x024d
                goto L_0x0273
            L_0x024d:
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.w     // Catch:{ Exception -> 0x026f }
                if (r0 == 0) goto L_0x0273
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.w     // Catch:{ Exception -> 0x026f }
                a.a.l.g r1 = r13.s     // Catch:{ Exception -> 0x026f }
            L_0x0259:
                a.a.l.i r1 = r1.f2595b     // Catch:{ Exception -> 0x026f }
                goto L_0x0269
            L_0x025c:
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.v     // Catch:{ Exception -> 0x026f }
                if (r0 == 0) goto L_0x0273
                a.a.l.g r0 = r13.s     // Catch:{ Exception -> 0x026f }
                a.a.j.a r0 = r0.v     // Catch:{ Exception -> 0x026f }
                a.a.l.g r1 = r13.s     // Catch:{ Exception -> 0x026f }
                goto L_0x0259
            L_0x0269:
                java.lang.String r1 = r1.f2679b     // Catch:{ Exception -> 0x026f }
                r0.a(r1)     // Catch:{ Exception -> 0x026f }
                goto L_0x0273
            L_0x026f:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0273:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.l.g.w.run():void");
        }
    }

    public class x implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2666a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2667b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap f2668c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String[] f2669d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2670e;

        public x(int i, ArrayList arrayList, ConcurrentHashMap concurrentHashMap, String[] strArr, int i2) {
            this.f2666a = i;
            this.f2667b = arrayList;
            this.f2668c = concurrentHashMap;
            this.f2669d = strArr;
            this.f2670e = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x008b A[LOOP:0: B:12:0x0086->B:14:0x008b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00e2 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0073  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                a.a.l.g r0 = a.a.l.g.this
                a.a.j.a r0 = r0.u
                r0.b()
                a.a.l.g r0 = a.a.l.g.this
                a.a.l.i r1 = r0.f2595b
                int r1 = r1.g
                r2 = 5
                r3 = 3
                if (r1 == r3) goto L_0x0017
                if (r1 == r2) goto L_0x0014
                goto L_0x001c
            L_0x0014:
                a.a.j.a r0 = r0.w
                goto L_0x0019
            L_0x0017:
                a.a.j.a r0 = r0.v
            L_0x0019:
                r0.b()
            L_0x001c:
                a.a.l.g r0 = a.a.l.g.this
                a.a.i.a r0 = r0.q
                int r1 = r9.f2666a
                r4 = 1
                int r1 = r1 + r4
                r0.b(r1)
                a.a.l.g r0 = a.a.l.g.this
                a.a.i.a r0 = r0.q
                r1 = 0
                r0.a(r1)
                a.a.l.g r0 = a.a.l.g.this
                java.util.ArrayList r5 = r9.f2667b
                r6 = 0
                a.a.l.g.a(r0, r5, r6)
                a.a.l.g r0 = a.a.l.g.this
                a.a.i.a r0 = r0.q
                r5 = 78
                r0.a(r5)
                a.a.l.g r0 = a.a.l.g.this
                java.util.concurrent.ConcurrentHashMap r5 = r9.f2668c
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r6 = r0.f2598e
                r6.clear()
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r0 = r0.f2598e
                r0.putAll(r5)
                a.a.l.g r0 = a.a.l.g.this
                java.lang.String[] r5 = r9.f2669d
                a.a.l.g.a(r0, r5)
                a.a.l.g r0 = a.a.l.g.this
                java.lang.String[] r5 = r9.f2669d
                a.a.l.g.b(r0, r5)
                a.a.l.g r0 = a.a.l.g.this
                a.a.j.a r5 = r0.u
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r6 = r0.f2597d
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r7 = r0.f2598e
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r8 = r0.f2599f
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.j.f> r0 = r0.g
                r5.a(r6, r7, r8, r0)
                a.a.l.g r0 = a.a.l.g.this
                a.a.l.i r5 = r0.f2595b
                int r5 = r5.g
                if (r5 == r3) goto L_0x0079
                if (r5 == r2) goto L_0x0076
                goto L_0x0086
            L_0x0076:
                a.a.j.a r2 = r0.w
                goto L_0x007b
            L_0x0079:
                a.a.j.a r2 = r0.v
            L_0x007b:
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r3 = r0.f2597d
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r5 = r0.f2598e
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r6 = r0.f2599f
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.j.f> r0 = r0.g
                r2.a(r3, r5, r6, r0)
            L_0x0086:
                java.lang.String[] r0 = r9.f2669d
                int r2 = r0.length
                if (r1 >= r2) goto L_0x00e2
                a.a.l.g r2 = a.a.l.g.this
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = r2.f2597d
                r0 = r0[r1]
                java.lang.Object r0 = r2.get(r0)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                a.a.l.g r2 = a.a.l.g.this
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r2 = r2.f2598e
                java.lang.String[] r3 = r9.f2669d
                r3 = r3[r1]
                java.lang.Object r2 = r2.get(r3)
                a.a.k.d r2 = (a.a.k.d) r2
                java.lang.String r2 = r2.f2567b
                a.a.l.g r3 = a.a.l.g.this
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r3 = r3.f2598e
                java.lang.String[] r5 = r9.f2669d
                r5 = r5[r1]
                java.lang.Object r3 = r3.get(r5)
                a.a.k.d r3 = (a.a.k.d) r3
                java.lang.String r3 = r3.f2566a
                a.a.l.g r5 = a.a.l.g.this
                a.a.k.c[] r5 = r5.r
                r5 = r5[r0]
                r5.a(r2, r3)
                a.a.l.g r2 = a.a.l.g.this
                a.a.k.c[] r3 = r2.r
                r0 = r3[r0]
                a.a.l.i r3 = r2.f2595b
                int r3 = r3.g
                java.util.concurrent.ConcurrentHashMap<java.lang.String, a.a.k.d> r2 = r2.f2598e
                java.lang.String[] r5 = r9.f2669d
                r5 = r5[r1]
                java.lang.Object r2 = r2.get(r5)
                a.a.k.d r2 = (a.a.k.d) r2
                int r2 = r2.f2570e
                r0.a(r3, r2)
                int r1 = r1 + 1
                goto L_0x0086
            L_0x00e2:
                a.a.l.g r0 = a.a.l.g.this
                a.a.l.a r0 = r0.C
                int r1 = r9.f2670e
                int r2 = r9.f2666a
                com.badlogic.gdx.scenes.scene2d.ui.Label r3 = r0.f2572a
                r3.clearActions()
                com.badlogic.gdx.scenes.scene2d.ui.Label r3 = r0.f2572a
                r3.visible = r4
                int r1 = r1 / 1000
                r0.f2573b = r1
                java.lang.String r4 = "Round "
                java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
                int r5 = r2 + 1
                r4.append(r5)
                java.lang.String r5 = " will start in "
                r4.append(r5)
                int r5 = r0.f2573b
                r4.append(r5)
                java.lang.String r5 = " seconds"
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                r3.setText(r4)
                com.badlogic.gdx.scenes.scene2d.ui.Label r3 = r0.f2572a
                a.a.l.a$a r4 = new a.a.l.a$a
                r4.<init>(r2)
                com.badlogic.gdx.scenes.scene2d.actions.RunnableAction r2 = co.hyperverge.hypersnapsdk.c.k.run(r4)
                r4 = 1065353216(0x3f800000, float:1.0)
                com.badlogic.gdx.scenes.scene2d.actions.DelayAction r2 = co.hyperverge.hypersnapsdk.c.k.delay(r4, r2)
                com.badlogic.gdx.scenes.scene2d.actions.RepeatAction r1 = co.hyperverge.hypersnapsdk.c.k.repeat(r1, r2)
                a.a.l.a$b r2 = new a.a.l.a$b
                r2.<init>()
                com.badlogic.gdx.scenes.scene2d.actions.RunnableAction r0 = co.hyperverge.hypersnapsdk.c.k.run(r2)
                com.badlogic.gdx.scenes.scene2d.actions.SequenceAction r0 = co.hyperverge.hypersnapsdk.c.k.sequence(r1, r0)
                r3.addAction(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.l.g.x.run():void");
        }
    }

    public class y implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2672a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2673b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Image f2674c;

        public y(int i, int i2, Image image) {
            this.f2672a = i;
            this.f2673b = i2;
            this.f2674c = image;
        }

        public void run() {
            Sound sound;
            a.a.k.c cVar = g.this.r[this.f2672a];
            int i = this.f2673b;
            a.a.e.a aVar = cVar.o;
            if (aVar != null) {
                aVar.clearActions();
                aVar.visible = true;
                aVar.F = i;
                Sound sound2 = aVar.s;
                if (sound2 != null) {
                    sound2.stop();
                }
                switch (i) {
                    case 1:
                        sound = aVar.u;
                        break;
                    case 2:
                        sound = aVar.v;
                        break;
                    case 3:
                        sound = aVar.w;
                        break;
                    case 4:
                        sound = aVar.z;
                        break;
                    case 5:
                        sound = aVar.A;
                        break;
                    case 6:
                        sound = aVar.B;
                        break;
                    case 7:
                        sound = aVar.C;
                        break;
                    case 8:
                        sound = aVar.D;
                        break;
                    default:
                        sound = aVar.t;
                        break;
                }
                aVar.s = sound;
                sound.loop(1.0f);
                aVar.addAction(co.hyperverge.hypersnapsdk.c.k.delay(1.85f, co.hyperverge.hypersnapsdk.c.k.run(new C0039a())));
            }
            Image image = this.f2674c;
            image.clearActions();
            image.listeners.clear();
            image.captureListeners.clear();
            Image image2 = this.f2674c;
            Group group = image2.parent;
            if (group != null) {
                group.removeActor(image2, true);
            }
        }
    }

    public g(i iVar, d dVar) {
        float f2;
        this.f2595b = iVar;
        this.f2594a = dVar;
        this.name = iVar.f2678a;
        Image image = new Image(a.a.a.a.d.b.f2412b.a("table_background"));
        this.j = image;
        image.setSize(2160.0f, 1080.0f);
        addActor(this.j);
        Image image2 = new Image(a.a.a.a.d.b.f2412b.a("table"));
        this.i = image2;
        image2.setSize(1944.0f, 999.0f);
        this.i.setPosition(108.0f, 10.0f);
        addActor(this.i);
        for (int i2 = 0; i2 < 4; i2++) {
            a.a.k.d dVar2 = new a.a.k.d();
            dVar2.f2567b = GeneratedOutlineSupport.outline41("Player ", i2);
            dVar2.f2568c = i2;
            dVar2.g = this.f2595b.p;
            dVar2.f2571f = new char[0];
            dVar2.f2569d = 0;
            float f3 = 540.0f;
            if (i2 == 0) {
                f2 = 220.0f;
            } else if (i2 == 1) {
                f3 = 770.0f;
                f2 = 980.0f;
            } else if (i2 != 2) {
                f3 = 110.0f;
                f2 = 1880.0f;
            } else {
                f2 = 1710.0f;
            }
            dVar2.h = f2;
            dVar2.i = f3;
            a.a.k.c cVar = new a.a.k.c(dVar2, this);
            this.r[i2] = cVar;
            addActorAfter(this.i, cVar);
        }
        a.a.i.a aVar = new a.a.i.a(-1, -1, 'N');
        this.q = aVar;
        addActorAfter(this.i, aVar);
        new ArrayList();
        a.a.d.b bVar = new a.a.d.b(this);
        this.t = bVar;
        addActorAfter(this.i, bVar);
        Texture a2 = a.a.a.a.d.b.f2412b.a("leave_table");
        Texture a3 = a.a.a.a.d.b.f2412b.a("leave_table_down");
        Image image3 = new Image(a2);
        this.k = image3;
        image3.setPosition(25.0f, 865.0f);
        this.k.setSize(100.0f, 100.0f);
        this.k.addListener(new k(a3, a2));
        Texture a4 = a.a.a.a.d.b.f2412b.a("table_refresh");
        Texture a5 = a.a.a.a.d.b.f2412b.a("table_refresh_down");
        Image image4 = new Image(a4);
        this.l = image4;
        image4.setPosition(2035.0f, 865.0f);
        this.l.setSize(100.0f, 100.0f);
        this.l.addListener(new t(a5, a4));
        addActor(this.l);
        Texture a6 = a.a.a.a.d.b.f2412b.a("score_icon1");
        Texture a7 = a.a.a.a.d.b.f2412b.a("score_icon_down1");
        Image image5 = new Image(a6);
        this.m = image5;
        image5.setPosition(2035.0f, 585.0f);
        this.m.setSize(100.0f, 100.0f);
        Image image6 = this.m;
        image6.visible = false;
        image6.addListener(new s(a7, a6));
        addActor(this.m);
        Texture a8 = a.a.a.a.d.b.f2412b.a("info_icon");
        Texture a9 = a.a.a.a.d.b.f2412b.a("info_icon_down");
        Image image7 = new Image(a8);
        this.n = image7;
        image7.setPosition(2035.0f, 745.0f);
        this.n.setSize(100.0f, 100.0f);
        this.n.addListener(new r(a9, a8));
        addActor(this.n);
        Texture a10 = a.a.a.a.d.b.f2412b.a("volume_control_on");
        Texture a11 = a.a.a.a.d.b.f2412b.a("volume_control_off");
        Image image8 = new Image(a10);
        this.o = image8;
        image8.setPosition(35.0f, 865.0f);
        this.o.setSize(100.0f, 100.0f);
        this.o.addListener(new u(a11, a10));
        addActor(this.o);
        Texture a12 = a.a.a.a.d.b.f2412b.a("vibration_control_on");
        Texture a13 = a.a.a.a.d.b.f2412b.a("vibration_control_off");
        Image image9 = new Image(a12);
        this.p = image9;
        image9.setPosition(35.0f, 745.0f);
        this.p.setSize(100.0f, 100.0f);
        this.p.addListener(new v(a13, a12));
        addActor(this.p);
        a.a.j.c cVar2 = new a.a.j.c(this.f2595b);
        this.u = cVar2;
        String str = this.f2595b.f2679b;
        addActor(cVar2);
        a.a.j.d dVar3 = new a.a.j.d(this.f2595b);
        this.v = dVar3;
        String str2 = this.f2595b.f2679b;
        addActor(dVar3);
        a.a.j.e eVar = new a.a.j.e(this.f2595b);
        this.w = eVar;
        String str3 = this.f2595b.f2679b;
        addActor(eVar);
        this.z = new j(this.f2595b);
        addActorAfter(this.u.c(), this.z);
        f fVar = new f(this);
        this.A = fVar;
        addActorAfter(this.z, fVar);
        this.C = new a();
        addActorBefore(this.u.c(), this.C);
        h hVar = new h();
        this.B = hVar;
        addActorAfter(this.A, hVar);
        this.D = a.a.a.a.d.b.f2413c.a("gameWin");
        d dVar4 = this.f2594a;
        if (dVar4 != null) {
            String str4 = this.f2595b.f2678a;
            com.cfg.mendikot.b bVar2 = (com.cfg.mendikot.b) dVar4;
            ConcurrentHashMap<String, e> concurrentHashMap = bVar2.k;
            if (concurrentHashMap != null) {
                if (concurrentHashMap.get(str4) == null) {
                    bVar2.k.put(str4, this);
                    bVar2.f2346d.addActor((g) bVar2.k.get(str4));
                }
                if (bVar2.k.get(str4) != null) {
                    AndroidLauncher androidLauncher = (AndroidLauncher) bVar2.p;
                    if (androidLauncher != null) {
                        try {
                            SocketManager socketManager = androidLauncher.g;
                            if (socketManager != null) {
                                socketManager.f2243a.put(str4, new com.cfg.mendikot.api.b(str4, androidLauncher));
                                androidLauncher.f2369f.put(str4, this);
                            } else {
                                throw null;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        throw null;
                    }
                }
            }
            ConcurrentHashMap<String, TextButton> concurrentHashMap2 = bVar2.l;
            if (concurrentHashMap2 != null) {
                TextButton textButton = concurrentHashMap2.get(str4);
                if (textButton != null) {
                    textButton.setChecked(true, textButton.programmaticChangeEvents);
                }
            }
        }
    }

    public static void a(g gVar, i iVar) {
        i iVar2 = gVar.f2595b;
        iVar2.m = iVar.m;
        iVar2.l = iVar.l;
        iVar2.g = iVar.g;
        iVar2.f2683f = iVar.f2683f;
        iVar2.f2682e = iVar.f2682e;
        iVar2.f2681d = iVar.f2681d;
        iVar2.i = iVar.i;
        iVar2.n = iVar.n;
        iVar2.o = iVar.o;
    }

    public static void b(g gVar, String[] strArr) {
        gVar.f2597d.clear();
        int i2 = 0;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].contentEquals(gVar.f2595b.f2679b)) {
                i2 = i3;
            }
        }
        for (int i4 = 0; i4 < strArr.length; i4++) {
            gVar.f2597d.put(strArr[((i2 + 1) + i4) % strArr.length], Integer.valueOf(i4));
        }
        gVar.f2597d.toString();
    }

    public static void d(g gVar, ConcurrentHashMap concurrentHashMap) {
        gVar.g.clear();
        for (Entry entry : concurrentHashMap.entrySet()) {
            String str = (String) entry.getValue();
            String str2 = (String) entry.getKey();
            a.a.j.f fVar = gVar.g.get(str) != null ? gVar.g.get(str) : new a.a.j.f();
            fVar.f2549d.add(str2);
            gVar.g.put(str, fVar);
        }
    }

    public void a(String str, char c2) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new c(c2));
        }
    }

    public void a(String str, a.a.d.a aVar, String str2, String str3, int i2, HashSet<Character> hashSet, int i3, boolean z2) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            Application application = co.hyperverge.hypersnapsdk.c.k.app;
            b bVar = new b(str2, str3, aVar, i2, i3, z2, hashSet);
            application.postRunnable(bVar);
        }
    }

    public void a(String str, i iVar, String str2, boolean z2, String[] strArr, int i2, char c2, ConcurrentHashMap<String, a.a.k.d> concurrentHashMap, ConcurrentHashMap<String, a.a.k.d> concurrentHashMap2, ConcurrentHashMap<String, String> concurrentHashMap3, char c3, ConcurrentHashMap<String, a.a.d.a> concurrentHashMap4, int i3, String str3, String str4, String str5, int i4, int i5, HashSet<Character> hashSet, String str6, ArrayList<a.a.d.a> arrayList, int i6) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            Application application = co.hyperverge.hypersnapsdk.c.k.app;
            w wVar = r1;
            w wVar2 = new w(this, z2, str, iVar, str2, i2, i6, c2, arrayList, hashSet, concurrentHashMap2, strArr, concurrentHashMap3, str3, str5, i4, i5, concurrentHashMap, concurrentHashMap4);
            application.postRunnable(wVar);
        }
    }

    public void a(String str, String str2) {
    }

    public void a(String str, String str2, int i2, HashSet<Character> hashSet, int i3) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            Application application = co.hyperverge.hypersnapsdk.c.k.app;
            a aVar = new a(str2, i2, i3, hashSet);
            application.postRunnable(aVar);
        }
    }

    public void a(String str, String str2, int i2, char[] cArr) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new d(str2, cArr, i2));
        }
    }

    public void a(String str, ArrayList<a.a.d.a> arrayList, String str2, ConcurrentHashMap<String, a.a.k.d> concurrentHashMap, String[] strArr, int i2, int i3) {
        try {
            if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
                arrayList.size();
                Application application = co.hyperverge.hypersnapsdk.c.k.app;
                x xVar = new x(i2, arrayList, concurrentHashMap, strArr, i3);
                application.postRunnable(xVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, a.a.j.b> hashMap) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new C0043g(hashMap));
        }
    }

    public void a(String str, HashSet<Character> hashSet, ArrayList<a.a.d.a> arrayList, ConcurrentHashMap<String, a.a.d.a> concurrentHashMap) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            arrayList.toString();
            concurrentHashMap.size();
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new j(arrayList, hashSet, concurrentHashMap));
        }
    }

    public void a(String str, HashMap<String, a.a.j.f>[] hashMapArr) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            hashMapArr.toString();
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new f());
        }
    }

    public void a(String str, HashMap<String, a.a.j.f>[] hashMapArr, ConcurrentHashMap<String, String> concurrentHashMap, boolean z2) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            int length = hashMapArr.length;
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new e(hashMapArr, concurrentHashMap, z2));
        }
    }

    public void b(String str, String str2) {
        a.a.f.a aVar = com.cfg.mendikot.b.s;
        a.a.f.a aVar2 = a.a.f.a.RUN;
    }

    public void b(String str, String str2, String str3, int i2) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new m(str2, str3, i2));
        }
    }

    public void c(String str) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new q());
        }
    }

    public void c(String str, String str2) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new i(str2));
        }
    }

    public void c(String str, String str2, String str3, int i2) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new l(str2, i2));
        }
    }

    public void d(String str) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            try {
                co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new n());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e(String str) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new p());
        }
    }

    public void f(String str) {
        if (com.cfg.mendikot.b.s == a.a.f.a.RUN) {
            co.hyperverge.hypersnapsdk.c.k.app.postRunnable(new o());
        }
    }

    public void setVisible(boolean z2) {
        this.visible = z2;
        if (z2 || !this.E) {
            d dVar = this.f2594a;
            if (dVar != null) {
                ((com.cfg.mendikot.b) dVar).d(this.f2595b.f2678a);
                return;
            }
            return;
        }
        d dVar2 = this.f2594a;
        if (dVar2 != null) {
            ((com.cfg.mendikot.b) dVar2).c(this.f2595b.f2678a);
        }
    }

    public static void a(g gVar, ArrayList arrayList, HashSet hashSet) {
        a.a.d.c cVar = gVar.s;
        if (cVar != null) {
            for (int i2 = 0; i2 < cVar.f2472a.size(); i2++) {
                cVar.f2474c.removeActor(cVar.f2472a.get(i2));
            }
            cVar.f2477f = null;
            gVar.s = null;
        }
        a.a.d.c cVar2 = new a.a.d.c(gVar, gVar.u.c(), arrayList, hashSet, gVar);
        gVar.s = cVar2;
    }

    public static void a(g gVar, ConcurrentHashMap concurrentHashMap) {
        a.a.d.b bVar = gVar.t;
        if (bVar.f2465b != null) {
            bVar.b();
        }
        a.a.d.g gVar2 = bVar.f2466c;
        if (gVar2 != null) {
            bVar.removeActor(gVar2);
        }
        if (bVar.f2467d != null) {
            bVar.d();
        }
        if (bVar.f2468e != null) {
            bVar.e();
        }
        for (a.a.d.a aVar : concurrentHashMap.values()) {
            int intValue = gVar.f2597d.get(aVar.j).intValue();
            if (intValue == 0) {
                gVar.t.a(aVar, 0.0f);
            } else if (intValue == 1) {
                gVar.t.b(aVar, 0.0f);
            } else if (intValue == 2) {
                gVar.t.c(aVar, 0.0f);
            } else if (intValue == 3) {
                gVar.t.d(aVar);
            }
        }
    }

    public static void a(g gVar, String[] strArr) {
        gVar.f2596c.clear();
        gVar.f2596c.put(strArr[0], Integer.valueOf(0));
        gVar.f2596c.put(strArr[1], Integer.valueOf(1));
        gVar.f2596c.put(strArr[2], Integer.valueOf(2));
        gVar.f2596c.put(strArr[3], Integer.valueOf(3));
        gVar.f2596c.toString();
    }

    public final void a(boolean z2) {
        String str = this.f2595b.f2678a;
        boolean z3 = this.visible;
        this.E = z2;
        if (z3 || !z2) {
            d dVar = this.f2594a;
            if (dVar != null) {
                ((com.cfg.mendikot.b) dVar).d(this.f2595b.f2678a);
                return;
            }
            return;
        }
        d dVar2 = this.f2594a;
        if (dVar2 != null) {
            ((com.cfg.mendikot.b) dVar2).c(str);
        }
    }
}
