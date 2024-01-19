package a.a.d;

import a.a.l.g;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class b extends Group {

    /* renamed from: a  reason: collision with root package name */
    public g f2464a;

    /* renamed from: b  reason: collision with root package name */
    public g f2465b;

    /* renamed from: c  reason: collision with root package name */
    public g f2466c;

    /* renamed from: d  reason: collision with root package name */
    public g f2467d;

    /* renamed from: e  reason: collision with root package name */
    public g f2468e;

    /* renamed from: f  reason: collision with root package name */
    public Sound f2469f;
    public Sound g;
    public float h = 0.6f;
    public float i = 0.2f;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                if (b.this.f2465b != null) {
                    b.this.f2465b.addAction(k.parallel(k.fadeOut(b.this.i), k.moveBy(147.55556f, 0.0f, 0.4f, Interpolation.fastSlow)));
                }
                if (b.this.f2466c != null) {
                    b.this.f2466c.addAction(k.parallel(k.fadeOut(b.this.i), k.moveBy(0.0f, -140.0f, 0.4f, Interpolation.fastSlow)));
                }
                if (b.this.f2467d != null) {
                    b.this.f2467d.addAction(k.parallel(k.fadeOut(b.this.i), k.moveBy(-147.55556f, 0.0f, 0.4f, Interpolation.fastSlow)));
                }
                if (b.this.f2468e != null) {
                    b.this.f2468e.addAction(k.parallel(k.fadeOut(b.this.i), k.moveBy(0.0f, 140.0f, 0.4f, Interpolation.fastSlow)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a.a.d.b$b  reason: collision with other inner class name */
    public class C0038b implements Runnable {
        public C0038b() {
        }

        public void run() {
            b bVar = b.this;
            bVar.visible = true;
            bVar.setPosition(0.0f, -120.0f);
            b.this.b();
            b bVar2 = b.this;
            bVar2.removeActor(bVar2.f2466c);
            b.this.d();
            b.this.e();
        }
    }

    public b(g gVar) {
        this.f2464a = gVar;
        this.f2469f = a.a.a.a.d.b.f2413c.a("cardSlide5");
        this.g = a.a.a.a.d.b.f2413c.a("cardTakeOut");
        setPosition(0.0f, -120.0f);
    }

    public void a(a aVar, float f2) {
        char c2 = aVar.f2459a;
        if (this.f2465b != null) {
            b();
        }
        g gVar = new g(aVar);
        this.f2465b = gVar;
        gVar.setPosition(220.0f, 540.0f);
        addActor(this.f2465b);
        g gVar2 = this.f2465b;
        MoveToAction moveTo = k.moveTo(1080.0f - ((this.h * 221.33333f) / 8.0f), 540.0f, f2);
        float f3 = this.h;
        gVar2.addAction(k.parallel(moveTo, k.scaleTo(f3, f3, f2, Interpolation.fastSlow), k.rotateBy(90.0f, f2, Interpolation.circleIn)));
        if (this.f2464a.visible && com.cfg.mendikot.a.y) {
            this.f2469f.play();
        }
    }

    public final void b() {
        removeActor(this.f2465b);
        this.f2465b = null;
    }

    public void b(a aVar, float f2) {
        char c2 = aVar.f2459a;
        g gVar = this.f2466c;
        if (gVar != null) {
            removeActor(gVar);
        }
        g gVar2 = new g(aVar);
        this.f2466c = gVar2;
        gVar2.setPosition(980.0f, 770.0f);
        addActor(this.f2466c);
        g gVar3 = this.f2466c;
        MoveToAction moveTo = k.moveTo(1080.0f - ((this.h * 221.33333f) / 2.0f), 610.0f, f2);
        float f3 = this.h;
        gVar3.addAction(k.parallel(moveTo, k.scaleTo(f3, f3, f2, Interpolation.fastSlow)));
        if (this.f2464a.visible && com.cfg.mendikot.a.y) {
            this.f2469f.play();
        }
    }

    public void c(a aVar, float f2) {
        char c2 = aVar.f2459a;
        if (this.f2467d != null) {
            d();
        }
        g gVar = new g(aVar);
        this.f2467d = gVar;
        gVar.setPosition(1710.0f, 540.0f);
        addActor(this.f2467d);
        g gVar2 = this.f2467d;
        float f3 = this.h;
        float f4 = 1080.0f - ((221.33333f * f3) / 3.0f);
        float f5 = f3 * 280.0f;
        MoveToAction moveTo = k.moveTo((f5 / 2.75f) + f4, (f5 / 1.33f) + 540.0f, f2);
        float f6 = this.h;
        gVar2.addAction(k.parallel(moveTo, k.scaleTo(f6, f6, f2, Interpolation.fastSlow), k.rotateBy(-90.0f, f2, Interpolation.circleIn)));
        if (this.f2464a.visible && com.cfg.mendikot.a.y) {
            this.f2469f.play();
        }
    }

    public final void d() {
        removeActor(this.f2467d);
        this.f2467d = null;
    }

    public void d(a aVar) {
        char c2 = aVar.f2459a;
        if (this.f2468e != null) {
            e();
        }
        aVar.f2461c = 1027.6848f;
        aVar.f2462d = 586.6667f;
        g gVar = new g(aVar);
        this.f2468e = gVar;
        float f2 = aVar.f2461c;
        float f3 = this.h;
        float f4 = aVar.f2462d;
        gVar.originX = ((221.33333f * f3) / 2.0f) + f2;
        gVar.originY = f4;
        gVar.setScale(f3);
        g gVar2 = this.f2468e;
        if (gVar2.rotation != 180.0f) {
            gVar2.rotation = 180.0f;
        }
        addActor(this.f2468e);
        if (this.f2464a.visible && com.cfg.mendikot.a.y) {
            this.f2469f.play();
        }
    }

    public final void e() {
        removeActor(this.f2468e);
        this.f2468e = null;
    }
}
