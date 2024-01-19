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

public class c extends Group implements a {
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
    public Image K;
    public Image L;
    public Image M;
    public Image N;
    public Label O;
    public Label P;
    public Label Q;
    public Label R;
    public Label S;
    public Label T;
    public float U = 430.0f;
    public float V = 690.0f;
    public float W = 1230.0f;
    public float X = 1490.0f;
    public float Y = 380.0f;
    public float Z = 430.0f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f2529a;
    public float a0 = 1230.0f;

    /* renamed from: b  reason: collision with root package name */
    public String f2530b = "Playing";
    public float b0 = 670.0f;

    /* renamed from: c  reason: collision with root package name */
    public String f2531c = "Player ";
    public float c0 = 600.0f;

    /* renamed from: d  reason: collision with root package name */
    public Label[] f2532d;
    public float d0 = 560.0f;

    /* renamed from: e  reason: collision with root package name */
    public Label[] f2533e;
    public float e0 = 520.0f;

    /* renamed from: f  reason: collision with root package name */
    public Label[] f2534f;
    public float f0 = 395.0f;
    public Label[] g;
    public float g0 = (690.0f + 30.0f);
    public Label[] h;
    public float h0 = (1490.0f + 30.0f);
    public String i = "—";
    public float i0 = 275.0f;
    public String j = "—";
    public float j0 = 232.0f;
    public Image[] k;
    public float k0 = 189.0f;
    public Image[] l;
    public Label[] m;
    public Label[] n;
    public Image o;
    public Image p;
    public Label q;
    public Label r;
    public Image s;
    public Image t;
    public Image u;
    public Image v;
    public Label w;
    public Label z;

    public class a extends InputListener {
        public a() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            c.this.visible = false;
            return false;
        }
    }

    public c(i iVar) {
        new HashMap();
        this.f2529a = new HashMap<>();
        Image image = new Image(b.f2412b.a("scoreboard_round_over"));
        this.o = image;
        image.setPosition(0.0f, 0.0f);
        this.o.setSize(2170.0f, 1085.0f);
        addActor(this.o);
        Image image2 = new Image(b.f2412b.a("close"));
        this.p = image2;
        float f2 = com.cfg.mendikot.a.v;
        float f3 = com.cfg.mendikot.a.w;
        image2.setPosition(1900.0f, 880.0f);
        Image image3 = this.p;
        float f4 = com.cfg.mendikot.a.u;
        float f5 = com.cfg.mendikot.a.t;
        image3.setSize(100.0f, 100.0f);
        this.p.addListener(new a());
        Image image4 = this.p;
        image4.touchable = Touchable.enabled;
        addActor(image4);
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle.fontColor = Color.WHITE;
        Label label = new Label("Team A", labelStyle);
        this.q = label;
        label.setAlignment(1);
        Label label2 = this.q;
        label2.wrap = true;
        label2.invalidateHierarchy();
        this.q.setFontScale(1.4f);
        Label label3 = this.q;
        float f6 = com.cfg.mendikot.a.p;
        float f7 = com.cfg.mendikot.a.r;
        label3.setSize(500.0f, 120.0f);
        this.q.setPosition(this.Z, this.b0);
        this.q.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline23 = GeneratedOutlineSupport.outline23(this, this.o, this.q);
        outline23.font = b.f2414d.a("Rajdhani-Bold");
        outline23.fontColor = Color.WHITE;
        Label label4 = new Label("Team B", outline23);
        this.r = label4;
        label4.setAlignment(1);
        Label label5 = this.r;
        label5.wrap = true;
        label5.invalidateHierarchy();
        this.r.setFontScale(1.4f);
        Label label6 = this.r;
        float f8 = com.cfg.mendikot.a.p;
        float f9 = com.cfg.mendikot.a.r;
        label6.setSize(500.0f, 120.0f);
        this.r.setPosition(this.a0, this.b0);
        this.r.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        addActorAfter(this.o, this.r);
        Image image5 = new Image(b.f2412b.a("lose"));
        this.s = image5;
        image5.setPosition(this.U, this.Y);
        Image image6 = this.s;
        float f10 = com.cfg.mendikot.a.p;
        float f11 = com.cfg.mendikot.a.q;
        image6.setSize(240.0f, 310.0f);
        Image image7 = this.s;
        image7.visible = true;
        addActor(image7);
        Image image8 = new Image(b.f2412b.a("lose"));
        this.t = image8;
        image8.setPosition(this.V, this.Y);
        Image image9 = this.t;
        float f12 = com.cfg.mendikot.a.p;
        float f13 = com.cfg.mendikot.a.q;
        image9.setSize(240.0f, 310.0f);
        Image image10 = this.t;
        image10.visible = true;
        addActor(image10);
        Image image11 = new Image(b.f2412b.a("lose"));
        this.u = image11;
        image11.setPosition(this.W, this.Y);
        Image image12 = this.u;
        float f14 = com.cfg.mendikot.a.p;
        float f15 = com.cfg.mendikot.a.q;
        image12.setSize(240.0f, 310.0f);
        Image image13 = this.u;
        image13.visible = true;
        addActor(image13);
        Image image14 = new Image(b.f2412b.a("lose"));
        this.v = image14;
        image14.setPosition(this.X, this.Y);
        Image image15 = this.v;
        float f16 = com.cfg.mendikot.a.p;
        float f17 = com.cfg.mendikot.a.q;
        image15.setSize(240.0f, 310.0f);
        Image image16 = this.v;
        image16.visible = true;
        addActor(image16);
        LabelStyle labelStyle2 = new LabelStyle();
        labelStyle2.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle2.fontColor = Color.WHITE;
        Label label7 = new Label(this.f2530b, labelStyle2);
        this.C = label7;
        label7.setAlignment(1);
        Label label8 = this.C;
        label8.wrap = true;
        label8.invalidateHierarchy();
        this.C.setFontScale(1.0f);
        Label label9 = this.C;
        float f18 = com.cfg.mendikot.a.s;
        float f19 = com.cfg.mendikot.a.r;
        label9.setSize(240.0f, 110.0f);
        this.C.setPosition(this.U, this.d0);
        this.C.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline232 = GeneratedOutlineSupport.outline23(this, this.s, this.C);
        outline232.font = b.f2414d.a("Rajdhani-Bold");
        outline232.fontColor = Color.WHITE;
        Label label10 = new Label(this.f2530b, outline232);
        this.D = label10;
        label10.setAlignment(1);
        Label label11 = this.D;
        label11.wrap = true;
        label11.invalidateHierarchy();
        this.D.setFontScale(1.0f);
        Label label12 = this.D;
        float f20 = com.cfg.mendikot.a.s;
        float f21 = com.cfg.mendikot.a.r;
        label12.setSize(240.0f, 110.0f);
        this.D.setPosition(this.V, this.d0);
        this.D.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline233 = GeneratedOutlineSupport.outline23(this, this.t, this.D);
        outline233.font = b.f2414d.a("Rajdhani-Bold");
        outline233.fontColor = Color.WHITE;
        Label label13 = new Label(this.f2530b, outline233);
        this.E = label13;
        label13.setAlignment(1);
        Label label14 = this.E;
        label14.wrap = true;
        label14.invalidateHierarchy();
        this.E.setFontScale(1.0f);
        Label label15 = this.E;
        float f22 = com.cfg.mendikot.a.s;
        float f23 = com.cfg.mendikot.a.r;
        label15.setSize(240.0f, 110.0f);
        this.E.setPosition(this.W, this.d0);
        this.E.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline234 = GeneratedOutlineSupport.outline23(this, this.u, this.E);
        outline234.font = b.f2414d.a("Rajdhani-Bold");
        outline234.fontColor = Color.WHITE;
        Label label16 = new Label(this.f2530b, outline234);
        this.F = label16;
        label16.setAlignment(1);
        Label label17 = this.F;
        label17.wrap = true;
        label17.invalidateHierarchy();
        this.F.setFontScale(1.0f);
        Label label18 = this.F;
        float f24 = com.cfg.mendikot.a.s;
        float f25 = com.cfg.mendikot.a.r;
        label18.setSize(240.0f, 110.0f);
        this.F.setPosition(this.X, this.d0);
        this.F.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline235 = GeneratedOutlineSupport.outline23(this, this.v, this.F);
        outline235.font = b.f2414d.a("Rajdhani-Bold");
        outline235.fontColor = Color.WHITE;
        Label label19 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.f2531c, 1), outline235);
        this.w = label19;
        label19.setAlignment(1);
        Label label20 = this.w;
        label20.wrap = true;
        label20.invalidateHierarchy();
        this.w.setFontScale(1.0f);
        Label label21 = this.w;
        float f26 = com.cfg.mendikot.a.s;
        float f27 = com.cfg.mendikot.a.r;
        label21.setSize(240.0f, 110.0f);
        this.w.setPosition(this.U, this.c0);
        this.w.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline236 = GeneratedOutlineSupport.outline23(this, this.s, this.w);
        outline236.font = b.f2414d.a("Rajdhani-Bold");
        outline236.fontColor = Color.WHITE;
        Label label22 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.f2531c, 2), outline236);
        this.z = label22;
        label22.setAlignment(1);
        Label label23 = this.z;
        label23.wrap = true;
        label23.invalidateHierarchy();
        this.z.setFontScale(1.0f);
        Label label24 = this.z;
        float f28 = com.cfg.mendikot.a.s;
        float f29 = com.cfg.mendikot.a.r;
        label24.setSize(240.0f, 110.0f);
        this.z.setPosition(this.V, this.c0);
        this.z.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline237 = GeneratedOutlineSupport.outline23(this, this.t, this.z);
        outline237.font = b.f2414d.a("Rajdhani-Bold");
        outline237.fontColor = Color.WHITE;
        Label label25 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.f2531c, 3), outline237);
        this.A = label25;
        label25.setAlignment(1);
        Label label26 = this.A;
        label26.wrap = true;
        label26.invalidateHierarchy();
        this.A.setFontScale(1.0f);
        Label label27 = this.A;
        float f30 = com.cfg.mendikot.a.s;
        float f31 = com.cfg.mendikot.a.r;
        label27.setSize(240.0f, 110.0f);
        this.A.setPosition(this.W, this.c0);
        this.A.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline238 = GeneratedOutlineSupport.outline23(this, this.u, this.A);
        outline238.font = b.f2414d.a("Rajdhani-Bold");
        outline238.fontColor = Color.WHITE;
        Label label28 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.f2531c, 4), outline238);
        this.B = label28;
        label28.setAlignment(1);
        Label label29 = this.B;
        label29.wrap = true;
        label29.invalidateHierarchy();
        this.B.setFontScale(1.0f);
        Label label30 = this.B;
        float f32 = com.cfg.mendikot.a.s;
        float f33 = com.cfg.mendikot.a.r;
        label30.setSize(240.0f, 110.0f);
        this.B.setPosition(this.X, this.c0);
        this.B.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline239 = GeneratedOutlineSupport.outline23(this, this.v, this.B);
        outline239.font = b.f2414d.a("Rajdhani-Bold");
        outline239.fontColor = Color.WHITE;
        Label label31 = new Label(this.i, outline239);
        this.G = label31;
        label31.setAlignment(1);
        Label label32 = this.G;
        label32.wrap = true;
        label32.invalidateHierarchy();
        this.G.setFontScale(1.2f);
        Label label33 = this.G;
        float f34 = com.cfg.mendikot.a.s;
        float f35 = com.cfg.mendikot.a.r;
        label33.setSize(240.0f, 110.0f);
        this.G.setPosition(this.U, this.e0);
        this.G.color.set(10.0f, 255.0f, 10.0f, 1.0f);
        LabelStyle outline2310 = GeneratedOutlineSupport.outline23(this, this.s, this.G);
        outline2310.font = b.f2414d.a("Rajdhani-Bold");
        outline2310.fontColor = Color.WHITE;
        Label label34 = new Label(this.i, outline2310);
        this.H = label34;
        label34.setAlignment(1);
        Label label35 = this.H;
        label35.wrap = true;
        label35.invalidateHierarchy();
        this.H.setFontScale(1.1f);
        Label label36 = this.H;
        float f36 = com.cfg.mendikot.a.s;
        float f37 = com.cfg.mendikot.a.r;
        label36.setSize(240.0f, 110.0f);
        this.H.setPosition(this.V, this.e0);
        this.H.color.set(10.0f, 255.0f, 10.0f, 1.0f);
        LabelStyle outline2311 = GeneratedOutlineSupport.outline23(this, this.t, this.H);
        outline2311.font = b.f2414d.a("Rajdhani-Bold");
        outline2311.fontColor = Color.WHITE;
        Label label37 = new Label(this.i, outline2311);
        this.I = label37;
        label37.setAlignment(1);
        Label label38 = this.I;
        label38.wrap = true;
        label38.invalidateHierarchy();
        this.I.setFontScale(1.1f);
        Label label39 = this.I;
        float f38 = com.cfg.mendikot.a.s;
        float f39 = com.cfg.mendikot.a.r;
        label39.setSize(240.0f, 110.0f);
        this.I.setPosition(this.W, this.e0);
        this.I.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2312 = GeneratedOutlineSupport.outline23(this, this.u, this.I);
        outline2312.font = b.f2414d.a("Rajdhani-Bold");
        outline2312.fontColor = Color.WHITE;
        Label label40 = new Label(this.i, outline2312);
        this.J = label40;
        label40.setAlignment(1);
        Label label41 = this.J;
        label41.wrap = true;
        label41.invalidateHierarchy();
        this.J.setFontScale(1.1f);
        Label label42 = this.J;
        float f40 = com.cfg.mendikot.a.s;
        float f41 = com.cfg.mendikot.a.r;
        label42.setSize(240.0f, 110.0f);
        this.J.setPosition(this.X, this.e0);
        this.J.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        addActorAfter(this.v, this.J);
        Image image17 = new Image(b.f2412b.a("pp1"));
        this.K = image17;
        image17.setPosition(this.U + 40.0f, this.f0);
        Image image18 = this.K;
        float f42 = com.cfg.mendikot.a.p;
        image18.setSize(160.0f, 160.0f);
        Image image19 = this.K;
        image19.visible = true;
        addActorAfter(this.s, image19);
        Image image20 = new Image(b.f2412b.a("pp3"));
        this.L = image20;
        image20.setPosition(this.V + 40.0f, this.f0);
        Image image21 = this.L;
        float f43 = com.cfg.mendikot.a.p;
        image21.setSize(160.0f, 160.0f);
        Image image22 = this.L;
        image22.visible = true;
        addActorAfter(this.t, image22);
        Image image23 = new Image(b.f2412b.a("pp2"));
        this.M = image23;
        image23.setPosition(this.W + 40.0f, this.f0);
        Image image24 = this.M;
        float f44 = com.cfg.mendikot.a.p;
        image24.setSize(160.0f, 160.0f);
        Image image25 = this.M;
        image25.visible = true;
        addActorAfter(this.u, image25);
        Image image26 = new Image(b.f2412b.a("pp4"));
        this.N = image26;
        image26.setPosition(this.X + 40.0f, this.f0);
        Image image27 = this.N;
        float f45 = com.cfg.mendikot.a.p;
        image27.setSize(160.0f, 160.0f);
        Image image28 = this.N;
        image28.visible = true;
        addActorAfter(this.v, image28);
        LabelStyle labelStyle3 = new LabelStyle();
        labelStyle3.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle3.fontColor = Color.WHITE;
        Label label43 = new Label(this.j, labelStyle3);
        this.O = label43;
        label43.setAlignment(8);
        Label label44 = this.O;
        label44.wrap = true;
        label44.invalidateHierarchy();
        this.O.setFontScale(1.0f);
        this.O.setSize(40.0f, 40.0f);
        this.O.setPosition(this.g0, this.i0);
        this.O.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2313 = GeneratedOutlineSupport.outline23(this, this.o, this.O);
        outline2313.font = b.f2414d.a("Rajdhani-Bold");
        outline2313.fontColor = Color.WHITE;
        Label label45 = new Label(this.j, outline2313);
        this.P = label45;
        label45.setAlignment(8);
        Label label46 = this.P;
        label46.wrap = true;
        label46.invalidateHierarchy();
        this.P.setFontScale(1.0f);
        this.P.setSize(40.0f, 40.0f);
        this.P.setPosition(this.h0, this.i0);
        this.P.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2314 = GeneratedOutlineSupport.outline23(this, this.o, this.P);
        outline2314.font = b.f2414d.a("Rajdhani-Bold");
        outline2314.fontColor = Color.WHITE;
        Label label47 = new Label(this.j, outline2314);
        this.Q = label47;
        label47.setAlignment(8);
        Label label48 = this.Q;
        label48.wrap = true;
        label48.invalidateHierarchy();
        this.Q.setFontScale(1.0f);
        this.Q.setSize(40.0f, 40.0f);
        this.Q.setPosition(this.g0, this.j0);
        this.Q.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2315 = GeneratedOutlineSupport.outline23(this, this.o, this.Q);
        outline2315.font = b.f2414d.a("Rajdhani-Bold");
        outline2315.fontColor = Color.WHITE;
        Label label49 = new Label(this.j, outline2315);
        this.R = label49;
        label49.setAlignment(8);
        Label label50 = this.R;
        label50.wrap = true;
        label50.invalidateHierarchy();
        this.R.setFontScale(1.0f);
        this.R.setSize(40.0f, 40.0f);
        this.R.setPosition(this.h0, this.j0);
        this.R.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2316 = GeneratedOutlineSupport.outline23(this, this.o, this.R);
        outline2316.font = b.f2414d.a("Rajdhani-Bold");
        outline2316.fontColor = Color.WHITE;
        Label label51 = new Label(this.j, outline2316);
        this.S = label51;
        label51.setAlignment(8);
        Label label52 = this.S;
        label52.wrap = true;
        label52.invalidateHierarchy();
        Label label53 = this.S;
        label53.visible = false;
        label53.setFontScale(1.0f);
        this.S.setSize(40.0f, 40.0f);
        this.S.setPosition(this.g0, this.k0);
        this.S.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2317 = GeneratedOutlineSupport.outline23(this, this.o, this.S);
        outline2317.font = b.f2414d.a("Rajdhani-Bold");
        outline2317.fontColor = Color.WHITE;
        Label label54 = new Label(this.j, outline2317);
        this.T = label54;
        label54.setAlignment(8);
        Label label55 = this.T;
        label55.wrap = true;
        label55.invalidateHierarchy();
        this.S.visible = false;
        this.T.setFontScale(1.0f);
        this.T.setSize(40.0f, 40.0f);
        this.T.setPosition(this.h0, this.k0);
        this.T.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        addActorAfter(this.o, this.T);
        this.k = new Image[]{this.s, this.t, this.u, this.v};
        this.l = new Image[]{this.K, this.L, this.M, this.N};
        this.m = new Label[]{this.G, this.H, this.I, this.J};
        this.n = new Label[]{this.C, this.D, this.E, this.F};
        this.f2532d = new Label[]{this.w, this.z, this.A, this.B};
        this.f2533e = new Label[]{this.q, this.r};
        this.f2534f = new Label[]{this.O, this.P};
        this.g = new Label[]{this.Q, this.R};
        this.h = new Label[]{this.S, this.T};
        this.touchable = Touchable.enabled;
        this.visible = false;
    }

    public final Drawable a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? new TextureRegionDrawable() : new TextureRegionDrawable(b.f2412b.a("pp4")) : new TextureRegionDrawable(b.f2412b.a("pp3")) : new TextureRegionDrawable(b.f2412b.a("pp2")) : new TextureRegionDrawable(b.f2412b.a("pp1"));
    }

    public void a(String str) {
    }

    public void a(ConcurrentHashMap<String, Integer> concurrentHashMap, ConcurrentHashMap<String, d> concurrentHashMap2, HashMap<String, b> hashMap, ConcurrentHashMap<String, f> concurrentHashMap3) {
        Label label;
        String str;
        if (hashMap != null && concurrentHashMap3 != null) {
            try {
                int i2 = 0;
                int i3 = 0;
                for (Entry next : concurrentHashMap3.entrySet()) {
                    String str2 = (String) next.getKey();
                    f fVar = (f) next.getValue();
                    if (i2 < 2) {
                        Iterator<String> it = fVar.f2549d.iterator();
                        while (it.hasNext()) {
                            String next2 = it.next();
                            if (i3 < 4) {
                                b bVar = hashMap.get(next2);
                                Label label2 = this.m[i3];
                                label2.setText((CharSequence) "₹ " + bVar.f2527b);
                                if (bVar.f2528c) {
                                    this.k[i3].setDrawable(new TextureRegionDrawable(b.f2412b.a("stars")));
                                    label = this.n[i3];
                                    str = "Won";
                                } else {
                                    this.k[i3].setDrawable(new TextureRegionDrawable(b.f2412b.a("lose")));
                                    label = this.n[i3];
                                    str = "Lost";
                                }
                                label.setText((CharSequence) str);
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

    public void b() {
        this.visible = false;
    }

    public Actor c() {
        return this;
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
                        this.f2533e[i2].setText((CharSequence) "TEAM " + str);
                        this.f2529a.put(str, Integer.valueOf(i2));
                        Iterator<String> it = fVar.f2549d.iterator();
                        while (it.hasNext()) {
                            String next2 = it.next();
                            if (i3 < 4) {
                                String str2 = concurrentHashMap2.get(next2).f2567b;
                                if (str2.length() > 10) {
                                    String substring = str2.substring(0, 9);
                                    str2 = substring + "...";
                                }
                                this.f2532d[i3].setText((CharSequence) str2);
                                this.l[i3].setDrawable(a(concurrentHashMap.get(next2).intValue()));
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
        int i2 = 0;
        while (i2 < 2) {
            try {
                this.f2534f[i2].setText((CharSequence) "");
                this.g[i2].setText((CharSequence) "");
                this.h[i2].setText((CharSequence) "");
                this.h[i2].visible = false;
                i2++;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (hashMapArr != null) {
            if (z2) {
                this.o.setDrawable(new TextureRegionDrawable(b.f2412b.a("scoreboard_round1")));
            }
            for (HashMap<String, f> hashMap : hashMapArr) {
                for (String next : hashMap.keySet()) {
                    f fVar = hashMap.get(next);
                    int intValue = this.f2529a.get(next).intValue();
                    this.f2534f[intValue].setText((CharSequence) fVar.f2547b + "");
                    this.g[intValue].setText((CharSequence) fVar.f2548c + "");
                    if (!z2) {
                        this.h[intValue].setText((CharSequence) fVar.f2546a + "");
                        this.h[intValue].visible = true;
                    }
                }
            }
        }
        this.visible = z3;
    }

    public void a() {
        this.visible = true;
    }
}
