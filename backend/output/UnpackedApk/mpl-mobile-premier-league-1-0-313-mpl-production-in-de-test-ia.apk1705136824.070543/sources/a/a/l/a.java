package a.a.l;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class a extends Group {

    /* renamed from: a  reason: collision with root package name */
    public Label f2572a;

    /* renamed from: b  reason: collision with root package name */
    public int f2573b;

    /* renamed from: c  reason: collision with root package name */
    public int f2574c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f2575d;

    /* renamed from: a.a.l.a$a  reason: collision with other inner class name */
    public class C0042a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2576a;

        public C0042a(int i) {
            this.f2576a = i;
        }

        public void run() {
            a.this.f2573b--;
            Label label = a.this.f2572a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Round ");
            outline73.append(this.f2576a + 1);
            outline73.append(" will start in ");
            outline73.append(a.this.f2573b);
            outline73.append(" seconds");
            label.setText((CharSequence) outline73.toString());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a aVar = a.this;
            aVar.f2572a.clearActions();
            aVar.f2573b = 0;
            aVar.f2572a.visible = false;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            int i = a.this.f2574c % 4;
            String str = i != 1 ? i != 2 ? i != 3 ? "" : "..." : ".." : ".";
            a aVar = a.this;
            aVar.f2574c++;
            aVar.f2572a.setText((CharSequence) "Connecting Players" + str);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            a aVar = a.this;
            aVar.f2572a.clearActions();
            aVar.f2574c = 0;
            aVar.f2572a.visible = false;
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            a.this.f2575d--;
            Label label = a.this.f2572a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Game has ended. Table will close in ");
            outline73.append(a.this.f2575d);
            outline73.append(" seconds.");
            label.setText((CharSequence) outline73.toString());
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            a aVar = a.this;
            aVar.f2572a.clearActions();
            aVar.f2575d = 0;
            aVar.f2572a.visible = false;
        }
    }

    public a() {
        Texture a2 = a.a.a.a.d.b.f2412b.a("message4");
        TextureFilter textureFilter = TextureFilter.Linear;
        a2.setFilter(textureFilter, textureFilter);
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = a.a.a.a.d.b.f2414d.a("Rajdhani-Bold");
        labelStyle.fontColor = Color.WHITE;
        labelStyle.background = new TextureRegionDrawable(new TextureRegion(a2));
        Label label = new Label(" Game messages will be shown here ", labelStyle);
        this.f2572a = label;
        label.setAlignment(1);
        Label label2 = this.f2572a;
        label2.wrap = true;
        label2.invalidateHierarchy();
        Label label3 = this.f2572a;
        float f2 = com.cfg.mendikot.a.l;
        float f3 = com.cfg.mendikot.a.m;
        label3.setSize(1560.0f, 100.0f);
        Label label4 = this.f2572a;
        float f4 = com.cfg.mendikot.a.n;
        float f5 = com.cfg.mendikot.a.o;
        label4.setPosition(300.0f, 240.0f);
        this.f2572a.setFontScale(1.4f);
        Label label5 = this.f2572a;
        label5.visible = false;
        addActor(label5);
    }
}
