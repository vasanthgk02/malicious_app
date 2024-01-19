package a.a.j;

import a.a.a.a.d.b;
import a.a.k.d;
import a.a.l.i;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class e extends Group implements a {
    public Label A;
    public Label B;
    public Label C;
    public Label D;
    public Label E;
    public Label F;
    public Label G;
    public Label H;
    public Label I;
    public Label J;
    public Label K;
    public Label L;
    public Label M;
    public Label N;
    public Label O;
    public Label P;
    public Image Q;
    public Image R;
    public Image S;
    public Image T;
    public Image U;
    public String V = "Player ";
    public Label[] W;
    public Label[] X;
    public Label[][] Y;
    public String Z = "——";

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f2541a;
    public Label[] a0;

    /* renamed from: b  reason: collision with root package name */
    public Image f2542b;
    public Label[] b0;

    /* renamed from: c  reason: collision with root package name */
    public Label f2543c;
    public Image[] c0;

    /* renamed from: d  reason: collision with root package name */
    public Label f2544d;
    public float d0 = 710.0f;
    public float e0 = 935.0f;
    public float f0 = 1270.0f;
    public float g0 = 1480.0f;
    public float h0 = 648.0f;
    public Label i;
    public float i0 = (710.0f - 20.0f);
    public Label j;
    public float j0 = (1270.0f - 20.0f);
    public Label k;
    public float k0 = 750.0f;
    public Label l;
    public float l0 = 480.0f;
    public Label m;
    public float m0 = 710.0f;
    public Label n;
    public float n0 = 960.0f;
    public Label o;
    public float o0 = 1270.0f;
    public Label p;
    public float p0 = 1500.0f;
    public Label q;
    public float q0 = 480.0f;
    public Label r;
    public float r0 = 415.0f;
    public Label s;
    public float s0 = 350.0f;
    public Label t;
    public float t0 = 276.0f;
    public Label u;
    public float u0 = 214.0f;
    public Label v;
    public float v0 = 140.0f;
    public Label w;
    public float w0 = 35.0f;
    public Label z;

    public class a extends InputListener {
        public a() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            e.this.visible = false;
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [com.badlogic.gdx.scenes.scene2d.Group, com.badlogic.gdx.scenes.scene2d.Actor, a.a.j.e] */
    public e(i iVar) {
        new HashMap();
        this.f2541a = new HashMap<>();
        Image image = new Image(b.f2412b.a("scoreboard_round5"));
        this.f2542b = image;
        image.setPosition(0.0f, -20.0f);
        this.f2542b.setSize(2160.0f, 1080.0f);
        addActor(this.f2542b);
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle.fontColor = Color.WHITE;
        Label label = new Label("Team A", labelStyle);
        this.f2543c = label;
        label.setAlignment(1);
        Label label2 = this.f2543c;
        label2.wrap = true;
        label2.invalidateHierarchy();
        this.f2543c.setFontScale(1.2f);
        Label label3 = this.f2543c;
        float f2 = com.cfg.mendikot.a.p;
        float f3 = com.cfg.mendikot.a.r;
        label3.setSize(500.0f, 120.0f);
        this.f2543c.setPosition(this.i0, this.k0);
        this.f2543c.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline25 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.f2543c);
        outline25.font = b.f2414d.a("Rajdhani-Bold");
        outline25.fontColor = Color.WHITE;
        Label label4 = new Label("Team B", outline25);
        this.f2544d = label4;
        label4.setAlignment(1);
        Label label5 = this.f2544d;
        label5.wrap = true;
        label5.invalidateHierarchy();
        this.f2544d.setFontScale(1.2f);
        Label label6 = this.f2544d;
        float f4 = com.cfg.mendikot.a.p;
        float f5 = com.cfg.mendikot.a.r;
        label6.setSize(500.0f, 120.0f);
        this.f2544d.setPosition(this.j0, this.k0);
        this.f2544d.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline252 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.f2544d);
        outline252.font = b.f2414d.a("Rajdhani-Bold");
        outline252.fontColor = Color.WHITE;
        Label label7 = new Label(this.Z, outline252);
        this.m = label7;
        label7.setAlignment(16);
        Label label8 = this.m;
        label8.wrap = true;
        label8.invalidateHierarchy();
        this.m.setFontScale(1.0f);
        this.m.setSize(120.0f, 120.0f);
        this.m.setPosition(this.m0, this.q0);
        this.m.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline253 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.m);
        outline253.font = b.f2414d.a("Rajdhani-Bold");
        outline253.fontColor = Color.WHITE;
        Label label9 = new Label(this.Z, outline253);
        this.n = label9;
        label9.setAlignment(16);
        Label label10 = this.n;
        label10.wrap = true;
        label10.invalidateHierarchy();
        this.n.setFontScale(1.0f);
        this.n.setSize(120.0f, 120.0f);
        this.n.setPosition(this.n0, this.q0);
        this.n.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline254 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.n);
        outline254.font = b.f2414d.a("Rajdhani-Bold");
        outline254.fontColor = Color.WHITE;
        Label label11 = new Label(this.Z, outline254);
        this.o = label11;
        label11.setAlignment(16);
        Label label12 = this.o;
        label12.wrap = true;
        label12.invalidateHierarchy();
        this.o.setFontScale(1.0f);
        this.o.setSize(120.0f, 120.0f);
        this.o.setPosition(this.o0, this.q0);
        this.o.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline255 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.o);
        outline255.font = b.f2414d.a("Rajdhani-Bold");
        outline255.fontColor = Color.WHITE;
        Label label13 = new Label(this.Z, outline255);
        this.p = label13;
        label13.setAlignment(16);
        Label label14 = this.p;
        label14.wrap = true;
        label14.invalidateHierarchy();
        this.p.setFontScale(1.0f);
        this.p.setSize(120.0f, 120.0f);
        this.p.setPosition(this.p0, this.q0);
        this.p.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline256 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.p);
        outline256.font = b.f2414d.a("Rajdhani-Bold");
        outline256.fontColor = Color.WHITE;
        Label label15 = new Label(this.Z, outline256);
        this.q = label15;
        label15.setAlignment(16);
        Label label16 = this.q;
        label16.wrap = true;
        label16.invalidateHierarchy();
        this.q.setFontScale(1.0f);
        this.q.setSize(120.0f, 120.0f);
        this.q.setPosition(this.m0, this.r0);
        this.q.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline257 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.q);
        outline257.font = b.f2414d.a("Rajdhani-Bold");
        outline257.fontColor = Color.WHITE;
        Label label17 = new Label(this.Z, outline257);
        this.r = label17;
        label17.setAlignment(16);
        Label label18 = this.r;
        label18.wrap = true;
        label18.invalidateHierarchy();
        this.r.setFontScale(1.0f);
        this.r.setSize(120.0f, 120.0f);
        this.r.setPosition(this.n0, this.r0);
        this.r.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline258 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.r);
        outline258.font = b.f2414d.a("Rajdhani-Bold");
        outline258.fontColor = Color.WHITE;
        Label label19 = new Label(this.Z, outline258);
        this.s = label19;
        label19.setAlignment(16);
        Label label20 = this.s;
        label20.wrap = true;
        label20.invalidateHierarchy();
        this.s.setFontScale(1.0f);
        this.s.setSize(120.0f, 120.0f);
        this.s.setPosition(this.o0, this.r0);
        this.s.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline259 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.s);
        outline259.font = b.f2414d.a("Rajdhani-Bold");
        outline259.fontColor = Color.WHITE;
        Label label21 = new Label(this.Z, outline259);
        this.t = label21;
        label21.setAlignment(16);
        Label label22 = this.t;
        label22.wrap = true;
        label22.invalidateHierarchy();
        this.t.setFontScale(1.0f);
        this.t.setSize(120.0f, 120.0f);
        this.t.setPosition(this.p0, this.r0);
        this.t.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2510 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.t);
        outline2510.font = b.f2414d.a("Rajdhani-Bold");
        outline2510.fontColor = Color.WHITE;
        Label label23 = new Label(this.Z, outline2510);
        this.u = label23;
        label23.setAlignment(16);
        Label label24 = this.u;
        label24.wrap = true;
        label24.invalidateHierarchy();
        this.u.setFontScale(1.0f);
        this.u.setSize(120.0f, 120.0f);
        this.u.setPosition(this.m0, this.s0);
        this.u.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2511 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.u);
        outline2511.font = b.f2414d.a("Rajdhani-Bold");
        outline2511.fontColor = Color.WHITE;
        Label label25 = new Label(this.Z, outline2511);
        this.v = label25;
        label25.setAlignment(16);
        Label label26 = this.v;
        label26.wrap = true;
        label26.invalidateHierarchy();
        this.v.setFontScale(1.0f);
        this.v.setSize(120.0f, 120.0f);
        this.v.setPosition(this.n0, this.s0);
        this.v.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2512 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.v);
        outline2512.font = b.f2414d.a("Rajdhani-Bold");
        outline2512.fontColor = Color.WHITE;
        Label label27 = new Label(this.Z, outline2512);
        this.w = label27;
        label27.setAlignment(16);
        Label label28 = this.w;
        label28.wrap = true;
        label28.invalidateHierarchy();
        this.w.setFontScale(1.0f);
        this.w.setSize(120.0f, 120.0f);
        this.w.setPosition(this.o0, this.s0);
        this.w.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2513 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.w);
        outline2513.font = b.f2414d.a("Rajdhani-Bold");
        outline2513.fontColor = Color.WHITE;
        Label label29 = new Label(this.Z, outline2513);
        this.z = label29;
        label29.setAlignment(16);
        Label label30 = this.z;
        label30.wrap = true;
        label30.invalidateHierarchy();
        this.z.setFontScale(1.0f);
        this.z.setSize(120.0f, 120.0f);
        this.z.setPosition(this.p0, this.s0);
        this.z.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2514 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.z);
        outline2514.font = b.f2414d.a("Rajdhani-Bold");
        outline2514.fontColor = Color.WHITE;
        Label label31 = new Label(this.Z, outline2514);
        this.A = label31;
        label31.setAlignment(16);
        Label label32 = this.A;
        label32.wrap = true;
        label32.invalidateHierarchy();
        this.A.setFontScale(1.0f);
        this.A.setSize(120.0f, 120.0f);
        this.A.setPosition(this.m0, this.t0);
        this.A.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2515 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.A);
        outline2515.font = b.f2414d.a("Rajdhani-Bold");
        outline2515.fontColor = Color.WHITE;
        Label label33 = new Label(this.Z, outline2515);
        this.B = label33;
        label33.setAlignment(16);
        Label label34 = this.B;
        label34.wrap = true;
        label34.invalidateHierarchy();
        this.B.setFontScale(1.0f);
        this.B.setSize(120.0f, 120.0f);
        this.B.setPosition(this.n0, this.t0);
        this.B.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2516 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.B);
        outline2516.font = b.f2414d.a("Rajdhani-Bold");
        outline2516.fontColor = Color.WHITE;
        Label label35 = new Label(this.Z, outline2516);
        this.C = label35;
        label35.setAlignment(16);
        Label label36 = this.C;
        label36.wrap = true;
        label36.invalidateHierarchy();
        this.C.setFontScale(1.0f);
        this.C.setSize(120.0f, 120.0f);
        this.C.setPosition(this.o0, this.t0);
        this.C.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2517 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.C);
        outline2517.font = b.f2414d.a("Rajdhani-Bold");
        outline2517.fontColor = Color.WHITE;
        Label label37 = new Label(this.Z, outline2517);
        this.D = label37;
        label37.setAlignment(16);
        Label label38 = this.D;
        label38.wrap = true;
        label38.invalidateHierarchy();
        this.D.setFontScale(1.0f);
        this.D.setSize(120.0f, 120.0f);
        this.D.setPosition(this.p0, this.t0);
        this.D.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2518 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.D);
        outline2518.font = b.f2414d.a("Rajdhani-Bold");
        outline2518.fontColor = Color.WHITE;
        Label label39 = new Label(this.Z, outline2518);
        this.E = label39;
        label39.setAlignment(16);
        Label label40 = this.E;
        label40.wrap = true;
        label40.invalidateHierarchy();
        this.E.setFontScale(1.0f);
        this.E.setSize(120.0f, 120.0f);
        this.E.setPosition(this.m0, this.u0);
        this.E.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2519 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.E);
        outline2519.font = b.f2414d.a("Rajdhani-Bold");
        outline2519.fontColor = Color.WHITE;
        Label label41 = new Label(this.Z, outline2519);
        this.F = label41;
        label41.setAlignment(16);
        Label label42 = this.F;
        label42.wrap = true;
        label42.invalidateHierarchy();
        this.F.setFontScale(1.0f);
        this.F.setSize(120.0f, 120.0f);
        this.F.setPosition(this.n0, this.u0);
        this.F.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2520 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.F);
        outline2520.font = b.f2414d.a("Rajdhani-Bold");
        outline2520.fontColor = Color.WHITE;
        Label label43 = new Label(this.Z, outline2520);
        this.G = label43;
        label43.setAlignment(16);
        Label label44 = this.G;
        label44.wrap = true;
        label44.invalidateHierarchy();
        this.G.setFontScale(1.0f);
        this.G.setSize(120.0f, 120.0f);
        this.G.setPosition(this.o0, this.u0);
        this.G.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2521 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.G);
        outline2521.font = b.f2414d.a("Rajdhani-Bold");
        outline2521.fontColor = Color.WHITE;
        Label label45 = new Label(this.Z, outline2521);
        this.H = label45;
        label45.setAlignment(16);
        Label label46 = this.H;
        label46.wrap = true;
        label46.invalidateHierarchy();
        this.H.setFontScale(1.0f);
        this.H.setSize(120.0f, 120.0f);
        this.H.setPosition(this.p0, this.u0);
        this.H.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2522 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.H);
        outline2522.font = b.f2414d.a("Rajdhani-Bold");
        outline2522.fontColor = Color.BLACK;
        Label label47 = new Label(this.Z, outline2522);
        this.I = label47;
        label47.setAlignment(16);
        Label label48 = this.I;
        label48.wrap = true;
        label48.invalidateHierarchy();
        this.I.setFontScale(1.1f);
        this.I.setSize(120.0f, 120.0f);
        this.I.setPosition(this.m0, this.v0);
        this.I.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2523 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.I);
        outline2523.font = b.f2414d.a("Rajdhani-Bold");
        outline2523.fontColor = Color.BLACK;
        Label label49 = new Label(this.Z, outline2523);
        this.J = label49;
        label49.setAlignment(16);
        Label label50 = this.J;
        label50.wrap = true;
        label50.invalidateHierarchy();
        this.J.setFontScale(1.1f);
        this.J.setSize(120.0f, 120.0f);
        this.J.setPosition(this.n0 + 1.0f, this.v0);
        this.J.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2524 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.J);
        outline2524.font = b.f2414d.a("Rajdhani-Bold");
        outline2524.fontColor = Color.BLACK;
        Label label51 = new Label(this.Z, outline2524);
        this.K = label51;
        label51.setAlignment(16);
        Label label52 = this.K;
        label52.wrap = true;
        label52.invalidateHierarchy();
        this.K.setFontScale(1.1f);
        this.K.setSize(120.0f, 120.0f);
        this.K.setPosition(this.o0 + 2.0f, this.v0);
        this.K.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2525 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.K);
        outline2525.font = b.f2414d.a("Rajdhani-Bold");
        outline2525.fontColor = Color.BLACK;
        Label label53 = new Label(this.Z, outline2525);
        this.L = label53;
        label53.setAlignment(16);
        Label label54 = this.L;
        label54.wrap = true;
        label54.invalidateHierarchy();
        this.L.setFontScale(1.1f);
        this.L.setSize(120.0f, 120.0f);
        this.L.setPosition(this.p0 + 2.0f, this.v0);
        this.L.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2526 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.L);
        outline2526.font = b.f2414d.a("Rajdhani-Bold");
        outline2526.fontColor = Color.BLACK;
        Label label55 = new Label(this.Z, outline2526);
        this.M = label55;
        label55.setAlignment(16);
        Label label56 = this.M;
        label56.wrap = true;
        label56.invalidateHierarchy();
        this.M.setFontScale(1.1f);
        this.M.setSize(120.0f, 120.0f);
        this.M.setPosition(this.m0, this.w0);
        this.M.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2527 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.M);
        outline2527.font = b.f2414d.a("Rajdhani-Bold");
        outline2527.fontColor = Color.BLACK;
        Label label57 = new Label(this.Z, outline2527);
        this.N = label57;
        label57.setAlignment(16);
        Label label58 = this.N;
        label58.wrap = true;
        label58.invalidateHierarchy();
        this.N.setFontScale(1.1f);
        this.N.setSize(120.0f, 120.0f);
        this.N.setPosition(this.n0 + 1.0f, this.w0);
        this.N.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2528 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.N);
        outline2528.font = b.f2414d.a("Rajdhani-Bold");
        outline2528.fontColor = Color.BLACK;
        Label label59 = new Label(this.Z, outline2528);
        this.O = label59;
        label59.setAlignment(16);
        Label label60 = this.O;
        label60.wrap = true;
        label60.invalidateHierarchy();
        this.O.setFontScale(1.1f);
        this.O.setSize(120.0f, 120.0f);
        this.O.setPosition(this.o0 + 2.0f, this.w0);
        this.O.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2529 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.O);
        outline2529.font = b.f2414d.a("Rajdhani-Bold");
        outline2529.fontColor = Color.BLACK;
        Label label61 = new Label(this.Z, outline2529);
        this.P = label61;
        label61.setAlignment(16);
        Label label62 = this.P;
        label62.wrap = true;
        label62.invalidateHierarchy();
        this.P.setFontScale(1.1f);
        this.P.setSize(120.0f, 120.0f);
        this.P.setPosition(this.p0 + 2.0f, this.w0);
        this.P.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        addActorAfter(this.f2542b, this.P);
        Image image2 = new Image(b.f2412b.a("winner_ribbon"));
        this.U = image2;
        image2.setPosition(this.i0 + 10.0f, this.k0);
        this.U.setSize(94.0f, 94.0f);
        Image image3 = this.U;
        image3.visible = false;
        addActorAfter(this.f2542b, image3);
        LabelStyle labelStyle2 = new LabelStyle();
        labelStyle2.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle2.fontColor = Color.WHITE;
        Label label63 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.V, 1), labelStyle2);
        this.i = label63;
        label63.setAlignment(1);
        Label label64 = this.i;
        label64.wrap = true;
        label64.invalidateHierarchy();
        this.i.setFontScale(1.0f);
        Label label65 = this.i;
        float f6 = com.cfg.mendikot.a.p;
        float f7 = com.cfg.mendikot.a.q;
        label65.setSize(240.0f, 310.0f);
        this.i.setPosition(this.d0, this.l0);
        this.i.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2530 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.i);
        outline2530.font = b.f2414d.a("Rajdhani-Bold");
        outline2530.fontColor = Color.WHITE;
        Label label66 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.V, 2), outline2530);
        this.j = label66;
        label66.setAlignment(1);
        Label label67 = this.j;
        label67.wrap = true;
        label67.invalidateHierarchy();
        this.j.setFontScale(1.0f);
        Label label68 = this.j;
        float f8 = com.cfg.mendikot.a.p;
        float f9 = com.cfg.mendikot.a.q;
        label68.setSize(240.0f, 310.0f);
        this.j.setPosition(this.e0, this.l0);
        this.j.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2531 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.j);
        outline2531.font = b.f2414d.a("Rajdhani-Bold");
        outline2531.fontColor = Color.WHITE;
        Label label69 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.V, 3), outline2531);
        this.k = label69;
        label69.setAlignment(1);
        Label label70 = this.k;
        label70.wrap = true;
        label70.invalidateHierarchy();
        this.k.setFontScale(1.0f);
        Label label71 = this.k;
        float f10 = com.cfg.mendikot.a.p;
        float f11 = com.cfg.mendikot.a.q;
        label71.setSize(240.0f, 310.0f);
        this.k.setPosition(this.f0, this.l0);
        this.k.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2532 = GeneratedOutlineSupport.outline25(this, this.f2542b, this.k);
        outline2532.font = b.f2414d.a("Rajdhani-Bold");
        outline2532.fontColor = Color.WHITE;
        Label label72 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.V, 4), outline2532);
        this.l = label72;
        label72.setAlignment(1);
        Label label73 = this.l;
        label73.wrap = true;
        label73.invalidateHierarchy();
        this.l.setFontScale(1.0f);
        Label label74 = this.l;
        float f12 = com.cfg.mendikot.a.p;
        float f13 = com.cfg.mendikot.a.q;
        label74.setSize(240.0f, 310.0f);
        this.l.setPosition(this.g0, this.l0);
        this.l.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        addActorAfter(this.f2542b, this.l);
        Image image4 = new Image(b.f2412b.a("pp1"));
        this.Q = image4;
        image4.setPosition(this.d0 + 40.0f, this.h0);
        Image image5 = this.Q;
        float f14 = com.cfg.mendikot.a.p;
        image5.setSize(160.0f, 160.0f);
        Image image6 = this.Q;
        image6.visible = true;
        addActorAfter(null, image6);
        Image image7 = new Image(b.f2412b.a("pp2"));
        this.R = image7;
        image7.setPosition(this.e0 + 40.0f, this.h0);
        Image image8 = this.R;
        float f15 = com.cfg.mendikot.a.p;
        image8.setSize(160.0f, 160.0f);
        Image image9 = this.R;
        image9.visible = true;
        addActorAfter(null, image9);
        Image image10 = new Image(b.f2412b.a("pp3"));
        this.S = image10;
        image10.setPosition(this.f0 + 40.0f, this.h0);
        Image image11 = this.S;
        float f16 = com.cfg.mendikot.a.p;
        image11.setSize(160.0f, 160.0f);
        Image image12 = this.S;
        image12.visible = true;
        addActorAfter(null, image12);
        Image image13 = new Image(b.f2412b.a("pp4"));
        this.T = image13;
        image13.setPosition(this.g0 + 40.0f, this.h0);
        Image image14 = this.T;
        float f17 = com.cfg.mendikot.a.p;
        image14.setSize(160.0f, 160.0f);
        Image image15 = this.T;
        image15.visible = true;
        addActorAfter(null, image15);
        this.Y = new Label[][]{new Label[]{this.m, this.n, this.o, this.p}, new Label[]{this.q, this.r, this.s, this.t}, new Label[]{this.u, this.v, this.w, this.z}, new Label[]{this.A, this.B, this.C, this.D}, new Label[]{this.E, this.F, this.G, this.H}};
        this.a0 = new Label[]{this.I, this.J, this.K, this.L};
        this.b0 = new Label[]{this.M, this.N, this.O, this.P};
        this.c0 = new Image[]{this.Q, this.R, this.S, this.T};
        this.W = new Label[]{this.i, this.j, this.k, this.l};
        this.X = new Label[]{this.f2543c, this.f2544d};
        this.touchable = Touchable.enabled;
        this.visible = false;
        addListener(new a());
    }

    public final Drawable a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? new TextureRegionDrawable() : new TextureRegionDrawable(b.f2412b.a("pp4")) : new TextureRegionDrawable(b.f2412b.a("pp3")) : new TextureRegionDrawable(b.f2412b.a("pp2")) : new TextureRegionDrawable(b.f2412b.a("pp1"));
    }

    public void a(String str) {
    }

    public void a(ConcurrentHashMap<String, Integer> concurrentHashMap, ConcurrentHashMap<String, d> concurrentHashMap2, HashMap<String, b> hashMap, ConcurrentHashMap<String, f> concurrentHashMap3) {
        float f2;
        Image image;
        float f3;
        HashMap<String, b> hashMap2 = hashMap;
        if (hashMap2 != null && concurrentHashMap3 != null) {
            try {
                Iterator<Entry<String, f>> it = concurrentHashMap3.entrySet().iterator();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = 1;
                    if (it.hasNext()) {
                        Entry next = it.next();
                        String str = (String) next.getKey();
                        f fVar = (f) next.getValue();
                        if (i2 < 2) {
                            Iterator<String> it2 = fVar.f2549d.iterator();
                            while (it2.hasNext()) {
                                b bVar = hashMap2.get(it2.next());
                                if (i3 < 4) {
                                    Label label = this.a0[i3];
                                    StringBuilder sb = new StringBuilder();
                                    double pow = (double) ((int) Math.pow(10.0d, (double) i4));
                                    sb.append(((double) Math.round(((double) bVar.f2526a) * pow)) / pow);
                                    sb.append("");
                                    label.setText((CharSequence) sb.toString());
                                    Label label2 = this.b0[i3];
                                    label2.setText((CharSequence) "₹ " + bVar.f2527b);
                                    if (!bVar.f2528c || i3 >= 2) {
                                        if (bVar.f2528c) {
                                            if (i3 >= 2) {
                                                image = this.U;
                                                float f4 = this.j0 - 4.0f;
                                                f2 = f4;
                                                f3 = this.k0;
                                            }
                                        }
                                        i3++;
                                        i4 = 1;
                                    } else {
                                        Image image2 = this.U;
                                        f3 = this.k0;
                                        f2 = this.i0 - 4.0f;
                                        image = image2;
                                    }
                                    image.setPosition(f2, f3);
                                    i3++;
                                    i4 = 1;
                                }
                            }
                            i2++;
                        }
                    } else {
                        this.U.visible = true;
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b() {
        this.visible = false;
    }

    public Actor c() {
        return this;
    }

    public final void d() {
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                this.Y[i3][i2].setText((CharSequence) this.Z);
                Label label = this.Y[i3][i2];
                label.color.set(Color.WHITE);
            }
            this.a0[i2].setText((CharSequence) this.Z);
            Label label2 = this.a0[i2];
            label2.color.set(Color.BLACK);
            this.b0[i2].setText((CharSequence) this.Z);
            Label label3 = this.b0[i2];
            label3.color.set(Color.BLACK);
        }
    }

    public void a(ConcurrentHashMap<String, Integer> concurrentHashMap, ConcurrentHashMap<String, d> concurrentHashMap2, ConcurrentHashMap<String, String> concurrentHashMap3, ConcurrentHashMap<String, f> concurrentHashMap4) {
        if (concurrentHashMap4 != null) {
            try {
                int i2 = 0;
                int i3 = 0;
                for (Entry next : concurrentHashMap4.entrySet()) {
                    String str = (String) next.getKey();
                    f fVar = (f) next.getValue();
                    if (i2 < 2) {
                        this.X[i2].setText((CharSequence) "TEAM " + str);
                        this.f2541a.put(str, Integer.valueOf(i2));
                        Iterator<String> it = fVar.f2549d.iterator();
                        while (it.hasNext()) {
                            String next2 = it.next();
                            if (i3 < 4) {
                                String str2 = concurrentHashMap2.get(next2).f2567b;
                                if (str2.length() > 10) {
                                    String substring = str2.substring(0, 9);
                                    str2 = substring + "...";
                                }
                                this.W[i3].setText((CharSequence) str2);
                                this.c0[i3].setDrawable(a(concurrentHashMap.get(next2).intValue()));
                                i3++;
                            }
                        }
                        i2++;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(boolean z2, ConcurrentHashMap<String, Integer> concurrentHashMap, HashMap<String, f>[] hashMapArr, ConcurrentHashMap<String, String> concurrentHashMap2, boolean z3) {
        try {
            d();
            if (hashMapArr != null) {
                for (int i2 = 0; i2 < hashMapArr.length; i2++) {
                    HashMap<String, f> hashMap = hashMapArr[i2];
                    for (String next : hashMap.keySet()) {
                        f fVar = hashMap.get(next);
                        int intValue = this.f2541a.get(next).intValue() * 2;
                        Label label = this.Y[i2][intValue];
                        label.setText((CharSequence) fVar.f2546a + "");
                        Label label2 = this.Y[i2][intValue + 1];
                        label2.setText((CharSequence) fVar.f2546a + "");
                    }
                }
            }
            this.visible = z3;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        this.visible = true;
    }
}
