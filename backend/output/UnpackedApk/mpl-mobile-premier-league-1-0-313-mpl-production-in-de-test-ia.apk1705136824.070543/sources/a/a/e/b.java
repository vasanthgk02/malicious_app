package a.a.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class b extends Group {

    /* renamed from: a  reason: collision with root package name */
    public Image f2500a;

    /* renamed from: b  reason: collision with root package name */
    public Image f2501b;

    /* renamed from: c  reason: collision with root package name */
    public Image f2502c;

    /* renamed from: d  reason: collision with root package name */
    public Image f2503d;

    /* renamed from: e  reason: collision with root package name */
    public Image f2504e;

    /* renamed from: f  reason: collision with root package name */
    public Image f2505f;
    public Image g;
    public Image h;
    public Image i;
    public Image j;
    public float k = 10.0f;
    public float l = 110.0f;
    public float m = 210.0f;
    public float n = 210.0f;
    public float o = 110.0f;
    public float p = 10.0f;
    public j q;

    public class a extends InputListener {
        public a() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2501b.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2501b.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(0);
            }
        }
    }

    /* renamed from: a.a.e.b$b  reason: collision with other inner class name */
    public class C0040b extends InputListener {
        public C0040b() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2502c.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2502c.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(1);
            }
        }
    }

    public class c extends InputListener {
        public c() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2503d.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2503d.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(2);
            }
        }
    }

    public class d extends InputListener {
        public d() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2504e.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2504e.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(3);
            }
        }
    }

    public class e extends InputListener {
        public e() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2505f.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.f2505f.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(4);
            }
        }
    }

    public class f extends InputListener {
        public f() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.g.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.g.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(5);
            }
        }
    }

    public class g extends InputListener {
        public g() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.h.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.h.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(6);
            }
        }
    }

    public class h extends InputListener {
        public h() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.i.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.i.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(7);
            }
        }
    }

    public class i extends InputListener {
        public i() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.j.setScale(0.75f);
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            b.this.j.setScale(1.0f);
            j jVar = b.this.q;
            if (jVar != null) {
                ((a.a.k.c.b) jVar).a(8);
            }
        }
    }

    public interface j {
    }

    public b(j jVar) {
        this.q = jVar;
        Texture a2 = a.a.a.a.d.b.f2412b.a("emoji_popup");
        TextureFilter textureFilter = TextureFilter.Linear;
        Image outline22 = GeneratedOutlineSupport.outline22(a2, textureFilter, textureFilter, a2);
        this.f2500a = outline22;
        outline22.setSize(310.0f, 310.0f);
        addActor(this.f2500a);
        Texture a3 = a.a.a.a.d.b.f2412b.a("emoji1");
        TextureFilter textureFilter2 = TextureFilter.Linear;
        Image outline222 = GeneratedOutlineSupport.outline22(a3, textureFilter2, textureFilter2, a3);
        this.f2501b = outline222;
        outline222.setSize(90.0f, 90.0f);
        this.f2501b.setPosition(this.k, this.n);
        this.f2501b.addListener(new a());
        addActor(this.f2501b);
        Texture a4 = a.a.a.a.d.b.f2412b.a("emoji2");
        TextureFilter textureFilter3 = TextureFilter.Linear;
        Image outline223 = GeneratedOutlineSupport.outline22(a4, textureFilter3, textureFilter3, a4);
        this.f2502c = outline223;
        outline223.setSize(90.0f, 90.0f);
        this.f2502c.setPosition(this.l, this.n);
        this.f2502c.addListener(new C0040b());
        addActor(this.f2502c);
        Texture a5 = a.a.a.a.d.b.f2412b.a("emoji3");
        TextureFilter textureFilter4 = TextureFilter.Linear;
        Image outline224 = GeneratedOutlineSupport.outline22(a5, textureFilter4, textureFilter4, a5);
        this.f2503d = outline224;
        outline224.setSize(90.0f, 90.0f);
        this.f2503d.setPosition(this.m, this.n);
        this.f2503d.addListener(new c());
        addActor(this.f2503d);
        Texture a6 = a.a.a.a.d.b.f2412b.a("emoji4");
        TextureFilter textureFilter5 = TextureFilter.Linear;
        Image outline225 = GeneratedOutlineSupport.outline22(a6, textureFilter5, textureFilter5, a6);
        this.f2504e = outline225;
        outline225.setSize(90.0f, 90.0f);
        this.f2504e.setPosition(this.k, this.o);
        this.f2504e.addListener(new d());
        addActor(this.f2504e);
        Texture a7 = a.a.a.a.d.b.f2412b.a("emoji5");
        TextureFilter textureFilter6 = TextureFilter.Linear;
        Image outline226 = GeneratedOutlineSupport.outline22(a7, textureFilter6, textureFilter6, a7);
        this.f2505f = outline226;
        outline226.setSize(90.0f, 90.0f);
        this.f2505f.setPosition(this.l, this.o);
        this.f2505f.addListener(new e());
        addActor(this.f2505f);
        Texture a8 = a.a.a.a.d.b.f2412b.a("emoji6");
        TextureFilter textureFilter7 = TextureFilter.Linear;
        Image outline227 = GeneratedOutlineSupport.outline22(a8, textureFilter7, textureFilter7, a8);
        this.g = outline227;
        outline227.setSize(90.0f, 90.0f);
        this.g.setPosition(this.m, this.o);
        this.g.addListener(new f());
        addActor(this.g);
        Texture a9 = a.a.a.a.d.b.f2412b.a("emoji7");
        TextureFilter textureFilter8 = TextureFilter.Linear;
        Image outline228 = GeneratedOutlineSupport.outline22(a9, textureFilter8, textureFilter8, a9);
        this.h = outline228;
        outline228.setSize(90.0f, 90.0f);
        this.h.setPosition(this.k, this.p);
        this.h.addListener(new g());
        addActor(this.h);
        Texture a10 = a.a.a.a.d.b.f2412b.a("emoji8");
        TextureFilter textureFilter9 = TextureFilter.Linear;
        Image outline229 = GeneratedOutlineSupport.outline22(a10, textureFilter9, textureFilter9, a10);
        this.i = outline229;
        outline229.setSize(90.0f, 90.0f);
        this.i.setPosition(this.l, this.p);
        this.i.addListener(new h());
        addActor(this.i);
        Texture a11 = a.a.a.a.d.b.f2412b.a("emoji9");
        TextureFilter textureFilter10 = TextureFilter.Linear;
        Image outline2210 = GeneratedOutlineSupport.outline22(a11, textureFilter10, textureFilter10, a11);
        this.j = outline2210;
        outline2210.setSize(90.0f, 90.0f);
        this.j.setPosition(this.m, this.p);
        this.j.addListener(new i());
        addActor(this.j);
    }
}
