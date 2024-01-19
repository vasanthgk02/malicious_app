package a.a.j;

import a.a.a.a.d.b;
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

public class d extends Group implements a {
    public Label A;
    public Label B;
    public Label C;
    public Label D;
    public Label E;
    public Label F;
    public Label G;
    public Label H;
    public Image I;
    public Image J;
    public Image K;
    public Image L;
    public Image M;
    public String N = "Player ";
    public Label[] O;
    public Label[] P;
    public Label[][] Q;
    public String R = "——";
    public Label[] S;
    public Label[] T;
    public Image[] U;
    public float V = 720.0f;
    public float W = 935.0f;
    public float X = 1270.0f;
    public float Y = 1480.0f;
    public float Z = 583.0f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f2536a;
    public float a0 = (720.0f - 20.0f);

    /* renamed from: b  reason: collision with root package name */
    public Image f2537b;
    public float b0 = (1270.0f - 20.0f);

    /* renamed from: c  reason: collision with root package name */
    public Label f2538c;
    public float c0 = 685.0f;

    /* renamed from: d  reason: collision with root package name */
    public Label f2539d;
    public float d0 = 420.0f;
    public float e0 = 720.0f;
    public float f0 = 960.0f;
    public float g0 = 1290.0f;
    public float h0 = 1510.0f;
    public Label i;
    public float i0 = 427.0f;
    public Label j;
    public float j0 = 360.0f;
    public Label k;
    public float k0 = 295.0f;
    public Label l;
    public float l0 = 221.0f;
    public Label m;
    public float m0 = 119.0f;
    public Label n;
    public Label o;
    public Label p;
    public Label q;
    public Label r;
    public Label s;
    public Label t;
    public Label u;
    public Label v;
    public Label w;
    public Label z;

    public class a extends InputListener {
        public a() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            d.this.visible = false;
            return false;
        }
    }

    public d(i iVar) {
        new HashMap();
        this.f2536a = new HashMap<>();
        Image image = new Image(b.f2412b.a("scoreboard_round3"));
        this.f2537b = image;
        image.setPosition(0.0f, -20.0f);
        this.f2537b.setSize(2160.0f, 1080.0f);
        addActor(this.f2537b);
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle.fontColor = Color.WHITE;
        Label label = new Label("Team A", labelStyle);
        this.f2538c = label;
        label.setAlignment(1);
        Label label2 = this.f2538c;
        label2.wrap = true;
        label2.invalidateHierarchy();
        this.f2538c.setFontScale(1.2f);
        Label label3 = this.f2538c;
        float f2 = com.cfg.mendikot.a.p;
        float f3 = com.cfg.mendikot.a.r;
        label3.setSize(500.0f, 120.0f);
        this.f2538c.setPosition(this.a0, this.c0);
        this.f2538c.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline24 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.f2538c);
        outline24.font = b.f2414d.a("Rajdhani-Bold");
        outline24.fontColor = Color.WHITE;
        Label label4 = new Label("Team B", outline24);
        this.f2539d = label4;
        label4.setAlignment(1);
        Label label5 = this.f2539d;
        label5.wrap = true;
        label5.invalidateHierarchy();
        this.f2539d.setFontScale(1.2f);
        Label label6 = this.f2539d;
        float f4 = com.cfg.mendikot.a.p;
        float f5 = com.cfg.mendikot.a.r;
        label6.setSize(500.0f, 120.0f);
        this.f2539d.setPosition(this.b0, this.c0);
        this.f2539d.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline242 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.f2539d);
        outline242.font = b.f2414d.a("Rajdhani-Bold");
        outline242.fontColor = Color.WHITE;
        Label label7 = new Label(this.R, outline242);
        this.m = label7;
        label7.setAlignment(16);
        Label label8 = this.m;
        label8.wrap = true;
        label8.invalidateHierarchy();
        this.m.setFontScale(1.0f);
        this.m.setSize(120.0f, 120.0f);
        this.m.setPosition(this.e0, this.i0);
        this.m.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline243 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.m);
        outline243.font = b.f2414d.a("Rajdhani-Bold");
        outline243.fontColor = Color.WHITE;
        Label label9 = new Label(this.R, outline243);
        this.n = label9;
        label9.setAlignment(16);
        Label label10 = this.n;
        label10.wrap = true;
        label10.invalidateHierarchy();
        this.n.setFontScale(1.0f);
        this.n.setSize(120.0f, 120.0f);
        this.n.setPosition(this.f0, this.i0);
        this.n.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline244 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.n);
        outline244.font = b.f2414d.a("Rajdhani-Bold");
        outline244.fontColor = Color.WHITE;
        Label label11 = new Label(this.R, outline244);
        this.o = label11;
        label11.setAlignment(16);
        Label label12 = this.o;
        label12.wrap = true;
        label12.invalidateHierarchy();
        this.o.setFontScale(1.0f);
        this.o.setSize(120.0f, 120.0f);
        this.o.setPosition(this.g0, this.i0);
        this.o.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline245 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.o);
        outline245.font = b.f2414d.a("Rajdhani-Bold");
        outline245.fontColor = Color.WHITE;
        Label label13 = new Label(this.R, outline245);
        this.p = label13;
        label13.setAlignment(16);
        Label label14 = this.p;
        label14.wrap = true;
        label14.invalidateHierarchy();
        this.p.setFontScale(1.0f);
        this.p.setSize(120.0f, 120.0f);
        this.p.setPosition(this.h0, this.i0);
        this.p.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline246 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.p);
        outline246.font = b.f2414d.a("Rajdhani-Bold");
        outline246.fontColor = Color.WHITE;
        Label label15 = new Label(this.R, outline246);
        this.q = label15;
        label15.setAlignment(16);
        Label label16 = this.q;
        label16.wrap = true;
        label16.invalidateHierarchy();
        this.q.setFontScale(1.0f);
        this.q.setSize(120.0f, 120.0f);
        this.q.setPosition(this.e0, this.j0);
        this.q.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline247 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.q);
        outline247.font = b.f2414d.a("Rajdhani-Bold");
        outline247.fontColor = Color.WHITE;
        Label label17 = new Label(this.R, outline247);
        this.r = label17;
        label17.setAlignment(16);
        Label label18 = this.r;
        label18.wrap = true;
        label18.invalidateHierarchy();
        this.r.setFontScale(1.0f);
        this.r.setSize(120.0f, 120.0f);
        this.r.setPosition(this.f0, this.j0);
        this.r.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline248 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.r);
        outline248.font = b.f2414d.a("Rajdhani-Bold");
        outline248.fontColor = Color.WHITE;
        Label label19 = new Label(this.R, outline248);
        this.s = label19;
        label19.setAlignment(16);
        Label label20 = this.s;
        label20.wrap = true;
        label20.invalidateHierarchy();
        this.s.setFontScale(1.0f);
        this.s.setSize(120.0f, 120.0f);
        this.s.setPosition(this.g0, this.j0);
        this.s.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline249 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.s);
        outline249.font = b.f2414d.a("Rajdhani-Bold");
        outline249.fontColor = Color.WHITE;
        Label label21 = new Label(this.R, outline249);
        this.t = label21;
        label21.setAlignment(16);
        Label label22 = this.t;
        label22.wrap = true;
        label22.invalidateHierarchy();
        this.t.setFontScale(1.0f);
        this.t.setSize(120.0f, 120.0f);
        this.t.setPosition(this.h0, this.j0);
        this.t.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2410 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.t);
        outline2410.font = b.f2414d.a("Rajdhani-Bold");
        outline2410.fontColor = Color.WHITE;
        Label label23 = new Label(this.R, outline2410);
        this.u = label23;
        label23.setAlignment(16);
        Label label24 = this.u;
        label24.wrap = true;
        label24.invalidateHierarchy();
        this.u.setFontScale(1.0f);
        this.u.setSize(120.0f, 120.0f);
        this.u.setPosition(this.e0, this.k0);
        this.u.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2411 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.u);
        outline2411.font = b.f2414d.a("Rajdhani-Bold");
        outline2411.fontColor = Color.WHITE;
        Label label25 = new Label(this.R, outline2411);
        this.v = label25;
        label25.setAlignment(16);
        Label label26 = this.v;
        label26.wrap = true;
        label26.invalidateHierarchy();
        this.v.setFontScale(1.0f);
        this.v.setSize(120.0f, 120.0f);
        this.v.setPosition(this.f0, this.k0);
        this.v.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2412 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.v);
        outline2412.font = b.f2414d.a("Rajdhani-Bold");
        outline2412.fontColor = Color.WHITE;
        Label label27 = new Label(this.R, outline2412);
        this.w = label27;
        label27.setAlignment(16);
        Label label28 = this.w;
        label28.wrap = true;
        label28.invalidateHierarchy();
        this.w.setFontScale(1.0f);
        this.w.setSize(120.0f, 120.0f);
        this.w.setPosition(this.g0, this.k0);
        this.w.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2413 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.w);
        outline2413.font = b.f2414d.a("Rajdhani-Bold");
        outline2413.fontColor = Color.WHITE;
        Label label29 = new Label(this.R, outline2413);
        this.z = label29;
        label29.setAlignment(16);
        Label label30 = this.z;
        label30.wrap = true;
        label30.invalidateHierarchy();
        this.z.setFontScale(1.0f);
        this.z.setSize(120.0f, 120.0f);
        this.z.setPosition(this.h0, this.k0);
        this.z.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2414 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.z);
        outline2414.font = b.f2414d.a("Rajdhani-Bold");
        outline2414.fontColor = Color.BLACK;
        Label label31 = new Label(this.R, outline2414);
        this.A = label31;
        label31.setAlignment(16);
        Label label32 = this.A;
        label32.wrap = true;
        label32.invalidateHierarchy();
        this.A.setFontScale(1.1f);
        this.A.setSize(120.0f, 120.0f);
        this.A.setPosition(this.e0, this.l0);
        this.A.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2415 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.A);
        outline2415.font = b.f2414d.a("Rajdhani-Bold");
        outline2415.fontColor = Color.BLACK;
        Label label33 = new Label(this.R, outline2415);
        this.B = label33;
        label33.setAlignment(16);
        Label label34 = this.B;
        label34.wrap = true;
        label34.invalidateHierarchy();
        this.B.setFontScale(1.1f);
        this.B.setSize(120.0f, 120.0f);
        this.B.setPosition(this.f0 + 1.0f, this.l0);
        this.B.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2416 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.B);
        outline2416.font = b.f2414d.a("Rajdhani-Bold");
        outline2416.fontColor = Color.BLACK;
        Label label35 = new Label(this.R, outline2416);
        this.C = label35;
        label35.setAlignment(16);
        Label label36 = this.C;
        label36.wrap = true;
        label36.invalidateHierarchy();
        this.C.setFontScale(1.1f);
        this.C.setSize(120.0f, 120.0f);
        this.C.setPosition(this.g0 + 2.0f, this.l0);
        this.C.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2417 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.C);
        outline2417.font = b.f2414d.a("Rajdhani-Bold");
        outline2417.fontColor = Color.BLACK;
        Label label37 = new Label(this.R, outline2417);
        this.D = label37;
        label37.setAlignment(16);
        Label label38 = this.D;
        label38.wrap = true;
        label38.invalidateHierarchy();
        this.D.setFontScale(1.1f);
        this.D.setSize(120.0f, 120.0f);
        this.D.setPosition(this.h0 + 2.0f, this.l0);
        this.D.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2418 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.D);
        outline2418.font = b.f2414d.a("Rajdhani-Bold");
        outline2418.fontColor = Color.BLACK;
        Label label39 = new Label(this.R, outline2418);
        this.E = label39;
        label39.setAlignment(16);
        Label label40 = this.E;
        label40.wrap = true;
        label40.invalidateHierarchy();
        this.E.setFontScale(1.1f);
        this.E.setSize(120.0f, 120.0f);
        this.E.setPosition(this.e0, this.m0);
        this.E.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2419 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.E);
        outline2419.font = b.f2414d.a("Rajdhani-Bold");
        outline2419.fontColor = Color.BLACK;
        Label label41 = new Label(this.R, outline2419);
        this.F = label41;
        label41.setAlignment(16);
        Label label42 = this.F;
        label42.wrap = true;
        label42.invalidateHierarchy();
        this.F.setFontScale(1.1f);
        this.F.setSize(120.0f, 120.0f);
        this.F.setPosition(this.f0 + 1.0f, this.m0);
        this.F.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2420 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.F);
        outline2420.font = b.f2414d.a("Rajdhani-Bold");
        outline2420.fontColor = Color.BLACK;
        Label label43 = new Label(this.R, outline2420);
        this.G = label43;
        label43.setAlignment(16);
        Label label44 = this.G;
        label44.wrap = true;
        label44.invalidateHierarchy();
        this.G.setFontScale(1.1f);
        this.G.setSize(120.0f, 120.0f);
        this.G.setPosition(this.g0 + 2.0f, this.m0);
        this.G.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2421 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.G);
        outline2421.font = b.f2414d.a("Rajdhani-Bold");
        outline2421.fontColor = Color.BLACK;
        Label label45 = new Label(this.R, outline2421);
        this.H = label45;
        label45.setAlignment(16);
        Label label46 = this.H;
        label46.wrap = true;
        label46.invalidateHierarchy();
        this.H.setFontScale(1.1f);
        this.H.setSize(120.0f, 120.0f);
        this.H.setPosition(this.h0 + 2.0f, this.m0);
        this.H.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        addActorAfter(this.f2537b, this.H);
        Image image2 = new Image(b.f2412b.a("winner_ribbon"));
        this.M = image2;
        image2.setPosition(this.a0 + 10.0f, this.c0);
        this.M.setSize(94.0f, 94.0f);
        Image image3 = this.M;
        image3.visible = false;
        addActorAfter(this.f2537b, image3);
        LabelStyle labelStyle2 = new LabelStyle();
        labelStyle2.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle2.fontColor = Color.WHITE;
        Label label47 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.N, 1), labelStyle2);
        this.i = label47;
        label47.setAlignment(1);
        Label label48 = this.i;
        label48.wrap = true;
        label48.invalidateHierarchy();
        this.i.setFontScale(1.0f);
        Label label49 = this.i;
        float f6 = com.cfg.mendikot.a.p;
        float f7 = com.cfg.mendikot.a.q;
        label49.setSize(240.0f, 310.0f);
        this.i.setPosition(this.V, this.d0);
        this.i.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2422 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.i);
        outline2422.font = b.f2414d.a("Rajdhani-Bold");
        outline2422.fontColor = Color.WHITE;
        Label label50 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.N, 2), outline2422);
        this.j = label50;
        label50.setAlignment(1);
        Label label51 = this.j;
        label51.wrap = true;
        label51.invalidateHierarchy();
        this.j.setFontScale(1.0f);
        Label label52 = this.j;
        float f8 = com.cfg.mendikot.a.p;
        float f9 = com.cfg.mendikot.a.q;
        label52.setSize(240.0f, 310.0f);
        this.j.setPosition(this.W, this.d0);
        this.j.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2423 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.j);
        outline2423.font = b.f2414d.a("Rajdhani-Bold");
        outline2423.fontColor = Color.WHITE;
        Label label53 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.N, 3), outline2423);
        this.k = label53;
        label53.setAlignment(1);
        Label label54 = this.k;
        label54.wrap = true;
        label54.invalidateHierarchy();
        this.k.setFontScale(1.0f);
        Label label55 = this.k;
        float f10 = com.cfg.mendikot.a.p;
        float f11 = com.cfg.mendikot.a.q;
        label55.setSize(240.0f, 310.0f);
        this.k.setPosition(this.X, this.d0);
        this.k.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        LabelStyle outline2424 = GeneratedOutlineSupport.outline24(this, this.f2537b, this.k);
        outline2424.font = b.f2414d.a("Rajdhani-Bold");
        outline2424.fontColor = Color.WHITE;
        Label label56 = new Label(GeneratedOutlineSupport.outline61(new StringBuilder(), this.N, 4), outline2424);
        this.l = label56;
        label56.setAlignment(1);
        Label label57 = this.l;
        label57.wrap = true;
        label57.invalidateHierarchy();
        this.l.setFontScale(1.0f);
        Label label58 = this.l;
        float f12 = com.cfg.mendikot.a.p;
        float f13 = com.cfg.mendikot.a.q;
        label58.setSize(240.0f, 310.0f);
        this.l.setPosition(this.Y, this.d0);
        this.l.color.set(255.0f, 255.0f, 255.0f, 1.0f);
        addActorAfter(this.f2537b, this.l);
        Image image4 = new Image(b.f2412b.a("pp1"));
        this.I = image4;
        image4.setPosition(this.V + 40.0f, this.Z);
        Image image5 = this.I;
        float f14 = com.cfg.mendikot.a.p;
        image5.setSize(160.0f, 160.0f);
        Image image6 = this.I;
        image6.visible = true;
        addActorAfter(null, image6);
        Image image7 = new Image(b.f2412b.a("pp2"));
        this.J = image7;
        image7.setPosition(this.W + 40.0f, this.Z);
        Image image8 = this.J;
        float f15 = com.cfg.mendikot.a.p;
        image8.setSize(160.0f, 160.0f);
        Image image9 = this.J;
        image9.visible = true;
        addActorAfter(null, image9);
        Image image10 = new Image(b.f2412b.a("pp3"));
        this.K = image10;
        image10.setPosition(this.X + 40.0f, this.Z);
        Image image11 = this.K;
        float f16 = com.cfg.mendikot.a.p;
        image11.setSize(160.0f, 160.0f);
        Image image12 = this.K;
        image12.visible = true;
        addActorAfter(null, image12);
        Image image13 = new Image(b.f2412b.a("pp4"));
        this.L = image13;
        image13.setPosition(this.Y + 40.0f, this.Z);
        Image image14 = this.L;
        float f17 = com.cfg.mendikot.a.p;
        image14.setSize(160.0f, 160.0f);
        Image image15 = this.L;
        image15.visible = true;
        addActorAfter(null, image15);
        this.Q = new Label[][]{new Label[]{this.m, this.n, this.o, this.p}, new Label[]{this.q, this.r, this.s, this.t}, new Label[]{this.u, this.v, this.w, this.z}};
        this.S = new Label[]{this.A, this.B, this.C, this.D};
        this.T = new Label[]{this.E, this.F, this.G, this.H};
        this.U = new Image[]{this.I, this.J, this.K, this.L};
        this.O = new Label[]{this.i, this.j, this.k, this.l};
        this.P = new Label[]{this.f2538c, this.f2539d};
        this.touchable = Touchable.enabled;
        this.visible = false;
        addListener(new a());
    }

    public final Drawable a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? new TextureRegionDrawable() : new TextureRegionDrawable(b.f2412b.a("pp4")) : new TextureRegionDrawable(b.f2412b.a("pp3")) : new TextureRegionDrawable(b.f2412b.a("pp2")) : new TextureRegionDrawable(b.f2412b.a("pp1"));
    }

    public void a(String str) {
    }

    public void a(ConcurrentHashMap<String, Integer> concurrentHashMap, ConcurrentHashMap<String, a.a.k.d> concurrentHashMap2, HashMap<String, b> hashMap, ConcurrentHashMap<String, f> concurrentHashMap3) {
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
                                    Label label = this.S[i3];
                                    StringBuilder sb = new StringBuilder();
                                    double pow = (double) ((int) Math.pow(10.0d, (double) i4));
                                    sb.append(((double) Math.round(((double) bVar.f2526a) * pow)) / pow);
                                    sb.append("");
                                    label.setText((CharSequence) sb.toString());
                                    Label label2 = this.T[i3];
                                    label2.setText((CharSequence) "₹ " + bVar.f2527b);
                                    if (!bVar.f2528c || i3 >= 2) {
                                        if (bVar.f2528c) {
                                            if (i3 >= 2) {
                                                image = this.M;
                                                float f4 = this.b0 - 4.0f;
                                                f2 = f4;
                                                f3 = this.c0;
                                            }
                                        }
                                        i3++;
                                        i4 = 1;
                                    } else {
                                        Image image2 = this.M;
                                        f3 = this.c0;
                                        f2 = this.a0 - 4.0f;
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
                        this.M.visible = true;
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
            for (int i3 = 0; i3 < 3; i3++) {
                this.Q[i3][i2].setText((CharSequence) this.R);
                Label label = this.Q[i3][i2];
                label.color.set(Color.WHITE);
            }
            this.S[i2].setText((CharSequence) this.R);
            Label label2 = this.S[i2];
            label2.color.set(Color.BLACK);
            this.T[i2].setText((CharSequence) this.R);
            Label label3 = this.T[i2];
            label3.color.set(Color.BLACK);
        }
    }

    public void a(ConcurrentHashMap<String, Integer> concurrentHashMap, ConcurrentHashMap<String, a.a.k.d> concurrentHashMap2, ConcurrentHashMap<String, String> concurrentHashMap3, ConcurrentHashMap<String, f> concurrentHashMap4) {
        if (concurrentHashMap4 != null) {
            try {
                int i2 = 0;
                int i3 = 0;
                for (Entry next : concurrentHashMap4.entrySet()) {
                    String str = (String) next.getKey();
                    f fVar = (f) next.getValue();
                    if (i2 < 2) {
                        this.P[i2].setText((CharSequence) "TEAM " + str);
                        this.f2536a.put(str, Integer.valueOf(i2));
                        Iterator<String> it = fVar.f2549d.iterator();
                        while (it.hasNext()) {
                            String next2 = it.next();
                            if (i3 < 4) {
                                String str2 = concurrentHashMap2.get(next2).f2567b;
                                if (str2.length() > 10) {
                                    String substring = str2.substring(0, 9);
                                    str2 = substring + "...";
                                }
                                this.O[i3].setText((CharSequence) str2);
                                this.U[i3].setDrawable(a(concurrentHashMap.get(next2).intValue()));
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
                        int intValue = this.f2536a.get(next).intValue() * 2;
                        Label label = this.Q[i2][intValue];
                        label.setText((CharSequence) fVar.f2546a + "");
                        Label label2 = this.Q[i2][intValue + 1];
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
