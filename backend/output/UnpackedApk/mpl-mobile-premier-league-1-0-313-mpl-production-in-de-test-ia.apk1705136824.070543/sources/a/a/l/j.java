package a.a.l;

import a.a.a.a.d.b;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class j extends Group {

    /* renamed from: a  reason: collision with root package name */
    public i f2684a;

    /* renamed from: b  reason: collision with root package name */
    public Image f2685b;

    /* renamed from: c  reason: collision with root package name */
    public Label f2686c;

    /* renamed from: d  reason: collision with root package name */
    public Label f2687d;

    /* renamed from: e  reason: collision with root package name */
    public Label f2688e;

    /* renamed from: f  reason: collision with root package name */
    public Label f2689f;
    public Label g;
    public Label h;
    public float i = 890.0f;
    public float j = 1380.0f;
    public float k = 655.0f;
    public float l = 595.0f;
    public float m = 535.0f;

    public class a extends InputListener {
        public a() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            j.this.visible = false;
            return false;
        }
    }

    public j(i iVar) {
        this.f2684a = iVar;
        Image image = new Image(b.f2412b.a("tableinfo"));
        this.f2685b = image;
        image.setPosition(-2.0f, -40.0f);
        this.f2685b.setSize(2170.0f, 1085.0f);
        addActor(this.f2685b);
        try {
            LabelStyle labelStyle = new LabelStyle();
            labelStyle.font = b.f2414d.a("Rajdhani-Bold");
            labelStyle.fontColor = Color.WHITE;
            Label label = new Label("₹ " + this.f2684a.f2681d, labelStyle);
            this.f2686c = label;
            label.setAlignment(16);
            Label label2 = this.f2686c;
            label2.wrap = true;
            label2.invalidateHierarchy();
            this.f2686c.setFontScale(1.1f);
            this.f2686c.setSize(120.0f, 120.0f);
            this.f2686c.setPosition(this.i - 5.0f, this.k);
            this.f2686c.color.set(255.0f, 255.0f, 255.0f, 1.0f);
            addActorAfter(this.f2685b, this.f2686c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            LabelStyle labelStyle2 = new LabelStyle();
            labelStyle2.font = b.f2414d.a("Rajdhani-Bold");
            labelStyle2.fontColor = Color.WHITE;
            Label label3 = new Label(this.f2684a.l + " secs", labelStyle2);
            this.f2687d = label3;
            label3.setAlignment(16);
            Label label4 = this.f2687d;
            label4.wrap = true;
            label4.invalidateHierarchy();
            this.f2687d.setFontScale(1.1f);
            this.f2687d.setSize(240.0f, 120.0f);
            this.f2687d.setPosition(this.j, this.k);
            this.f2687d.color.set(255.0f, 255.0f, 255.0f, 1.0f);
            addActorAfter(this.f2685b, this.f2687d);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            LabelStyle labelStyle3 = new LabelStyle();
            labelStyle3.font = b.f2414d.a("Rajdhani-Bold");
            labelStyle3.fontColor = Color.WHITE;
            Label label5 = new Label(a((this.f2684a.m * 100.0d) / ((double) (this.f2684a.f2681d * this.f2684a.f2682e)), 1) + "%", labelStyle3);
            this.f2688e = label5;
            label5.setAlignment(16);
            Label label6 = this.f2688e;
            label6.wrap = true;
            label6.invalidateHierarchy();
            this.f2688e.setFontScale(1.1f);
            this.f2688e.setSize(120.0f, 120.0f);
            this.f2688e.setPosition(this.i, this.l);
            this.f2688e.color.set(255.0f, 255.0f, 255.0f, 1.0f);
            addActorAfter(this.f2685b, this.f2688e);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            LabelStyle labelStyle4 = new LabelStyle();
            labelStyle4.font = b.f2414d.a("Rajdhani-Bold");
            labelStyle4.fontColor = Color.WHITE;
            String str = "₹ " + this.f2684a.i;
            if (this.f2684a.f2683f == 2) {
                str = "₹" + this.f2684a.n + ", ₹" + this.f2684a.o;
            }
            Label label7 = new Label(str, labelStyle4);
            this.h = label7;
            label7.setAlignment(16);
            Label label8 = this.h;
            label8.wrap = true;
            label8.invalidateHierarchy();
            this.h.setFontScale(1.1f);
            this.h.setSize(240.0f, 120.0f);
            this.h.setPosition(this.j, this.l);
            this.h.color.set(255.0f, 255.0f, 255.0f, 1.0f);
            addActorAfter(this.f2685b, this.h);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            LabelStyle labelStyle5 = new LabelStyle();
            labelStyle5.font = b.f2414d.a("Rajdhani-Bold");
            labelStyle5.fontColor = Color.WHITE;
            Label label9 = new Label("" + this.f2684a.g, labelStyle5);
            this.f2689f = label9;
            label9.setAlignment(16);
            Label label10 = this.f2689f;
            label10.wrap = true;
            label10.invalidateHierarchy();
            this.f2689f.setFontScale(1.1f);
            this.f2689f.setSize(120.0f, 120.0f);
            this.f2689f.setPosition(this.i - 8.0f, this.m);
            this.f2689f.color.set(255.0f, 255.0f, 255.0f, 1.0f);
            addActorAfter(this.f2685b, this.f2689f);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            LabelStyle labelStyle6 = new LabelStyle();
            labelStyle6.font = b.f2414d.a("Rajdhani-Bold");
            labelStyle6.fontColor = Color.WHITE;
            Label label11 = new Label("" + this.f2684a.f2683f, labelStyle6);
            this.g = label11;
            label11.setAlignment(16);
            Label label12 = this.g;
            label12.wrap = true;
            label12.invalidateHierarchy();
            this.g.setFontScale(1.1f);
            this.g.setSize(120.0f, 120.0f);
            this.g.setPosition(this.j - 8.0f, this.m);
            this.g.color.set(255.0f, 255.0f, 255.0f, 1.0f);
            addActorAfter(this.f2685b, this.g);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        this.touchable = Touchable.enabled;
        this.visible = false;
        addListener(new a());
    }

    public final double a(double d2, int i2) {
        double pow = (double) ((int) Math.pow(10.0d, (double) i2));
        return ((double) Math.round(d2 * pow)) / pow;
    }

    public void a(i iVar) {
        this.f2684a.toString();
        this.f2684a = iVar;
        Label label = this.f2686c;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("₹ ");
        outline73.append(this.f2684a.f2681d);
        label.setText((CharSequence) outline73.toString());
        this.f2687d.setText((CharSequence) this.f2684a.l + " secs");
        Label label2 = this.f2688e;
        StringBuilder sb = new StringBuilder();
        i iVar2 = this.f2684a;
        sb.append(a((iVar2.m * 100.0d) / ((double) (iVar2.f2681d * iVar2.f2682e)), 1));
        sb.append("%");
        label2.setText((CharSequence) sb.toString());
        Label label3 = this.f2689f;
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("");
        outline732.append(this.f2684a.g);
        label3.setText((CharSequence) outline732.toString());
        Label label4 = this.g;
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("");
        outline733.append(this.f2684a.f2683f);
        label4.setText((CharSequence) outline733.toString());
        String str = "₹ " + this.f2684a.i;
        if (this.f2684a.f2683f == 2) {
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("₹");
            outline734.append(this.f2684a.n);
            outline734.append(", ₹");
            outline734.append(this.f2684a.o);
            str = outline734.toString();
        }
        this.h.setText((CharSequence) str);
    }
}
